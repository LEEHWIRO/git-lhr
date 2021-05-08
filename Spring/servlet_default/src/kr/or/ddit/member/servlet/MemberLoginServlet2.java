package kr.or.ddit.member.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

public class MemberLoginServlet2 extends HttpServlet {
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//System.out.println("Hello!!");
		
		//Scanner scan = new Scanner(System.in);
		
		
//		resp.setContentType("application/weofij;charset=utf-8");
		resp.setContentType("text/html;charset=utf-8");
//		resp.setContentType("text/plane;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>연습</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"login2.html\" memthod=\"Post\">");
		out.println("<input type=\"text\" name=\"memId\">");
		out.println("<br>");
		out.println("<input type=\"password\" name=\"memPass\">");
		out.println("<button type=\"submit\" >로그인</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//			resp.setContentType("text/html;charset=utf-8");
//			PrintWriter out = resp.getWriter();
//			
//			String memId = req.getParameter("memId");
//			String memPass = req.getParameter("memPass");
//			MemberVO memberVo = new MemberVO();
//			
//			memberVo.setMemId(memId);
//			
//			MemberServiceImpl memberService = (MemberServiceImpl) MemberServiceImpl.getInstance();
//			
//			List<MemberVO> memList = memberService.selectMemberById(memberVo);
//			
//			req.setAttribute("memList", memList);
//				
//			if(memList.get(0).getMemId().equals(memId) && memList.get(0).getMemPass().equals(memPass)) {
//				out.println("<h1>로그인 완료</h1>");
//			}else {
//				
//			}
	}

}
