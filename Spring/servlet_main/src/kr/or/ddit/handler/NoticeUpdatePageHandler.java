package kr.or.ddit.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.dto.NoticeVO;
import kr.or.ddit.service.MemberService;
import kr.or.ddit.service.NoticeService;

public class NoticeUpdatePageHandler implements Handler {
	
	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "notice/updateNotice";

		int nno = Integer.parseInt(request.getParameter("nno"));
		
		try {
			NoticeVO notice = noticeService.listDetailNotice(nno);
			
			request.setAttribute("notice", notice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return url;
	}

}
