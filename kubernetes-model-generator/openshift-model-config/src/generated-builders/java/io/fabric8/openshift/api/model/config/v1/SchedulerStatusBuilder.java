package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SchedulerStatusBuilder extends SchedulerStatusFluent<SchedulerStatusBuilder> implements VisitableBuilder<SchedulerStatus,SchedulerStatusBuilder>{

  SchedulerStatusFluent<?> fluent;

  public SchedulerStatusBuilder() {
    this(new SchedulerStatus());
  }
  
  public SchedulerStatusBuilder(SchedulerStatusFluent<?> fluent) {
    this(fluent, new SchedulerStatus());
  }
  
  public SchedulerStatusBuilder(SchedulerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SchedulerStatusBuilder(SchedulerStatusFluent<?> fluent,SchedulerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SchedulerStatus build() {
    SchedulerStatus buildable = new SchedulerStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}