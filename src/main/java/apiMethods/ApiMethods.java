package apiMethods;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import environmentVarriables.EnvrionmentVariables;
import io.restassured.response.Response;
import requestPayload.Client;
import requestPayload.Order;
import responsePayload.AccessToken;
import responsePayload.Book;
import responsePayload.Status;

import static io.restassured.RestAssured.given;


public class ApiMethods {

    private final EnvrionmentVariables envrionmentVariables = new EnvrionmentVariables();
    private AccessToken accessToken;

    public Response getStatusApiResposne() {
        return given()
                .when()
                .get("%s/%s".formatted(envrionmentVariables.getEndPoint(), envrionmentVariables.getStatus()));
    }

    public Response getListOfBooksApiResponse(){
        return given()
                .when()
                .get("%s/%s".formatted(envrionmentVariables.getEndPoint(),envrionmentVariables.getBooks()));
    }

    public Response getASingleBookApiResponse(int book_id){
        return given()
                .when()
                .get("%s/%s/%s".formatted(envrionmentVariables.getEndPoint(),envrionmentVariables.getBooks(),book_id));
    }

    public Response getAccessTokenApiResponse(Client client) {
        JsonObject clientJsonObject = new Gson().toJsonTree(client).getAsJsonObject();
        return given()
                .header("Content-Type","application/json")
                .body(clientJsonObject.toString())
                .post(String.format("%s/%s", envrionmentVariables.getEndPoint(), envrionmentVariables.getClients()));
    }

    public String getAccessToken(Client client) {
        Response response = this.getAccessTokenApiResponse(client);
        String responseBody = response.getBody().asString();
        this.accessToken = new Gson().fromJson(responseBody, AccessToken.class);
        return this.accessToken.getAccessToken();
    }

    public Response getSubmitAnOrderApiResponse(Order order){
        JsonObject orderJsonObject = new Gson().toJsonTree(order).getAsJsonObject();
        return given()
                .header("Authorization",this.accessToken.getAccessToken())
                .header("Content-Type","application/json")
                .body(orderJsonObject.toString())
                .post("%s/%s".formatted(envrionmentVariables.getEndPoint(),envrionmentVariables.getOrders()));
    }

    public Response getAllOrdersApiResponse(){
        return given()
                .header("Authorization",this.accessToken.getAccessToken())
                .header("Content-Type","application/json")
                .get("%s/%s".formatted(envrionmentVariables.getEndPoint(),envrionmentVariables.getOrders()));
    }

    public Response getSingleOrderApiResponse(String orderId){
        return given()
                .header("Authorization",this.accessToken.getAccessToken())
                .header("Content-Type","application/json")
                .get("%s/%s/%s".formatted(envrionmentVariables.getEndPoint(),envrionmentVariables.getOrders(),envrionmentVariables.getOrder_id()));
    }




    public static void main(String[] args) {
        ApiMethods apiMethods = new ApiMethods();
//        Status status = new Gson().fromJson(apiMethods.getStatusApiResposne().getBody().asString(),Status.class);
//        System.out.println(status.getStatus());
        Book[] books = new Gson().fromJson(apiMethods.getListOfBooksApiResponse().getBody().asString(),Book[].class);
        System.out.println(books[0].getName());
    }


}
