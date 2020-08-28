package com.wappi.user_interfaces;

import static net.serenitybdd.screenplay.targets.Target.the;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaIniciarSesion extends PageObject {
  public static final Target USUARIO = the("Campo usuario").located(By.id("username"));
  public static final Target CONTRASENIA = the("Campo contraseña").located(By.id("password"));
  public static final Target BTN_INGRESAR = the("Boton ingresar").located(By.id("button-login"));
}
