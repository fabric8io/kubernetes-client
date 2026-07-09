package io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MutatingAdmissionPolicyBuilder extends MutatingAdmissionPolicyFluent<MutatingAdmissionPolicyBuilder> implements VisitableBuilder<MutatingAdmissionPolicy,MutatingAdmissionPolicyBuilder>{

  MutatingAdmissionPolicyFluent<?> fluent;

  public MutatingAdmissionPolicyBuilder() {
    this(new MutatingAdmissionPolicy());
  }
  
  public MutatingAdmissionPolicyBuilder(MutatingAdmissionPolicyFluent<?> fluent) {
    this(fluent, new MutatingAdmissionPolicy());
  }
  
  public MutatingAdmissionPolicyBuilder(MutatingAdmissionPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MutatingAdmissionPolicyBuilder(MutatingAdmissionPolicyFluent<?> fluent,MutatingAdmissionPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MutatingAdmissionPolicy build() {
    MutatingAdmissionPolicy buildable = new MutatingAdmissionPolicy(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}