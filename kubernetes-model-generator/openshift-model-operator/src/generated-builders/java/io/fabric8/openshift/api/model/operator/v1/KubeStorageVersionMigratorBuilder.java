package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeStorageVersionMigratorBuilder extends KubeStorageVersionMigratorFluent<KubeStorageVersionMigratorBuilder> implements VisitableBuilder<KubeStorageVersionMigrator,KubeStorageVersionMigratorBuilder>{

  KubeStorageVersionMigratorFluent<?> fluent;

  public KubeStorageVersionMigratorBuilder() {
    this(new KubeStorageVersionMigrator());
  }
  
  public KubeStorageVersionMigratorBuilder(KubeStorageVersionMigratorFluent<?> fluent) {
    this(fluent, new KubeStorageVersionMigrator());
  }
  
  public KubeStorageVersionMigratorBuilder(KubeStorageVersionMigrator instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeStorageVersionMigratorBuilder(KubeStorageVersionMigratorFluent<?> fluent,KubeStorageVersionMigrator instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeStorageVersionMigrator build() {
    KubeStorageVersionMigrator buildable = new KubeStorageVersionMigrator(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}