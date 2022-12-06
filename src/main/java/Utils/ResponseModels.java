package Utils;

import AllUseModels.Models;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

public class ResponseModels {
    public List<Models> getAsModelsClassArray(Response response) {
        return Arrays.asList(response.getBody().as(Models[].class));
    }

    public Models getAsModelsClass(Response response) {
        return response.body().as(Models.class);
    }
}
