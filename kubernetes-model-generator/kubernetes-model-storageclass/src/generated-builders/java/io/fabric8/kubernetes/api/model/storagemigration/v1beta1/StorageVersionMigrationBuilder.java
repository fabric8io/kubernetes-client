package io.fabric8.kubernetes.api.model.storagemigration.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageVersionMigrationBuilder extends StorageVersionMigrationFluent<StorageVersionMigrationBuilder> implements VisitableBuilder<StorageVersionMigration,StorageVersionMigrationBuilder>{

  StorageVersionMigrationFluent<?> fluent;

  public StorageVersionMigrationBuilder() {
    this(new StorageVersionMigration());
  }
  
  public StorageVersionMigrationBuilder(StorageVersionMigrationFluent<?> fluent) {
    this(fluent, new StorageVersionMigration());
  }
  
  public StorageVersionMigrationBuilder(StorageVersionMigration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageVersionMigrationBuilder(StorageVersionMigrationFluent<?> fluent,StorageVersionMigration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageVersionMigration build() {
    StorageVersionMigration buildable = new StorageVersionMigration(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}