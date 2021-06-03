package kr.or.ddit.handler.member.test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;

public class MemberInsertHandler implements Handler {
	
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "member/listMember";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		int enabled = Integer.parseInt(request.getParameter("enabled"));
		String phone = request.getParameter("phone");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setEmail(email);
		member.setEnabled(enabled);
		member.setPhone(phone);
		member.setName(name);
		member.setAddress(address);
		
		try {
//			int cnt = memberService.regist(member);
			String msg = "";
//			
//			if(cnt == 1) {
//				msg = "등록성공";
//			}else {
//				msg = "등록실패";			
//			}
//			
////			List<MemberVO> memberList = memberService.listMember();
//			
//			request.setAttribute("memberList", memberList);
			request.setAttribute("msg", msg);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
	}

}
