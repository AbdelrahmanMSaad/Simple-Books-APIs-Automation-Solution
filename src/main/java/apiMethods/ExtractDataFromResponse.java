package apiMethods;

import io.restassured.response.Response;

public class ExtractDataFromResponse {

    public Integer getStatusCodeFromResponse(Response response){
        return response.statusCode();
    }

    public String getBodyFromResponse(Response response){
        return response.getBody().asString();
    }

    public String getHeaderFromResponse(Response response,String header){
        return response.header(header);
    }
}
