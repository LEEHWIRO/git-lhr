package kr.or.ddit.handler.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;

public class MemberDeleteHandler implements Handler {
	
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "member/listMember";
		
		String id = request.getParameter("id");
		
		try {
			int cnt = memberService.deleteMember(id);
			String msg = "";
			
			if(cnt == 1) {
				msg = "삭제성공";
			}else {
				msg = "삭제실패";			
			}
			
			List<MemberVO> memberList = memberService.listMember();
			
			request.setAttribute("memberList", memberList);
			
			request.setAttribute("msg", msg);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
	}

}
