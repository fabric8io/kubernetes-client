package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BackendTLSPolicyValidationBuilder extends BackendTLSPolicyValidationFluent<BackendTLSPolicyValidationBuilder> implements VisitableBuilder<BackendTLSPolicyValidation,BackendTLSPolicyValidationBuilder>{

  BackendTLSPolicyValidationFluent<?> fluent;

  public BackendTLSPolicyValidationBuilder() {
    this(new BackendTLSPolicyValidation());
  }
  
  public BackendTLSPolicyValidationBuilder(BackendTLSPolicyValidationFluent<?> fluent) {
    this(fluent, new BackendTLSPolicyValidation());
  }
  
  public BackendTLSPolicyValidationBuilder(BackendTLSPolicyValidation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BackendTLSPolicyValidationBuilder(BackendTLSPolicyValidationFluent<?> fluent,BackendTLSPolicyValidation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BackendTLSPolicyValidation build() {
    BackendTLSPolicyValidation buildable = new BackendTLSPolicyValidation(fluent.buildCaCertificateRefs(), fluent.getHostname(), fluent.buildSubjectAltNames(), fluent.getWellKnownCACertificates());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}