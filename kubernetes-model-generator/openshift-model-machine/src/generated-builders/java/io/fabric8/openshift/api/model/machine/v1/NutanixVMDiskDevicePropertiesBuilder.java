package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NutanixVMDiskDevicePropertiesBuilder extends NutanixVMDiskDevicePropertiesFluent<NutanixVMDiskDevicePropertiesBuilder> implements VisitableBuilder<NutanixVMDiskDeviceProperties,NutanixVMDiskDevicePropertiesBuilder>{

  NutanixVMDiskDevicePropertiesFluent<?> fluent;

  public NutanixVMDiskDevicePropertiesBuilder() {
    this(new NutanixVMDiskDeviceProperties());
  }
  
  public NutanixVMDiskDevicePropertiesBuilder(NutanixVMDiskDevicePropertiesFluent<?> fluent) {
    this(fluent, new NutanixVMDiskDeviceProperties());
  }
  
  public NutanixVMDiskDevicePropertiesBuilder(NutanixVMDiskDeviceProperties instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NutanixVMDiskDevicePropertiesBuilder(NutanixVMDiskDevicePropertiesFluent<?> fluent,NutanixVMDiskDeviceProperties instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NutanixVMDiskDeviceProperties build() {
    NutanixVMDiskDeviceProperties buildable = new NutanixVMDiskDeviceProperties(fluent.getAdapterType(), fluent.getDeviceIndex(), fluent.getDeviceType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}