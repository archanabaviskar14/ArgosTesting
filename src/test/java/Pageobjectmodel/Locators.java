package Pageobjectmodel;

import Testcases.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Locators extends BaseClass {

    public void search() throws InterruptedException
    {
        driver.findElement(By.id("searchTerm")).sendKeys("artificial flower");
        logger.info("searchText entered");
        driver.findElement(By.className("_2mKaC")).click();
        logger.info("search button clicked");
        Thread.sleep(3000);
    }

    public String selectAnyProduct() throws InterruptedException
    {
        List<WebElement> elements=driver.findElements(By.cssSelector("a[data-test='component-product-card-title']"));
        int totalElements=elements.size();
        WebElement selectedElement=elements.get(randomNumber(totalElements));
        String expectedTitle=selectedElement.getText();
        Thread.sleep(3000);
        selectedElement.click();
        return expectedTitle;
    }
    public void addProductToBasket() throws InterruptedException
    {
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[data-test='add-to-trolley-button-button']")).click();

    }
    public void goToTrolley() throws InterruptedException
    {
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[data-test='component-att-button-basket']")).click();
    }
    public List<String> getItemsInTrolley()
    {
        List<WebElement> products=driver.findElements(By.cssSelector("a[data-e2e='product-name']"));
        List<String> productInTrolley=new ArrayList<>();
        System.out.println(products.size());
        for(WebElement product:products)
        {
            String text=product.getText();
            if(!text.isEmpty())
            {
                productInTrolley.add(text);
            }
        }
        return productInTrolley;
    }
    public void selectDropdown() throws InterruptedException
    {
        Thread.sleep(3000);
        WebElement dropdownSelector=driver.findElement(By.cssSelector("select[data-e2e='product-quantity']"));
        Select option=new Select(dropdownSelector);
        option.selectByValue("2");
    }
    public Double getPriceFromTrolley()
    {
        String price=driver.findElement(By.cssSelector("span[data-e2e='product-line-price']")).getText();
        String priceWithoutSymbol=price.replace("£","");
        Double priceDouble=Double.parseDouble(priceWithoutSymbol);
        return priceDouble;
    }
    public String removeProductFromTrolley() throws InterruptedException
    {
        driver.findElement(By.cssSelector("button[data-test='basket-removeproduct']")).click();
        Thread.sleep(3000);
        String title=driver.findElement(By.cssSelector("h3[data-e2e='basket-emptytitle']")).getText();
        return title;

    }

}
