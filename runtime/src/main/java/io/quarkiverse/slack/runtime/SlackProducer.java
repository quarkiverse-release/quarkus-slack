package io.quarkiverse.slack.runtime;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import com.slack.api.Slack;

public class SlackProducer {

    @Produces
    @ApplicationScoped
    Slack createSlack(SlackConfig config) {
        return Slack.getInstance();
    }
}
