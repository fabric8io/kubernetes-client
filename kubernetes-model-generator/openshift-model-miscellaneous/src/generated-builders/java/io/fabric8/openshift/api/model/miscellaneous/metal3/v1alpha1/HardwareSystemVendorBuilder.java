package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HardwareSystemVendorBuilder extends HardwareSystemVendorFluent<HardwareSystemVendorBuilder> implements VisitableBuilder<HardwareSystemVendor,HardwareSystemVendorBuilder>{

  HardwareSystemVendorFluent<?> fluent;

  public HardwareSystemVendorBuilder() {
    this(new HardwareSystemVendor());
  }
  
  public HardwareSystemVendorBuilder(HardwareSystemVendorFluent<?> fluent) {
    this(fluent, new HardwareSystemVendor());
  }
  
  public HardwareSystemVendorBuilder(HardwareSystemVendor instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HardwareSystemVendorBuilder(HardwareSystemVendorFluent<?> fluent,HardwareSystemVendor instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HardwareSystemVendor build() {
    HardwareSystemVendor buildable = new HardwareSystemVendor(fluent.getManufacturer(), fluent.getProductName(), fluent.getSerialNumber());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}