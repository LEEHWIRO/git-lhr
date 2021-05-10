package kr.or.ddit.member.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/list")
public class ListMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/listMember.jsp";
		
		MemberServiceImpl memberService = (MemberServiceImpl) MemberServiceImpl.getInstance(); 
		
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
