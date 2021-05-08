package kr.or.ddit.member.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundException;
import com.servlet.view.HTMLView;

import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private MemberServiceImpl memberService = (MemberServiceImpl) MemberServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HTMLView.loginView(response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//입력
		String id = request.getParameter("memId");
		String pwd = request.getParameter("memPass");
		
		
		//처리
		String script = "";
//		 memService, login(id, pwd), memberVO, InvalidPasswordException, NotFoundIOException 
		try {
			out.println("1");
			MemberVO member = memberService.login(id, pwd);
			out.println("2");
			script="alert('로그인 성공했습니다.')"
					+"location.href='" + request.getContextPath() + "/main';";
			
		} catch (NotFoundException e) {
			script="alert('" + e.getMessage() + "');"
					+"history.go(-1)";
		} catch (InvalidPasswordException e) {
			script="alert('" + e.getMessage() + "');"
					+"location.href='/login';";
		} catch (SQLException e) {
			script="alert('서버장애로 인해 불가합니다.');"
					+"history.go(-1)";
			e.printStackTrace();
		}
		
		//출력
		HTMLView.html(response, script);
	}

}
