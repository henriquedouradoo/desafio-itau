package desafio.itau.dto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.OffsetDateTime;

@Valid
@Getter
public class TransacaoRequest {

    @NotNull
    @Min(0)
    private Double valor;

    private OffsetDateTime dataHora;


}
