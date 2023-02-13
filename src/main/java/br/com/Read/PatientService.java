package br.com.Read;

import br.com.Read.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final Repository repository;

    @Autowired
    public PatientService(Repository repository) {
        this.repository = repository;
    }

    public void salvarInfoPaci(Patient patient) {
        repository.save(patient);
    }

}