package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EvictionSpecBuilder extends EvictionSpecFluent<EvictionSpecBuilder> implements VisitableBuilder<EvictionSpec,EvictionSpecBuilder>{

  EvictionSpecFluent<?> fluent;

  public EvictionSpecBuilder() {
    this(new EvictionSpec());
  }
  
  public EvictionSpecBuilder(EvictionSpecFluent<?> fluent) {
    this(fluent, new EvictionSpec());
  }
  
  public EvictionSpecBuilder(EvictionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EvictionSpecBuilder(EvictionSpecFluent<?> fluent,EvictionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EvictionSpec build() {
    EvictionSpec buildable = new EvictionSpec(fluent.buildTarget());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}