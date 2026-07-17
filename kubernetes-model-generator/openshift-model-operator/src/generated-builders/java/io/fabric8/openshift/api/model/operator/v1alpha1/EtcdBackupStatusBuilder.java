package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EtcdBackupStatusBuilder extends EtcdBackupStatusFluent<EtcdBackupStatusBuilder> implements VisitableBuilder<EtcdBackupStatus,EtcdBackupStatusBuilder>{

  EtcdBackupStatusFluent<?> fluent;

  public EtcdBackupStatusBuilder() {
    this(new EtcdBackupStatus());
  }
  
  public EtcdBackupStatusBuilder(EtcdBackupStatusFluent<?> fluent) {
    this(fluent, new EtcdBackupStatus());
  }
  
  public EtcdBackupStatusBuilder(EtcdBackupStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EtcdBackupStatusBuilder(EtcdBackupStatusFluent<?> fluent,EtcdBackupStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EtcdBackupStatus build() {
    EtcdBackupStatus buildable = new EtcdBackupStatus(fluent.buildBackupJob(), fluent.getConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}