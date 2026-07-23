package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SyncStatusBuilder extends SyncStatusFluent<SyncStatusBuilder> implements VisitableBuilder<SyncStatus,SyncStatusBuilder>{

  SyncStatusFluent<?> fluent;

  public SyncStatusBuilder() {
    this(new SyncStatus());
  }
  
  public SyncStatusBuilder(SyncStatusFluent<?> fluent) {
    this(fluent, new SyncStatus());
  }
  
  public SyncStatusBuilder(SyncStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SyncStatusBuilder(SyncStatusFluent<?> fluent,SyncStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SyncStatus build() {
    SyncStatus buildable = new SyncStatus(fluent.getApiVersion(), fluent.buildConditions(), fluent.getHash(), fluent.getKind(), fluent.getName(), fluent.getNamespace(), fluent.getResource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}