package io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageStateListBuilder extends StorageStateListFluent<StorageStateListBuilder> implements VisitableBuilder<StorageStateList,StorageStateListBuilder>{

  StorageStateListFluent<?> fluent;

  public StorageStateListBuilder() {
    this(new StorageStateList());
  }
  
  public StorageStateListBuilder(StorageStateListFluent<?> fluent) {
    this(fluent, new StorageStateList());
  }
  
  public StorageStateListBuilder(StorageStateList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageStateListBuilder(StorageStateListFluent<?> fluent,StorageStateList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageStateList build() {
    StorageStateList buildable = new StorageStateList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}