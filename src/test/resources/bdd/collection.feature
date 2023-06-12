Feature: CollectionsBook

  Scenario: Add Book
    Given a set of collection
    When I add a new book
    Then the new set of collection is equal to the old set with the added book