package com.wappi.user_interfaces;

import static net.serenitybdd.screenplay.targets.Target.the;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaInicio {

  public static final Target BARRA_MENU =
      the("Barra manu principal").locatedBy("//a[@ng-reflect-router-link='/{0}']");
  public static final Target BTN_OPTENER_CUPON =
      the("Boton optener cupon").located(By.id("welcome-coupon"));
  public static final Target BTN_PEDIR =
      the("Boton pedir").locatedBy("//tr[@id='offer-{0}']//button");
  public static final Target ARTICULOS =
      the("Boton pedir articulos")
          .locatedBy("//td[contains(text(),'{0}')]/following-sibling::*[5]");

  public static final Target TITULO_MODAL =
      the("Titulo del modal").locatedBy("//span[@class='offer-description']");
  public static final Target PRECIO_MODAL =
      the("Precio del modal").locatedBy("//span[@class='offer-price']");
  public static final Target BTN_CONFIRMAR_PEDIDO_MODAL =
      the("Precio del modal").located(By.id("order-confirm"));
  public static final Target CERRAR_CONFIRMACION_ALERTA =
      the("Cerrar el modal de confirmacion de pedido")
          .locatedBy("//div[@id='confirmation-modal']//span");
  public static final Target CAMPO_DESCUENTO =
      the("Campo donde ingresamos cupon").located(By.id("coupon"));

  public static final Target CUPON_GENERADO =
      the("Cupon que se genero").locatedBy("//span[@id='coupon-code']");
  public static final Target CERRAR_MODAL_CUPON =
      the("Cupon que se genero").locatedBy("//div[@id='coupon-modal']//span[1]");
  public static final Target MENSAJE_CUPON_INVALIDO =
      the("Mensaje de Cupon invalido").located(By.id("e-coupon"));
}
