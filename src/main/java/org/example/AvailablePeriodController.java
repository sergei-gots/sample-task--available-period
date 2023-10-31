package org.example;

import org.example.dto.AvailablePeriodDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/available-period")
public class AvailablePeriodController {
    private final AvailablePeriodService availablePeriodService;

    public AvailablePeriodController(AvailablePeriodService availablePeriodService) {
        this.availablePeriodService = availablePeriodService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public AvailablePeriodDto getAvailablePeriod() {
        return availablePeriodService.getAvailablePeriod();
    }


}
