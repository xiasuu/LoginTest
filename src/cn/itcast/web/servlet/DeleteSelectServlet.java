package cn.itcast.web.servlet;

import cn.itcast.service.Impl.UserServiceImpl;
import cn.itcast.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteSelectServlet")
public class DeleteSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] id = request.getParameterValues("id");
        UserService service = new UserServiceImpl();
        service.delSelectedUser(id);
        response.sendRedirect(request.getContextPath()+"/userlistServlet");
    }
}
