package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ValidatingAdmissionPolicyStatusBuilder extends ValidatingAdmissionPolicyStatusFluent<ValidatingAdmissionPolicyStatusBuilder> implements VisitableBuilder<ValidatingAdmissionPolicyStatus,ValidatingAdmissionPolicyStatusBuilder>{

  ValidatingAdmissionPolicyStatusFluent<?> fluent;

  public ValidatingAdmissionPolicyStatusBuilder() {
    this(new ValidatingAdmissionPolicyStatus());
  }
  
  public ValidatingAdmissionPolicyStatusBuilder(ValidatingAdmissionPolicyStatusFluent<?> fluent) {
    this(fluent, new ValidatingAdmissionPolicyStatus());
  }
  
  public ValidatingAdmissionPolicyStatusBuilder(ValidatingAdmissionPolicyStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ValidatingAdmissionPolicyStatusBuilder(ValidatingAdmissionPolicyStatusFluent<?> fluent,ValidatingAdmissionPolicyStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ValidatingAdmissionPolicyStatus build() {
    ValidatingAdmissionPolicyStatus buildable = new ValidatingAdmissionPolicyStatus(fluent.getConditions(), fluent.getObservedGeneration(), fluent.buildTypeChecking());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}