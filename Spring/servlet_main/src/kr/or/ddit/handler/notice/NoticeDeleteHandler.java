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

public class NoticeDeleteHandler implements Handler {
	
	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "notice/listNotice";
		
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return url;
	}

}
