package com.singtel.todo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.singtel.todo.utils.Constants;
import com.singtel.todo.utils.PropertyUtils;

public class TodoPage {

	private static Logger logger = Logger.getLogger(TodoPage.class);
	
	@FindBy(xpath = "//h1")
	public WebElement todoHeader;
	@FindBy(xpath = "//input[@class='new-todo']")
	public WebElement addTaskTextBox;
	@FindBy(xpath = "//ul[@class='filters']//a[text()='Active']")
	public WebElement activeFilter;
	@FindBy(xpath = "//ul[@class='filters']//a[text()='Completed']")
	public WebElement completeFilter;
	@FindBy(xpath = "//input[@class='toggle']")
	public WebElement taskRadioButton;
	@FindBy(xpath = "//button[@class='clear-completed']")
	public WebElement ClearCompletedBtn;
	@FindBy(xpath = "//span[@class='todo-count']")
	public WebElement Count;
	private WebDriver webDriver;

	private String url;
	SoftAssert soft = new SoftAssert();

	public TodoPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.url = PropertyUtils.getPropertyByName(Constants.URL);
		PageFactory.initElements(webDriver, this);
	}

	public void loadTodoPage() {
		webDriver.get(url);
		soft.assertEquals(todoHeader.getText(), "todos");
	}

	public void addTaskToTheList(String str) {
		addTaskTextBox.sendKeys(str);
		addTaskTextBox.sendKeys(Keys.ENTER);
		logger.info("Task added to the list "+str);
	}

	public void verifyNewlyAddedTask(String str) {
		List<WebElement> taskList = webDriver.findElements(By.xpath("//li[@class='todo']//label"));
		for (int i = 0; i < taskList.size(); i++) {
			String task = taskList.get(i).getText();
			Assert.assertEquals(task, str);
		}
		logger.info("Verifed newly added task "+str);
	}

	public void clickActiveFilter() {
		activeFilter.click();
	}

	public void completeGivenTask(String str) {
		activeFilter.click();
		List<WebElement> taskList = webDriver.findElements(By.xpath("//li[@class='todo']//label"));
		List<WebElement> radioButtons = webDriver.findElements(By.xpath("//input[@class='toggle']"));
		for (int i = 0; i < taskList.size(); i++) {
			String task = taskList.get(i).getText();
			if (task.contentEquals(str)) {
				radioButtons.get(i).click();

			}
		}
		logger.info("Completed given task "+str);
	}

	public void verifyTaskCompleted(String str) {
		completeFilter.click();
		List<WebElement> taskList = webDriver.findElements(By.xpath("//li[@class='todo']//label"));
		for (int i = 0; i < taskList.size(); i++) {
			String task = taskList.get(i).getText();
			Assert.assertEquals(task, str);
		}
		logger.info("Completed given task "+str);
	}

	public void clickClearCompleted() {
		ClearCompletedBtn.click();

	}

	public void checkCompletedTaskRemoved() {
		completeFilter.click();
		List<WebElement> taskList = webDriver.findElements(By.xpath("//li[@class='todo']//label"));
		if (taskList.size() != 0) {
			Assert.fail("Completed Task Removed - Test Failed");
		}
	}

	public void checkActiveTaskCount(int taskCount) {
		activeFilter.click();
		List<WebElement> taskList = webDriver.findElements(By.xpath("//li[@class='todo']//label"));
		if (taskList.size() != taskCount) {
			Assert.fail("Active Task Count - Test Failed");
		}

	}

	public void itemLeftCheck(int count) {
		String itemleft = Count.getText();
		soft.assertEquals(itemleft, "" + count + " item left");
	}

}
