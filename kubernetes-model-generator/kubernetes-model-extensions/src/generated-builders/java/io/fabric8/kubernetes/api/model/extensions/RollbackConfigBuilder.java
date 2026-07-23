package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RollbackConfigBuilder extends RollbackConfigFluent<RollbackConfigBuilder> implements VisitableBuilder<RollbackConfig,RollbackConfigBuilder>{

  RollbackConfigFluent<?> fluent;

  public RollbackConfigBuilder() {
    this(new RollbackConfig());
  }
  
  public RollbackConfigBuilder(RollbackConfigFluent<?> fluent) {
    this(fluent, new RollbackConfig());
  }
  
  public RollbackConfigBuilder(RollbackConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RollbackConfigBuilder(RollbackConfigFluent<?> fluent,RollbackConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RollbackConfig build() {
    RollbackConfig buildable = new RollbackConfig(fluent.getRevision());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}