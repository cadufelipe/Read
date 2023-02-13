package br.com.Read;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Patient")
public class Patient implements Serializable {
    @Id
    String NOME = "Nome teste";
    String SEXO = "M";
    String NASC = "1900-01-01 00:00:00";

}
