package windowsandframes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class NestedFramesTest {

	public static void main(String[] args) {
		// Setup the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Open the URL
        driver.get("http://the-internet.herokuapp.com/nested_frames");

        // Switch to the top frame
        driver.switchTo().frame("frame-top");

        // --- Switch to the left frame and verify text "LEFT" ---
        driver.switchTo().frame("frame-left");
        String leftText = driver.findElement(By.xpath("//body")).getText();
        if (leftText.equals("LEFT")) {
            System.out.println("✅ Verified: LEFT frame contains 'LEFT'");
        } else {
            System.out.println("❌ LEFT frame text mismatch");
        }

        // Switch back to top frame
        driver.switchTo().parentFrame();

        // --- Switch to the middle frame and verify text "MIDDLE" ---
        driver.switchTo().frame("frame-middle");
        String middleText = driver.findElement(By.cssSelector("div")).getText();
        if (middleText.equals("MIDDLE")) {
            System.out.println("✅ Verified: MIDDLE frame contains 'MIDDLE'");
        } else {
            System.out.println("❌ MIDDLE frame text mismatch");
        }

        // Switch back to top frame
        driver.switchTo().parentFrame();

        // --- Switch to the right frame and verify text "RIGHT" ---
        driver.switchTo().frame("frame-right");
        String rightText = driver.findElement(By.xpath("//body")).getText();
        if (rightText.equals("RIGHT")) {
            System.out.println("✅ Verified: RIGHT frame contains 'RIGHT'");
        } else {
            System.out.println("❌ RIGHT frame text mismatch");
        }

        // Switch back to the main content to access bottom frame
        driver.switchTo().defaultContent();

        // --- Switch to bottom frame and verify text "BOTTOM" ---
        driver.switchTo().frame("frame-bottom");
        String bottomText = driver.findElement(By.xpath("//body")).getText();
        if (bottomText.equals("BOTTOM")) {
            System.out.println("✅ Verified: BOTTOM frame contains 'BOTTOM'");
        } else {
            System.out.println("❌ BOTTOM frame text mismatch");
        }

        // Close the browser
        //driver.quit();

	}

}
