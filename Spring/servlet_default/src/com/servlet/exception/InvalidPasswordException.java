package com.servlet.exception;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InvalidPasswordException extends Exception {
       
    public InvalidPasswordException() {
        super("패스워드가 일치하지않습니다.");
        // TODO Auto-generated constructor stub
    }


}
