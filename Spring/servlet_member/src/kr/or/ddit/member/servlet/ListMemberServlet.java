package kr.or.ddit.member.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.context.ApplicationContext;
import kr.or.ddit.member.dto.MemberVO;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

@WebServlet("/list")
public class ListMemberServlet extends HttpServlet {
     
	private IMemberService memberService 
		= (IMemberService) ApplicationContext.getApplicationContext().get("memberService");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/listMember.jsp";
		
		
			try {
				List<MemberVO> memberList = memberService.listMember();
				
				request.setAttribute("memberList", memberList);
				request.getRequestDispatcher(url).forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
 	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
