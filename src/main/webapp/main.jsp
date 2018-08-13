<%--
  Created by IntelliJ IDEA.
  User: TAO
  Date: 2018/8/13
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Film" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    List<Film> list = (List<Film>) request.getAttribute("filmList");
%>
<html>
<head>
    <title>主界面</title>
    <link rel="stylesheet" href="css/MainFilm.css" type="text/css">
    <script type="text/javascript" src="jquery-3.3.1.min.js"></script>

    <style>
        #addBtn{
            float: right;
            color: coral;
            padding-top: 10px;
            padding-bottom: 10px;
            padding-right: 10px;
            text-decoration: none;
            size: 30px;
        }
    </style>

</head>
<body >
    <a id="addBtn" href="http://localhost:8080/add.jsp/showLanguage?method=add">新增</a>
    <table border="1" width="100%">
        　
        <tr>
            　　　　
            <th class="th1">电影编号</th>
            <th class="th2">主题</th>
            <th class="th3">描述</th>
            <th class="th4">语言</th>
            <th class="th5">操作</th>
            　　
        </tr>

        <%
            if (!list.isEmpty()){
                for (int i = 0; i < list.size(); i++) {
                    Film film = list.get(i);

        %>

            <tr>
                <td><%=film.getFilmId()%></td>
                <td><%=film.getTitle()%></td>
                <td><%=film.getDescription()%></td>
                <td><%=film.getLanguage()%></td>
                <td>
                    <a href="http://localhost:8080/addFilm.jsp?method=update&id=<%= film.getFilmId()%>&title=<%= film.getTitle()%>&description=<%= film.getDescription()%>&language=<%= film.getLanguage()%>">修改</a>|
                    <a href="http://localhost:8080/delete?filmId=<%= film.getFilmId()%>" onclick="return confirm('确定要删除么？')" >删除</a>
                </td>
            </tr>

        <%
                }
            }
        %>

    </table>



</body>
</html>
