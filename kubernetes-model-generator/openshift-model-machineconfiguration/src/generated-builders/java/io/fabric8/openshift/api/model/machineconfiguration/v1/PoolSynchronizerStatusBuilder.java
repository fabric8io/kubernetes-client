package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PoolSynchronizerStatusBuilder extends PoolSynchronizerStatusFluent<PoolSynchronizerStatusBuilder> implements VisitableBuilder<PoolSynchronizerStatus,PoolSynchronizerStatusBuilder>{

  PoolSynchronizerStatusFluent<?> fluent;

  public PoolSynchronizerStatusBuilder() {
    this(new PoolSynchronizerStatus());
  }
  
  public PoolSynchronizerStatusBuilder(PoolSynchronizerStatusFluent<?> fluent) {
    this(fluent, new PoolSynchronizerStatus());
  }
  
  public PoolSynchronizerStatusBuilder(PoolSynchronizerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PoolSynchronizerStatusBuilder(PoolSynchronizerStatusFluent<?> fluent,PoolSynchronizerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PoolSynchronizerStatus build() {
    PoolSynchronizerStatus buildable = new PoolSynchronizerStatus(fluent.getAvailableMachineCount(), fluent.getMachineCount(), fluent.getObservedGeneration(), fluent.getPoolSynchronizerType(), fluent.getReadyMachineCount(), fluent.getUnavailableMachineCount(), fluent.getUpdatedMachineCount());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}