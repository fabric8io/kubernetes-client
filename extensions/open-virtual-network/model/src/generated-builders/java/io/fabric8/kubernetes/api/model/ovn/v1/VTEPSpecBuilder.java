package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VTEPSpecBuilder extends VTEPSpecFluent<VTEPSpecBuilder> implements VisitableBuilder<VTEPSpec,VTEPSpecBuilder>{

  VTEPSpecFluent<?> fluent;

  public VTEPSpecBuilder() {
    this(new VTEPSpec());
  }
  
  public VTEPSpecBuilder(VTEPSpecFluent<?> fluent) {
    this(fluent, new VTEPSpec());
  }
  
  public VTEPSpecBuilder(VTEPSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VTEPSpecBuilder(VTEPSpecFluent<?> fluent,VTEPSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VTEPSpec build() {
    VTEPSpec buildable = new VTEPSpec(fluent.getCidrs(), fluent.getMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}