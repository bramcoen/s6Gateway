package party.coenders.s6;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.util.StreamUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;
import static org.springframework.util.ReflectionUtils.rethrowRuntimeException;

public class ModifyResponseBodyFilter extends ZuulFilter {
    public String filterType() {
        return "post";
    }

    public int filterOrder() {
        return 999;
    }

    public boolean shouldFilter() {
        RequestContext context = getCurrentContext();
        return context.getRequest().getParameter("service") == null;
    }

    public Object run() {
        try {
            RequestContext context = getCurrentContext();
            InputStream stream = context.getResponseDataStream();
            String body = StreamUtils.copyToString(stream, StandardCharsets.UTF_8);
            context.setResponseBody("Modified via setResponseBody(): "+body);
        }
        catch (IOException e) {
            rethrowRuntimeException(e);
        }
        return null;
    }
}
