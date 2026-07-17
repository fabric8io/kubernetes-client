package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EtcdBackupBuilder extends EtcdBackupFluent<EtcdBackupBuilder> implements VisitableBuilder<EtcdBackup,EtcdBackupBuilder>{

  EtcdBackupFluent<?> fluent;

  public EtcdBackupBuilder() {
    this(new EtcdBackup());
  }
  
  public EtcdBackupBuilder(EtcdBackupFluent<?> fluent) {
    this(fluent, new EtcdBackup());
  }
  
  public EtcdBackupBuilder(EtcdBackup instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EtcdBackupBuilder(EtcdBackupFluent<?> fluent,EtcdBackup instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EtcdBackup build() {
    EtcdBackup buildable = new EtcdBackup(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}