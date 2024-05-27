import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        boolean shouldExit = false;
        while (!shouldExit) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Lab 1.1");
            System.out.println("2. Lab 1.2");
            System.out.println("3. Lab 1.3");
            System.out.println("4. Lab 2.1");
            System.out.println("5. Lab 2.2");
            System.out.println("6. Lab 3.1");
            System.out.println("7. Lab 3.2");
            System.out.println("8. Lab 3.3");
            System.out.println("0. Exit");
            System.out.print("Select task: ");
            int number = scanner.nextInt();
            switch (number) {
                case 0:
                    shouldExit = true;
                    break;
                case 1:
                    Lab1_1();
                    break;
                case 2:
                    Lab1_2();
                    break;
                case 3:
                    Lab1_3();
                    break;
                case 4:
                    Lab2_1();
                    break;
                case 5:
                    Lab2_2();
                    break;
                case 6:
                    Lab3_1();
                    break;
                case 7:
                    Lab3_2();
                    break;
                case 8:
                    Lab3_3();
                    break;
            }
        }
    }
    static void Lab1_1() throws InterruptedException {
        WebDriver driver = GetWebDriver();
        driver.get("https://suninjuly.github.io/xpath_examples");
        WebElement Button = driver.findElement(By.xpath("//button[text()='Gold']"));
        Button.click();
        Thread.sleep(5000);
        driver.quit();
    }
    static void Lab1_2() throws InterruptedException {
        WebDriver driver = GetWebDriver();
        driver.get("https://suninjuly.github.io/simple_form_find_task.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement textBox = driver.findElement(By.tagName("input"));
        textBox.sendKeys("Roman");
        WebElement textBox2 = driver.findElement(By.name("last_name"));
        textBox2.sendKeys("Drozhzhin");
        WebElement textBox3 = driver.findElement(By.className("city"));
        textBox3.sendKeys("Stavropol");
        WebElement textBox4 = driver.findElement(By.id("country"));
        textBox4.sendKeys("Russia");
        WebElement Button = driver.findElement(By.cssSelector("button"));
        Button.click();
        Thread.sleep(5000);
        driver.quit();
    }

    static void Lab1_3() throws InterruptedException {
        WebDriver driver = GetWebDriver();
        driver.get("http://suninjuly.github.io/find_link_text");
        double result= Math.ceil(Math.pow(Math.PI, Math.E)*10000);
        String strResult = String.valueOf((int) result);
        System.out.println("Result" +strResult);
        WebElement submitButton = driver.findElement(By.linkText(strResult));
        submitButton.click();
        WebElement textBox = driver.findElement(By.tagName("input"));
        textBox.sendKeys("Roman");
        WebElement textBox2 = driver.findElement(By.name("last_name"));
        textBox2.sendKeys("Drozhzhin");
        WebElement textBox3 = driver.findElement(By.className("city"));
        textBox3.sendKeys("Stavropol");
        WebElement textBox4 = driver.findElement(By.id("country"));
        textBox4.sendKeys("Russia");
        WebElement Button = driver.findElement(By.cssSelector("button"));
        Button.click();
        Thread.sleep(5000);
        driver.quit();
    }
    static void Lab2_1() throws InterruptedException {
        WebDriver driver = GetWebDriver();
        driver.get("https://suninjuly.github.io/math.html");
        WebElement el = driver.findElement(By.id("input_value"));
        int x = Integer.parseInt(el.getText());
        double y = Math.log(Math.abs(12 * Math.sin(x)));
        WebElement input = driver.findElement(By.id("answer"));
        input.sendKeys(Double.toString(y));
        WebElement chekbox = driver.findElement(By.id("robotCheckbox"));
        chekbox.click();
        WebElement radiobox = driver.findElement(By.id("robotsRule"));
        radiobox.click();
        WebElement button = driver.findElement(By.cssSelector("button"));
        button.click();
        Thread.sleep(5000);
        driver.quit();
    }
    static void Lab2_2() throws InterruptedException {
        WebDriver driver = GetWebDriver();
        driver.get("https://suninjuly.github.io/get_attribute.html");
        WebElement el = driver.findElement(By.id("treasure"));
        int x = Integer.parseInt(el.getAttribute("valuex"));
        double y = Math.log(Math.abs(12*Math.sin(x)));
        WebElement input = driver.findElement(By.id("answer"));
        input.sendKeys(Double.toString(y));
        WebElement chekbox = driver.findElement(By.id("robotCheckbox"));
        chekbox.click();
        WebElement radiobox = driver.findElement(By.id("robotsRule"));
        radiobox.click();
        WebElement button = driver.findElement(By.cssSelector("button"));
        button.click();
        Thread.sleep(5000);
        driver.quit();
    }
    static void Lab3_1() throws InterruptedException {
        WebDriver driver = GetWebDriver();
        driver.get("https://suninjuly.github.io/selects1.html");

        WebElement num1 = driver.findElement(By.id("num1"));
        int nom1 = Integer.parseInt(num1.getText());
        WebElement num2 = driver.findElement(By.id("num2"));
        int nom2 = Integer.parseInt(num2.getText());
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByVisibleText(Integer.toString(nom1 + nom2));

        WebElement btn = driver.findElement(By.cssSelector(".btn"));
        btn.click();

        Thread.sleep(5000);
        driver.quit();

    }
    static void Lab3_2() throws InterruptedException {
        WebDriver driver = GetWebDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://SunInJuly.github.io/execute_script.html");

        WebElement value = driver.findElement(By.id("input_value"));
        int x = Integer.parseInt(value.getText());
        double y= Math.log(Math.abs(12* Math.sin(x)));

        WebElement form = driver.findElement(By.id("answer"));
        form.sendKeys(Double.toString(y));

        WebElement button = driver.findElement(By.cssSelector("button"));
        js.executeScript("return arguments[0].scrollIntoView(true)",button);

        WebElement robotCheckbox = driver.findElement(By.id("robotCheckbox"));
        robotCheckbox.click();
        WebElement robotsRule = driver.findElement(By.id("robotsRule"));
        robotsRule.click();
        button.click();

        Thread.sleep(5000);
        driver.quit();
    }
    static void Lab3_3() throws InterruptedException {
        WebDriver driver = GetWebDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("http://suninjuly.github.io/file_input.html");

        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("Roman");
        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("Drozhzhin");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("mail");

        driver.findElement(By.id("file")).sendKeys("C:\\Projects\\TestLabs\\file.txt");
        WebElement button = driver.findElement(By.cssSelector("button"));
        button.click();

        Thread.sleep(5000);
        driver.quit();
    }
    static WebDriver GetWebDriver() {
        System.setProperty("webdriver.chrome.driver","C:\\Projects\\TestLabs\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        return  driver;
    }
}