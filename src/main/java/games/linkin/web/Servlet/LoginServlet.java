package games.linkin.web.Servlet;

import com.alibaba.fastjson.JSON;
import games.linkin.pojo.User;
import games.linkin.service.UserService;
import games.linkin.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/login/*")
public class LoginServlet extends BaseServlet{
    private UserService userService = new UserServiceImpl();
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取品牌数据
        BufferedReader br = req.getReader();
        String params = br.readLine();
        System.out.println(params);
        //2.转为user对象
        User user = JSON.parseObject(params, User.class);
        System.out.println(user);
        //3.调用service查询
        User loginUser = userService.login(user);
        System.out.println(loginUser);

        //4.判断是否成功,若成功分发session
        if( null != loginUser ){
            //设置session
            // 1.获取session对象
            HttpSession session = req.getSession();
            // 2.设置session对象
            session.setAttribute("linkin", "success");
            // 3.返回成功响应
            resp.getWriter().write("success");
        }else {
            System.out.println("用户名或密码错误");
        }
    }
}
