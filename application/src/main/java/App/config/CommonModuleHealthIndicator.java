package App.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Component
public class CommonModuleHealthIndicator implements HealthIndicator {

    private final RestTemplate restTemplate;
    private final URI dependentModuleUrl;

    public CommonModuleHealthIndicator(RestTemplate restTemplate, ApplicationProperties applicationProperties) throws URISyntaxException {
        this.restTemplate = restTemplate;
        this.dependentModuleUrl = applicationProperties.getDependentModuleUrl().toURI();
    }

    @Override
    public Health health() {
        try {
            restTemplate.getForObject(dependentModuleUrl, String.class);
            return Health.up()
                    .withDetail("description", "common module is reachable").build();
        }
        catch (Exception e) {
            log.error("Exception happens", e);
            return Health.down()
                    .withDetail("description", "common module is unreachable")
                    .withDetail("reason", e.getLocalizedMessage()).build();
        }
    }
}
