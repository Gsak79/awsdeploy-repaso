package com.docseeker.patient.domain.persistence;

import com.docseeker.patient.domain.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
  Patient findByDniAndPassword(String dni, String password);
}
