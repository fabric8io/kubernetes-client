package io.fabric8.openshift.api.model.installer.aws.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VPCBuilder extends VPCFluent<VPCBuilder> implements VisitableBuilder<VPC,VPCBuilder>{

  VPCFluent<?> fluent;

  public VPCBuilder() {
    this(new VPC());
  }
  
  public VPCBuilder(VPCFluent<?> fluent) {
    this(fluent, new VPC());
  }
  
  public VPCBuilder(VPC instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VPCBuilder(VPCFluent<?> fluent,VPC instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VPC build() {
    VPC buildable = new VPC(fluent.buildSubnets());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}