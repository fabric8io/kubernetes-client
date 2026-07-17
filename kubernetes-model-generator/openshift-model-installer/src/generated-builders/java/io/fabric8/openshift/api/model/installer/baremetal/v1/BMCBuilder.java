package io.fabric8.openshift.api.model.installer.baremetal.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BMCBuilder extends BMCFluent<BMCBuilder> implements VisitableBuilder<BMC,BMCBuilder>{

  BMCFluent<?> fluent;

  public BMCBuilder() {
    this(new BMC());
  }
  
  public BMCBuilder(BMCFluent<?> fluent) {
    this(fluent, new BMC());
  }
  
  public BMCBuilder(BMC instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BMCBuilder(BMCFluent<?> fluent,BMC instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BMC build() {
    BMC buildable = new BMC(fluent.getAddress(), fluent.getDisableCertificateVerification(), fluent.getPassword(), fluent.getUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}