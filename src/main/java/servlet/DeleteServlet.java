package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author TAO
 * @date 2018/8/13
 */
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String className="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://127.0.0.1/sakila";
        String username="root";
        String password="111111";
        Connection con = null;
        PreparedStatement pstm = null;

        int filmId = Integer.parseInt(request.getParameter("filmId"));
        int rs = -1;

        String sql = "delete from film where film_id = "+filmId;
        String sql2 = "SET FOREIGN_KEY_CHECKS = 0";

        try {
            Class.forName(className);
            con= DriverManager.getConnection(url,username,password);
            con.prepareStatement(sql2).execute();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(rs);
        if (rs>0){
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script>alert('Delete Successfully'); window.location.href='http://localhost:8080/index.jsp' </script>");
            out.flush();
            out.close();
        }

        try{
            if(pstm!=null) {
                pstm.close();
            }
        }catch(Exception e){
            System.out.println("关闭pstm对象失败！");
        }
        try{
            if(con!=null) {
                con.close();
            }
        }catch(Exception e){
            System.out.println("关闭con对象失败！");
        }


    }
}
