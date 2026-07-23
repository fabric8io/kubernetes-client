package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HardwareDetailsBuilder extends HardwareDetailsFluent<HardwareDetailsBuilder> implements VisitableBuilder<HardwareDetails,HardwareDetailsBuilder>{

  HardwareDetailsFluent<?> fluent;

  public HardwareDetailsBuilder() {
    this(new HardwareDetails());
  }
  
  public HardwareDetailsBuilder(HardwareDetailsFluent<?> fluent) {
    this(fluent, new HardwareDetails());
  }
  
  public HardwareDetailsBuilder(HardwareDetails instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HardwareDetailsBuilder(HardwareDetailsFluent<?> fluent,HardwareDetails instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HardwareDetails build() {
    HardwareDetails buildable = new HardwareDetails(fluent.buildCpu(), fluent.buildFirmware(), fluent.getHostname(), fluent.buildNics(), fluent.getRamMebibytes(), fluent.buildStorage(), fluent.buildSystemVendor());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}