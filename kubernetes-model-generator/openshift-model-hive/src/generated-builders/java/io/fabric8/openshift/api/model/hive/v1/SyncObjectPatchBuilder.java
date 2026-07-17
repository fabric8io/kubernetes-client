package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SyncObjectPatchBuilder extends SyncObjectPatchFluent<SyncObjectPatchBuilder> implements VisitableBuilder<SyncObjectPatch,SyncObjectPatchBuilder>{

  SyncObjectPatchFluent<?> fluent;

  public SyncObjectPatchBuilder() {
    this(new SyncObjectPatch());
  }
  
  public SyncObjectPatchBuilder(SyncObjectPatchFluent<?> fluent) {
    this(fluent, new SyncObjectPatch());
  }
  
  public SyncObjectPatchBuilder(SyncObjectPatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SyncObjectPatchBuilder(SyncObjectPatchFluent<?> fluent,SyncObjectPatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SyncObjectPatch build() {
    SyncObjectPatch buildable = new SyncObjectPatch(fluent.getApiVersion(), fluent.getKind(), fluent.getName(), fluent.getNamespace(), fluent.getPatch(), fluent.getPatchType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}