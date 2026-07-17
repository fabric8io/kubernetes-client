package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SchedulerListBuilder extends SchedulerListFluent<SchedulerListBuilder> implements VisitableBuilder<SchedulerList,SchedulerListBuilder>{

  SchedulerListFluent<?> fluent;

  public SchedulerListBuilder() {
    this(new SchedulerList());
  }
  
  public SchedulerListBuilder(SchedulerListFluent<?> fluent) {
    this(fluent, new SchedulerList());
  }
  
  public SchedulerListBuilder(SchedulerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SchedulerListBuilder(SchedulerListFluent<?> fluent,SchedulerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SchedulerList build() {
    SchedulerList buildable = new SchedulerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}