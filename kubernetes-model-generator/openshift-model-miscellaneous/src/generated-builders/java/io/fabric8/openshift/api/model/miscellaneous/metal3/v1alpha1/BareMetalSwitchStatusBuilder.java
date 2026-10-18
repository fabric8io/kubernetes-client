package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BareMetalSwitchStatusBuilder extends BareMetalSwitchStatusFluent<BareMetalSwitchStatusBuilder> implements VisitableBuilder<BareMetalSwitchStatus,BareMetalSwitchStatusBuilder>{

  BareMetalSwitchStatusFluent<?> fluent;

  public BareMetalSwitchStatusBuilder() {
    this(new BareMetalSwitchStatus());
  }
  
  public BareMetalSwitchStatusBuilder(BareMetalSwitchStatusFluent<?> fluent) {
    this(fluent, new BareMetalSwitchStatus());
  }
  
  public BareMetalSwitchStatusBuilder(BareMetalSwitchStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BareMetalSwitchStatusBuilder(BareMetalSwitchStatusFluent<?> fluent,BareMetalSwitchStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BareMetalSwitchStatus build() {
    BareMetalSwitchStatus buildable = new BareMetalSwitchStatus(fluent.getConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}