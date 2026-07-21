package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ScheduleStatusBuilder extends ScheduleStatusFluent<ScheduleStatusBuilder> implements VisitableBuilder<ScheduleStatus,ScheduleStatusBuilder>{

  ScheduleStatusFluent<?> fluent;

  public ScheduleStatusBuilder() {
    this(new ScheduleStatus());
  }
  
  public ScheduleStatusBuilder(ScheduleStatusFluent<?> fluent) {
    this(fluent, new ScheduleStatus());
  }
  
  public ScheduleStatusBuilder(ScheduleStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ScheduleStatusBuilder(ScheduleStatusFluent<?> fluent,ScheduleStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ScheduleStatus build() {
    ScheduleStatus buildable = new ScheduleStatus(fluent.buildActive(), fluent.getTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}