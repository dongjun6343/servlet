package hello.servlet.basic.response;


import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Content-Type : application/json
        response.setContentType("application/json");
        // response.setCharacterEncoding("utf-8"); -> application/json는 utf-8 형식을 사용하도록 되어있어서 필요없다.


        HelloData helloData = new HelloData();
        helloData.setUsername("park");
        helloData.setAge(29);


        // {"username":"park"... }
        String s = objectMapper.writeValueAsString(helloData); // 객체를 JSON문자로 변환
        response.getWriter().write(s);

    }
}
