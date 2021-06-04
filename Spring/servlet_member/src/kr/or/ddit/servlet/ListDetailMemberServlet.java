package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.context.ApplicationContext;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.service.MemberService;
import kr.or.ddit.service.MemberServiceImpl;

@WebServlet("/listDetail")
public class ListDetailMemberServlet extends HttpServlet {
	
	private MemberService memberService 
		= (MemberService) ApplicationContext.getApplicationContext().get("memberService");
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/member/listDetailMember.jsp";
		
		String memId = request.getParameter("memId");
		
			try {
				MemberVO member = memberService.listDetailMember(memId);
				
				request.setAttribute("member", member);
				request.getRequestDispatcher(url).forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
 	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
