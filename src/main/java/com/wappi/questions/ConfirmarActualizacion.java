package com.wappi.questions;

import com.wappi.user_interfaces.FormularioInfoPersonal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ConfirmarActualizacion implements Question<String> {

  public String mensajeOptenido;

  @Override
  public String answeredBy(Actor actor) {
    mensajeOptenido = FormularioInfoPersonal.MODAL_CONFIRMACION.resolveFor(actor).getText();
    return mensajeOptenido;
  }

  public static ConfirmarActualizacion mensajeOptenido() {
    return new ConfirmarActualizacion();
  }
}
