package steps;

import com.google.gson.Gson;
import errorMessages.ErrorMessages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import responsePayload.Book;
import responsePayload.BookErrorMessage;

public class GetSingleBookApiSteps extends Steps {
    private int bookId;

    @Given("User get a list of books")
    public void user_get_a_list_of_books() {
        response = apiMethods.getListOfBooksApiResponse();
    }

    @Given("User get the {string} index book id")
    public void user_get_the_book_id(String index) {
        int intIndex = Integer.parseInt(index);
        intIndex--;
        String responseBody = extractDataFromResponse.getBodyFromResponse(response);
        Book[] books = new Gson().fromJson(responseBody, Book[].class);
        bookId = books[intIndex].getId();
    }

    @When("User send get single book API with the book id")
    public void user_send_get_single_book_api_with_the_book_id() {
        response = apiMethods.getASingleBookApiResponse(bookId);
    }

    @Then("Response status code is {int}")
    public void response_code_is(Integer statusCode) {
        softAssert.assertEquals(extractDataFromResponse.getStatusCodeFromResponse(response), statusCode);
    }

    @Then("Response body contains a single book with details")
    public void response_body_contains_a_single_book_with_details() {
        Book book = new Gson().fromJson(extractDataFromResponse.getBodyFromResponse(response), Book.class);
        softAssert.assertEquals(book.getId(), bookId);
        softAssert.assertNotEquals(book.getName(), null);
        softAssert.assertNotEquals(book.getAuthor(), null);
        softAssert.assertNotEquals(book.getIsbn(), null);
        softAssert.assertNotEquals(book.getType(), null);
        softAssert.assertNotEquals(book.getPrice(), null);
        softAssert.assertNotEquals(book.getCurrentStock(), null);
        softAssert.assertNotEquals(book.isAvailable(), null);
        softAssert.assertAll();
    }

    @When("User send get single book API with the book id {int}")
    public void user_send_get_single_book_api_with_the_book_id(Integer index) {
        System.out.println(index);
        bookId = index;
        response = apiMethods.getASingleBookApiResponse(index);
    }
    @Then("Error message will appear")
    public void error_message_will_appear() {
        BookErrorMessage bookErrorMessage = new Gson().fromJson(extractDataFromResponse.getBodyFromResponse(response),BookErrorMessage.class);
        softAssert.assertEquals(bookErrorMessage.getError(), "%s%s".formatted(ErrorMessages.bookErrorMessage,bookId));
        softAssert.assertAll();
    }
}
