package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NutanixVMDiskBuilder extends NutanixVMDiskFluent<NutanixVMDiskBuilder> implements VisitableBuilder<NutanixVMDisk,NutanixVMDiskBuilder>{

  NutanixVMDiskFluent<?> fluent;

  public NutanixVMDiskBuilder() {
    this(new NutanixVMDisk());
  }
  
  public NutanixVMDiskBuilder(NutanixVMDiskFluent<?> fluent) {
    this(fluent, new NutanixVMDisk());
  }
  
  public NutanixVMDiskBuilder(NutanixVMDisk instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NutanixVMDiskBuilder(NutanixVMDiskFluent<?> fluent,NutanixVMDisk instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NutanixVMDisk build() {
    NutanixVMDisk buildable = new NutanixVMDisk(fluent.buildDataSource(), fluent.buildDeviceProperties(), fluent.getDiskSize(), fluent.buildStorageConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}