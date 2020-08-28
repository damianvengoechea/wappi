package com.wappi.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class UsoMaxCupon implements Question<String> {

  String usoMaximoCupon;

  @Override
  public String answeredBy(Actor actor) {
    usoMaximoCupon = Serenity.sessionVariableCalled("MensajeCuponInvalido");
    return usoMaximoCupon;
  }

  public static UsoMaxCupon correcto() {
    return new UsoMaxCupon();
  }
}
