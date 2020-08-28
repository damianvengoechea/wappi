package com.wappi.questions;

import com.wappi.user_interfaces.PaginaInicio;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarModal implements Question<String> {

  public String precioArticulo;

  @Override
  public String answeredBy(Actor actor) {
    precioArticulo = PaginaInicio.PRECIO_MODAL.resolveFor(actor).getText();
    return precioArticulo;
  }

  public static ValidarModal precioObtenido() {
    return new ValidarModal();
  }
}
