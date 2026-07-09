package io.fabric8.kubernetes.api.model.storage;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CSIStorageCapacityListBuilder extends CSIStorageCapacityListFluent<CSIStorageCapacityListBuilder> implements VisitableBuilder<CSIStorageCapacityList,CSIStorageCapacityListBuilder>{

  CSIStorageCapacityListFluent<?> fluent;

  public CSIStorageCapacityListBuilder() {
    this(new CSIStorageCapacityList());
  }
  
  public CSIStorageCapacityListBuilder(CSIStorageCapacityListFluent<?> fluent) {
    this(fluent, new CSIStorageCapacityList());
  }
  
  public CSIStorageCapacityListBuilder(CSIStorageCapacityList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CSIStorageCapacityListBuilder(CSIStorageCapacityListFluent<?> fluent,CSIStorageCapacityList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CSIStorageCapacityList build() {
    CSIStorageCapacityList buildable = new CSIStorageCapacityList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}