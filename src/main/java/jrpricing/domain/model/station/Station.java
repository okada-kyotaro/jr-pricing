package jrpricing.domain.model.station;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
public class Station {
    @Getter
    private final StationId stationId;

    @Getter
    private final StationName stationName;
}
