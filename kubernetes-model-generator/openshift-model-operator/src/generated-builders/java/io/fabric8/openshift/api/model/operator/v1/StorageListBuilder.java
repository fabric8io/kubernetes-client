package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageListBuilder extends StorageListFluent<StorageListBuilder> implements VisitableBuilder<StorageList,StorageListBuilder>{

  StorageListFluent<?> fluent;

  public StorageListBuilder() {
    this(new StorageList());
  }
  
  public StorageListBuilder(StorageListFluent<?> fluent) {
    this(fluent, new StorageList());
  }
  
  public StorageListBuilder(StorageList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageListBuilder(StorageListFluent<?> fluent,StorageList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageList build() {
    StorageList buildable = new StorageList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}