package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HardwareDataSpecBuilder extends HardwareDataSpecFluent<HardwareDataSpecBuilder> implements VisitableBuilder<HardwareDataSpec,HardwareDataSpecBuilder>{

  HardwareDataSpecFluent<?> fluent;

  public HardwareDataSpecBuilder() {
    this(new HardwareDataSpec());
  }
  
  public HardwareDataSpecBuilder(HardwareDataSpecFluent<?> fluent) {
    this(fluent, new HardwareDataSpec());
  }
  
  public HardwareDataSpecBuilder(HardwareDataSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HardwareDataSpecBuilder(HardwareDataSpecFluent<?> fluent,HardwareDataSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HardwareDataSpec build() {
    HardwareDataSpec buildable = new HardwareDataSpec(fluent.buildHardware());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}