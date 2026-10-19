package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BareMetalSwitchSpecBuilder extends BareMetalSwitchSpecFluent<BareMetalSwitchSpecBuilder> implements VisitableBuilder<BareMetalSwitchSpec,BareMetalSwitchSpecBuilder>{

  BareMetalSwitchSpecFluent<?> fluent;

  public BareMetalSwitchSpecBuilder() {
    this(new BareMetalSwitchSpec());
  }
  
  public BareMetalSwitchSpecBuilder(BareMetalSwitchSpecFluent<?> fluent) {
    this(fluent, new BareMetalSwitchSpec());
  }
  
  public BareMetalSwitchSpecBuilder(BareMetalSwitchSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BareMetalSwitchSpecBuilder(BareMetalSwitchSpecFluent<?> fluent,BareMetalSwitchSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BareMetalSwitchSpec build() {
    BareMetalSwitchSpec buildable = new BareMetalSwitchSpec(fluent.getAddress(), fluent.getCredentials(), fluent.getDeviceType(), fluent.getDisableCertificateVerification(), fluent.getDriver(), fluent.getMacAddress(), fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}