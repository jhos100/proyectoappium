package stepDefinition;

import io.appium.java_client.AppiumDriver;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MyStepdefs {

    AppiumDriver<MobileElement> driver;

    @Given("que el usuario esta en la pagina de inicio de sesion")
    public void queElUsuarioEstaEnLaPaginaDeInicioDeSesion() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "34261JEHN01446");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", "com.booking");
        capabilities.setCapability("appActivity", "com.booking.startup.HomeActivity");
        capabilities.setCapability("noReset", true);

        // Dirección del servidor Appium (local o remoto)
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);  // Usar 'capabilities'
    }

    @When("el usuario ingresa un nombre de usuario valido {string} y una contrasena valida {string}")
    public void elUsuarioIngresaUnNombreDeUsuarioValidoYUnaContrasenaValida(String usuario, String contrasena) {
        // Encontrar el campo de nombre de usuario y la contraseña
        MobileElement campoUsuario = driver.findElement(By.id("com.ejemplo.app:id/usuario"));  // Ajusta el ID del elemento
        campoUsuario.sendKeys(usuario);

        MobileElement campoContrasena = driver.findElement(By.id("com.ejemplo.app:id/contrasena"));  // Ajusta el ID del elemento
        campoContrasena.sendKeys(contrasena);

        // Hacer clic en el botón de inicio de sesión
        MobileElement botonLogin = driver.findElement(By.id("com.ejemplo.app:id/iniciarSesion"));  // Ajusta el ID del elemento
        botonLogin.click();
    }

    @Then("el usuario debería ser redirigido a la pagina de inicio")
    public void elUsuarioDeberíaSerRedirigidoALaPaginaDeInicio() {
        MobileElement paginaInicio = driver.findElement(By.id("com.ejemplo.app:id/paginaInicio"));  // Ajusta el ID del elemento
        if (paginaInicio == null) {
            throw new AssertionError("El usuario no fue redirigido a la página de inicio");
        }
    }

    @And("el usuario deberia ver un mensaje de bienvenida {string}")
    public void elUsuarioDeberiaVerUnMensajeDeBienvenida(String mensajeEsperado) {
        MobileElement mensajeBienvenida = driver.findElement(By.id("com.ejemplo.app:id/mensajeBienvenida"));  // Ajusta el ID del elemento
        String mensajeActual = mensajeBienvenida.getText();

        if (!mensajeActual.equals(mensajeEsperado)) {
            throw new AssertionError("El mensaje de bienvenida no es el esperado. Esperado: " + mensajeEsperado + " pero obtuvo: " + mensajeActual);
        }
    }
}
