package desafio.itau.service;
import desafio.itau.model.Transacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@Service
@Slf4j
public class TransacaoService {

    private Queue<Transacao> transacoes = new ConcurrentLinkedDeque<>();

    public void inserirTransacao(Transacao transacao) {
        log.info("Iniciando processo de transação");
        log.debug("Dados da transação: {}", transacao);
        transacoes.add(transacao);

        log.info("Transação processada com sucesso!");
    }

    public void deletarTrasacoes() {
        log.info("Iniciando processo de exclusão das transações");
        transacoes.clear();

        log.info("Transações excluídas com sucesso!");
    }

    public DoubleSummaryStatistics getStatistic() {
        log.info("Iniciando coleta de estatísticas");
        OffsetDateTime now = OffsetDateTime.now();
        log.info("Dados estatisticos concluídos!");
        return transacoes.stream()
                // .filter(t -> t.getDataHora().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();
    }
}
