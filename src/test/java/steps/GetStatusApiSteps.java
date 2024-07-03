package steps;

import com.google.gson.Gson;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import responsePayload.Status;

public class GetStatusApiSteps extends Steps{

    @When("User sends the get status API and gets the response")
    public void user_sends_the_get_status_api_and_gets_the_response() {
        response = apiMethods.getStatusApiResposne();
    }

    @Then("Api response code is {string}")
    public void api_response_code_is(String statusCode) {
        softAssert.assertTrue(extractDataFromResponse.getStatusCodeFromResponse(response) == Integer.parseInt(statusCode));
    }

    @Then("Api Response body status is {string}")
    public void api_response_body_status_is_ok(String statusMessage) {
        Status status = new Gson().fromJson(response.getBody().asString(), Status.class);
        softAssert.assertTrue(status.getStatus() == statusMessage);
    }
}
