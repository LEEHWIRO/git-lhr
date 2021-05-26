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

@WebServlet("/updateNotice")
public class updateNoticeServlet extends HttpServlet {
	
	private INoticeService noticeService 
		= (INoticeService) ApplicationContext.getApplicationContext().get("noticeService");
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/updateNotice.jsp";
		
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
		
		int nno = Integer.parseInt(request.getParameter("nno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		NoticeVO mv = new NoticeVO();
		mv.setNno(nno);
		mv.setTitle(title);
		mv.setContent(content);
		
		try {
			int cnt = noticeService.updateNotice(mv);
			String msg = "";
			if(cnt == 1) {
				msg = "수정성공";
			}else {
				msg = "수정실패";			
			}
			
			String Url =  "/WEB-INF/views/listDetailNotice.jsp";
			
			NoticeVO notice = noticeService.listDetailNotice(nno);
			
			request.setAttribute("notice", notice);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(Url).forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
