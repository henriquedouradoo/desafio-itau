package desafio.itau.controller;

import desafio.itau.dto.TransacaoRequest;
import desafio.itau.model.Transacao;
import desafio.itau.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarTransacao(@RequestBody TransacaoRequest request) {
        if (request.getDataHora().isAfter(OffsetDateTime.now()) || request.getValor() < 0) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Transacao transacao = new Transacao(request.getValor(), request.getDataHora());
        service.inserirTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> removerTransacoes() {
        service.deletarTrasacoes();
        return ResponseEntity.ok().build();
    }


}
