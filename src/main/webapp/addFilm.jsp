<%@ page import="entity.Film" %><%--
  Created by IntelliJ IDEA.
  User: TAO
  Date: 2018/8/13
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
%>

<html>
<head>
    <title>修改电影</title>
</head>
<body>
<%
    String id= request.getParameter("id");
    String title = request.getParameter("title");
    String description = request.getParameter("description");
    String language = request.getParameter("language");
    String method = request.getParameter("method");
%>

　　<form id="UpdateFrom" action="addFilm.jsp/update" method="get" >

    　　<table width="100%" height="200px" border="1">
    　　<tr>
    　　　　<td colspan="2">
                <input type="text" name="method" value="<%=method%>">
            </td>
    　　</tr>
    　　<tr>
    　　　　<td align="right">电影编号</td>
    　　　　<td>
                <input type="text" name="id" value="<%=id%>">
            </td>    　　
        </tr>
    　　<tr>
    　　　　<td align="right">标题:</td>
            <td>
                <input type="text" name="title" value="<%=title%>">
            </td>    　　
        </tr>   　　
        <tr>
            <td align="right">描述:</td>
            <td>
            　　<input type="text" name="description" value="<%=description%>">
            </td>    　　
        </tr>

        <tr>
            <td align="right">语言:</td>
            <td>
                　　<input type="text" name="language" value="<%=language%>">
            </td>    　　
        </tr>

    　　<tr>
    　　　　<td colspan='2' align="center">       　　　　
                　　<input type="submit" value="保存" name="btnSubmit">          　　　　
                　　<input type="reset" value="重置" name="btnCancel">    　　　　
            </td>
    　　</tr>
</table>
</form>

</body>
</html>
