package io.fabric8.openshift.api.model.installer.ovirt.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DiskBuilder extends DiskFluent<DiskBuilder> implements VisitableBuilder<Disk,DiskBuilder>{

  DiskFluent<?> fluent;

  public DiskBuilder() {
    this(new Disk());
  }
  
  public DiskBuilder(DiskFluent<?> fluent) {
    this(fluent, new Disk());
  }
  
  public DiskBuilder(Disk instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DiskBuilder(DiskFluent<?> fluent,Disk instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Disk build() {
    Disk buildable = new Disk(fluent.getSizeGB());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}