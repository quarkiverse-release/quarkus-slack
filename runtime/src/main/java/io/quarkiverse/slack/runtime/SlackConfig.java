package io.quarkiverse.slack.runtime;

import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "quarkus.slack")
@ConfigRoot(phase = ConfigPhase.RUN_TIME)
public interface SlackConfig {

    /**
     * The token to use to authenticate with Slack
     *
     * @return the token
     */
    String token();
}
