package roman.test.rest;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("testget")
public class TestRestServ {

    @Inject
    private TestRequestScoped testRequestScoped;

    @GET
    public String testGet() {
        return testRequestScoped.testService();
    }
}
