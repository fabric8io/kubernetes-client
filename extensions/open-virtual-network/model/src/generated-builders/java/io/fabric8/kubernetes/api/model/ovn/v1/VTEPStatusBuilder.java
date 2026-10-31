package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VTEPStatusBuilder extends VTEPStatusFluent<VTEPStatusBuilder> implements VisitableBuilder<VTEPStatus,VTEPStatusBuilder>{

  VTEPStatusFluent<?> fluent;

  public VTEPStatusBuilder() {
    this(new VTEPStatus());
  }
  
  public VTEPStatusBuilder(VTEPStatusFluent<?> fluent) {
    this(fluent, new VTEPStatus());
  }
  
  public VTEPStatusBuilder(VTEPStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VTEPStatusBuilder(VTEPStatusFluent<?> fluent,VTEPStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VTEPStatus build() {
    VTEPStatus buildable = new VTEPStatus(fluent.getConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}