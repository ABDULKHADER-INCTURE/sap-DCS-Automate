package com.sap.dcs.automation;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TicketCreationNew {
  @Test
  public static void main() throws InterruptedException
  {



Scanner scanner = new Scanner( System.in );

  System.out.print( "Enter the URL for Regression Testing: " );
  String url = scanner.nextLine();


  System.out.println("Enter Username & Password: ");
  String uname = scanner.nextLine();
  String pwd = scanner.nextLine();

  System.out.println( "url = " + url );
  System.out.println( "UserName = " + uname );
  System.out.println( "Password = " + pwd );

  
  String Dir = System.getProperty("user.dir");
  //String Dir = System.out.println("Dir  : "+System.getProperty("user.dir")+"\\ChromeDriver");

  System.setProperty("webdriver.chrome.driver", Dir + "\\chromedriver.exe");
  WebDriver driver = new ChromeDriver();

  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

  driver.get(url);
  driver.manage().window().maximize();
  System.out.println("Portal opened");
  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

  driver.findElement(By.xpath("//*[@id='j_username']")).sendKeys( new String[] {uname});
  System.out.println("User name entered");
  driver.findElement(By.xpath("//*[@id='j_password']")).sendKeys(new String[] {pwd});
  System.out.println("password entered");
  driver.findElement(By.xpath("//*[@id='logOnFormSubmit']")).click();
  System.out.println("Logged In");
  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);


  WebElement selectRole=driver.findElement(By.xpath("//*[@id='__item3-__table0-0']"));
  System.out.println("driversearch"+driver);
  System.out.println("selectRole = "+selectRole.isDisplayed());
  System.out.println("selectRole = "+selectRole.isEnabled());
  Actions actions = new Actions(driver);
  actions.moveToElement(selectRole);
  actions.click(selectRole).perform();
  System.out.println("OPERATOR ROLE IS CLICKED");

  WebDriverWait wait = new WebDriverWait(driver, 1000);
  WebElement confirmRole= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__button0']")));
  confirmRole.click();
  System.out.println("OPERATOR ROLE IS SUBMITTED");

  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

  WebElement selectVehicle=driver.findElement(By.xpath("//*[@id='__item4-__table1-0_cell2']"));
  System.out.println("driversearch"+driver);
  System.out.println("selectVehicle = "+selectVehicle.isDisplayed());
  System.out.println("selectVehicle = "+selectVehicle.isEnabled());
  Actions actions1 = new Actions(driver);
  actions1.moveToElement(selectVehicle);
  actions1.click(selectVehicle).perform();
  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
  String vehicheUSer = selectVehicle.getText();
  System.out.println("VEHICLE IS ALLOTED TO :"+vehicheUSer);

  if(vehicheUSer== null || vehicheUSer.contains(uname))
  {
  	WebElement confirmVehicle1= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__button1']")));
  	confirmVehicle1.click();
  	System.out.println("VEHICLE IS SUBMITTED");

  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

  WebElement confirmMessage= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__button2-inner']")));
  confirmMessage.click();
  System.out.println("MESSAGE IS SUBMITTED");

  //create new ticket

  Thread.sleep(3000);

  WebElement createNewTicket= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__component0---landingDetail--aboPanel']/div//*[@id='__tile0-__component0---landingDetail--aboPanel-0']")));
  System.out.println("createNewTicket isDisplayed = "+createNewTicket.isDisplayed());
  System.out.println("createNewTicket isEnabled = "+createNewTicket.isEnabled());
  System.out.println("createNewTicket isSelected = "+createNewTicket.isSelected());
  Actions actions3 = new Actions(driver);
  actions3.moveToElement(createNewTicket);
  actions3.click(createNewTicket).perform();
  System.out.println("CLICKED ON CREATE NEW TICKET");



  //TICKET NUMBER

  long date = System.currentTimeMillis();

  String tcnumber = date+"";

  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
  WebElement ticketNumber= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__component0---ticketCaptureDetails--tcTicketNumberInputId-inner']")));
  ticketNumber.sendKeys(tcnumber);
  System.out.println("TICKET NUMBER ENTERED");



  //CARNET DETAIS

  Thread.sleep(2000);
  WebElement selectpaymenttype=driver.findElement(By.xpath("//*[@id='__component0---ticketCaptureDetails--tcPaymentTransactionId']"));
  System.out.println("selectpaymenttype = "+selectpaymenttype.isDisplayed());
  System.out.println("selectpaymenttype = "+selectpaymenttype.isEnabled());
  Actions actions7 = new Actions(driver);
  actions7.moveToElement(selectpaymenttype);
  actions7.click(selectpaymenttype).perform();
  System.out.println("PaymentType IS SELECTED");

  Thread.sleep(3000);
  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
  WebElement selectcarnet= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__item11-__component0---ticketCaptureDetails--tcPaymentTransactionId-2']")));
  Actions actions8 = new Actions(driver);
  actions8.moveToElement(selectcarnet);
  actions8.click(selectcarnet).perform();
  System.out.println("Payment carnet selected");


  Thread.sleep(3000);
  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
  WebElement entercarnetnumber= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__component0---ticketCaptureDetails--tcCardNumberInputId-inner']")));
  entercarnetnumber.sendKeys("1234567891234567892");
  System.out.println("Carnet number ENTERED");

  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
  WebElement entercarnetcustomer= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__component0---ticketCaptureDetails--tcEpodCustomerNameInputId-inner']")));
  entercarnetcustomer.sendKeys("TEST");
  System.out.println("Carnet customer name ENTERED");



  //CARNET DETAILS

  //FLIGHT INFO
  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
  WebElement enterDestination= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__component0---ticketCaptureDetails--tcFinalDestinationNameInputId-inner']")));
  enterDestination.sendKeys("CHENNAI");
  System.out.println("DESTINATION ENTERED");

  WebElement selectDestination=driver.findElement(By.xpath("//*[@id='__item8-__component0---ticketCaptureDetails--tcFinalDestinationNameInputId-0-sli']"));
  System.out.println("driversearch"+driver);
  System.out.println("selectDestination = "+selectDestination.isDisplayed());
  System.out.println("selectDestination = "+selectDestination.isEnabled());
  Actions actions5 = new Actions(driver);
  actions5.moveToElement(selectDestination);
  actions5.click(selectDestination).perform();
  System.out.println("Destination IS SELECTED");

  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
  WebElement enterFlightno= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__component0---ticketCaptureDetails--tcFlightNumber-inner']")));
  enterFlightno.sendKeys("AK01");
  System.out.println("FLIGHT NO. ENTERED");


  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
  WebElement enterFlightType= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__component0---ticketCaptureDetails--tcAircraftTypeInputId-inner']")));
  enterFlightType.sendKeys("B737");
  System.out.println("FlightType ENTERED");

  Thread.sleep(1000);
  WebElement selectFlightTypesel=driver.findElement(By.xpath("//*[@id='__component0---ticketCaptureDetails--tcAircraftTypeInputId-popup-list-listUl']"));
  System.out.println("driversearch"+driver);
  System.out.println("selectFlightTypesel = "+selectFlightTypesel.isDisplayed());
  System.out.println("selectFlightTypesel = "+selectFlightTypesel.isEnabled());
  Actions actions6 = new Actions(driver);
  actions6.moveToElement(selectFlightTypesel);
  actions6.click(selectFlightTypesel).perform();
  System.out.println("FlightType IS SELECTED");

  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
  WebElement enterFlightReg= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__component0---ticketCaptureDetails--tcAircraftRegistrationNumberId-inner']")));
  enterFlightReg.sendKeys("AK01");
  System.out.println("FlightRegType ENTERED");


  //Fueling Time
  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
  WebElement enterFuelstarttime= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__component0---ticketCaptureDetails--tcFuelStartTimeId-inner']")));
  enterFuelstarttime.sendKeys("23:50");
  System.out.println("Fueling Start Time ENTERED");

  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
  WebElement enterFuelendtime= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__component0---ticketCaptureDetails--tcFuelEndTimeId-inner']")));
  enterFuelendtime.sendKeys("23:58");
  System.out.println("Fueling Start Time ENTERED");

  // Fueling Time


  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
  WebElement startMeterReading= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__component0---ticketCaptureDetails--tcMeterStartReadingId-inner']")));
  String meterReading =startMeterReading.getAttribute("value");
  System.out.println("startMeterReading : "+meterReading);

  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
  WebElement endMeterReading= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__component0---ticketCaptureDetails--tcMeterEndReadingId-inner']")));
  float EndMeter = Float.parseFloat(meterReading) + 1000;
  System.out.println("endMeterReading : "+EndMeter);
  endMeterReading.sendKeys(String.valueOf(EndMeter));
  System.out.println("endMeterReading ENTERED");

  //submit
  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
  WebElement ticketSubmit= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__button5-inner']")));
  ticketSubmit.click();
  System.out.println("TICKET SUBMIT CLICKED");


  //REVIEW & SUBMIT
  driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
  WebElement reviewTicketSubmit= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__component0---ticketCaptureDetailsReview--SubmitReviewBtnId-inner']")));
  reviewTicketSubmit.click();
  System.out.println("REVIEWD & TICKET SUBMIT CLICKED");

  driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
  WebElement acceptSubmit= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__button9-inner']")));
  acceptSubmit.click();
  System.out.println("TICKET SUBMITTED");

  }
  else{
  	System.out.println("VEHICLE IS NOT EMPTY");
  }
  }

}
