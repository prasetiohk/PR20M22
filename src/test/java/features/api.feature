Feature: Test Automation GoRest Rest Api

  @api
  Scenario: Test get list data normal
    Given prepare url for "GET_ALL_LIST_DATA"
    And hit api get all list data
    Then validation status code is equals 200
    Then validation response body get list user data
    Then validation response json with JSONSchema "get_list_data.json"

  @api
  Scenario: Test get data specific
    Given prepare url for "GET_DATA_SPECIFIC"
    And hit api get data specific
    Then validation status code is equals 200
    Then validation response body data specific
    Then validation response json with JSONSchema "get_data_specific.json"

  @api
  Scenario: Test get data wrong id
    Given prepare url for "GET_DATA_WRONG_ID"
    And hit api get data wrong id
    Then validation status code is equals 404
    Then validation response body wrong id

  @api
  Scenario: Test post create new data
    Given prepare url for "GET_POST_CREATE_NEW_DATA"
    And hit api post create new data
    Then validation status code is equals 201
    Then validation response body post create new data
    Then validation response json with JSONSchema "post_create_new_data.json"

  @api
  Scenario: Test delete new data
    Given prepare url for "GET_POST_CREATE_NEW_DATA"
    And hit api post create new data
    Then validation status code is equals 201
    Then validation response body post create new data
    And hit api delete new data
    Then validation status code is equals 204




