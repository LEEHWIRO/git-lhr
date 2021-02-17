package k_jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBCUtilTest {
	
	public static void main(String[] args) {
		JDBCUtil jdbc = JDBCUtil.getInstance();
		
		//selectList Test
//		String sql = "select * from cart "
//				+ " where cart_member = ?";
//		List<Object> param = new ArrayList<>();
//		param.add("a001");
//		
//		List<Map<String, Object>> list = jdbc.selectList(sql, param);
//		System.out.println(list);
		
		//selectOne Test
		String sql = "select * from member where mem_id = ?";
		List<Object> param = new ArrayList<>();
		param.add("a001");
		
		Map<String, Object> row = jdbc.selectOne(sql, param);
		if(row == null){
			
		}
		
		if(row.size() == 0){
			
		}
		System.out.println(row);
		
		//update Test
//		String sql = "insert into tb_jdbc_board values("
//				+ "(select nvl(max(board_no),0) + 1 from tb_jdbc_board)"
////				+ "testseq_seq.nextval" //시퀀스를 사용하는 경우
//				+ ",?,?,?,sysdate)";
//		List<Object> param = new ArrayList<>();
//		param.add("제목입니다.");
//		param.add("내용입니다.");
//		param.add("a001");
//		
//		int result = jdbc.update(sql,param);
//		System.out.println(result + "행이 영향을 받았습니다.");
	}
}
