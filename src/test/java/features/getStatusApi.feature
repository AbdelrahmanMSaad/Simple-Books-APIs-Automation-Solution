Feature: Get Status API
  Scenario: Test Get Status , Validate Response Code and Response Body
    When User sends the get status API and gets the response
    Then Api response code is "200"
    Then Api Response body status is "OK"