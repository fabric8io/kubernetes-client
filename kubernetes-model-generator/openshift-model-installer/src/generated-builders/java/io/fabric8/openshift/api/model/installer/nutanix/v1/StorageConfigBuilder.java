package io.fabric8.openshift.api.model.installer.nutanix.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageConfigBuilder extends StorageConfigFluent<StorageConfigBuilder> implements VisitableBuilder<StorageConfig,StorageConfigBuilder>{

  StorageConfigFluent<?> fluent;

  public StorageConfigBuilder() {
    this(new StorageConfig());
  }
  
  public StorageConfigBuilder(StorageConfigFluent<?> fluent) {
    this(fluent, new StorageConfig());
  }
  
  public StorageConfigBuilder(StorageConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageConfigBuilder(StorageConfigFluent<?> fluent,StorageConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageConfig build() {
    StorageConfig buildable = new StorageConfig(fluent.getDiskMode(), fluent.buildStorageContainer());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}