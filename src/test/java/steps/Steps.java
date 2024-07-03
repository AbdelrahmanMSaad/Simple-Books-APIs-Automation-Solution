package steps;

import apiMethods.ApiMethods;
import apiMethods.ExtractDataFromResponse;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

public class Steps {
    protected final ApiMethods apiMethods = new ApiMethods();
    protected final ExtractDataFromResponse extractDataFromResponse = new ExtractDataFromResponse();
    protected Response response;

    protected final SoftAssert softAssert = new SoftAssert();
}
