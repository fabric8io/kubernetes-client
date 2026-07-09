package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ValidatingAdmissionPolicyListBuilder extends ValidatingAdmissionPolicyListFluent<ValidatingAdmissionPolicyListBuilder> implements VisitableBuilder<ValidatingAdmissionPolicyList,ValidatingAdmissionPolicyListBuilder>{

  ValidatingAdmissionPolicyListFluent<?> fluent;

  public ValidatingAdmissionPolicyListBuilder() {
    this(new ValidatingAdmissionPolicyList());
  }
  
  public ValidatingAdmissionPolicyListBuilder(ValidatingAdmissionPolicyListFluent<?> fluent) {
    this(fluent, new ValidatingAdmissionPolicyList());
  }
  
  public ValidatingAdmissionPolicyListBuilder(ValidatingAdmissionPolicyList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ValidatingAdmissionPolicyListBuilder(ValidatingAdmissionPolicyListFluent<?> fluent,ValidatingAdmissionPolicyList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ValidatingAdmissionPolicyList build() {
    ValidatingAdmissionPolicyList buildable = new ValidatingAdmissionPolicyList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}