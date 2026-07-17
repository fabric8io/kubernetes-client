package io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StorageVersionMigrationStatusConditionsBuilder extends StorageVersionMigrationStatusConditionsFluent<StorageVersionMigrationStatusConditionsBuilder> implements VisitableBuilder<StorageVersionMigrationStatusConditions,StorageVersionMigrationStatusConditionsBuilder>{

  StorageVersionMigrationStatusConditionsFluent<?> fluent;

  public StorageVersionMigrationStatusConditionsBuilder() {
    this(new StorageVersionMigrationStatusConditions());
  }
  
  public StorageVersionMigrationStatusConditionsBuilder(StorageVersionMigrationStatusConditionsFluent<?> fluent) {
    this(fluent, new StorageVersionMigrationStatusConditions());
  }
  
  public StorageVersionMigrationStatusConditionsBuilder(StorageVersionMigrationStatusConditions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StorageVersionMigrationStatusConditionsBuilder(StorageVersionMigrationStatusConditionsFluent<?> fluent,StorageVersionMigrationStatusConditions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StorageVersionMigrationStatusConditions build() {
    StorageVersionMigrationStatusConditions buildable = new StorageVersionMigrationStatusConditions(fluent.getLastUpdateTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}