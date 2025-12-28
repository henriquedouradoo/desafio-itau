package desafio.itau.controller;

import desafio.itau.dto.EstatisticaResponse;
import desafio.itau.service.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private final TransacaoService service;

    public EstatisticaController(TransacaoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<EstatisticaResponse> getStatistics() {
        DoubleSummaryStatistics stats = service.getStatistic();
        return ResponseEntity.ok(new EstatisticaResponse(stats));
    }

    public TransacaoService getService() {
        return service;
    }
}
