package com.wappi.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.wappi.user_interfaces.PaginaInicio;
import com.wappi.util.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SeleccionarOpcionMenu implements Task {
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(PaginaInicio.BARRA_MENU.of(Constantes.INFORMACION_PERSONAL)));
  }

  public static Performable opcionMenu() {
    return instrumented(SeleccionarOpcionMenu.class);
  }
}
