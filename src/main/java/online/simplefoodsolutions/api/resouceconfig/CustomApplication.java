package online.simplefoodsolutions.api.resouceconfig;

import online.simplefoodsolutions.api.filter.AuthenticationFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class CustomApplication extends ResourceConfig
{
    public CustomApplication()
    {
        register(AuthenticationFilter.class);
    }
}
