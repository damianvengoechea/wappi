package com.wappi.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.wappi.user_interfaces.FormularioInfoPersonal;
import com.wappi.util.Constantes;
import java.util.List;
import java.util.Map;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DiligenciarFormulario implements Interaction {

  private List<Map<String, String>> informacionPersonal;

  public DiligenciarFormulario(List<Map<String, String>> informacionPersonal) {
    this.informacionPersonal = informacionPersonal;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {

    WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
    driver
        .findElement(By.xpath("//input[@id='image']"))
        .sendKeys(informacionPersonal.get(0).get("imagen"));

    actor.attemptsTo(
        Enter.theValue(informacionPersonal.get(0).get("nombre"))
            .into(FormularioInfoPersonal.CAMPOS_FORMULARIO.of(Constantes.NOMBRE)),
        Enter.theValue(informacionPersonal.get(0).get("apellido"))
            .into(FormularioInfoPersonal.CAMPOS_FORMULARIO.of(Constantes.APELLIDO)),
        Enter.theValue(informacionPersonal.get(0).get("fecha_nacimiento"))
            .into(FormularioInfoPersonal.CAMPOS_FORMULARIO.of(Constantes.FECHA_NACI)),
        Click.on(FormularioInfoPersonal.SELECCIONAR_PAIS.of(Constantes.COLOMBIA)),
        Hit.the(Keys.ARROW_DOWN).keyIn(FormularioInfoPersonal.SEXO.of(Constantes.SEXO_FEMENINO)),
        Click.on(FormularioInfoPersonal.SEXO.of(Constantes.SEXO_FEMENINO)),
        Click.on(FormularioInfoPersonal.BTN_GUARDAR));
  }

  public static Performable conDatos(List<Map<String, String>> informacionPersonal) {
    return instrumented(DiligenciarFormulario.class, informacionPersonal);
  }
}
