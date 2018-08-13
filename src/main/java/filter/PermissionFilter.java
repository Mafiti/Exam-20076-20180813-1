package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by TAO on 2018/8/13.
 */
public class PermissionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //首先将参数中的ServletRequest和ServletResponse强转为Http...
        HttpServletRequest hreq= (HttpServletRequest) req;
        HttpServletResponse hresp= (HttpServletResponse) resp;

        //获取请求中的Servletpath
        String servletpath=hreq.getServletPath();
        //获取session对象
        HttpSession hsess=hreq.getSession();
        //获取session对象中flag的值，强转为String类型
        String flag= (String) hsess.getAttribute("flag");

        //如果用户登录的是首页或者是login或者是执行登录操作的话
        // 将请求直接转发给下一个组件进行处理
        //对于其他请求则都进行权限校验
        if (servletpath!=null&&(servletpath.equals("/index.jsp"))||
                (servletpath.equals("/login.jsp"))||
                (servletpath.equals("/login.jsp/login"))){

            chain.doFilter(req, resp);
        }else{
            //用户处于登录状态则可以直接进行访问
            if (flag!=null&&flag.equals("login_success")){
                chain.doFilter(req, resp);
                //登录失败,则跳转到登录界面
            }else if (flag!=null&&flag.equals("login_error")){
                hreq.setAttribute("msg","登录失败，请重新登录!!!<br/>");
                hreq.setAttribute("return_uri",servletpath);
                RequestDispatcher rd=hreq.getRequestDispatcher("/login.jsp");
                rd.forward(hreq,hresp);
                //没有登录则也跳转到login.jsp界面，并提示“您尚未登录！！！”
            }else {
                hreq.setAttribute("msg","您尚未登录！！！");
                hreq.setAttribute("return_uri",servletpath);
                RequestDispatcher rd=hreq.getRequestDispatcher("/login.jsp");
                rd.forward(hreq,hresp);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
