package com.wappi.questions;

import com.wappi.user_interfaces.MisPedidos;
import com.wappi.util.Constantes;
import java.util.logging.Logger;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarMisPedidos implements Question<String> {

  final Logger log = Logger.getLogger(String.valueOf(ValidarMisPedidos.class));

  public String ultimoArticulo;

  @Override
  public String answeredBy(Actor actor) {

    int posicion = Serenity.sessionVariableCalled("tamanioArticulos");

    log.info("Posicion que viene desde el feature: " + posicion);

    ultimoArticulo =
        MisPedidos.TABLA_PEDIDOS
            .of(String.valueOf(posicion), Constantes.TABLA_M_P_DESCRIPCION)
            .resolveFor(actor)
            .getText();
    return ultimoArticulo;
  }

  public static ValidarMisPedidos pedidosAgregados() {
    return new ValidarMisPedidos();
  }
}
