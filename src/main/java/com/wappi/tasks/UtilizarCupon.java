package com.wappi.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import com.wappi.user_interfaces.PaginaInicio;
import java.util.List;
import java.util.Map;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class UtilizarCupon implements Task {
  private List<Map<String, String>> articulo;

  public UtilizarCupon(List<Map<String, String>> articulo) {
    this.articulo = articulo;
  }

  String cuponObtenido = Serenity.sessionVariableCalled("cuponObtenido");

  @Override
  public <T extends Actor> void performAs(T actor) {
    for (int i = 0; i < 2; i++) {
      actor.attemptsTo(
          Click.on(PaginaInicio.ARTICULOS.of(articulo.get(0).get("articulos"))),
          Enter.theValue(cuponObtenido).into(PaginaInicio.CAMPO_DESCUENTO),
          Click.on(PaginaInicio.BTN_CONFIRMAR_PEDIDO_MODAL),
          WaitUntil.the(PaginaInicio.CERRAR_CONFIRMACION_ALERTA, isVisible()),
          Click.on(PaginaInicio.CERRAR_CONFIRMACION_ALERTA));
    }

    actor.attemptsTo(
        Click.on(PaginaInicio.ARTICULOS.of(articulo.get(2).get("articulos"))),
        Enter.theValue(cuponObtenido).into(PaginaInicio.CAMPO_DESCUENTO),
        Click.on(PaginaInicio.BTN_CONFIRMAR_PEDIDO_MODAL));
    Serenity.setSessionVariable("MensajeCuponInvalido")
        .to(PaginaInicio.MENSAJE_CUPON_INVALIDO.resolveFor(actor).getText());
  }

  public static Performable numArticulos(List<Map<String, String>> articulos) {
    return instrumented(UtilizarCupon.class, articulos);
  }
}
