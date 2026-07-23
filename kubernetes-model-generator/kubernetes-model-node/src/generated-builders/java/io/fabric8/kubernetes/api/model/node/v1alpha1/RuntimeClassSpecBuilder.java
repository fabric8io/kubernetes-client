package io.fabric8.kubernetes.api.model.node.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RuntimeClassSpecBuilder extends RuntimeClassSpecFluent<RuntimeClassSpecBuilder> implements VisitableBuilder<RuntimeClassSpec,RuntimeClassSpecBuilder>{

  RuntimeClassSpecFluent<?> fluent;

  public RuntimeClassSpecBuilder() {
    this(new RuntimeClassSpec());
  }
  
  public RuntimeClassSpecBuilder(RuntimeClassSpecFluent<?> fluent) {
    this(fluent, new RuntimeClassSpec());
  }
  
  public RuntimeClassSpecBuilder(RuntimeClassSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RuntimeClassSpecBuilder(RuntimeClassSpecFluent<?> fluent,RuntimeClassSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RuntimeClassSpec build() {
    RuntimeClassSpec buildable = new RuntimeClassSpec(fluent.buildOverhead(), fluent.getRuntimeHandler(), fluent.buildScheduling());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}