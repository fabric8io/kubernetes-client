package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CSISnapshotControllerSpecBuilder extends CSISnapshotControllerSpecFluent<CSISnapshotControllerSpecBuilder> implements VisitableBuilder<CSISnapshotControllerSpec,CSISnapshotControllerSpecBuilder>{

  CSISnapshotControllerSpecFluent<?> fluent;

  public CSISnapshotControllerSpecBuilder() {
    this(new CSISnapshotControllerSpec());
  }
  
  public CSISnapshotControllerSpecBuilder(CSISnapshotControllerSpecFluent<?> fluent) {
    this(fluent, new CSISnapshotControllerSpec());
  }
  
  public CSISnapshotControllerSpecBuilder(CSISnapshotControllerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CSISnapshotControllerSpecBuilder(CSISnapshotControllerSpecFluent<?> fluent,CSISnapshotControllerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CSISnapshotControllerSpec build() {
    CSISnapshotControllerSpec buildable = new CSISnapshotControllerSpec(fluent.getLogLevel(), fluent.getManagementState(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}