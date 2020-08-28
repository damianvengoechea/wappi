package com.wappi.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import com.wappi.user_interfaces.PaginaInicio;
import com.wappi.util.Constantes;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SeleccionarArticulos implements Task {

  final Logger log = Logger.getLogger(String.valueOf(SeleccionarArticulos.class));

  private List<Map<String, String>> nombreArticulo;

  public SeleccionarArticulos(List<Map<String, String>> nombreArticulo) {
    this.nombreArticulo = nombreArticulo;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    int contador = 0;
    int tamanioArticulos = nombreArticulo.size();
    Serenity.setSessionVariable("tamanioArticulos").to(tamanioArticulos);
    String cuponObtenido = Serenity.sessionVariableCalled("cuponObtenido");

    log.info("Tamaño de la lista de articulos--> " + tamanioArticulos);

    for (int i = 0; i < tamanioArticulos; i++) {
      String tieneCupon = nombreArticulo.get(i).get("cupon");
      switch (tieneCupon) {
        case "Si":
          if (contador < 3) {
            contador = contador + 1;
            actor.attemptsTo(
                Click.on(PaginaInicio.ARTICULOS.of(nombreArticulo.get(i).get("articulos"))),
                Enter.theValue(cuponObtenido).into(PaginaInicio.CAMPO_DESCUENTO),
                Click.on(PaginaInicio.BTN_CONFIRMAR_PEDIDO_MODAL));
            if (PaginaInicio.MENSAJE_CUPON_INVALIDO.resolveFor(actor).isVisible()) {
              log.info(
                  "El cupon obtenido es --> "
                      + PaginaInicio.MENSAJE_CUPON_INVALIDO.resolveFor(actor).getText());
              Serenity.setSessionVariable("MensajeCuponInvalido")
                  .to(PaginaInicio.MENSAJE_CUPON_INVALIDO.resolveFor(actor).getText());
              actor.attemptsTo(
                  Clear.field(PaginaInicio.CAMPO_DESCUENTO),
                  Click.on(PaginaInicio.BTN_CONFIRMAR_PEDIDO_MODAL));
            }
            actor.attemptsTo(Click.on(PaginaInicio.CERRAR_CONFIRMACION_ALERTA));
          }
          break;
        case "No":
          actor.attemptsTo(
              Click.on(PaginaInicio.ARTICULOS.of(nombreArticulo.get(i).get("articulos"))),
              Click.on(PaginaInicio.BTN_CONFIRMAR_PEDIDO_MODAL),
              WaitUntil.the(PaginaInicio.CERRAR_CONFIRMACION_ALERTA, isVisible()),
              Click.on(PaginaInicio.CERRAR_CONFIRMACION_ALERTA));
          break;
      }
    }
    actor.attemptsTo(Click.on(PaginaInicio.BARRA_MENU.of(Constantes.MIS_PEDIDOS)));
    Serenity.setSessionVariable("ultimoArticulo")
        .to(nombreArticulo.get(tamanioArticulos - 1).get("articulos"));
    log.info(
        " variable de sesion con el  ultimo articulo--> "
            + Serenity.sessionVariableCalled("ultimoArticulo"));
  }

  public static Performable AComprar(List<Map<String, String>> nombreArticulo) {
    return instrumented(SeleccionarArticulos.class, nombreArticulo);
  }
}
