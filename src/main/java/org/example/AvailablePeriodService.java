package org.example;

import org.example.dto.AvailablePeriodDto;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AvailablePeriodService {

    public AvailablePeriodDto getAvailablePeriod(Instant date) {
        return new AvailablePeriodDto(date);
    }
}
