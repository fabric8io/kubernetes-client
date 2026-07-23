package io.fabric8.kubernetes.api.model.node.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SchedulingBuilder extends SchedulingFluent<SchedulingBuilder> implements VisitableBuilder<Scheduling,SchedulingBuilder>{

  SchedulingFluent<?> fluent;

  public SchedulingBuilder() {
    this(new Scheduling());
  }
  
  public SchedulingBuilder(SchedulingFluent<?> fluent) {
    this(fluent, new Scheduling());
  }
  
  public SchedulingBuilder(Scheduling instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SchedulingBuilder(SchedulingFluent<?> fluent,Scheduling instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Scheduling build() {
    Scheduling buildable = new Scheduling(fluent.getNodeSelector(), fluent.getTolerations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}