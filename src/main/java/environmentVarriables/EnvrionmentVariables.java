package environmentVarriables;

public class EnvrionmentVariables {
    private final String endPoint = "https://simple-books-api.glitch.me",
            status = "status",
            books = "books",
            orders = "orders",
            clients = "api-clients";

    private String accessToken,
            order_id;

    public String getEndPoint() {
        return endPoint;
    }

    public String getStatus() {
        return status;
    }

    public String getBooks() {
        return books;
    }

    public String getOrders() {
        return orders;
    }

    public String getClients() {
        return clients;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = "Bearer %s".formatted(accessToken);
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public static void main(String[] args) {
        EnvrionmentVariables envrionmentVariables = new EnvrionmentVariables();
        System.out.println(envrionmentVariables.getEndPoint());
    }
}
