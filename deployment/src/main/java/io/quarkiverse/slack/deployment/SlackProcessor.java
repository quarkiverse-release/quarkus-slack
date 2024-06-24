package io.quarkiverse.slack.deployment;

import io.quarkiverse.slack.runtime.SlackProducer;
import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;

class SlackProcessor {

    private static final String FEATURE = "slack";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    void registerSlackClient(BuildProducer<AdditionalBeanBuildItem> additionalBeanBuildItemBuildProducer) {
        additionalBeanBuildItemBuildProducer.produce(AdditionalBeanBuildItem.unremovableOf(SlackProducer.class));
    }
}
