package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SwitchPortBuilder extends SwitchPortFluent<SwitchPortBuilder> implements VisitableBuilder<SwitchPort,SwitchPortBuilder>{

  SwitchPortFluent<?> fluent;

  public SwitchPortBuilder() {
    this(new SwitchPort());
  }
  
  public SwitchPortBuilder(SwitchPortFluent<?> fluent) {
    this(fluent, new SwitchPort());
  }
  
  public SwitchPortBuilder(SwitchPort instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SwitchPortBuilder(SwitchPortFluent<?> fluent,SwitchPort instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SwitchPort build() {
    SwitchPort buildable = new SwitchPort(fluent.getPortID(), fluent.getSwitchID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}