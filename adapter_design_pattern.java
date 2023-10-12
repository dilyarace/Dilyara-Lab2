package adapter_design_pattern;

// Interface defining methods for interacting with web elements
interface WebDriver {
    public void getElement();     // Method to get a web element
    public void selectElement();  // Method to select a web element
}

// ChromeDriver class implementing the WebDriver interface
class ChromeDriver implements WebDriver {
    @Override
    public void getElement() {
        System.out.println("Get element from ChromeDriver");
    }

    @Override
    public void selectElement() {
        System.out.println("Select element from ChromeDriver");
    }
}

// IEDriver class that does not implement the WebDriver interface
class IEDriver {
    public void findElement() {
        System.out.println("Find element from IEDriver");
    }

    public void clickElement() {
        System.out.println("Click element from IEDriver");
    }
}

// Adapter class that converts IEDriver to WebDriver
class WebDriverAdapter implements WebDriver {
    IEDriver ieDriver;

    public WebDriverAdapter(IEDriver ieDriver) {
        this.ieDriver = ieDriver;
    }

    @Override
    public void getElement() {
        // The adapter calls the findElement method of IEDriver
        ieDriver.findElement();
    }

    @Override
    public void selectElement() {
        // The adapter calls the clickElement method of IEDriver
        ieDriver.clickElement();
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        // Create a ChromeDriver and demonstrate its methods
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.getElement();
        chromeDriver.selectElement();

        // Create an IEDriver and demonstrate its methods
        IEDriver ieDriver = new IEDriver();
        ieDriver.findElement();
        ieDriver.clickElement();

        // Use the WebDriverAdapter to adapt IEDriver to WebDriver and demonstrate its methods
        WebDriver webDriver = new WebDriverAdapter(ieDriver);
        webDriver.getElement();
        webDriver.selectElement();
    }
}
