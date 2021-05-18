package kr.or.ddit.member.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/insert")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/insertMember.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Url =  "/WEB-INF/views/listMember.jsp";
		
		String memId = request.getParameter("memId");
		String memPass = request.getParameter("memPass");
		String memEmail = request.getParameter("memEmail");
		String memPhone = request.getParameter("memPhone");
		
		MemberServiceImpl memberService = (MemberServiceImpl) MemberServiceImpl.getInstance();
		
		MemberVO mv = new MemberVO();
		mv.setMemId(memId);
		mv.setMemPass(memPass);
		mv.setMemEmail(memEmail);
		mv.setMemPhone(memPhone);
		
		try {
			int cnt = memberService.insertMember(mv);
			String msg = "";
			
			if(cnt == 1) {
				msg = "등록성공";
			}else {
				msg = "등록실패";			
			}
			
			System.out.println("------------------------------------");
			
			List<MemberVO> memberList = memberService.listMember();
			
			request.setAttribute("memberList", memberList);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(Url).forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
