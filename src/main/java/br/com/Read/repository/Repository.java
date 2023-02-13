package br.com.Read.repository;

import br.com.Read.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Patient, String> {

}
