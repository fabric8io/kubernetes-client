package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ValidatingAdmissionPolicySpecBuilder extends ValidatingAdmissionPolicySpecFluent<ValidatingAdmissionPolicySpecBuilder> implements VisitableBuilder<ValidatingAdmissionPolicySpec,ValidatingAdmissionPolicySpecBuilder>{

  ValidatingAdmissionPolicySpecFluent<?> fluent;

  public ValidatingAdmissionPolicySpecBuilder() {
    this(new ValidatingAdmissionPolicySpec());
  }
  
  public ValidatingAdmissionPolicySpecBuilder(ValidatingAdmissionPolicySpecFluent<?> fluent) {
    this(fluent, new ValidatingAdmissionPolicySpec());
  }
  
  public ValidatingAdmissionPolicySpecBuilder(ValidatingAdmissionPolicySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ValidatingAdmissionPolicySpecBuilder(ValidatingAdmissionPolicySpecFluent<?> fluent,ValidatingAdmissionPolicySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ValidatingAdmissionPolicySpec build() {
    ValidatingAdmissionPolicySpec buildable = new ValidatingAdmissionPolicySpec(fluent.buildAuditAnnotations(), fluent.getFailurePolicy(), fluent.buildMatchConditions(), fluent.buildMatchConstraints(), fluent.buildParamKind(), fluent.buildValidations(), fluent.buildVariables());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}