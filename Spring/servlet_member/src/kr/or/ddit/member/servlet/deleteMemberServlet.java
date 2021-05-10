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

@WebServlet("/delete")
public class deleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/listMember.jsp";
		
		String memId = request.getParameter("memId");
		
		MemberServiceImpl memberService = (MemberServiceImpl) MemberServiceImpl.getInstance(); 
		
		try {
			int cnt = memberService.deleteMember(memId);
			String msg = "";
			if(cnt == 1) {
				msg = "삭제성공";
			}else {
				msg = "삭제실패";			
			}
			List<MemberVO> memberList = memberService.listMember();
			request.setAttribute("memberList", memberList);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
