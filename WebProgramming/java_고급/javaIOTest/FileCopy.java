package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		
		try {
//			InputStreamReader fr = new InputStreamReader("d:/D_Other/Tulips.jpg");
			
//			FileReader fr = new FileReader("d:/D_Other/Tulips.jpg");
			FileInputStream fis = new FileInputStream("d:/D_Other/Tulips.jpg");
			
			FileOutputStream fos = new FileOutputStream("d:/D_Other/복사본2_Tulips.jpg");
			
			int data;
			
			byte[] readBy = new byte[200];
			
			while((data = fis.read(readBy)) != -1) {
				fos.write(readBy,0,data);
			}
//			fos.flush();
			fos.close();
			fis.close();
			
			System.out.println("작업 완료...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if(file.exists()) {
//			System.out.println(file.getAbsolutePath() + "은 존재합니다.");
//		}else {
//			System.out.println(file.getAbsolutePath() + "은 없는 파일입니다.");
//		}
		
		}
		
		
	


	}
	
	
	
