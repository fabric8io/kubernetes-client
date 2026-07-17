package io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageStateSpecBuilder extends StorageStateSpecFluent<StorageStateSpecBuilder> implements VisitableBuilder<StorageStateSpec,StorageStateSpecBuilder>{

  StorageStateSpecFluent<?> fluent;

  public StorageStateSpecBuilder() {
    this(new StorageStateSpec());
  }
  
  public StorageStateSpecBuilder(StorageStateSpecFluent<?> fluent) {
    this(fluent, new StorageStateSpec());
  }
  
  public StorageStateSpecBuilder(StorageStateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageStateSpecBuilder(StorageStateSpecFluent<?> fluent,StorageStateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageStateSpec build() {
    StorageStateSpec buildable = new StorageStateSpec(fluent.buildResource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}