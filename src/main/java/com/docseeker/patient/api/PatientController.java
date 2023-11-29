package com.docseeker.patient.api;

import com.docseeker.patient.domain.model.entity.Patient;
import com.docseeker.patient.domain.service.PatientService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/v1/patients")
@AllArgsConstructor
public class PatientController {
  private final PatientService patientService;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public Patient create(@RequestBody Patient patient) {
    return patientService.save(patient);
  }

  @GetMapping("")
  public List<Patient> findAll() {
    return patientService.findAll();
  }

  @GetMapping("dni/{dni}/password/{password}")
  public Patient login(@PathVariable String dni, @PathVariable String password) {
    return patientService.findByDniAndPassword(dni, password);
  }

  @GetMapping("/{id}")
  public Patient findById(@PathVariable int id) {
    return patientService.findById(id);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping("/{id}")
  public Patient update(@RequestBody Patient patient, @PathVariable int id) {
    return patientService.update(patient, id);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void delete(@PathVariable int id) {
    patientService.delete(id);
  }
}
