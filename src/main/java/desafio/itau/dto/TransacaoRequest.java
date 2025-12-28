package desafio.itau.dto;
import java.time.OffsetDateTime;

public class TransacaoRequest {

    private Double valor;

    private OffsetDateTime dataHora;

    public Double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}
