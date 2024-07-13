package LiterAlura_AT.com.alura.challege.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosAutor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") String fechaDeNacimiento

) {
}