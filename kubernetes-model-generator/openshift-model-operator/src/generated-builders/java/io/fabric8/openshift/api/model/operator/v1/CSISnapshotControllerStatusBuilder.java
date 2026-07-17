package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CSISnapshotControllerStatusBuilder extends CSISnapshotControllerStatusFluent<CSISnapshotControllerStatusBuilder> implements VisitableBuilder<CSISnapshotControllerStatus,CSISnapshotControllerStatusBuilder>{

  CSISnapshotControllerStatusFluent<?> fluent;

  public CSISnapshotControllerStatusBuilder() {
    this(new CSISnapshotControllerStatus());
  }
  
  public CSISnapshotControllerStatusBuilder(CSISnapshotControllerStatusFluent<?> fluent) {
    this(fluent, new CSISnapshotControllerStatus());
  }
  
  public CSISnapshotControllerStatusBuilder(CSISnapshotControllerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CSISnapshotControllerStatusBuilder(CSISnapshotControllerStatusFluent<?> fluent,CSISnapshotControllerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CSISnapshotControllerStatus build() {
    CSISnapshotControllerStatus buildable = new CSISnapshotControllerStatus(fluent.buildConditions(), fluent.buildGenerations(), fluent.getLatestAvailableRevision(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}