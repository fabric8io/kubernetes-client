package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MSTeamsConfigBuilder extends MSTeamsConfigFluent<MSTeamsConfigBuilder> implements VisitableBuilder<MSTeamsConfig,MSTeamsConfigBuilder>{

  MSTeamsConfigFluent<?> fluent;

  public MSTeamsConfigBuilder() {
    this(new MSTeamsConfig());
  }
  
  public MSTeamsConfigBuilder(MSTeamsConfigFluent<?> fluent) {
    this(fluent, new MSTeamsConfig());
  }
  
  public MSTeamsConfigBuilder(MSTeamsConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MSTeamsConfigBuilder(MSTeamsConfigFluent<?> fluent,MSTeamsConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MSTeamsConfig build() {
    MSTeamsConfig buildable = new MSTeamsConfig(fluent.buildHttpConfig(), fluent.getSendResolved(), fluent.getSummary(), fluent.getText(), fluent.getTitle(), fluent.getWebhookUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}