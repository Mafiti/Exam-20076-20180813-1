package servlet;

import entity.Language;
import util.Connector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TAO
 * @date 2018/8/13
 */
public class ShowLanguageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Language> list = new ArrayList<>();
        Connector connector = new Connector();
        String sql = "select language_id,name from language";
        connector.doPstm(sql,null);

        ResultSet rs = connector.getRs();

        try {
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Language language = new Language(id,name);
                list.add(language);
            }
            request.setAttribute("languageList",list);
            request.getRequestDispatcher("/add.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connector.closed();
        }
    }
}
