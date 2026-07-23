package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSchedulingContextSpecBuilder extends PodSchedulingContextSpecFluent<PodSchedulingContextSpecBuilder> implements VisitableBuilder<PodSchedulingContextSpec,PodSchedulingContextSpecBuilder>{

  PodSchedulingContextSpecFluent<?> fluent;

  public PodSchedulingContextSpecBuilder() {
    this(new PodSchedulingContextSpec());
  }
  
  public PodSchedulingContextSpecBuilder(PodSchedulingContextSpecFluent<?> fluent) {
    this(fluent, new PodSchedulingContextSpec());
  }
  
  public PodSchedulingContextSpecBuilder(PodSchedulingContextSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSchedulingContextSpecBuilder(PodSchedulingContextSpecFluent<?> fluent,PodSchedulingContextSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSchedulingContextSpec build() {
    PodSchedulingContextSpec buildable = new PodSchedulingContextSpec(fluent.getPotentialNodes(), fluent.getSelectedNode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}