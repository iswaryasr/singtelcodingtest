@TodoMVC
Feature: Verify all the scenarios related for Manage Todo list as a MVC user

  @AddTaskAttendMeeting
  Scenario: Add a Todo task to the list
    Given I am on Todo Page
    When I add a task Attend Meeting at 11AM
    Then The task Attend Meeting should be added successfully to the list

  @AddedTaskInActiveFilter
  Scenario: Newly added task to be present under active filter
    Given Attend Meeting at 11AM task is added to the list
    When Active filter is selected
    Then The task should be present in active filter

  @CompleteAddedtask
  Scenario: Complete the added task in the Todo list
    Given Attend Meeting at 11AM task is added to the list
    When The task Attend Meeting at 11AM is completed
    Then The task should be moved to completed filter

  @ClearOnlyCompletedTask
  Scenario: Clear only completed task
    Given A task in completed state
    And A task in active state
    When Clear completed option is selected
    Then The completed task should be removed from the list

  @CheckTheItemCount
  Scenario: Item count should be updated correctly
    Given Two items added to the todo List
    When There are two items in the Active state
    Then Item left count should show as 2
