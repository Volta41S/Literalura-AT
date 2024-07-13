package LiterAlura_AT.com.alura.challege.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DatosAutor> autor,
        @JsonAlias("copyright") String derechosDeAutor,
        @JsonAlias("download_count") Double descargas,
        @JsonAlias("languages") List<String> idiomas
) {
}
