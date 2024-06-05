package io.quarkiverse.slack.runtime;

import com.slack.api.SlackConfig;

/**
 * Customize the Slack configuration
 */
public interface SlackConfigCustomizer {
    /**
     * Called when the application starts to customize the Slack configuration
     */
    void customize(SlackConfig config);
}
