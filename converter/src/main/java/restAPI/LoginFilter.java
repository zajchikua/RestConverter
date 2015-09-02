package restAPI;

import javax.servlet.*;
import java.util.Date;
import java.util.logging.Filter;

public class LoginFilter implements Filter{
    public void init(FilterConfig config)
        throws ServletException{
        //Get init parameter
        String testParam = config.getInitParameter("test-param");
        //Print out the init param
        System.out.print("Test Param: " + testParam);
    }
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws java.io.IOException, ServletException{
        //Get the IP address of the client machine
        String ipAddress = request.getRemoteAddr();
        //Log the IP address and current timestamp
        System.out.println("IP " + ipAddress + ", Time "
        + new Date().toString());
        //Pass request back down the filter chain
        chain.doFilter(request, response);
    }
    public void destroy(){
        /*
        called before the Filter instance is removed from service by the web container
         */
    }
}
