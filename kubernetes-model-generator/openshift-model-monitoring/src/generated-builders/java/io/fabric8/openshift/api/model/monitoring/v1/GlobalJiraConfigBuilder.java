package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GlobalJiraConfigBuilder extends GlobalJiraConfigFluent<GlobalJiraConfigBuilder> implements VisitableBuilder<GlobalJiraConfig,GlobalJiraConfigBuilder>{

  GlobalJiraConfigFluent<?> fluent;

  public GlobalJiraConfigBuilder() {
    this(new GlobalJiraConfig());
  }
  
  public GlobalJiraConfigBuilder(GlobalJiraConfigFluent<?> fluent) {
    this(fluent, new GlobalJiraConfig());
  }
  
  public GlobalJiraConfigBuilder(GlobalJiraConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GlobalJiraConfigBuilder(GlobalJiraConfigFluent<?> fluent,GlobalJiraConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GlobalJiraConfig build() {
    GlobalJiraConfig buildable = new GlobalJiraConfig(fluent.getApiURL());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}