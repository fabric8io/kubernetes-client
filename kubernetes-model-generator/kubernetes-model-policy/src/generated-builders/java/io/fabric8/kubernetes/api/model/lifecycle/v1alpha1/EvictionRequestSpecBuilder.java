package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EvictionRequestSpecBuilder extends EvictionRequestSpecFluent<EvictionRequestSpecBuilder> implements VisitableBuilder<EvictionRequestSpec,EvictionRequestSpecBuilder>{

  EvictionRequestSpecFluent<?> fluent;

  public EvictionRequestSpecBuilder() {
    this(new EvictionRequestSpec());
  }
  
  public EvictionRequestSpecBuilder(EvictionRequestSpecFluent<?> fluent) {
    this(fluent, new EvictionRequestSpec());
  }
  
  public EvictionRequestSpecBuilder(EvictionRequestSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EvictionRequestSpecBuilder(EvictionRequestSpecFluent<?> fluent,EvictionRequestSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EvictionRequestSpec build() {
    EvictionRequestSpec buildable = new EvictionRequestSpec(fluent.getIntent(), fluent.getRequester(), fluent.buildTarget());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}