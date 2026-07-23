package io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MutatingAdmissionPolicyBindingListBuilder extends MutatingAdmissionPolicyBindingListFluent<MutatingAdmissionPolicyBindingListBuilder> implements VisitableBuilder<MutatingAdmissionPolicyBindingList,MutatingAdmissionPolicyBindingListBuilder>{

  MutatingAdmissionPolicyBindingListFluent<?> fluent;

  public MutatingAdmissionPolicyBindingListBuilder() {
    this(new MutatingAdmissionPolicyBindingList());
  }
  
  public MutatingAdmissionPolicyBindingListBuilder(MutatingAdmissionPolicyBindingListFluent<?> fluent) {
    this(fluent, new MutatingAdmissionPolicyBindingList());
  }
  
  public MutatingAdmissionPolicyBindingListBuilder(MutatingAdmissionPolicyBindingList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MutatingAdmissionPolicyBindingListBuilder(MutatingAdmissionPolicyBindingListFluent<?> fluent,MutatingAdmissionPolicyBindingList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MutatingAdmissionPolicyBindingList build() {
    MutatingAdmissionPolicyBindingList buildable = new MutatingAdmissionPolicyBindingList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}