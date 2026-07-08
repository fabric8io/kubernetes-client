package io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineDeletionStatusBuilder extends MachineDeletionStatusFluent<MachineDeletionStatusBuilder> implements VisitableBuilder<MachineDeletionStatus,MachineDeletionStatusBuilder>{

  MachineDeletionStatusFluent<?> fluent;

  public MachineDeletionStatusBuilder() {
    this(new MachineDeletionStatus());
  }
  
  public MachineDeletionStatusBuilder(MachineDeletionStatusFluent<?> fluent) {
    this(fluent, new MachineDeletionStatus());
  }
  
  public MachineDeletionStatusBuilder(MachineDeletionStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineDeletionStatusBuilder(MachineDeletionStatusFluent<?> fluent,MachineDeletionStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineDeletionStatus build() {
    MachineDeletionStatus buildable = new MachineDeletionStatus(fluent.getNodeDrainStartTime(), fluent.getWaitForNodeVolumeDetachStartTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}