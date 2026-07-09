package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ValidatingAdmissionPolicyBuilder extends ValidatingAdmissionPolicyFluent<ValidatingAdmissionPolicyBuilder> implements VisitableBuilder<ValidatingAdmissionPolicy,ValidatingAdmissionPolicyBuilder>{

  ValidatingAdmissionPolicyFluent<?> fluent;

  public ValidatingAdmissionPolicyBuilder() {
    this(new ValidatingAdmissionPolicy());
  }
  
  public ValidatingAdmissionPolicyBuilder(ValidatingAdmissionPolicyFluent<?> fluent) {
    this(fluent, new ValidatingAdmissionPolicy());
  }
  
  public ValidatingAdmissionPolicyBuilder(ValidatingAdmissionPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ValidatingAdmissionPolicyBuilder(ValidatingAdmissionPolicyFluent<?> fluent,ValidatingAdmissionPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ValidatingAdmissionPolicy build() {
    ValidatingAdmissionPolicy buildable = new ValidatingAdmissionPolicy(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}