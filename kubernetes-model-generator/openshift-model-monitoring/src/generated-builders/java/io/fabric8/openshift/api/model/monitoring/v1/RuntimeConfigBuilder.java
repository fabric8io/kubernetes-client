package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RuntimeConfigBuilder extends RuntimeConfigFluent<RuntimeConfigBuilder> implements VisitableBuilder<RuntimeConfig,RuntimeConfigBuilder>{

  RuntimeConfigFluent<?> fluent;

  public RuntimeConfigBuilder() {
    this(new RuntimeConfig());
  }
  
  public RuntimeConfigBuilder(RuntimeConfigFluent<?> fluent) {
    this(fluent, new RuntimeConfig());
  }
  
  public RuntimeConfigBuilder(RuntimeConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RuntimeConfigBuilder(RuntimeConfigFluent<?> fluent,RuntimeConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RuntimeConfig build() {
    RuntimeConfig buildable = new RuntimeConfig(fluent.getGoGC());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}