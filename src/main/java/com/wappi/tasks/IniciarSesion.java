package com.wappi.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.wappi.user_interfaces.PaginaIniciarSesion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class IniciarSesion implements Task {
  private String usuario;
  private String contrasenia;

  public IniciarSesion(String usuario, String contrasenia) {
    this.usuario = usuario;
    this.contrasenia = contrasenia;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Enter.theValue(usuario).into(PaginaIniciarSesion.USUARIO),
        Enter.theValue(contrasenia).into(PaginaIniciarSesion.CONTRASENIA),
        Click.on(PaginaIniciarSesion.BTN_INGRESAR));
  }

  public static Performable conUsuarioContrasenia(String usuario, String contrasenia) {
    return instrumented(IniciarSesion.class, usuario, contrasenia);
  }
}
