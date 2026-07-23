package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ValidatingAdmissionPolicyBindingListBuilder extends ValidatingAdmissionPolicyBindingListFluent<ValidatingAdmissionPolicyBindingListBuilder> implements VisitableBuilder<ValidatingAdmissionPolicyBindingList,ValidatingAdmissionPolicyBindingListBuilder>{

  ValidatingAdmissionPolicyBindingListFluent<?> fluent;

  public ValidatingAdmissionPolicyBindingListBuilder() {
    this(new ValidatingAdmissionPolicyBindingList());
  }
  
  public ValidatingAdmissionPolicyBindingListBuilder(ValidatingAdmissionPolicyBindingListFluent<?> fluent) {
    this(fluent, new ValidatingAdmissionPolicyBindingList());
  }
  
  public ValidatingAdmissionPolicyBindingListBuilder(ValidatingAdmissionPolicyBindingList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ValidatingAdmissionPolicyBindingListBuilder(ValidatingAdmissionPolicyBindingListFluent<?> fluent,ValidatingAdmissionPolicyBindingList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ValidatingAdmissionPolicyBindingList build() {
    ValidatingAdmissionPolicyBindingList buildable = new ValidatingAdmissionPolicyBindingList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}