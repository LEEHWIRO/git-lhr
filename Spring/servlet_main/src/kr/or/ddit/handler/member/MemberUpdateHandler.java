package kr.or.ddit.handler.member;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;

public class MemberUpdateHandler implements Handler {
	
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "member/listDetailMember";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		int enabled = Integer.parseInt(request.getParameter("enabled"));
		String phone = request.getParameter("phone");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO mv = new MemberVO();
		mv.setId(id);
		mv.setPwd(pwd);
		mv.setEmail(email);
		mv.setEnabled(enabled);
		mv.setPhone(phone);
		mv.setName(name);
		mv.setAddress(address);
		
		try {
			int cnt = memberService.updateMember(mv);
			String msg = "";
			
			if(cnt == 1) {
				msg = "수정성공";
			}else {
				msg = "수정실패";			
			}
			MemberVO member = memberService.listDetailMember(id);
			
			request.setAttribute("member", member);
			request.setAttribute("msg", msg);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
	}

}
