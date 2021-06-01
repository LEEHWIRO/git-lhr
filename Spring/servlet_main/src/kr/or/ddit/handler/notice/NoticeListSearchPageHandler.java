package kr.or.ddit.handler.notice;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.NoticeService;

public class NoticeListSearchPageHandler implements Handler {

	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "notice/listNotice";
		
		String pageParam = request.getParameter("page");
		String perPageNumParam = request.getParameter("perPageNum");
		String searchType= request.getParameter("searchType");
	    String keyword= request.getParameter("keyword");
	      
		try {
			SearchCriteria cri = new SearchCriteria();
			cri.setPage(pageParam);
			cri.setPerPageNum(perPageNumParam);
			cri.setSearchType(searchType);
			cri.setKeyword(keyword);
			
			Map<String, Object> dataMap = noticeService.getNoticeList(cri);
			
			request.setAttribute("noticeList", dataMap.get("noticeList"));
			request.setAttribute("pageMaker", dataMap.get("pageMaker"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return url;
	}

}
