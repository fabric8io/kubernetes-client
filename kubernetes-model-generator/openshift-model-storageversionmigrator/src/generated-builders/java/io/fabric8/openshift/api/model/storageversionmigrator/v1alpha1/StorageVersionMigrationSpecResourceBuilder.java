package io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageVersionMigrationSpecResourceBuilder extends StorageVersionMigrationSpecResourceFluent<StorageVersionMigrationSpecResourceBuilder> implements VisitableBuilder<StorageVersionMigrationSpecResource,StorageVersionMigrationSpecResourceBuilder>{

  StorageVersionMigrationSpecResourceFluent<?> fluent;

  public StorageVersionMigrationSpecResourceBuilder() {
    this(new StorageVersionMigrationSpecResource());
  }
  
  public StorageVersionMigrationSpecResourceBuilder(StorageVersionMigrationSpecResourceFluent<?> fluent) {
    this(fluent, new StorageVersionMigrationSpecResource());
  }
  
  public StorageVersionMigrationSpecResourceBuilder(StorageVersionMigrationSpecResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageVersionMigrationSpecResourceBuilder(StorageVersionMigrationSpecResourceFluent<?> fluent,StorageVersionMigrationSpecResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageVersionMigrationSpecResource build() {
    StorageVersionMigrationSpecResource buildable = new StorageVersionMigrationSpecResource(fluent.getGroup(), fluent.getResource(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}