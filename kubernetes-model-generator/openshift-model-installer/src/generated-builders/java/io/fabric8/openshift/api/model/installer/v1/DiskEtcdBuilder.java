package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DiskEtcdBuilder extends DiskEtcdFluent<DiskEtcdBuilder> implements VisitableBuilder<DiskEtcd,DiskEtcdBuilder>{

  DiskEtcdFluent<?> fluent;

  public DiskEtcdBuilder() {
    this(new DiskEtcd());
  }
  
  public DiskEtcdBuilder(DiskEtcdFluent<?> fluent) {
    this(fluent, new DiskEtcd());
  }
  
  public DiskEtcdBuilder(DiskEtcd instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DiskEtcdBuilder(DiskEtcdFluent<?> fluent,DiskEtcd instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DiskEtcd build() {
    DiskEtcd buildable = new DiskEtcd(fluent.getPlatformDiskID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}