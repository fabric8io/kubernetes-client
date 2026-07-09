package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ValidatingAdmissionPolicyBindingBuilder extends ValidatingAdmissionPolicyBindingFluent<ValidatingAdmissionPolicyBindingBuilder> implements VisitableBuilder<ValidatingAdmissionPolicyBinding,ValidatingAdmissionPolicyBindingBuilder>{

  ValidatingAdmissionPolicyBindingFluent<?> fluent;

  public ValidatingAdmissionPolicyBindingBuilder() {
    this(new ValidatingAdmissionPolicyBinding());
  }
  
  public ValidatingAdmissionPolicyBindingBuilder(ValidatingAdmissionPolicyBindingFluent<?> fluent) {
    this(fluent, new ValidatingAdmissionPolicyBinding());
  }
  
  public ValidatingAdmissionPolicyBindingBuilder(ValidatingAdmissionPolicyBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ValidatingAdmissionPolicyBindingBuilder(ValidatingAdmissionPolicyBindingFluent<?> fluent,ValidatingAdmissionPolicyBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ValidatingAdmissionPolicyBinding build() {
    ValidatingAdmissionPolicyBinding buildable = new ValidatingAdmissionPolicyBinding(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}