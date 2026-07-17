package io.fabric8.openshift.api.model.tuned.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperandConfigBuilder extends OperandConfigFluent<OperandConfigBuilder> implements VisitableBuilder<OperandConfig,OperandConfigBuilder>{

  OperandConfigFluent<?> fluent;

  public OperandConfigBuilder() {
    this(new OperandConfig());
  }
  
  public OperandConfigBuilder(OperandConfigFluent<?> fluent) {
    this(fluent, new OperandConfig());
  }
  
  public OperandConfigBuilder(OperandConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperandConfigBuilder(OperandConfigFluent<?> fluent,OperandConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperandConfig build() {
    OperandConfig buildable = new OperandConfig(fluent.getDebug(), fluent.buildTunedConfig(), fluent.getVerbosity());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}