package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 1. 파라미터 전송 기능
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RequestParamServlet.service");

        System.out.println("전체 파라미터 조회");

        request.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println(paramName + "=" + request
                .getParameter(paramName)));

        System.out.println("단일 파라미터 조회");

        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);

        System.out.println("이름이 같은 복수 파라미터");

        String[] usernames = request.getParameterValues("username");
        for (String s : usernames) {
            System.out.println("s = " + s);
        }
    }

    /**
     * request.getParameter() 는 GET URL 쿼리 파라미터 형식도 지원하고, POST HTML Form 형식도 둘 다 지원한다.
     *
     * -> GET URL 쿼리 파라미터 형식 : HTTP 메시지 바디를 사용 X -> content-type 없다.
     *
     * -> POST HTML Form 형식 : HTTP 메시지 바디에 해당 데이터를 포함해서 보내기 때문에 content-type을 꼭 지정해야 한다!
     *      => 이렇게 폼으로 데이터를 전송하는 형식을 application/x-www-form-urlencoded 라 한다.
     */



}
