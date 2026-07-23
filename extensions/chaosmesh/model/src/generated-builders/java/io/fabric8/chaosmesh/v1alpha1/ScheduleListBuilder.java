package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ScheduleListBuilder extends ScheduleListFluent<ScheduleListBuilder> implements VisitableBuilder<ScheduleList,ScheduleListBuilder>{

  ScheduleListFluent<?> fluent;

  public ScheduleListBuilder() {
    this(new ScheduleList());
  }
  
  public ScheduleListBuilder(ScheduleListFluent<?> fluent) {
    this(fluent, new ScheduleList());
  }
  
  public ScheduleListBuilder(ScheduleList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ScheduleListBuilder(ScheduleListFluent<?> fluent,ScheduleList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ScheduleList build() {
    ScheduleList buildable = new ScheduleList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}