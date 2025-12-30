package desafio.itau.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Transacao {

    private Double valor;
    private OffsetDateTime dataHora;

    @Override
    public String toString() {
        return "valor=" + valor +
                ", dataHora=" + dataHora;
    }
}
