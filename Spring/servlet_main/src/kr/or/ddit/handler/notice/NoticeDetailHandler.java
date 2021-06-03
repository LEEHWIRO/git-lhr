package kr.or.ddit.handler.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.dto.NoticeVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;
import kr.or.ddit.service.NoticeService;

public class NoticeDetailHandler implements Handler {

	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url = "notice/detailNotice";
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		try {
			NoticeVO notice = noticeService.getNotice(nno);
			
			request.setAttribute("notice", notice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

}
