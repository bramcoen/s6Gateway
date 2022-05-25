package party.coenders.s6;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletResponse;

public class AddResponseHeaderFilter extends ZuulFilter {
    public String filterType() {
        return "post";
    }

    public int filterOrder() {
        return 999;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        if (context.getRequest().getRequestURL().toString().startsWith("http://localhost")){
        HttpServletResponse servletResponse = context.getResponse();
            servletResponse.addHeader("Access-Control-Allow-Origin","http://localhost");
        }
       else if (context.getRequest().getRequestURL().toString().startsWith("https://www.coenders.party")) {
            HttpServletResponse servletResponse = context.getResponse();
            servletResponse.addHeader("Access-Control-Allow-Origin", "https://www.coenders.party");

        }
        return null;
    }
}
