package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3MachineStatusBuilder extends Metal3MachineStatusFluent<Metal3MachineStatusBuilder> implements VisitableBuilder<Metal3MachineStatus,Metal3MachineStatusBuilder>{

  Metal3MachineStatusFluent<?> fluent;

  public Metal3MachineStatusBuilder() {
    this(new Metal3MachineStatus());
  }
  
  public Metal3MachineStatusBuilder(Metal3MachineStatusFluent<?> fluent) {
    this(fluent, new Metal3MachineStatus());
  }
  
  public Metal3MachineStatusBuilder(Metal3MachineStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3MachineStatusBuilder(Metal3MachineStatusFluent<?> fluent,Metal3MachineStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3MachineStatus build() {
    Metal3MachineStatus buildable = new Metal3MachineStatus(fluent.getAddresses(), fluent.getConditions(), fluent.getFailureMessage(), fluent.getFailureReason(), fluent.getLastUpdated(), fluent.getMetaData(), fluent.getNetworkData(), fluent.getPhase(), fluent.getReady(), fluent.buildRenderedData(), fluent.getUserData(), fluent.buildV1beta2());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}