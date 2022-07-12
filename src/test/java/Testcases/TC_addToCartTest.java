package Testcases;


import Pageobjectmodel.Locators;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;

import java.util.List;

public class TC_addToCartTest extends BaseClass{
    Locators locator=new Locators();

    @Test
    public void searchProductTest() throws InterruptedException
    {
        locator.search();
        String actualProductName=driver.findElement(By.xpath("//*[@id='product-title-8439484']")).getText();
        String expectedProductName="Artificial Flower";
        if(actualProductName.contains("Artificial Flower"))
        {
            System.out.println("test case passed");
        }
        else
        {
            System.out.println("test case failed");
        }

    }
    @Test
    public void basketTest() throws InterruptedException
    {
        locator.search();
        String expectedTitle=locator.selectAnyProduct();
        locator.addProductToBasket();
        locator.goToTrolley();
        List<String> actualTitle=locator.getItemsInTrolley();
        System.out.println(expectedTitle);
        System.out.println(actualTitle);
       }
@Test
       public void quantityTest() throws InterruptedException
       {
           locator.search();
           locator.selectAnyProduct();
           locator.addProductToBasket();
           locator.goToTrolley();
           locator.getItemsInTrolley();
           Double priceForOneProduct=locator.getPriceFromTrolley();
           Double expectedPrice=priceForOneProduct*2;
           System.out.println(expectedPrice);
           Thread.sleep(3000);
           locator.selectDropdown();
           Thread.sleep(3000);
           Double actualPrice= locator.getPriceFromTrolley();
           System.out.println(actualPrice);
           assertEquals(expectedPrice,actualPrice);
       }

       @Test
       public void emptyTrolley() throws InterruptedException
       {
           locator.search();
           locator.selectAnyProduct();
           locator.addProductToBasket();
           locator.goToTrolley();
           locator.getItemsInTrolley();
           String expectedTitle="Empty trolley!";
           String actualTitle=locator.removeProductFromTrolley();
           assertEquals(expectedTitle,actualTitle);
       }
}
