package pl.coderslab.webexamplejeuw01.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter("/*")
public class SetUtf8EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        System.out.println("set content type and character encoding");
    }
}
