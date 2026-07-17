package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SchedulerSpecBuilder extends SchedulerSpecFluent<SchedulerSpecBuilder> implements VisitableBuilder<SchedulerSpec,SchedulerSpecBuilder>{

  SchedulerSpecFluent<?> fluent;

  public SchedulerSpecBuilder() {
    this(new SchedulerSpec());
  }
  
  public SchedulerSpecBuilder(SchedulerSpecFluent<?> fluent) {
    this(fluent, new SchedulerSpec());
  }
  
  public SchedulerSpecBuilder(SchedulerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SchedulerSpecBuilder(SchedulerSpecFluent<?> fluent,SchedulerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SchedulerSpec build() {
    SchedulerSpec buildable = new SchedulerSpec(fluent.getDefaultNodeSelector(), fluent.getMastersSchedulable(), fluent.buildPolicy(), fluent.getProfile(), fluent.buildProfileCustomizations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}