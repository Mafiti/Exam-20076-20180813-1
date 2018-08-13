package servlet;

import util.Connector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by TAO on 2018/8/13.
 */

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        Connector connector = new Connector();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");
        PrintWriter out = response.getWriter();

        if (name == null || name.trim().equals("")){
            System.out.println("用户名不能为空");
            out.print("<script>alert('The name can not be null!');</script>");
        }else {
            String sql = "select first_name from customer where first_name =  "+"'"+name+"'" ;
            connector.doPstm(sql,null);
            ResultSet rs = connector.getRs();

            try {
                if (rs.next()){
                    System.out.println("登录成功");
                    session.setAttribute("flag","login_success");
                    out.print("<script>alert('Successful!');</script>");
                    response.sendRedirect("http://localhost:8080/index.jsp");
                }else {
                    System.out.println("查无此人!");
                    session.setAttribute("flag","login_success");
                    out.print("<script>alert('The person doesn't exist!');</script>");
                    response.sendRedirect("http://localhost:8080/login.jsp");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                out.flush();
                out.close();
                connector.closed();
            }
            }
        }
    }


