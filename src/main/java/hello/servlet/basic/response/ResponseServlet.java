package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseServlet", urlPatterns = "/response-header")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setStatus(HttpServletResponse.SC_OK);

        // [response-headers]
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 캐시 무효화
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");

        //[Header 편의 메서드]
        // content(response);

        //[쿠키 편의 메서드]
        cookie(response);

        //[Redirect 편의 메서드]
        redirect(response);

        //[Message Body]
        PrintWriter writer = response.getWriter();
        writer.println("ok"); // 단순 텍스트 응답.
    }

    private void redirect(HttpServletResponse response) throws IOException {

        //Status Code 302
        //Location: /basic/hello-form.html

        //response.setStatus(HttpServletResponse.SC_FOUND); // 302
        //response.setHeader("Location", "/basic/hello-form.html"); // 302 -> 리다이렉트 시킨다. (상태코드가 302이면서 Location값이 있다.)

        response.sendRedirect("/basic/hello-form.html"); // 위에 두개를 합쳐서 한줄로 사용!
    }

    private void content(HttpServletResponse response) {
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
    }

    private void cookie(HttpServletResponse response) {

        // Set-Cookie : myCookie=good; Max-age=600
        // response.setHeader("Set-Cookie","myCookie=good; Max-age=600");

        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); // 600초
        response.addCookie(cookie);
    }
}
