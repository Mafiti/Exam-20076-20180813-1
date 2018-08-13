package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @author TAO
 * @date 2018/8/13
 */
public class UpdateServlet extends HttpServlet {
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



        String method = request.getParameter("method");


        int rs = -1;

        if ("update".equals(method)){
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String name = request.getParameter("language");
            String sql = "update film,language " +
                    "set title = " + "'" + title + "'" + ",description = " + "'" + description + "'" + ",language.name = " + "'" + name + "'"  +
                    " where film.language_id = language.language_id and film_id = " + "'" + id + "'";

            try {
                Class.forName(className);
                con= DriverManager.getConnection(url,username,password);
                pstm = con.prepareStatement(sql);
                rs = pstm.executeUpdate();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (rs>0){
                response.setCharacterEncoding("utf-8");
                PrintWriter out = response.getWriter();
                out.print("<script>alert('Update Successfully'); window.location.href='http://localhost:8080/index.jsp' </script>");
                out.flush();
                out.close();
            }

            rs=-1;
        }else {

            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String name = request.getParameter("language");
            int language_id = 1 ;

            String sqlName = "select language_id from language where name = "+"'"+name+"'";
            System.out.println(sqlName);
            try {
                Class.forName(className);
                con= DriverManager.getConnection(url,username,password);
                pstm = con.prepareStatement(sqlName);
                ResultSet resultSet = pstm.executeQuery();
                while (resultSet.next()){
                    language_id = resultSet.getInt(1);
                }
                String sql2 = "insert into film(title,description,language_id)" +
                        "value("+"'"+title+"'"+","+"'"+description+"'"+","+"'"+language_id+"'"+")";
                pstm = con.prepareStatement(sql2);
                rs = pstm.executeUpdate();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (rs>0){
                response.setCharacterEncoding("utf-8");
                PrintWriter out = response.getWriter();
                out.print("<script>alert('Add Successfully'); window.location.href='http://localhost:8080/index.jsp' </script>");
                out.flush();
                out.close();
            }

            rs=-1;
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
