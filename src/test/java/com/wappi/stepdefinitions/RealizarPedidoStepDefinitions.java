package com.wappi.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import com.wappi.questions.UsoMaxCupon;
import com.wappi.questions.ValidarMisPedidos;
import com.wappi.questions.ValidarModal;
import com.wappi.questions.ValidarUsoCupon;
import com.wappi.tasks.ObtenerCupon;
import com.wappi.tasks.SeleccionarArticulo;
import com.wappi.tasks.SeleccionarArticulos;
import com.wappi.tasks.UtilizarCupon;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import java.util.Map;
import net.serenitybdd.core.Serenity;

public class RealizarPedidoStepDefinitions {

  @When("^selecciona el articulo (.*)$")
  public void seleccionaLosArticulos(String nombreArticulo) {
    theActorInTheSpotlight().attemptsTo(SeleccionarArticulo.ParaComprar(nombreArticulo));
  }

  @Then("^el precio del articulo del modal debera ser (.*)$")
  public void podraVerLaListaEnMisPedidos(String precioEsperado) {
    theActorInTheSpotlight()
        .should(seeThat(ValidarModal.precioObtenido(), equalTo(precioEsperado)));
  }

  @When("^selecciona los articulos$")
  public void seleccionaLosArticulos(List<Map<String, String>> nombreArticulos) {
    theActorInTheSpotlight().attemptsTo(SeleccionarArticulos.AComprar(nombreArticulos));
  }

  @Then("^en la opcion de mis pedidos validamo el ultimo articulo seleccionado$")
  public void enLaOpcionDeMisPedidosDeberanEstarLosArticulos() {
    theActorInTheSpotlight()
        .should(
            seeThat(
                ValidarMisPedidos.pedidosAgregados(),
                equalTo(Serenity.sessionVariableCalled("ultimoArticulo"))));
  }

  @When("^optiene el cupon$")
  public void optieneElCupon() {
    theActorInTheSpotlight().attemptsTo(ObtenerCupon.AUsar());
  }

  @Then("^se vera reflejado en mis pedidos el uso del cupon en (.*)$")
  public void seVeraReflejadoEnMisPedidosElUsoDelCuponEnSi(String usoCupon) {
    theActorInTheSpotlight().should(seeThat(ValidarUsoCupon.si(), equalTo(usoCupon)));
  }

  @When("^usa el cupon mas de dos veces$")
  public void usaElCuponMasDeDosVeces(List<Map<String, String>> articulos) {
    theActorInTheSpotlight().attemptsTo(UtilizarCupon.numArticulos(articulos));
  }

  @Then("^debera mostra el mensaje (.*) en el modal$")
  public void deberaMostraElMensajeEnElModal(String cuponInvalido) {
    theActorInTheSpotlight().should(seeThat(UsoMaxCupon.correcto(), equalTo(cuponInvalido)));
  }
}
