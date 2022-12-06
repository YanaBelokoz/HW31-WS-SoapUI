package Service;

import AllUseModels.Models;
import AllUseModels.Query;
import ClientHTTP.ClientHTTP;
import Utils.Endpoint;

public class AllService {

    public Responce getModels(Query options) {
        Endpoint endpoint = new Endpoint().pathParameter("models");
        if (options.orderType !=null) endpoint.queryParam("orderType", options.orderType);
        endpoint
                .queryParam("page", options.page)
                .queryParam("pagination", options.pagination)
                .queryParam("size", options.size);
        if (options.sortBy !=null) endpoint.queryParam("models").pathParameter(modelsId).build();
        return ClientHTTP.get(endpoint.build());
    }

    public Responce createModels (Models models) {
        String endpoint = new Endpoint().pathParameter("models").pathParameter(modelsId).build();
        return ClientHTTP.post(endpoint, models);
    }

    public Responce deleteModels (int modelsId) {
        String endpoint = new Endpoint().pathParameter("models").pathParameter(modelsId).build();
        return ClientHTTP.delete(endpoint, models);
    }

    public Responce getModelsById(Query options, Integer id) {
        Endpoint endpoint = new Endpoint().pathParameter("models").pathParameter(id);
        if (options.orderType !=null) endpoint.queryParam("orderType", options.orderType);
        endpoint
                .queryParam("page", options.page)
                .queryParam("pagination", String.valueOf(options.pagination))
                .queryParam("size", options.size);
        if (options.sortBy !=null) endpoint.queryParam("sortBy", options.sortBy);
        return ClientHTTP.get(endpoint.build());
    }
}
