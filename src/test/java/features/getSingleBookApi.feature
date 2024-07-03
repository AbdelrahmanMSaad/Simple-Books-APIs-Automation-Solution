Feature: Get single book API
  Scenario: Test get a single book API which returns a book entity with more details
    Given User get a list of books
    Given User get the "1" index book id
    When User send get single book API with the book id
    Then Response status code is 200
    Then Response body contains a single book with details

  Scenario: Test getting non existant book id
    When User send get single book API with the book id 0
    Then Response status code is 404
    Then Error message will appear
