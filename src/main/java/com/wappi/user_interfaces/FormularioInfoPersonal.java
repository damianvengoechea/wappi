package com.wappi.user_interfaces;

import static net.serenitybdd.screenplay.targets.Target.the;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FormularioInfoPersonal {
  public static final Target BTN_SELECCIONAR_IMAGEN =
      the("Boton para seleccionar imagen").located(By.id("image"));
  public static final Target CAMPOS_FORMULARIO =
      the("Campos del formulario").locatedBy("//input[@id='{0}']");
  public static final Target SELECCIONAR_PAIS =
      the("Seleccionar el pais ").locatedBy("//select[@id='country']/option[@value='{0}']");
  public static final Target SEXO = the("Opcion de genero").locatedBy("//input[@id='{0}']");
  public static final Target BTN_GUARDAR =
      the("Boton guardar datos").located(By.id("save-profile"));
  public static final Target MODAL_CONFIRMACION =
      the("Modal de confirmacion de actualizacion")
          .locatedBy("//p[@class='confirmation-modal-info']");
}
