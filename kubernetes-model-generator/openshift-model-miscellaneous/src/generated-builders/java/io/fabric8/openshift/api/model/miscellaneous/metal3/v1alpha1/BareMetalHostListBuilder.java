package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BareMetalHostListBuilder extends BareMetalHostListFluent<BareMetalHostListBuilder> implements VisitableBuilder<BareMetalHostList,BareMetalHostListBuilder>{

  BareMetalHostListFluent<?> fluent;

  public BareMetalHostListBuilder() {
    this(new BareMetalHostList());
  }
  
  public BareMetalHostListBuilder(BareMetalHostListFluent<?> fluent) {
    this(fluent, new BareMetalHostList());
  }
  
  public BareMetalHostListBuilder(BareMetalHostList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BareMetalHostListBuilder(BareMetalHostListFluent<?> fluent,BareMetalHostList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BareMetalHostList build() {
    BareMetalHostList buildable = new BareMetalHostList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}