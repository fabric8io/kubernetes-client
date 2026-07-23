package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeStorageVersionMigratorStatusBuilder extends KubeStorageVersionMigratorStatusFluent<KubeStorageVersionMigratorStatusBuilder> implements VisitableBuilder<KubeStorageVersionMigratorStatus,KubeStorageVersionMigratorStatusBuilder>{

  KubeStorageVersionMigratorStatusFluent<?> fluent;

  public KubeStorageVersionMigratorStatusBuilder() {
    this(new KubeStorageVersionMigratorStatus());
  }
  
  public KubeStorageVersionMigratorStatusBuilder(KubeStorageVersionMigratorStatusFluent<?> fluent) {
    this(fluent, new KubeStorageVersionMigratorStatus());
  }
  
  public KubeStorageVersionMigratorStatusBuilder(KubeStorageVersionMigratorStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeStorageVersionMigratorStatusBuilder(KubeStorageVersionMigratorStatusFluent<?> fluent,KubeStorageVersionMigratorStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeStorageVersionMigratorStatus build() {
    KubeStorageVersionMigratorStatus buildable = new KubeStorageVersionMigratorStatus(fluent.buildConditions(), fluent.buildGenerations(), fluent.getLatestAvailableRevision(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}