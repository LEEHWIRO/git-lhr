package kr.or.ddit.member.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.context.ApplicationContext;
import kr.or.ddit.member.dto.MemberVO;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

@WebServlet("/update")
public class updateMemberServlet extends HttpServlet {
	
	private IMemberService memberService 
		= (IMemberService) ApplicationContext.getApplicationContext().get("memberService");
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/updateMember.jsp";
		
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
		
		String memId = request.getParameter("memId");
		String memPass = request.getParameter("memPass");
		String memEmail = request.getParameter("memEmail");
		String memPhone = request.getParameter("memPhone");
		
		
		MemberVO mv = new MemberVO();
		mv.setId(memId);
		mv.setPwd(memPass);
		mv.setEmail(memEmail);
		mv.setPhone(memPhone);
		
		try {
			int cnt = memberService.updateMember(mv);
			String msg = "";
			if(cnt == 1) {
				msg = "수정성공";
			}else {
				msg = "수정실패";			
			}
			
			String Url =  "/WEB-INF/views/listDetailMember.jsp";
			
			MemberVO member = memberService.listDetailMember(memId);
			
			request.setAttribute("member", member);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(Url).forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
