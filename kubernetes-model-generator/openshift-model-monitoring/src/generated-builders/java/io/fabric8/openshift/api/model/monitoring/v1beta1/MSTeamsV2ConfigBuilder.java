package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MSTeamsV2ConfigBuilder extends MSTeamsV2ConfigFluent<MSTeamsV2ConfigBuilder> implements VisitableBuilder<MSTeamsV2Config,MSTeamsV2ConfigBuilder>{

  MSTeamsV2ConfigFluent<?> fluent;

  public MSTeamsV2ConfigBuilder() {
    this(new MSTeamsV2Config());
  }
  
  public MSTeamsV2ConfigBuilder(MSTeamsV2ConfigFluent<?> fluent) {
    this(fluent, new MSTeamsV2Config());
  }
  
  public MSTeamsV2ConfigBuilder(MSTeamsV2Config instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MSTeamsV2ConfigBuilder(MSTeamsV2ConfigFluent<?> fluent,MSTeamsV2Config instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MSTeamsV2Config build() {
    MSTeamsV2Config buildable = new MSTeamsV2Config(fluent.buildHttpConfig(), fluent.getSendResolved(), fluent.getText(), fluent.getTitle(), fluent.getWebhookURL());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}