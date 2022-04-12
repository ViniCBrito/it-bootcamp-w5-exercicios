package br.com.meli.qa_bugs.dto;

import br.com.meli.qa_bugs.domain.TestCase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestCaseDTO {

    private Long id_case;

    @NotBlank(message = "O campo 'description' não pode ficar em branco/vazio.")
    private String description;
    @NotNull(message = "O campo 'tested' não pode ficar vazio.")
    private Boolean tested;
    @NotNull(message = "O campo 'passed' não pode ficar vazio.")
    private Boolean passed;
    @NotNull(message = "O campo 'numberOfTries' não pode ficar vazio.")
    private Integer numberOfTries;

    private Timestamp lastUpdate;
}
