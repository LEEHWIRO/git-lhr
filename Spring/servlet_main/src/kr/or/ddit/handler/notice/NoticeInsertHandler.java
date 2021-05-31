package kr.or.ddit.handler.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.dto.NoticeVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;
import kr.or.ddit.service.NoticeService;

public class NoticeInsertHandler implements Handler {
	
	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "notice/listNotice";
		
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
			
			List<NoticeVO> noticeList = noticeService.listNotice();
			
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("msg", msg);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
	}

}
