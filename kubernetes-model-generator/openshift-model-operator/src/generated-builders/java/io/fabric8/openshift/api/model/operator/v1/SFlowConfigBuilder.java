package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SFlowConfigBuilder extends SFlowConfigFluent<SFlowConfigBuilder> implements VisitableBuilder<SFlowConfig,SFlowConfigBuilder>{

  SFlowConfigFluent<?> fluent;

  public SFlowConfigBuilder() {
    this(new SFlowConfig());
  }
  
  public SFlowConfigBuilder(SFlowConfigFluent<?> fluent) {
    this(fluent, new SFlowConfig());
  }
  
  public SFlowConfigBuilder(SFlowConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SFlowConfigBuilder(SFlowConfigFluent<?> fluent,SFlowConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SFlowConfig build() {
    SFlowConfig buildable = new SFlowConfig(fluent.getCollectors());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}