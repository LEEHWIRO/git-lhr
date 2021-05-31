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

public class NoticeInsertPageHandler implements Handler {
	
	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "notice/insertNotice";
		
		HttpSession session = request.getSession();
		
		try {
			request.setAttribute("loginUser", session.getAttribute("loginUser"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return url;
	}

}
