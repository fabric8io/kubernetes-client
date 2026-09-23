package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EvictionRequestTargetBuilder extends EvictionRequestTargetFluent<EvictionRequestTargetBuilder> implements VisitableBuilder<EvictionRequestTarget,EvictionRequestTargetBuilder>{

  EvictionRequestTargetFluent<?> fluent;

  public EvictionRequestTargetBuilder() {
    this(new EvictionRequestTarget());
  }
  
  public EvictionRequestTargetBuilder(EvictionRequestTargetFluent<?> fluent) {
    this(fluent, new EvictionRequestTarget());
  }
  
  public EvictionRequestTargetBuilder(EvictionRequestTarget instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EvictionRequestTargetBuilder(EvictionRequestTargetFluent<?> fluent,EvictionRequestTarget instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EvictionRequestTarget build() {
    EvictionRequestTarget buildable = new EvictionRequestTarget(fluent.buildPod());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}