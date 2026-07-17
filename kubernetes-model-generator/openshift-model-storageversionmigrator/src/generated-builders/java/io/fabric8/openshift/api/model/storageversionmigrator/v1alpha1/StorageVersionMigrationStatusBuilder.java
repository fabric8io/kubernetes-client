package io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageVersionMigrationStatusBuilder extends StorageVersionMigrationStatusFluent<StorageVersionMigrationStatusBuilder> implements VisitableBuilder<StorageVersionMigrationStatus,StorageVersionMigrationStatusBuilder>{

  StorageVersionMigrationStatusFluent<?> fluent;

  public StorageVersionMigrationStatusBuilder() {
    this(new StorageVersionMigrationStatus());
  }
  
  public StorageVersionMigrationStatusBuilder(StorageVersionMigrationStatusFluent<?> fluent) {
    this(fluent, new StorageVersionMigrationStatus());
  }
  
  public StorageVersionMigrationStatusBuilder(StorageVersionMigrationStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageVersionMigrationStatusBuilder(StorageVersionMigrationStatusFluent<?> fluent,StorageVersionMigrationStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageVersionMigrationStatus build() {
    StorageVersionMigrationStatus buildable = new StorageVersionMigrationStatus(fluent.buildConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}