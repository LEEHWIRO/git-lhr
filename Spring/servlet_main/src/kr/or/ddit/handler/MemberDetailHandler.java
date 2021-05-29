package kr.or.ddit.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.service.MemberService;

public class MemberDetailHandler implements Handler {

	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "member/listDetailMember";
		String id = request.getParameter("id");
		
		try {
			MemberVO member = memberService.listDetailMember(id);
			
			request.setAttribute("member", member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

}
