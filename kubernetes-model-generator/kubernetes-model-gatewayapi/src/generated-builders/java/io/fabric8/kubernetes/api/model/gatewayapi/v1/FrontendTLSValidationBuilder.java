package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FrontendTLSValidationBuilder extends FrontendTLSValidationFluent<FrontendTLSValidationBuilder> implements VisitableBuilder<FrontendTLSValidation,FrontendTLSValidationBuilder>{

  FrontendTLSValidationFluent<?> fluent;

  public FrontendTLSValidationBuilder() {
    this(new FrontendTLSValidation());
  }
  
  public FrontendTLSValidationBuilder(FrontendTLSValidationFluent<?> fluent) {
    this(fluent, new FrontendTLSValidation());
  }
  
  public FrontendTLSValidationBuilder(FrontendTLSValidation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FrontendTLSValidationBuilder(FrontendTLSValidationFluent<?> fluent,FrontendTLSValidation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FrontendTLSValidation build() {
    FrontendTLSValidation buildable = new FrontendTLSValidation(fluent.buildCaCertificateRefs(), fluent.getMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}