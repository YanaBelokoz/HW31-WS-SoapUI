package ClientHTTP;

import AllUseModels.Models;
import Utils.Env;
import groovy.beans.PropertyReader;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.lang.reflect.Method;

import static io.restassured.RestAssured.given;

public class ClientHTTP {
    static PropertyReader Env = Utils.Env.getInstance();

    public static Responce get(String endpoint) {
        return ClientHTTP.sendRequest(Method.GET, endpoint);
    }
    public static Responce post(String endpoint, Models body) {
        return ClientHTTP.sendRequest(Method.POST, endpoint, body);
    }

    public static Responce put(String endpoint, Models body) {
        return ClientHTTP.sendRequest(Method.PUT, endpoint, body);
    }

    public static Responce delete(String endpoint) {
        return ClientHTTP.sendRequest(Method.DELETE, endpoint);
    }

    private static Response sendRequest(Method method, String endpoint, Models body) {
        System evn = null;
        String url = evn.getProperty("service.host") + endpoint;
        RequestSpecification spec = given().auth().preemptive().basic("admin", "password");
        if (body !=null) spec.contentType("application/json").body(body);
        return spec.request(String.valueOf(method), url);
    }
}