package kr.or.ddit.common.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.service.CodeService;
import kr.or.ddit.common.vo.CodeVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class CodeServlet
 */
@WebServlet("/CodeServlet")
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
				super.doGet(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		// 그룹코드로 코드테이블 조회
		String groupCode = req.getParameter("groupCode");
			
		CodeVO codeVo = new CodeVO();
		codeVo.setGroupCode(groupCode);
		
		CodeService codeService = new CodeService();
		List<CodeVO> list = codeService.retrieveCodeList(codeVo);
			// TODO Auto-generated catch block
		
		
		req.setAttribute("list", list);
		
		RequestDispatcher disp = req.getRequestDispatcher("/html/common/codeListResult.jsp");
		disp.forward(req, resp);
	} catch (SQLException e) {
		e.printStackTrace();
		
	}
	
	
	}
}