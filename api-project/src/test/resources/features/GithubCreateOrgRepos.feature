#Author: vishnuprakash
Feature: Create organization repository
  This features file hass scenarios for the Create organization repositories POST endpoint

  Scenario: Create repository with valid org,token,name
    Given path param "orgName" with value "RestAPITestingApril2022"
    And header "Authorization" with value "Bearer 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"
    And input json body for create repo key "name" with value "repo_july_13_03"
    When POST request is exectuted with "https://api.github.com/orgs/{orgName}/repos"
    Then verify status code is 201
   
  @current 
  @smoke
  Scenario: Create repository with valid org,token,name and verify deserialization
    Given path param "orgName" with value "RestAPITestingApril2022"
    And header "Authorization" with value "Bearer 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"
    And input json body for create repo with "repo_july_13_03","false","Repo with deserialization"
    When POST request is exectuted with "https://api.github.com/orgs/{orgName}/repos"
    Then verify status code is 201
    Then verify if json body has key "name" with value "repo_july_02_02"
    Then verify if response body as "repo_july_13_03","false","Repo with deserialization"

  Scenario Outline: Create repository with valid and invalid scenarios
    Given path param "orgName" with value "<orgname>"
    And header "Authorization" with value "<auth>"
    And input json body for create repo with "<repo_name>","<private>","<description>"
    When POST request is exectuted with "https://api.github.com/orgs/{orgName}/repos"
    Then verify status code is <status_code>

    Examples: 
      | orgname                 | auth                                            | repo_name       | private | description          | status_code |
      | RestAPITestingApril2022 | Bearer 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 | repo_july_13_03 | true    |                      |         201 |
      | RestAPITestingApril2022 | Bearer ghp_9999999                              | repo_july_13_03 | true    | repo from automation |         401 |
      | RestAPI3333333333332022 | Bearer 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 | repo_july_13_03 | true    | repo from automation |         404 |
      | RestAPITestingApril2022 | Bearer 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 | repo_july_13_03 | true    | repo from automation |         422 |
      | RestAPITestingApril2022 | Bearer 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 | repo_july_13_03 | true    | repo from automation |         403 |
