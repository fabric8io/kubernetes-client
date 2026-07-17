package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NutanixGPUBuilder extends NutanixGPUFluent<NutanixGPUBuilder> implements VisitableBuilder<NutanixGPU,NutanixGPUBuilder>{

  NutanixGPUFluent<?> fluent;

  public NutanixGPUBuilder() {
    this(new NutanixGPU());
  }
  
  public NutanixGPUBuilder(NutanixGPUFluent<?> fluent) {
    this(fluent, new NutanixGPU());
  }
  
  public NutanixGPUBuilder(NutanixGPU instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NutanixGPUBuilder(NutanixGPUFluent<?> fluent,NutanixGPU instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NutanixGPU build() {
    NutanixGPU buildable = new NutanixGPU(fluent.getDeviceID(), fluent.getName(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}