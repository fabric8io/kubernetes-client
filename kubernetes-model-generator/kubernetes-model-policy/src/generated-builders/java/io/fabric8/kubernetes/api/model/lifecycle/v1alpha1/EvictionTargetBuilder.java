package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EvictionTargetBuilder extends EvictionTargetFluent<EvictionTargetBuilder> implements VisitableBuilder<EvictionTarget,EvictionTargetBuilder>{

  EvictionTargetFluent<?> fluent;

  public EvictionTargetBuilder() {
    this(new EvictionTarget());
  }
  
  public EvictionTargetBuilder(EvictionTargetFluent<?> fluent) {
    this(fluent, new EvictionTarget());
  }
  
  public EvictionTargetBuilder(EvictionTarget instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EvictionTargetBuilder(EvictionTargetFluent<?> fluent,EvictionTarget instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EvictionTarget build() {
    EvictionTarget buildable = new EvictionTarget(fluent.buildPod());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}