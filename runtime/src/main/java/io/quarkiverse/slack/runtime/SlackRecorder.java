package io.quarkiverse.slack.runtime;

import java.util.function.Function;

import com.slack.api.Slack;
import com.slack.api.SlackConfig;

import io.quarkus.arc.SyntheticCreationalContext;
import io.quarkus.runtime.annotations.Recorder;

@Recorder
public class SlackRecorder {

    public Function<SyntheticCreationalContext<Slack>, Slack> createSlackClient(SlackConfig config) {
        return (ctx) -> Slack.getInstance(config);
    }

}
