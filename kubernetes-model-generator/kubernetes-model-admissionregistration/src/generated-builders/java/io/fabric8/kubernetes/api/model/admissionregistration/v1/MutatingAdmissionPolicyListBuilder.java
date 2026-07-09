package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MutatingAdmissionPolicyListBuilder extends MutatingAdmissionPolicyListFluent<MutatingAdmissionPolicyListBuilder> implements VisitableBuilder<MutatingAdmissionPolicyList,MutatingAdmissionPolicyListBuilder>{

  MutatingAdmissionPolicyListFluent<?> fluent;

  public MutatingAdmissionPolicyListBuilder() {
    this(new MutatingAdmissionPolicyList());
  }
  
  public MutatingAdmissionPolicyListBuilder(MutatingAdmissionPolicyListFluent<?> fluent) {
    this(fluent, new MutatingAdmissionPolicyList());
  }
  
  public MutatingAdmissionPolicyListBuilder(MutatingAdmissionPolicyList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MutatingAdmissionPolicyListBuilder(MutatingAdmissionPolicyListFluent<?> fluent,MutatingAdmissionPolicyList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MutatingAdmissionPolicyList build() {
    MutatingAdmissionPolicyList buildable = new MutatingAdmissionPolicyList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}