package io.fabric8.kubernetes.api.model.node.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RuntimeClassBuilder extends RuntimeClassFluent<RuntimeClassBuilder> implements VisitableBuilder<RuntimeClass,RuntimeClassBuilder>{

  RuntimeClassFluent<?> fluent;

  public RuntimeClassBuilder() {
    this(new RuntimeClass());
  }
  
  public RuntimeClassBuilder(RuntimeClassFluent<?> fluent) {
    this(fluent, new RuntimeClass());
  }
  
  public RuntimeClassBuilder(RuntimeClass instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RuntimeClassBuilder(RuntimeClassFluent<?> fluent,RuntimeClass instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RuntimeClass build() {
    RuntimeClass buildable = new RuntimeClass(fluent.getApiVersion(), fluent.getHandler(), fluent.getKind(), fluent.buildMetadata(), fluent.buildOverhead(), fluent.buildScheduling());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}