package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JVMChaosStatusBuilder extends JVMChaosStatusFluent<JVMChaosStatusBuilder> implements VisitableBuilder<JVMChaosStatus,JVMChaosStatusBuilder>{

  JVMChaosStatusFluent<?> fluent;

  public JVMChaosStatusBuilder() {
    this(new JVMChaosStatus());
  }
  
  public JVMChaosStatusBuilder(JVMChaosStatusFluent<?> fluent) {
    this(fluent, new JVMChaosStatus());
  }
  
  public JVMChaosStatusBuilder(JVMChaosStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JVMChaosStatusBuilder(JVMChaosStatusFluent<?> fluent,JVMChaosStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JVMChaosStatus build() {
    JVMChaosStatus buildable = new JVMChaosStatus(fluent.buildConditions(), fluent.buildExperiment());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}