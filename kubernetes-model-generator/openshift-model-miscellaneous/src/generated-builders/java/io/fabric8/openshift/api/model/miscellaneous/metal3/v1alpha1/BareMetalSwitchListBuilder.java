package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BareMetalSwitchListBuilder extends BareMetalSwitchListFluent<BareMetalSwitchListBuilder> implements VisitableBuilder<BareMetalSwitchList,BareMetalSwitchListBuilder>{

  BareMetalSwitchListFluent<?> fluent;

  public BareMetalSwitchListBuilder() {
    this(new BareMetalSwitchList());
  }
  
  public BareMetalSwitchListBuilder(BareMetalSwitchListFluent<?> fluent) {
    this(fluent, new BareMetalSwitchList());
  }
  
  public BareMetalSwitchListBuilder(BareMetalSwitchList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BareMetalSwitchListBuilder(BareMetalSwitchListFluent<?> fluent,BareMetalSwitchList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BareMetalSwitchList build() {
    BareMetalSwitchList buildable = new BareMetalSwitchList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}