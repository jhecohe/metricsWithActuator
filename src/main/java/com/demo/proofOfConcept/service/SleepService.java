package com.demo.proofOfConcept.service;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SleepService {

    private static final Log logger = LogFactory.getLog(SleepService.class);
    private final Timer doSleepTimer;

    public SleepService(MeterRegistry meterRegistry) {
        this.doSleepTimer = meterRegistry.timer("do.sleep.method.timed",
                "labelSleepTime",
                "valueTime");
    }

//    @Async
//    @Timed(value="do.sleep.method.timed")
    public Long doSleep(Long ms) {
//        try {
//            TimeUnit.MILLISECONDS.sleep(ms);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        logger.info("doSleep is executed");
        this.doSleepTimer.record(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(ms);
                logger.info("doSleep was executed success");
            } catch (InterruptedException e) {
                logger.info("doSleep was executed with error");
                throw new RuntimeException(e);
            }
        });

        return ms;
    }
}
