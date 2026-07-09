package io.fabric8.kubernetes.api.model.storage;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageClassListBuilder extends StorageClassListFluent<StorageClassListBuilder> implements VisitableBuilder<StorageClassList,StorageClassListBuilder>{

  StorageClassListFluent<?> fluent;

  public StorageClassListBuilder() {
    this(new StorageClassList());
  }
  
  public StorageClassListBuilder(StorageClassListFluent<?> fluent) {
    this(fluent, new StorageClassList());
  }
  
  public StorageClassListBuilder(StorageClassList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageClassListBuilder(StorageClassListFluent<?> fluent,StorageClassList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageClassList build() {
    StorageClassList buildable = new StorageClassList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}