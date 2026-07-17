package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GlobalMattermostConfigBuilder extends GlobalMattermostConfigFluent<GlobalMattermostConfigBuilder> implements VisitableBuilder<GlobalMattermostConfig,GlobalMattermostConfigBuilder>{

  GlobalMattermostConfigFluent<?> fluent;

  public GlobalMattermostConfigBuilder() {
    this(new GlobalMattermostConfig());
  }
  
  public GlobalMattermostConfigBuilder(GlobalMattermostConfigFluent<?> fluent) {
    this(fluent, new GlobalMattermostConfig());
  }
  
  public GlobalMattermostConfigBuilder(GlobalMattermostConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GlobalMattermostConfigBuilder(GlobalMattermostConfigFluent<?> fluent,GlobalMattermostConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GlobalMattermostConfig build() {
    GlobalMattermostConfig buildable = new GlobalMattermostConfig(fluent.getWebhookURL());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}