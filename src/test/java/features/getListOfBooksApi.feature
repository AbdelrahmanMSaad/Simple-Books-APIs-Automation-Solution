Feature: Get list of books API
  Scenario: Test get list of books API, validate the response code and the response body
    When User sends the get list of books API
    Then The response Code is 200
    Then Response Body Contains an array of non detailed books