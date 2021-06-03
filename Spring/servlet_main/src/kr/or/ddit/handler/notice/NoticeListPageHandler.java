package kr.or.ddit.handler.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.dto.NoticeVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.NoticeService;

public class NoticeListPageHandler implements Handler {

	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "notice/listNotice";
		
		String pageParam = request.getParameter("page");
		String perPageNumParam = request.getParameter("perPageNum");
		try {
			Criteria cri = new Criteria();
			cri.setPage(pageParam);
			cri.setPerPageNum(perPageNumParam);
			
			List<NoticeVO> noticeList = noticeService.getNoticeList(cri);
			
			request.setAttribute("noticeList", noticeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return url;
	}

}
