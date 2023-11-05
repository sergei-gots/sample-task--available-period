package org.example;

import org.example.dto.AvailablePeriodDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/available-period")
public class AvailablePeriodController {
    private final AvailablePeriodService availablePeriodService;

    public AvailablePeriodController(AvailablePeriodService availablePeriodService) {
        this.availablePeriodService = availablePeriodService;
    }

    @GetMapping()
    public AvailablePeriodDto getAvailablePeriod(@RequestHeader("session-token") String sessionToken) {
        return availablePeriodService.getAvailablePeriod();
    }


}
