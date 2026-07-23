package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CSISnapshotControllerBuilder extends CSISnapshotControllerFluent<CSISnapshotControllerBuilder> implements VisitableBuilder<CSISnapshotController,CSISnapshotControllerBuilder>{

  CSISnapshotControllerFluent<?> fluent;

  public CSISnapshotControllerBuilder() {
    this(new CSISnapshotController());
  }
  
  public CSISnapshotControllerBuilder(CSISnapshotControllerFluent<?> fluent) {
    this(fluent, new CSISnapshotController());
  }
  
  public CSISnapshotControllerBuilder(CSISnapshotController instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CSISnapshotControllerBuilder(CSISnapshotControllerFluent<?> fluent,CSISnapshotController instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CSISnapshotController build() {
    CSISnapshotController buildable = new CSISnapshotController(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}