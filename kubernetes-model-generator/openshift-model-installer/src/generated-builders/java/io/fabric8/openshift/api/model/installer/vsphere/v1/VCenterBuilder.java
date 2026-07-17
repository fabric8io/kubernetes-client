package io.fabric8.openshift.api.model.installer.vsphere.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VCenterBuilder extends VCenterFluent<VCenterBuilder> implements VisitableBuilder<VCenter,VCenterBuilder>{

  VCenterFluent<?> fluent;

  public VCenterBuilder() {
    this(new VCenter());
  }
  
  public VCenterBuilder(VCenterFluent<?> fluent) {
    this(fluent, new VCenter());
  }
  
  public VCenterBuilder(VCenter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VCenterBuilder(VCenterFluent<?> fluent,VCenter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VCenter build() {
    VCenter buildable = new VCenter(fluent.getDatacenters(), fluent.getPassword(), fluent.getPort(), fluent.getServer(), fluent.getUser());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}