package io.fabric8.autoscaling.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StartupBoostBuilder extends StartupBoostFluent<StartupBoostBuilder> implements VisitableBuilder<StartupBoost,StartupBoostBuilder>{

  StartupBoostFluent<?> fluent;

  public StartupBoostBuilder() {
    this(new StartupBoost());
  }
  
  public StartupBoostBuilder(StartupBoostFluent<?> fluent) {
    this(fluent, new StartupBoost());
  }
  
  public StartupBoostBuilder(StartupBoost instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StartupBoostBuilder(StartupBoostFluent<?> fluent,StartupBoost instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StartupBoost build() {
    StartupBoost buildable = new StartupBoost(fluent.buildCpu());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}