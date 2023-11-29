package com.docseeker.patient.domain.service;

import com.docseeker.patient.domain.model.entity.Patient;
import java.util.List;

public interface PatientService {
  Patient save(Patient patient);
  List<Patient> findAll();
  Patient findById(int id);
  Patient update(Patient patient, int id);
  void delete(int id);

  Patient findByDniAndPassword(String dni, String password);


}
