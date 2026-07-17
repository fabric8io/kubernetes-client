package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StaticConfigBuilder extends StaticConfigFluent<StaticConfigBuilder> implements VisitableBuilder<StaticConfig,StaticConfigBuilder>{

  StaticConfigFluent<?> fluent;

  public StaticConfigBuilder() {
    this(new StaticConfig());
  }
  
  public StaticConfigBuilder(StaticConfigFluent<?> fluent) {
    this(fluent, new StaticConfig());
  }
  
  public StaticConfigBuilder(StaticConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StaticConfigBuilder(StaticConfigFluent<?> fluent,StaticConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StaticConfig build() {
    StaticConfig buildable = new StaticConfig(fluent.getLabels(), fluent.getTargets());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}