package io.fabric8.kubernetes.api.model.storagemigration.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageVersionMigrationListBuilder extends StorageVersionMigrationListFluent<StorageVersionMigrationListBuilder> implements VisitableBuilder<StorageVersionMigrationList,StorageVersionMigrationListBuilder>{

  StorageVersionMigrationListFluent<?> fluent;

  public StorageVersionMigrationListBuilder() {
    this(new StorageVersionMigrationList());
  }
  
  public StorageVersionMigrationListBuilder(StorageVersionMigrationListFluent<?> fluent) {
    this(fluent, new StorageVersionMigrationList());
  }
  
  public StorageVersionMigrationListBuilder(StorageVersionMigrationList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageVersionMigrationListBuilder(StorageVersionMigrationListFluent<?> fluent,StorageVersionMigrationList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageVersionMigrationList build() {
    StorageVersionMigrationList buildable = new StorageVersionMigrationList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}