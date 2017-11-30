package roman.test.rest;


import javax.enterprise.context.RequestScoped;


@RequestScoped
public class TestRequestScoped {

    public String testService() {
        return "test successful";
    }
}
