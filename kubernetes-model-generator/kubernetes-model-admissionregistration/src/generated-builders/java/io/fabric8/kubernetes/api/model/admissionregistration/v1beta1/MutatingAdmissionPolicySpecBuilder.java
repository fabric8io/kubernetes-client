package io.fabric8.kubernetes.api.model.admissionregistration.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MutatingAdmissionPolicySpecBuilder extends MutatingAdmissionPolicySpecFluent<MutatingAdmissionPolicySpecBuilder> implements VisitableBuilder<MutatingAdmissionPolicySpec,MutatingAdmissionPolicySpecBuilder>{

  MutatingAdmissionPolicySpecFluent<?> fluent;

  public MutatingAdmissionPolicySpecBuilder() {
    this(new MutatingAdmissionPolicySpec());
  }
  
  public MutatingAdmissionPolicySpecBuilder(MutatingAdmissionPolicySpecFluent<?> fluent) {
    this(fluent, new MutatingAdmissionPolicySpec());
  }
  
  public MutatingAdmissionPolicySpecBuilder(MutatingAdmissionPolicySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MutatingAdmissionPolicySpecBuilder(MutatingAdmissionPolicySpecFluent<?> fluent,MutatingAdmissionPolicySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MutatingAdmissionPolicySpec build() {
    MutatingAdmissionPolicySpec buildable = new MutatingAdmissionPolicySpec(fluent.getFailurePolicy(), fluent.buildMatchConditions(), fluent.buildMatchConstraints(), fluent.buildMutations(), fluent.buildParamKind(), fluent.getReinvocationPolicy(), fluent.buildVariables());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}