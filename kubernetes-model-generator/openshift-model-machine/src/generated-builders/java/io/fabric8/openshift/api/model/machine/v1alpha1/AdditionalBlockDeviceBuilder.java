package io.fabric8.openshift.api.model.machine.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AdditionalBlockDeviceBuilder extends AdditionalBlockDeviceFluent<AdditionalBlockDeviceBuilder> implements VisitableBuilder<AdditionalBlockDevice,AdditionalBlockDeviceBuilder>{

  AdditionalBlockDeviceFluent<?> fluent;

  public AdditionalBlockDeviceBuilder() {
    this(new AdditionalBlockDevice());
  }
  
  public AdditionalBlockDeviceBuilder(AdditionalBlockDeviceFluent<?> fluent) {
    this(fluent, new AdditionalBlockDevice());
  }
  
  public AdditionalBlockDeviceBuilder(AdditionalBlockDevice instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AdditionalBlockDeviceBuilder(AdditionalBlockDeviceFluent<?> fluent,AdditionalBlockDevice instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AdditionalBlockDevice build() {
    AdditionalBlockDevice buildable = new AdditionalBlockDevice(fluent.getName(), fluent.getSizeGiB(), fluent.buildStorage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}