package desafio.itau.service;
import desafio.itau.model.Transacao;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@Service
public class TransacaoService {

    private Queue<Transacao> transacoes = new ConcurrentLinkedDeque<>();

    public void inserirTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public void deletarTrasacoes() {
        transacoes.clear();
    }

    public DoubleSummaryStatistics getStatistic() {
        OffsetDateTime now = OffsetDateTime.now();
        return transacoes.stream()
                // .filter(t -> t.getDataHora().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();
    }
}
