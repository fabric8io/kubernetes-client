package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SignatureGenericEntityBuilder extends SignatureGenericEntityFluent<SignatureGenericEntityBuilder> implements VisitableBuilder<SignatureGenericEntity,SignatureGenericEntityBuilder>{

  SignatureGenericEntityFluent<?> fluent;

  public SignatureGenericEntityBuilder() {
    this(new SignatureGenericEntity());
  }
  
  public SignatureGenericEntityBuilder(SignatureGenericEntityFluent<?> fluent) {
    this(fluent, new SignatureGenericEntity());
  }
  
  public SignatureGenericEntityBuilder(SignatureGenericEntity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SignatureGenericEntityBuilder(SignatureGenericEntityFluent<?> fluent,SignatureGenericEntity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SignatureGenericEntity build() {
    SignatureGenericEntity buildable = new SignatureGenericEntity(fluent.getCommonName(), fluent.getOrganization());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}