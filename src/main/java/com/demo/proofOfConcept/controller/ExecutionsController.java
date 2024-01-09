package com.demo.proofOfConcept.controller;

import com.demo.proofOfConcept.service.ConsumeServiceDummy;
import com.demo.proofOfConcept.service.SleepService;
import io.micrometer.core.annotation.Timed;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/execution")
public class ExecutionsController {

    private final SleepService sleepService;
    private final ConsumeServiceDummy consumeServiceDummy;

    public ExecutionsController(SleepService sleepService, ConsumeServiceDummy consumeServiceDummy) {
        this.sleepService = sleepService;
        this.consumeServiceDummy = consumeServiceDummy;
    }

    @GetMapping("/sleep")
    @Timed("controller.sleep.method")
    public Long sleep(@RequestParam Long ms){
        Long period = sleepService.doSleep(ms);
        return period;
    }
}
