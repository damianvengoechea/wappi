package com.wappi.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import com.wappi.user_interfaces.PaginaInicio;
import com.wappi.util.Constantes;
import java.util.logging.Logger;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ObtenerCupon implements Task {
  final Logger log = Logger.getLogger(String.valueOf(ObtenerCupon.class));

  @Override
  public <T extends Actor> void performAs(T actor) {
    String cuponObtenido;
    actor.attemptsTo(
        Click.on(PaginaInicio.BTN_OPTENER_CUPON),
        WaitUntil.the(PaginaInicio.CUPON_GENERADO, isVisible()));
    cuponObtenido = PaginaInicio.CUPON_GENERADO.resolveFor(actor).getText();
    Serenity.setSessionVariable("cuponObtenido").to(cuponObtenido);
    log.info("Este es el cupon obtenido -->  " + cuponObtenido);
    actor.attemptsTo(
        Click.on(PaginaInicio.CERRAR_MODAL_CUPON),
        Click.on(PaginaInicio.BARRA_MENU.of(Constantes.INICIO)));
  }

  public static Performable AUsar() {
    return instrumented(ObtenerCupon.class);
  }
}
