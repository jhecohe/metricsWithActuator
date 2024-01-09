package com.demo.proofOfConcept.service;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

@Service
public class ConsumeServiceDummy implements HealthIndicator {

    private final Environment env;

    public ConsumeServiceDummy(Environment env) {
        this.env = env;
    }

    @Override
    public Health health() {

        try {
            if (isServiceUp()) {
                return Health.up().withDetail("Test service", "is working good").build();
            } else {
                return Health.down().withDetail("Test Service", "down").build();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean isServiceUp() throws IOException {
        String address = env.getProperty("testService.address");
        String port = env.getProperty("testService.port");

        return isAddressReachable(address, Integer.parseInt(port), 3000);
    }

    private boolean isAddressReachable(String address, int port, int timeout) throws IOException{

        Socket isSocket = new Socket();

        try {
            isSocket.connect(new InetSocketAddress(address, port), timeout);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            isSocket.close();
        }
    }
}
