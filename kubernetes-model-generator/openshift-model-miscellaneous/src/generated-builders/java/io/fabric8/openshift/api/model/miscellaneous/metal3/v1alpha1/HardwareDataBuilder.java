package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HardwareDataBuilder extends HardwareDataFluent<HardwareDataBuilder> implements VisitableBuilder<HardwareData,HardwareDataBuilder>{

  HardwareDataFluent<?> fluent;

  public HardwareDataBuilder() {
    this(new HardwareData());
  }
  
  public HardwareDataBuilder(HardwareDataFluent<?> fluent) {
    this(fluent, new HardwareData());
  }
  
  public HardwareDataBuilder(HardwareData instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HardwareDataBuilder(HardwareDataFluent<?> fluent,HardwareData instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HardwareData build() {
    HardwareData buildable = new HardwareData(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}