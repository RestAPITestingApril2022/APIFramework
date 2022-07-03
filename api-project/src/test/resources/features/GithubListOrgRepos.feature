#Author: vishnuprakash
Feature: List organization repositories
  This features file hass scenarios for the List organization repositories GET endpoint

Background: Token Generation
	Given token to be generated

  @smoke
  Scenario: GET List of organization repositories
    Given path param "orgName" with value "RestAPITestingApril2022"
    When GET request is exectuted with "orgs/{orgName}/repos"
    Then verify status code is 200

  @p2
  Scenario: GET List of organization private repositories
    Given path param "orgName" with value "RestAPITestingApril2022"
    And query param "type" with value "private"
    And header "Authorization" with value "Bearer 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"
    When GET request is exectuted with "orgs/{orgName}/repos"
    Then verify status code is 200

  @p1
  Scenario: GET List of organization private repositories limit 1
    Given path param "orgName" with value "RestAPITestingApril2022"
    And query param "type" with value "private"
    And query param "per_page" with value 1
    And header "Authorization" with value "Bearer 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"
    When GET request is exectuted with "orgs/{orgName}/repos"
    Then verify status code is 200
    And verify response body count is 2

  @p3
  Scenario: GET List of organization private repositories limit 1 and pageNo
    Given path param "orgName" with value "RestAPITestingApril2022"
    And query param "type" with value "private"
    And query param "per_page" with value 1
    And header "Authorization" with value "Bearer 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"
    When GET request is exectuted with "orgs/{orgName}/repos"
    Then verify status code is 200

  Scenario Outline: GET List of organization repositories
    Given path param "orgName" with value "<orgname>"
    And query param "type" with value "<type>"
    And header "Authorization" with value "<auth>"
    When GET request is exectuted with "orgs/{orgName}/repos"
    Then verify status code is <statuscode>

    Examples: 
      | orgname                 | auth                                            | type    | statuscode |
      | RestAPITestingApril2022 |                                                 |         |        200 |
      | aasdfasdasdf            |                                                 |         |        404 |
      | RestAPITestingApril2022 | Bearer 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 | private |        200 |
      | RestAPITestingApril2022 |                                                 | private |        200 |
