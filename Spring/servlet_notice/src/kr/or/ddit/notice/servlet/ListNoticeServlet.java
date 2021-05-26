package kr.or.ddit.notice.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.context.ApplicationContext;
import kr.or.ddit.notice.dto.NoticeVO;
import kr.or.ddit.notice.service.INoticeService;

@WebServlet("/listNotice")
public class ListNoticeServlet extends HttpServlet {
     
	private INoticeService noticeService 
		= (INoticeService) ApplicationContext.getApplicationContext().get("noticeService");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/listNotice.jsp";
		
		
			try {
				List<NoticeVO> noticeList = noticeService.listNotice();
				
				request.setAttribute("noticeList", noticeList);
				request.getRequestDispatcher(url).forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
 	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
