package com.pomObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentInformationpage {


@FindBy(xpath = "//a[@href='addPayment.php']")
private WebElement addpaymentlink;

public PaymentInformationpage(WebDriver driver)

{
	PageFactory.initElements(driver, this);
}

public WebElement getAddpaymentlink() {
	return addpaymentlink;
}

}
