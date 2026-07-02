package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSchedulingGroupBuilder extends PodSchedulingGroupFluent<PodSchedulingGroupBuilder> implements VisitableBuilder<PodSchedulingGroup,PodSchedulingGroupBuilder>{

  PodSchedulingGroupFluent<?> fluent;

  public PodSchedulingGroupBuilder() {
    this(new PodSchedulingGroup());
  }
  
  public PodSchedulingGroupBuilder(PodSchedulingGroupFluent<?> fluent) {
    this(fluent, new PodSchedulingGroup());
  }
  
  public PodSchedulingGroupBuilder(PodSchedulingGroup instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSchedulingGroupBuilder(PodSchedulingGroupFluent<?> fluent,PodSchedulingGroup instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSchedulingGroup build() {
    PodSchedulingGroup buildable = new PodSchedulingGroup(fluent.getPodGroupName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}