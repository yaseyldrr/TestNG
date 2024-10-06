package Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseDriverGeneral {
    public static Logger logEkle = LogManager.getLogger(); //Logları ekleyeceğim kuyruğu başlattım.
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void BaslangicIslemleri () {
        logEkle.info("Loglama işlemi başladı");
        // System.out.println("Başlangıç işlemleri yapılıyor");

        driver = new ChromeDriver();
        logEkle.info("Driver Başlatıldı");

        //hata oluşmuş olsaydı
        logEkle.error("Driver oluşturulurken hata oluştu");

        //driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // 20 sn mühlet: elementi bulma mühleti
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Login();
    }

    @AfterClass
    public void KapanisIslemleri () {
        // System.out.println("Kapanis işlemleri yapılıyor");

        Tools.Wait(3);
        driver.quit();
        logEkle.info("Loglama işlemi bitti");
    }

    public void Login () {
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        Tools.Wait(2);

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("yasetest1@gmail.com");
        logEkle.info("Şu anda " + "testng1@gmail.com" + " isimli user login olmak için gönderildi");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("messi");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
        loginBtn.click();

        wait.until(ExpectedConditions.titleIs("My Account"));
        logEkle.debug("Login işlemi testine geçiliyor");
        Assert.assertTrue(driver.getTitle().equals("My Account"), "Login olunamadı");
        logEkle.debug("Login işlemi başarıyla yapıldı");
        logEkle.warn("Login işlemlerinde testng1@gmail.com kullanıca önemli hata oluştu");
    }

    @BeforeMethod
    public void BeforeMetod ()
    {
        logEkle.info("Metod çalışmaya başlayacak");
    }

    @AfterMethod
    public void AfterMetod (ITestResult sonuc) // ITestResult: tesin sonuç ve isim bilgisini olduğu değişkeni
    {
        logEkle.info(sonuc.getName() + " Metod çalışması tamalandı");
        logEkle.info(sonuc.getStatus() == 1 ? "Passed" : "failed");  //ternary operatörü

        //çok önemli fata oldu
        logEkle.fatal(sonuc.getName() + " Metod da çok önemli hata oldu");
    }
}


