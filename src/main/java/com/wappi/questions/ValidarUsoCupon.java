package com.wappi.questions;

import com.wappi.user_interfaces.MisPedidos;
import com.wappi.util.Constantes;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarUsoCupon implements Question<String> {

  final Logger log = Logger.getLogger(String.valueOf(ValidarUsoCupon.class));
  public String usoCupon;

  @Override
  public String answeredBy(Actor actor) {
    List<String> listaArticulos = new ArrayList<String>();
    int tamanioLista = Serenity.sessionVariableCalled("tamanioArticulos");
    log.info("posicion que viene de articulos  " + tamanioLista);

    for (int i = 1; i <= tamanioLista; i++) {
      listaArticulos.add(
          MisPedidos.TABLA_PEDIDOS
              .of(String.valueOf(i), Constantes.TABLA_M_P_USO_CUPON)
              .resolveFor(actor)
              .getText());
    }
    log.info(" Lista articulos uso de cupon " + listaArticulos);

    if (listaArticulos.contains("Si")) {
      usoCupon = "Si";
    }
    return usoCupon;
  }

  public static ValidarUsoCupon si() {
    return new ValidarUsoCupon();
  }
}
