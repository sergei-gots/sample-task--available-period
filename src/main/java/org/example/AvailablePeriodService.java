package org.example;

import org.example.dto.AvailablePeriodDto;
import org.springframework.stereotype.Service;

@Service
public class AvailablePeriodService {

    public AvailablePeriodDto getAvailablePeriod() {
        return new AvailablePeriodDto();
    }
}
