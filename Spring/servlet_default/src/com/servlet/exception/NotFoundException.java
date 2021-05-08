package com.servlet.exception;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotFoundException extends Exception {
       
    public NotFoundException() {
        super("아이디가 존재하지 않습니다.");
        // TODO Auto-generated constructor stub
    }


}
