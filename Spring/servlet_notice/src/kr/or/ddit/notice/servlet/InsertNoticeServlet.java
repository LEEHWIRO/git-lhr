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

@WebServlet("/insertNotice")
public class InsertNoticeServlet extends HttpServlet {
	
	private INoticeService noticeService 
		= (INoticeService) ApplicationContext.getApplicationContext().get("noticeService");
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/insertNotice.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Url =  "/WEB-INF/views/listNotice.jsp";
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		
		NoticeVO mv = new NoticeVO();
		mv.setTitle(title);
		mv.setWriter(writer);
		mv.setContent(content);
		
		try {
			int cnt = noticeService.insertNotice(mv);
			String msg = "";
			
			if(cnt == 1) {
				msg = "등록성공";
			}else {
				msg = "등록실패";			
			}
			
			System.out.println("------------------------------------");
			
			List<NoticeVO> noticeList = noticeService.listNotice();
			
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(Url).forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
