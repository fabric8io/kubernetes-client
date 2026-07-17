package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VSphereDiskBuilder extends VSphereDiskFluent<VSphereDiskBuilder> implements VisitableBuilder<VSphereDisk,VSphereDiskBuilder>{

  VSphereDiskFluent<?> fluent;

  public VSphereDiskBuilder() {
    this(new VSphereDisk());
  }
  
  public VSphereDiskBuilder(VSphereDiskFluent<?> fluent) {
    this(fluent, new VSphereDisk());
  }
  
  public VSphereDiskBuilder(VSphereDisk instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VSphereDiskBuilder(VSphereDiskFluent<?> fluent,VSphereDisk instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VSphereDisk build() {
    VSphereDisk buildable = new VSphereDisk(fluent.getName(), fluent.getProvisioningMode(), fluent.getSizeGiB());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}