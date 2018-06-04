package com.epam.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://github.com/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//a[contains(@aria-label, 'Create new')]")
	private WebElement buttonCreateNew;

	@FindBy(xpath = "//a[contains(text(), 'New repository')]")
	private WebElement linkNewRepository;

	@FindBy(xpath = "//span[@class='dropdown-caret']")
	private WebElement userDropdownMenu;

	@FindBy(xpath = "//button[@class='dropdown-item dropdown-signout']")
	private WebElement logoutButton;

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnCreateNewRepositoryButton()
	{
		buttonCreateNew.click();
		linkNewRepository.click();
	}

	public void clickOnLogoutButton() {
		userDropdownMenu.click();
		logoutButton.click();
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
        logger.info("Main page opened");
	}
}
