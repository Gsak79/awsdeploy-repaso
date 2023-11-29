package com.docseeker.patient.cucumberglue;

import com.docseeker.patient.api.PatientController;
import com.docseeker.patient.domain.model.entity.Patient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StepDefinitions {
  private final PatientController patientController;
  private Patient patient;

  public StepDefinitions(PatientController patientController) {
    this.patientController = patientController;
  }

  @Given("el usuario se encuentra en el formulario de registro")
  public void elUsuarioSeEncuentraEnElFormularioDeRegistro() {
    this.patient = new Patient();
  }

  @When("ingresa su nombre, correo, ubicación, edad, número de celular, contraseña y apellidos correctos, y elige su rol")
  public void ingresaSuNombreCorreoUbicaciónEdadNúmeroDeCelularContraseñaYApellidosCorrectosYEligeSuRol() {
    patient.setName("Juan");
    patient.setEmail("juan@gmail.com");
    patient.setPassword("123456");
    patient.setDni("12345678");
    patient.setWeight(70);
    patient.setHeight(1.70f);
    patient.setCellphone("987654321");
    patient.setBirthday("2000-01-01");
  }

  @Then("se registra su nueva cuenta")
  public void seRegistraSuNuevaCuenta() {
    Patient response = patientController.create(patient);
    assertNotEquals(null, response);
  }

}
