package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EtcdBackupListBuilder extends EtcdBackupListFluent<EtcdBackupListBuilder> implements VisitableBuilder<EtcdBackupList,EtcdBackupListBuilder>{

  EtcdBackupListFluent<?> fluent;

  public EtcdBackupListBuilder() {
    this(new EtcdBackupList());
  }
  
  public EtcdBackupListBuilder(EtcdBackupListFluent<?> fluent) {
    this(fluent, new EtcdBackupList());
  }
  
  public EtcdBackupListBuilder(EtcdBackupList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EtcdBackupListBuilder(EtcdBackupListFluent<?> fluent,EtcdBackupList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EtcdBackupList build() {
    EtcdBackupList buildable = new EtcdBackupList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}