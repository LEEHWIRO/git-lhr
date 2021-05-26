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
import kr.or.ddit.notice.service.NoticeServiceImpl;

@WebServlet("/deleteNotice")
public class deleteNoticeServlet extends HttpServlet {
	
	private INoticeService noticeService 
		= (INoticeService) ApplicationContext.getApplicationContext().get("noticeService");
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String url = "/WEB-INF/views/listNotice.jsp";
		
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		try {
			int cnt = noticeService.deleteNotice(nno);
			String msg = "";
			if(cnt == 1) {
				msg = "삭제성공";
			}else {
				msg = "삭제실패";			
			}
			List<NoticeVO> noticeList = noticeService.listNotice();
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
