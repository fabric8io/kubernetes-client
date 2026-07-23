package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EtcdBackupSpecBuilder extends EtcdBackupSpecFluent<EtcdBackupSpecBuilder> implements VisitableBuilder<EtcdBackupSpec,EtcdBackupSpecBuilder>{

  EtcdBackupSpecFluent<?> fluent;

  public EtcdBackupSpecBuilder() {
    this(new EtcdBackupSpec());
  }
  
  public EtcdBackupSpecBuilder(EtcdBackupSpecFluent<?> fluent) {
    this(fluent, new EtcdBackupSpec());
  }
  
  public EtcdBackupSpecBuilder(EtcdBackupSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EtcdBackupSpecBuilder(EtcdBackupSpecFluent<?> fluent,EtcdBackupSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EtcdBackupSpec build() {
    EtcdBackupSpec buildable = new EtcdBackupSpec(fluent.getPvcName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}