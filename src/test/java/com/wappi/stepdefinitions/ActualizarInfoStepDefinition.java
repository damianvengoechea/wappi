package com.wappi.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import com.wappi.interactions.AbrirNavegador;
import com.wappi.questions.ConfirmarActualizacion;
import com.wappi.tasks.DiligenciarFormulario;
import com.wappi.tasks.IniciarSesion;
import com.wappi.tasks.SeleccionarOpcionMenu;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import java.util.Map;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class ActualizarInfoStepDefinition {

  @Before
  public void prepararEscenario() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Given("^(.*) ingresa a la pagina de wappi con (.*) (.*)$")
  public void damianIngresaALaPaginaDeWappi(
      String nombreActor, String usuario, String contrasenia) {
    theActorCalled(nombreActor)
        .wasAbleTo(
            AbrirNavegador.conUrl(), IniciarSesion.conUsuarioContrasenia(usuario, contrasenia));
  }

  @When("^diligencia el formulario$")
  public void diligenciaElFormulario(List<Map<String, String>> informacionPersonal) {
    theActorInTheSpotlight()
        .attemptsTo(
            SeleccionarOpcionMenu.opcionMenu(),
            DiligenciarFormulario.conDatos(informacionPersonal));
  }

  @Then("^se actualiza la informacion y debe mostrar el mensaje (.*)$")
  public void seActualizaLaInformacionYDebeMostrarElMensaje(String mensajeEsperado) {
    theActorInTheSpotlight()
        .should(seeThat(ConfirmarActualizacion.mensajeOptenido(), equalTo(mensajeEsperado)));
  }
}
