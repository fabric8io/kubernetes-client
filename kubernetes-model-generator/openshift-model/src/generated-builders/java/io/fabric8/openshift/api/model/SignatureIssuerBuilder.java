package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SignatureIssuerBuilder extends SignatureIssuerFluent<SignatureIssuerBuilder> implements VisitableBuilder<SignatureIssuer,SignatureIssuerBuilder>{

  SignatureIssuerFluent<?> fluent;

  public SignatureIssuerBuilder() {
    this(new SignatureIssuer());
  }
  
  public SignatureIssuerBuilder(SignatureIssuerFluent<?> fluent) {
    this(fluent, new SignatureIssuer());
  }
  
  public SignatureIssuerBuilder(SignatureIssuer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SignatureIssuerBuilder(SignatureIssuerFluent<?> fluent,SignatureIssuer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SignatureIssuer build() {
    SignatureIssuer buildable = new SignatureIssuer(fluent.getCommonName(), fluent.getOrganization());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}