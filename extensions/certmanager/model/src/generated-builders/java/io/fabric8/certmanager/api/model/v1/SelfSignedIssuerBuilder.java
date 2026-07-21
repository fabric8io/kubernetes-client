package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SelfSignedIssuerBuilder extends SelfSignedIssuerFluent<SelfSignedIssuerBuilder> implements VisitableBuilder<SelfSignedIssuer,SelfSignedIssuerBuilder>{

  SelfSignedIssuerFluent<?> fluent;

  public SelfSignedIssuerBuilder() {
    this(new SelfSignedIssuer());
  }
  
  public SelfSignedIssuerBuilder(SelfSignedIssuerFluent<?> fluent) {
    this(fluent, new SelfSignedIssuer());
  }
  
  public SelfSignedIssuerBuilder(SelfSignedIssuer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SelfSignedIssuerBuilder(SelfSignedIssuerFluent<?> fluent,SelfSignedIssuer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SelfSignedIssuer build() {
    SelfSignedIssuer buildable = new SelfSignedIssuer(fluent.getCrlDistributionPoints());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}