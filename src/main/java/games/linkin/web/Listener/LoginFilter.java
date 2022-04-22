package games.linkin.web.Listener;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/data/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //从客户端获取Session
        //0.强制转换
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 1.获取session对象
        HttpSession session = request.getSession();

        // 2. 获取session对象
        Object user = session.getAttribute("linkin");

        if(user != null){
            //登录了。放行
            System.out.println("成功放行");
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //没有登录。跳转登录页面，并且输出 “您尚登入，请登入”
            System.out.println("转跳");
            response.sendRedirect("../login.html");
        }
    }
    @Override
    public void destroy() {
    }
}
