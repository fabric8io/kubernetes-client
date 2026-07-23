package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSchedulingContextBuilder extends PodSchedulingContextFluent<PodSchedulingContextBuilder> implements VisitableBuilder<PodSchedulingContext,PodSchedulingContextBuilder>{

  PodSchedulingContextFluent<?> fluent;

  public PodSchedulingContextBuilder() {
    this(new PodSchedulingContext());
  }
  
  public PodSchedulingContextBuilder(PodSchedulingContextFluent<?> fluent) {
    this(fluent, new PodSchedulingContext());
  }
  
  public PodSchedulingContextBuilder(PodSchedulingContext instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSchedulingContextBuilder(PodSchedulingContextFluent<?> fluent,PodSchedulingContext instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSchedulingContext build() {
    PodSchedulingContext buildable = new PodSchedulingContext(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}