package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RuntimeClassStrategyOptionsBuilder extends RuntimeClassStrategyOptionsFluent<RuntimeClassStrategyOptionsBuilder> implements VisitableBuilder<RuntimeClassStrategyOptions,RuntimeClassStrategyOptionsBuilder>{

  RuntimeClassStrategyOptionsFluent<?> fluent;

  public RuntimeClassStrategyOptionsBuilder() {
    this(new RuntimeClassStrategyOptions());
  }
  
  public RuntimeClassStrategyOptionsBuilder(RuntimeClassStrategyOptionsFluent<?> fluent) {
    this(fluent, new RuntimeClassStrategyOptions());
  }
  
  public RuntimeClassStrategyOptionsBuilder(RuntimeClassStrategyOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RuntimeClassStrategyOptionsBuilder(RuntimeClassStrategyOptionsFluent<?> fluent,RuntimeClassStrategyOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RuntimeClassStrategyOptions build() {
    RuntimeClassStrategyOptions buildable = new RuntimeClassStrategyOptions(fluent.getAllowedRuntimeClassNames(), fluent.getDefaultRuntimeClassName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}