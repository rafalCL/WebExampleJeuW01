package pl.coderslab.webexamplejeuw01.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LogUserAgentAndProcessingTimeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final String userAgent = ((HttpServletRequest) request).getHeader("User-Agent");
        System.out.println("LogUserAgentAndProcessingTimeFilter : userAgent=" + userAgent);
        final long startMs = System.currentTimeMillis();
        chain.doFilter(request, response);
        final long endMs = System.currentTimeMillis();
        System.out.println("LogUserAgentAndProcessingTimeFilter : execution time [ms]: " + (endMs-startMs));
    }
}
