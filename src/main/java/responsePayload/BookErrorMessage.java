package responsePayload;

public class BookErrorMessage {
    private String error;

    public BookErrorMessage(String error){
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
