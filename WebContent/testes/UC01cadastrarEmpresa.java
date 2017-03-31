package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UC01cadastrarEmpresa {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUC01cadastrarEmpresa() throws Exception {
    driver.get(baseUrl + "/sceweb/visao/FormEmpresa.jsp");
    driver.findElement(By.id("campo")).clear();
    driver.findElement(By.id("campo")).sendKeys("Open Informatica");
    driver.findElement(By.name("txtCNPJ")).clear();
    driver.findElement(By.name("txtCNPJ")).sendKeys("96606141958");
    driver.findElement(By.name("txtNomeFantasia")).clear();
    driver.findElement(By.name("txtNomeFantasia")).sendKeys("Open Informatica Ltda");
    driver.findElement(By.name("txtEndereco")).clear();
    driver.findElement(By.name("txtEndereco")).sendKeys("Rua Taquari");
    driver.findElement(By.name("txtTelefone")).clear();
    driver.findElement(By.name("txtTelefone")).sendKeys("(11) 933210122");
    driver.findElement(By.name("txtResponsavel")).clear();
    driver.findElement(By.name("txtResponsavel")).sendKeys("Joao Alberto");
    driver.findElement(By.name("txtTelefoneResponsavel")).clear();
    driver.findElement(By.name("txtTelefoneResponsavel")).sendKeys("(11) 933210122");
    driver.findElement(By.name("txtSetor")).clear();
    driver.findElement(By.name("txtSetor")).sendKeys("Desenvolvimento");
    driver.findElement(By.name("txtEmail")).clear();
    driver.findElement(By.name("txtEmail")).sendKeys("joaoalb@gmail.com");
    driver.findElement(By.id("botao")).click();
    try {
      assertEquals("cadastro realizado com sucesso", driver.findElement(By.cssSelector("form[name=\"formEmpresaIncluir\"] > label")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
