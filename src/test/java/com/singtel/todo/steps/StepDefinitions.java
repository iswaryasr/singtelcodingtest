package com.singtel.todo.steps;

import org.openqa.selenium.WebDriver;

import com.singtel.todo.pages.TodoPage;
import com.singtel.todo.utils.WebDriverUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	private TodoPage todoPage;

	private WebDriver webDriver;

	public StepDefinitions() {
		webDriver = WebDriverUtils.getWebDriver();
		todoPage = new TodoPage(webDriver);

	}

	@Given("I am on Todo Page")
	public void I_am_on_Todo_Page() throws Throwable {
		todoPage.loadTodoPage();
	}

	@When("I add a task Attend Meeting at 11AM")
	public void I_add_a_task_Attend_Meeting_at_11AM() throws Throwable {
		todoPage.addTaskToTheList("Attend Meeting at 11AM");
	}

	@Then("The task Attend Meeting should be added successfully to the list")
	public void Task_Attend_Meeting_Added_Successfully() throws Throwable {
		todoPage.verifyNewlyAddedTask("Attend Meeting at 11AM");
	}

	@Given("Attend Meeting at 11AM task is added to the list")
	public void Attend_Meeting_at_11AM_Added_To_The_List() throws Throwable {
		todoPage.verifyNewlyAddedTask("Attend Meeting at 11AM");
	}

	@When("Active filter is selected")
	public void Active_Filter_Is_Selected() throws Throwable {
		todoPage.clickActiveFilter();
	}

	@Then("The task should be present in active filter")
	public void The_Task_be_Present_In_Active_Filter() throws Throwable {
		todoPage.verifyTaskCompleted("Attend Meeting at 11AM");

	}

	@When("The task Attend Meeting at 11AM is completed")
	public void Attend_Meeting_At_11AM_is_Completed() throws Throwable {
		todoPage.completeGivenTask("Attend Meeting at 11AM");
	}

	@Then("The task should be moved to completed filter")
	public void The_Task_Moved_To_Completed_Filter() throws Throwable {
		todoPage.verifyTaskCompleted("Attend Meeting at 11AM");

	}

	@Given("A task in completed state")
	public void A_Task_In_Completed_State() throws Throwable {

		todoPage.verifyTaskCompleted("Attend Meeting at 11AM");
	}

	@Given("A task in active state")
	public void A_Task_In_Active_State() throws Throwable {
		todoPage.addTaskToTheList("Cancel Meeting at 1PM");
	}

	@When("Clear completed option is selected")
	public void Clear_Completed_Option_Selected() throws Throwable {
		todoPage.clickClearCompleted();
	}

	@Then("The completed task should be removed from the list")
	public void Completed_Tasks_Removed_From_List() throws Throwable {
		todoPage.checkCompletedTaskRemoved();
	}

	@Given("Two items added to the todo List")
	public void Two_Items_Added_To_List() throws Throwable {
		todoPage.addTaskToTheList("Test Task2");
	}

	@When("There are two items in the Active state")
	public void There__Are_Two_Items_In_Active_State() throws Throwable {
		todoPage.checkActiveTaskCount(2);
	}

	@Then("Item left count should show as 2")
	public void Item_Count_Should_Show_As_Two() throws Throwable {
		todoPage.itemLeftCheck(2);
	}
}
