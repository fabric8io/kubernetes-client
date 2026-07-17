package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VLANBuilder extends VLANFluent<VLANBuilder> implements VisitableBuilder<VLAN,VLANBuilder>{

  VLANFluent<?> fluent;

  public VLANBuilder() {
    this(new VLAN());
  }
  
  public VLANBuilder(VLANFluent<?> fluent) {
    this(fluent, new VLAN());
  }
  
  public VLANBuilder(VLAN instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VLANBuilder(VLANFluent<?> fluent,VLAN instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VLAN build() {
    VLAN buildable = new VLAN(fluent.getId(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}