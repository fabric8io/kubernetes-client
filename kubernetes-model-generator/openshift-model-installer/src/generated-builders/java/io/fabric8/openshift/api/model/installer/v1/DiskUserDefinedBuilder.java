package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DiskUserDefinedBuilder extends DiskUserDefinedFluent<DiskUserDefinedBuilder> implements VisitableBuilder<DiskUserDefined,DiskUserDefinedBuilder>{

  DiskUserDefinedFluent<?> fluent;

  public DiskUserDefinedBuilder() {
    this(new DiskUserDefined());
  }
  
  public DiskUserDefinedBuilder(DiskUserDefinedFluent<?> fluent) {
    this(fluent, new DiskUserDefined());
  }
  
  public DiskUserDefinedBuilder(DiskUserDefined instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DiskUserDefinedBuilder(DiskUserDefinedFluent<?> fluent,DiskUserDefined instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DiskUserDefined build() {
    DiskUserDefined buildable = new DiskUserDefined(fluent.getMountPath(), fluent.getPlatformDiskID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}