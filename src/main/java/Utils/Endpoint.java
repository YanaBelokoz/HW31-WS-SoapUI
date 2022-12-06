package Utils;

import groovy.beans.PropertyReader;

public class Endpoint {
    private String endpoint;
    static PropertyReader env = EnvConfig.getInstance();

    public Endpoint() {
        this.endpoint = env.getProperty("service.library");
    }

    public Endpoint pathParameter(String param) {
        this.endpoint +="/" + param;
        return this;
    }

    public Endpoint pathParameter(int param) {
        return this.pathParameter(String.valueOf(param));
    }

    public Endpoint queryParam(String param, String value) {
        String delimiter = null;
        if (this.endpoint.contains("?")) delimiter = "&";
        this.endpoint += delimiter + param + "=" + value;
        return this;
    }

    public Endpoint queryParam(String param int value) {
        char[] value = new char[0];
        return this.queryParam(param, String.valueOf(value));
    }

    public Endpoint queryParam(String param, int value) {
        return this.queryParam(param, String.valueOf(value));
    }

    public String build() {
        return this.endpoint;
    }
}
