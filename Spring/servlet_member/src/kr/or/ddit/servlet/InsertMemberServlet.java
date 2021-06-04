package kr.or.ddit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.context.ApplicationContext;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.service.MemberService;
import kr.or.ddit.service.MemberServiceImpl;

@WebServlet("/insert")
public class InsertMemberServlet extends HttpServlet {
	
	private MemberService memberService 
		= (MemberService) ApplicationContext.getApplicationContext().get("memberService");
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/member/insertMember.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
		
		String Url =  "/WEB-INF/views/listMember.jsp";
		
		String memId = request.getParameter("memId");
		String memPass = request.getParameter("memPass");
		String memEmail = request.getParameter("memEmail");
		int memEnabled = Integer.parseInt(request.getParameter("memEnabled"));
		String memPhone = request.getParameter("memPhone");
		String memName = request.getParameter("memName");
		String memAddress = request.getParameter("memAddress");
		
		
		MemberVO mv = new MemberVO();
		mv.setId(memId);
		mv.setPwd(memPass);
		mv.setEmail(memEmail);
		mv.setEnabled(memEnabled);
		mv.setPhone(memPhone);
		mv.setName(memName);
		mv.setAddress(memAddress);
		
		try {
			int cnt = memberService.insertMember(mv);
			String msg = "";
			
			if(cnt == 1) {
				msg = "등록성공";
			}else {
				msg = "등록실패";			
			}
			
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
