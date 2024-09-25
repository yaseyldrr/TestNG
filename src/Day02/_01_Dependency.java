package Day02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {
    @Test
    public void StartCar() {
        System.out.println("Start car");
    }
    @Test(dependsOnMethods = {"StartCar"})
    public void DriveCar() {
        System.out.println("Drive car");
    }
    @Test(dependsOnMethods = {"StartCar","DriveCar"}) // Birden fazla bağımlılık
    public void ParkCar() {
        System.out.println("Park car");
        // Bağımlı metod zinciri 2 tane öncesini çalıştırır ama 3 tane de hata verir.
    }
    @Test(dependsOnMethods = {"ParkCar"}, alwaysRun = true) // Hatalı olsa da çalış
    public void StopCar() {
        System.out.println("Stop car");
    }
    //Dependency (bağımlılık):Bir testin diğer bir testin sonucuna veya
    //belirli bir duruma bağlı olduğu durumları ifade eder.
    //Örneğin, bir testin çalışabilmesi için önce başka bir testin başarılı
    //bir şekilde tamamlanması gerekebilir. Bu tür senaryolarda TestNG'nin
    // Dependency özelliği devreye girer.

    // bağımlı testler, direk metodundan çalıştırdığınızda bağımlı olduğu metod zincirinde
    // 2 üste kadar otomatik çağırıp çalışabilir.
}
