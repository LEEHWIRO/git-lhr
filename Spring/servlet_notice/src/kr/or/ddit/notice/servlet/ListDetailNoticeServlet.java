package kr.or.ddit.notice.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.context.ApplicationContext;
import kr.or.ddit.notice.dto.NoticeVO;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;

@WebServlet("/listDetailNotice")
public class ListDetailNoticeServlet extends HttpServlet {
	
	private INoticeService noticeService 
		= (INoticeService) ApplicationContext.getApplicationContext().get("noticeService");
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/listDetailNotice.jsp";
		
		int nno = Integer.parseInt(request.getParameter("nno"));
		
			try {
				NoticeVO notice = noticeService.listDetailNotice(nno);
				
				request.setAttribute("notice", notice);
				request.getRequestDispatcher(url).forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
 	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
