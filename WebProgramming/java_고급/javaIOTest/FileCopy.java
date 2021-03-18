package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
	public static void main(String[] args) {
		
		File file = new File("d:/D_Other/Tulips.jpg");
		
//		if(file.exists()) {
//			System.out.println(file.getAbsolutePath() + "은 존재합니다.");
//		}else {
//			System.out.println(file.getAbsolutePath() + "은 없는 파일입니다.");
//		}
		
		try {
			if(file.createNewFile()) {
				System.out.println(file.getAbsolutePath() + "파일 생성 완료");
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		}
		
		
	


	}
	
	
	
