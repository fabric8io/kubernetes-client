package io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageStateBuilder extends StorageStateFluent<StorageStateBuilder> implements VisitableBuilder<StorageState,StorageStateBuilder>{

  StorageStateFluent<?> fluent;

  public StorageStateBuilder() {
    this(new StorageState());
  }
  
  public StorageStateBuilder(StorageStateFluent<?> fluent) {
    this(fluent, new StorageState());
  }
  
  public StorageStateBuilder(StorageState instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageStateBuilder(StorageStateFluent<?> fluent,StorageState instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageState build() {
    StorageState buildable = new StorageState(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}