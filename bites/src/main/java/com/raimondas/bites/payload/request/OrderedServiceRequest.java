package com.raimondas.bites.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class OrderedServiceRequest {

    @NotNull(message = "Date service is active from must be present")
    private final LocalDate activeFrom;

    @NotNull(message = "Date service is active till must be present")
    private final LocalDate activeTo;

    public OrderedServiceRequest(@JsonProperty("activeFrom") String activeFrom,
                                 @JsonProperty("activeTo") String activeTo) {
        this.activeFrom = LocalDate.parse(activeFrom);
        this.activeTo = LocalDate.parse(activeTo);
    }

    public LocalDate getActiveFrom() {
        return activeFrom;
    }

    public LocalDate getActiveTo() {
        return activeTo;
    }

}
