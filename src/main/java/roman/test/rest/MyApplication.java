package roman.test.rest;


import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;


@ApplicationPath("test")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        packages("roman.test.rest");
    }
}