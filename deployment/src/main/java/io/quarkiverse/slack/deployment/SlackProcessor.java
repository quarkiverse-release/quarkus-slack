package io.quarkiverse.slack.deployment;

import jakarta.enterprise.context.ApplicationScoped;

import com.slack.api.Slack;
import com.slack.api.SlackConfig;

import io.quarkiverse.slack.runtime.SlackRecorder;
import io.quarkus.arc.deployment.SyntheticBeanBuildItem;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.ExecutionTime;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.deployment.builditem.FeatureBuildItem;

class SlackProcessor {

    private static final String FEATURE = "slack";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    @Record(value = ExecutionTime.RUNTIME_INIT)
    void registerSlackClient(BuildProducer<SyntheticBeanBuildItem> syntheticBeanBuildItemBuildProducer,
            SlackRecorder recorder) {
        syntheticBeanBuildItemBuildProducer.produce(
                SyntheticBeanBuildItem.configure(Slack.class)
                        .scope(ApplicationScoped.class)
                        .unremovable()
                        .createWith(recorder.createSlackClient(new SlackConfig()))
                        .done());

    }
}
