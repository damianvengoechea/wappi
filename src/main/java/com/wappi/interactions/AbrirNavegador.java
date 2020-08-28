package com.wappi.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.wappi.user_interfaces.PaginaIniciarSesion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;

public class AbrirNavegador implements Interaction {
  private PaginaIniciarSesion paginaInicio;

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Open.browserOn(paginaInicio));
  }

  public static Performable conUrl() {
    return instrumented(AbrirNavegador.class);
  }
}
