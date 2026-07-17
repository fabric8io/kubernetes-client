package io.fabric8.openshift.api.model.installer.vsphere.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VCentersBuilder extends VCentersFluent<VCentersBuilder> implements VisitableBuilder<VCenters,VCentersBuilder>{

  VCentersFluent<?> fluent;

  public VCentersBuilder() {
    this(new VCenters());
  }
  
  public VCentersBuilder(VCentersFluent<?> fluent) {
    this(fluent, new VCenters());
  }
  
  public VCentersBuilder(VCenters instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VCentersBuilder(VCentersFluent<?> fluent,VCenters instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VCenters build() {
    VCenters buildable = new VCenters(fluent.getPassword(), fluent.getUsername(), fluent.getVCenter());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}