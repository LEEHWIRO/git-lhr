package kr.or.ddit.handler.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.handler.Handler;

public class NoticeMainHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "notice/main";
		
		return url;
	}

}
