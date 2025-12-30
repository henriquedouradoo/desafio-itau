package desafio.itau.dto;

import lombok.Getter;

import java.util.DoubleSummaryStatistics;

@Getter
public class EstatisticaResponse {

    private Long count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;

    public EstatisticaResponse(DoubleSummaryStatistics doubleSummaryStatistics) {
        this.count = doubleSummaryStatistics.getCount();
        this.sum = doubleSummaryStatistics.getSum();
        this.avg = doubleSummaryStatistics.getAverage();
        this.min = Math.min(0, doubleSummaryStatistics.getMin());
        this.max = Math.max(0, doubleSummaryStatistics.getMax());
    }

}
