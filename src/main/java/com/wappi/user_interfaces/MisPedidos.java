package com.wappi.user_interfaces;

import static net.serenitybdd.screenplay.targets.Target.the;

import net.serenitybdd.screenplay.targets.Target;

public class MisPedidos {
  public static final Target TABLA_PEDIDOS =
      the("Tabla Pedidos").locatedBy("//table//tr[{0}]/td[{1}]");
}
