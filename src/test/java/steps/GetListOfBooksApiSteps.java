package steps;

import com.google.gson.Gson;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import responsePayload.Book;

public class GetListOfBooksApiSteps extends Steps{

    @When("User sends the get list of books API")
    public void user_sends_the_get_list_of_books_api() {
        response = apiMethods.getListOfBooksApiResponse();
    }
    @Then("The response Code is {int}")
    public void the_response_code_is(Integer statusCode) {
        softAssert.assertEquals(extractDataFromResponse.getStatusCodeFromResponse(response), statusCode);
    }

    @Then("Response Body Contains an array of non detailed books")
    public void response_body_contains_an_array_of_non_detailed_books() {
        String responseBody = extractDataFromResponse.getBodyFromResponse(response);
        Book[] books = new Gson().fromJson(responseBody,Book[].class);
        softAssert.assertNotEquals(extractDataFromResponse.getBodyFromResponse(response),null);
        softAssert.assertNotEquals(books,null);
        softAssert.assertNotEquals(books.length, 0);
        softAssert.assertEquals(books[0].getAuthor(),null);
        softAssert.assertEquals(books[0].getIsbn(),null);
        softAssert.assertEquals(books[0].getCurrentStock(),0);
        softAssert.assertAll();
    }

}
