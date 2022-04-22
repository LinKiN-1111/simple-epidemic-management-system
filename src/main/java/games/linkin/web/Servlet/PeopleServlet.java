package games.linkin.web.Servlet;

import com.alibaba.fastjson.JSON;
import games.linkin.pojo.People;
import games.linkin.pojo.PeopleBean;
import games.linkin.service.PeopleService;
import games.linkin.service.impl.PeopleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/data/*")
public class PeopleServlet extends BaseServlet{
    //1.创建对象
    private PeopleService peopleService =  new PeopleServiceImpl();
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.调用service查询
        List<People> peoples=peopleService.selectAll();

        //2.把数据转为json
        String jsonString = JSON.toJSONString(peoples);

        //3.写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取品牌数据
        BufferedReader br = req.getReader();
        String params = br.readLine();
        //2.转为People对象
        People people = JSON.parseObject(params, People.class);
        //3.调用service添加
        peopleService.add(people);

        //4.响应一个成功的表示
        resp.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取品牌数据
        BufferedReader br = req.getReader();
        String params = br.readLine();

        //2.转为int[]
        int[] ids = JSON.parseObject(params, int[].class);

        //3.调用service删除
        peopleService.deleteByIds(ids);

        //4.响应一个成功的表示
        resp.getWriter().write("success");
    }

    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取品牌数据
        BufferedReader br = req.getReader();
        String params = br.readLine();
        //2.转为People对象
        People people = JSON.parseObject(params, People.class);
        //3.调用service删除
        peopleService.deleteById(people);
        //4.响应一个成功的表示
        resp.getWriter().write("success");
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取数据
        BufferedReader br = req.getReader();
        String params = br.readLine();
        //2.转为People对象
        People people = JSON.parseObject(params, People.class);
        //3.调用service修改
        peopleService.update(people);
        //4.响应一个成功的表示
        resp.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接受当前页码和每页展示条数 url?currentPage=1&pageSize=5
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        //2.调用service查询
        PeopleBean<People> pageBean = peopleService.selectByPage(currentPage, pageSize);

        //3.把数据转为json
        String jsonString = JSON.toJSONString(pageBean);

        //3.写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    public void selectByCardId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取数据
        BufferedReader br = req.getReader();
        String params = br.readLine();

        //3.调用service查询
        List<People> people = peopleService.selectByCardId(params);
        //3.把数据转为json
        String jsonString = JSON.toJSONString(people);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
}
