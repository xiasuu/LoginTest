package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.Impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.设置编码
        req.setCharacterEncoding("utf-8");
/*
//        2.获取请求参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
//        3.封装user对象
        User loginUser=new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
*/
        HttpSession session = req.getSession();
//        2.获取所有请求参数
        Map<String, String[]> map =req.getParameterMap();
//        3.创建User对象
        User user=new User();
//        3.2使用BeanUtils封装
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        /*
//        4.调用UserDao的login方法
        UserDao dao=new UserDao();
        User user=dao.login(loginUser);
        */
//        4.调用Service查询
        UserService service=new UserServiceImpl();
        User loginUser=service.login(user);

//        5.判断user
        if(loginUser==null){
//        登录失败
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else {
//        登录成功
//          存储数据
            session.setAttribute("user",loginUser);
//          转发
            resp.sendRedirect(req.getContextPath()+"/successServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
