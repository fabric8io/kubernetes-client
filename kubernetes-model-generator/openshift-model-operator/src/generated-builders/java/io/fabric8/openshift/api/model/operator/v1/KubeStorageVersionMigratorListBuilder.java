package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeStorageVersionMigratorListBuilder extends KubeStorageVersionMigratorListFluent<KubeStorageVersionMigratorListBuilder> implements VisitableBuilder<KubeStorageVersionMigratorList,KubeStorageVersionMigratorListBuilder>{

  KubeStorageVersionMigratorListFluent<?> fluent;

  public KubeStorageVersionMigratorListBuilder() {
    this(new KubeStorageVersionMigratorList());
  }
  
  public KubeStorageVersionMigratorListBuilder(KubeStorageVersionMigratorListFluent<?> fluent) {
    this(fluent, new KubeStorageVersionMigratorList());
  }
  
  public KubeStorageVersionMigratorListBuilder(KubeStorageVersionMigratorList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeStorageVersionMigratorListBuilder(KubeStorageVersionMigratorListFluent<?> fluent,KubeStorageVersionMigratorList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeStorageVersionMigratorList build() {
    KubeStorageVersionMigratorList buildable = new KubeStorageVersionMigratorList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}