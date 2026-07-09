package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ValidatingAdmissionPolicyBindingSpecBuilder extends ValidatingAdmissionPolicyBindingSpecFluent<ValidatingAdmissionPolicyBindingSpecBuilder> implements VisitableBuilder<ValidatingAdmissionPolicyBindingSpec,ValidatingAdmissionPolicyBindingSpecBuilder>{

  ValidatingAdmissionPolicyBindingSpecFluent<?> fluent;

  public ValidatingAdmissionPolicyBindingSpecBuilder() {
    this(new ValidatingAdmissionPolicyBindingSpec());
  }
  
  public ValidatingAdmissionPolicyBindingSpecBuilder(ValidatingAdmissionPolicyBindingSpecFluent<?> fluent) {
    this(fluent, new ValidatingAdmissionPolicyBindingSpec());
  }
  
  public ValidatingAdmissionPolicyBindingSpecBuilder(ValidatingAdmissionPolicyBindingSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ValidatingAdmissionPolicyBindingSpecBuilder(ValidatingAdmissionPolicyBindingSpecFluent<?> fluent,ValidatingAdmissionPolicyBindingSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ValidatingAdmissionPolicyBindingSpec build() {
    ValidatingAdmissionPolicyBindingSpec buildable = new ValidatingAdmissionPolicyBindingSpec(fluent.buildMatchResources(), fluent.buildParamRef(), fluent.getPolicyName(), fluent.getValidationActions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}