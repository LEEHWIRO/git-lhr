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

public class MemberLoginServlet extends HttpServlet {
       
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
		out.println("<script type=\"text/javascript\">\r\n" + 
				"	function login(){\r\n" + 
				"		var f = document.myForm;\r\n" + 
				"		if(!f.memId.value){\r\n" + 
				"			alert(\"아이디를 입력하시오\")\r\n" + 
				"			f.memId.focus();\r\n" + 
				"			return;\r\n" + 
				"		}\r\n" + 
				"		if(!f.memPass.value){\r\n" + 
				"			alert(\"비밀번호를 입력하시오\")\r\n" + 
				"			f.memPass.focus();\r\n" + 
				"			return;\r\n" + 
				"		}\r\n" + 
				"		f.action = \"/servlet_default/login\"\r\n" + 
				"		f.submit();\r\n" + 
				"	}\r\n" + 
				"</script>");
		out.println("<body>");
		out.println("<form action=\"\" memthod=\"post\" name=\"myForm\">");
		out.println("ID : <input type=\"text\" name=\"memId\" id=\"memId\"><br>");
		out.println("PW : <input type=\"password\" name=\"memPass\" id=\"memPass\">");
		out.println("<button type=\"button\" onclick=\"login()\">로그인</button>");
//		out.println("<input type='submit' value = '로그인'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		doPost(req, resp);
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
////			}
//	}

}
