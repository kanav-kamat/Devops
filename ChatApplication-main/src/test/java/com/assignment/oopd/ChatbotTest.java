package com.assignment.oopd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChatbotTest {
    WebDriver createRoomDriver;
    WebDriver joinRoomDriver;
    String roomId = "";
    String createRoomUser = "Ram";
    String joinRoomUser = "Sham";
    String msg1 = "Hello";
    String msg2 = "Hey";

    @Test
    public void init(){
        initBrowser();
    }

    public void initBrowser(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        createRoomDriver = new ChromeDriver();
        createRoomDriver.get("http://localhost:8080");

        createRoomTest();  

        joinRoomDriver = new ChromeDriver();
        joinRoomDriver.get("http://localhost:8080"); 

        joinRoomTest(); 
        
        chatTest();
    }

    public void createRoomTest(){
        try {
            Thread.sleep(6000);
            createRoomDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/form/button")).click();
            Thread.sleep(2000);
            createRoomDriver.findElement(By.xpath("/html/body/div[1]/div/div[1]/form/div[1]/input")).sendKeys(createRoomUser);
            Thread.sleep(2000);
            createRoomDriver.findElement(By.xpath("/html/body/div[1]/div/div[1]/form/div[5]/button")).click();
            Thread.sleep(2000);
            roomId = createRoomDriver.findElement(By.xpath("/html/body/div[2]/div/div[1]/h1/span")).getText().toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void joinRoomTest() {
        try {

            Thread.sleep(6000);
            joinRoomDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/form/button")).click();
            Thread.sleep(2000);
            joinRoomDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[1]/input")).sendKeys(joinRoomUser);
            joinRoomDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[2]/input")).sendKeys(roomId);
            Thread.sleep(1000);
            joinRoomDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[3]/button")).click();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void chatTest(){
        try {
            joinRoomDriver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/input")).sendKeys(msg1);
            Thread.sleep(1000);
            joinRoomDriver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/button")).click();
            Thread.sleep(2000);
            createRoomDriver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/input")).sendKeys(msg2);
            Thread.sleep(1000);
            createRoomDriver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/button")).click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
