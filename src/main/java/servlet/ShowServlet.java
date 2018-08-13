package servlet;

import entity.Film;
import util.Connector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by TAO on 2018/8/13.
 */
public class ShowServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sql = "select film_id,title,description,language.name " +
                "from Film,language" +
                " where Film.language_id = language.language_id";

        Connector connector = new Connector();
        connector.doPstm(sql,null);
        ResultSet rs = connector.getRs();
        List<Film> list = new ArrayList<>();

        try {
            while (rs.next()){
                int filmId = rs.getInt(1);
                String title = rs.getString(2);
                String description = rs.getString(3);
                String language = rs.getString(4);
                Film film = new Film(filmId,title,description,language);
                list.add(film);
            }

            request.setAttribute("filmList",list);
            request.getRequestDispatcher("/main.jsp").forward(request, response);



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connector.closed();
        }

    }
}
