package desafio.itau.controller;

import desafio.itau.dto.TransacaoRequest;
import desafio.itau.model.Transacao;
import desafio.itau.service.TransacaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarTransacao(@RequestBody TransacaoRequest request) {

        log.info("Recebida requisição POST /transacao");

        if (request.getDataHora().isAfter(OffsetDateTime.now()) || request.getValor() < 0) {
            log.warn("Requisição não completada - dataHora ou valor incorretos - unprocessableEntity");
            log.debug("Dados da requisição - dataHora: {}, valor: {}", request.getDataHora(), request.getValor());
            return ResponseEntity.unprocessableEntity().build();
        }

        Transacao transacao = new Transacao(request.getValor(), request.getDataHora());
        service.inserirTransacao(transacao);
        log.info("Endpoint com retorno 201 - CREATED");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> removerTransacoes() {

        log.info("Recebida requisição DELETE /transacao");

        service.deletarTrasacoes();

        log.info("Endpoint com retorno 200 - OK");

        return ResponseEntity.ok().build();
    }


}
