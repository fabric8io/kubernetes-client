package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VTEPBuilder extends VTEPFluent<VTEPBuilder> implements VisitableBuilder<VTEP,VTEPBuilder>{

  VTEPFluent<?> fluent;

  public VTEPBuilder() {
    this(new VTEP());
  }
  
  public VTEPBuilder(VTEPFluent<?> fluent) {
    this(fluent, new VTEP());
  }
  
  public VTEPBuilder(VTEP instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VTEPBuilder(VTEPFluent<?> fluent,VTEP instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VTEP build() {
    VTEP buildable = new VTEP(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}