package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SchedulerBuilder extends SchedulerFluent<SchedulerBuilder> implements VisitableBuilder<Scheduler,SchedulerBuilder>{

  SchedulerFluent<?> fluent;

  public SchedulerBuilder() {
    this(new Scheduler());
  }
  
  public SchedulerBuilder(SchedulerFluent<?> fluent) {
    this(fluent, new Scheduler());
  }
  
  public SchedulerBuilder(Scheduler instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SchedulerBuilder(SchedulerFluent<?> fluent,Scheduler instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Scheduler build() {
    Scheduler buildable = new Scheduler(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}