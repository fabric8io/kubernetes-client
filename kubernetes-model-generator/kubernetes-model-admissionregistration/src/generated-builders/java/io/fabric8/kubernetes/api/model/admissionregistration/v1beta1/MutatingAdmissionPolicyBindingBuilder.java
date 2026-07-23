package io.fabric8.kubernetes.api.model.admissionregistration.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MutatingAdmissionPolicyBindingBuilder extends MutatingAdmissionPolicyBindingFluent<MutatingAdmissionPolicyBindingBuilder> implements VisitableBuilder<MutatingAdmissionPolicyBinding,MutatingAdmissionPolicyBindingBuilder>{

  MutatingAdmissionPolicyBindingFluent<?> fluent;

  public MutatingAdmissionPolicyBindingBuilder() {
    this(new MutatingAdmissionPolicyBinding());
  }
  
  public MutatingAdmissionPolicyBindingBuilder(MutatingAdmissionPolicyBindingFluent<?> fluent) {
    this(fluent, new MutatingAdmissionPolicyBinding());
  }
  
  public MutatingAdmissionPolicyBindingBuilder(MutatingAdmissionPolicyBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MutatingAdmissionPolicyBindingBuilder(MutatingAdmissionPolicyBindingFluent<?> fluent,MutatingAdmissionPolicyBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MutatingAdmissionPolicyBinding build() {
    MutatingAdmissionPolicyBinding buildable = new MutatingAdmissionPolicyBinding(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}