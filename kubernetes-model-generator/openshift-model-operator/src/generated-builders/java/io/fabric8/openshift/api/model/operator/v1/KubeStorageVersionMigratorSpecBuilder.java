package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeStorageVersionMigratorSpecBuilder extends KubeStorageVersionMigratorSpecFluent<KubeStorageVersionMigratorSpecBuilder> implements VisitableBuilder<KubeStorageVersionMigratorSpec,KubeStorageVersionMigratorSpecBuilder>{

  KubeStorageVersionMigratorSpecFluent<?> fluent;

  public KubeStorageVersionMigratorSpecBuilder() {
    this(new KubeStorageVersionMigratorSpec());
  }
  
  public KubeStorageVersionMigratorSpecBuilder(KubeStorageVersionMigratorSpecFluent<?> fluent) {
    this(fluent, new KubeStorageVersionMigratorSpec());
  }
  
  public KubeStorageVersionMigratorSpecBuilder(KubeStorageVersionMigratorSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeStorageVersionMigratorSpecBuilder(KubeStorageVersionMigratorSpecFluent<?> fluent,KubeStorageVersionMigratorSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeStorageVersionMigratorSpec build() {
    KubeStorageVersionMigratorSpec buildable = new KubeStorageVersionMigratorSpec(fluent.getLogLevel(), fluent.getManagementState(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}