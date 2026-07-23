package io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageVersionMigrationSpecBuilder extends StorageVersionMigrationSpecFluent<StorageVersionMigrationSpecBuilder> implements VisitableBuilder<StorageVersionMigrationSpec,StorageVersionMigrationSpecBuilder>{

  StorageVersionMigrationSpecFluent<?> fluent;

  public StorageVersionMigrationSpecBuilder() {
    this(new StorageVersionMigrationSpec());
  }
  
  public StorageVersionMigrationSpecBuilder(StorageVersionMigrationSpecFluent<?> fluent) {
    this(fluent, new StorageVersionMigrationSpec());
  }
  
  public StorageVersionMigrationSpecBuilder(StorageVersionMigrationSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageVersionMigrationSpecBuilder(StorageVersionMigrationSpecFluent<?> fluent,StorageVersionMigrationSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageVersionMigrationSpec build() {
    StorageVersionMigrationSpec buildable = new StorageVersionMigrationSpec(fluent.getContinueToken(), fluent.buildResource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}