package windowsandframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandlingTest {

	public static void main(String[] args) {
		// Setup the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Step 1 & 2: Open browser and navigate to the URL
        driver.get("https://the-internet.herokuapp.com/windows");

        // Step 3: Click the "Click Here" button
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        // Step 4: Get window handles and switch to the new window
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> iterator = allWindows.iterator();

        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);

                // Step 5: Verify the text "New Window" is present
                String pageText = driver.findElement(By.tagName("h3")).getText();
                if (pageText.equals("New Window")) {
                    System.out.println("✅ Verified: 'New Window' text is present.");
                } else {
                    System.out.println("❌ 'New Window' text is NOT present.");
                }

                // Step 6: Close the new window
                driver.close();
            }
        }

        // Step 7: Switch back to original window
        driver.switchTo().window(mainWindow);
        System.out.println("✅ Back to original window.");

        // Step 8: Close browser instance
         driver.quit();
	}

}
