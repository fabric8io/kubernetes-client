package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ScheduleBuilder extends ScheduleFluent<ScheduleBuilder> implements VisitableBuilder<Schedule,ScheduleBuilder>{

  ScheduleFluent<?> fluent;

  public ScheduleBuilder() {
    this(new Schedule());
  }
  
  public ScheduleBuilder(ScheduleFluent<?> fluent) {
    this(fluent, new Schedule());
  }
  
  public ScheduleBuilder(Schedule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ScheduleBuilder(ScheduleFluent<?> fluent,Schedule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Schedule build() {
    Schedule buildable = new Schedule(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}