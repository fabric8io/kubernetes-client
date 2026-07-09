package io.fabric8.kubernetes.api.model.storage;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageClassBuilder extends StorageClassFluent<StorageClassBuilder> implements VisitableBuilder<StorageClass,StorageClassBuilder>{

  StorageClassFluent<?> fluent;

  public StorageClassBuilder() {
    this(new StorageClass());
  }
  
  public StorageClassBuilder(StorageClassFluent<?> fluent) {
    this(fluent, new StorageClass());
  }
  
  public StorageClassBuilder(StorageClass instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageClassBuilder(StorageClassFluent<?> fluent,StorageClass instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageClass build() {
    StorageClass buildable = new StorageClass(fluent.getAllowVolumeExpansion(), fluent.getAllowedTopologies(), fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.getMountOptions(), fluent.getParameters(), fluent.getProvisioner(), fluent.getReclaimPolicy(), fluent.getVolumeBindingMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}