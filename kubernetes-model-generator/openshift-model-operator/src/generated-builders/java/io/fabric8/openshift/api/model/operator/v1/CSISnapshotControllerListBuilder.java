package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CSISnapshotControllerListBuilder extends CSISnapshotControllerListFluent<CSISnapshotControllerListBuilder> implements VisitableBuilder<CSISnapshotControllerList,CSISnapshotControllerListBuilder>{

  CSISnapshotControllerListFluent<?> fluent;

  public CSISnapshotControllerListBuilder() {
    this(new CSISnapshotControllerList());
  }
  
  public CSISnapshotControllerListBuilder(CSISnapshotControllerListFluent<?> fluent) {
    this(fluent, new CSISnapshotControllerList());
  }
  
  public CSISnapshotControllerListBuilder(CSISnapshotControllerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CSISnapshotControllerListBuilder(CSISnapshotControllerListFluent<?> fluent,CSISnapshotControllerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CSISnapshotControllerList build() {
    CSISnapshotControllerList buildable = new CSISnapshotControllerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}