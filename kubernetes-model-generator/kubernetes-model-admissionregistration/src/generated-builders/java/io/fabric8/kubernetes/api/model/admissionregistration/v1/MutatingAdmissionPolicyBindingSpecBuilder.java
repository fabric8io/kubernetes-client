package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MutatingAdmissionPolicyBindingSpecBuilder extends MutatingAdmissionPolicyBindingSpecFluent<MutatingAdmissionPolicyBindingSpecBuilder> implements VisitableBuilder<MutatingAdmissionPolicyBindingSpec,MutatingAdmissionPolicyBindingSpecBuilder>{

  MutatingAdmissionPolicyBindingSpecFluent<?> fluent;

  public MutatingAdmissionPolicyBindingSpecBuilder() {
    this(new MutatingAdmissionPolicyBindingSpec());
  }
  
  public MutatingAdmissionPolicyBindingSpecBuilder(MutatingAdmissionPolicyBindingSpecFluent<?> fluent) {
    this(fluent, new MutatingAdmissionPolicyBindingSpec());
  }
  
  public MutatingAdmissionPolicyBindingSpecBuilder(MutatingAdmissionPolicyBindingSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MutatingAdmissionPolicyBindingSpecBuilder(MutatingAdmissionPolicyBindingSpecFluent<?> fluent,MutatingAdmissionPolicyBindingSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MutatingAdmissionPolicyBindingSpec build() {
    MutatingAdmissionPolicyBindingSpec buildable = new MutatingAdmissionPolicyBindingSpec(fluent.buildMatchResources(), fluent.buildParamRef(), fluent.getPolicyName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}