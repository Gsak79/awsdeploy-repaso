package com.docseeker.patient.service;

import com.docseeker.patient.domain.model.entity.Patient;
import com.docseeker.patient.domain.persistence.PatientRepository;
import com.docseeker.patient.domain.service.PatientService;
import com.docseeker.patient.util.Util;
import java.lang.reflect.Array;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PatientServiceImpl implements PatientService {

  @Autowired
  private PatientRepository patientRepository;

  public static final String PATIENT_NOT_FOUND = "Patient not found";
  @Override
  public Patient save(Patient patient) {
    patient.setBmi(Util.calculateBMI(patient.getHeight(), patient.getWeight()));
    return patientRepository.save(patient);
  }

  @Override
  public List<Patient> findAll() {
    return patientRepository.findAll();
  }

  @Override
  public Patient findById(int id) {
    return patientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, PATIENT_NOT_FOUND));
  }

  @Override
  public Patient update(Patient patient, int id) {
    patientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, PATIENT_NOT_FOUND));
    patient.setId(id);
    return patientRepository.save(patient);
  }

  @Override
  public void delete(int id) {
    patientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, PATIENT_NOT_FOUND));
    patientRepository.deleteById(id);
  }

  @Override
  public Patient findByDniAndPassword(String dni, String password) {
    return patientRepository.findByDniAndPassword(dni, password);
  }
}
