package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LLDPBuilder extends LLDPFluent<LLDPBuilder> implements VisitableBuilder<LLDP,LLDPBuilder>{

  LLDPFluent<?> fluent;

  public LLDPBuilder() {
    this(new LLDP());
  }
  
  public LLDPBuilder(LLDPFluent<?> fluent) {
    this(fluent, new LLDP());
  }
  
  public LLDPBuilder(LLDP instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LLDPBuilder(LLDPFluent<?> fluent,LLDP instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LLDP build() {
    LLDP buildable = new LLDP(fluent.getPortID(), fluent.getSwitchID(), fluent.getSwitchSystemName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}