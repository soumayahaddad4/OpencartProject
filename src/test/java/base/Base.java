package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Cette classe va contenir tout ce qui est commun (Set up et tear down)
public class Base {
	WebDriver driver;
	public Properties prop;

	// on va utiliser la classe predefinie properties pour manipuler les proprietes
	// communes
	public Base() {
		prop = new Properties();

		// Utiliser la classe file qui fait partie de la classe java (I/O)
		// pour manipuler le fichier properties
		// le chemin du fichier config.properties
		// user.dir va lire le chemin dans la machine

		File propFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");
		// pour lire morceau par morceau a partir d'un fichier donné
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WebDriver intialiserNavigateurOuvrirUrl(String browserName) throws InterruptedException {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("qaUrl"));
		Thread.sleep(5);
		return driver;
	}

}
