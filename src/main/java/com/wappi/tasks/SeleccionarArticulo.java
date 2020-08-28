package com.wappi.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.wappi.user_interfaces.PaginaInicio;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SeleccionarArticulo implements Task {

  private String precioArticulo;

  public SeleccionarArticulo(String precioArticulo) {
    this.precioArticulo = precioArticulo;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(PaginaInicio.ARTICULOS.of(precioArticulo)));
  }

  public static Performable ParaComprar(String precioArticulo) {
    return instrumented(SeleccionarArticulo.class, precioArticulo);
  }
}
