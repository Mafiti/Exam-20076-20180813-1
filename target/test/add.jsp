<%@ page import="java.util.List" %>
<%@ page import="entity.Language" %><%--
  Created by IntelliJ IDEA.
  User: TAO
  Date: 2018/8/13
  Time: 20:44
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
    <title>添加影片</title>
</head>

<style>
    .input{
        width: 90%;
        left: 0px;
    }
</style>
<body>

<%
    String method = request.getParameter("method");
    List<Language> list = (List<Language>) request.getAttribute("languageList");
%>

　<form id="UpdateFrom" action="http://localhost:8080/addFilm.jsp/update" method="get" >

    　　<table width="100%" height="200px" border="1">
    　　<tr>
    　　　　<td colspan="2">
    <input type="text" name="method" value="<%=method%>">
</td>
    　　</tr>
    　　
    　　<tr>
    　　　　<td align="right">标题:</td>
    <td>
        <input class="input" type="text" name="title">
    </td>    　　
</tr>   　　
    <tr>
        <td align="right">描述:</td>
        <td>
            　　<input class="input" type="text" name="description" >
        </td>    　　
    </tr>

    <tr>
        <td align="right">语言:</td>
        <td>
            <select name="language">
                <%
                    if (!list.isEmpty()){
                        for (int i = 0; i < list.size(); i++) {
                %>
                    <option><%=list.get(i).getLanguageName()%></option>
                <%
                        }
                    }
                %>
            </select>
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
