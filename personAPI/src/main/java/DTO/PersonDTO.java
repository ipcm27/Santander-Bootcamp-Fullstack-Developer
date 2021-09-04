package DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {


        private Long id;

        @NotEmpty
        @Size(min =1, max=100)
        private String firstName;

        @NotEmpty
        @Size(min =1, max=100)
        private String lastName;

        @NotEmpty
        @Size(min =1, max=100)
        @CPF
        private String cpf;

        private String birthDate;

        @Valid
        @NotEmpty
        private List<PhoneDTO> phones;
    }

