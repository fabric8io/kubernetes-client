package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BareMetalSwitchBuilder extends BareMetalSwitchFluent<BareMetalSwitchBuilder> implements VisitableBuilder<BareMetalSwitch,BareMetalSwitchBuilder>{

  BareMetalSwitchFluent<?> fluent;

  public BareMetalSwitchBuilder() {
    this(new BareMetalSwitch());
  }
  
  public BareMetalSwitchBuilder(BareMetalSwitchFluent<?> fluent) {
    this(fluent, new BareMetalSwitch());
  }
  
  public BareMetalSwitchBuilder(BareMetalSwitch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BareMetalSwitchBuilder(BareMetalSwitchFluent<?> fluent,BareMetalSwitch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BareMetalSwitch build() {
    BareMetalSwitch buildable = new BareMetalSwitch(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}