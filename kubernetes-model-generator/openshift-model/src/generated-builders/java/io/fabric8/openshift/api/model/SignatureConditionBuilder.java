package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SignatureConditionBuilder extends SignatureConditionFluent<SignatureConditionBuilder> implements VisitableBuilder<SignatureCondition,SignatureConditionBuilder>{

  SignatureConditionFluent<?> fluent;

  public SignatureConditionBuilder() {
    this(new SignatureCondition());
  }
  
  public SignatureConditionBuilder(SignatureConditionFluent<?> fluent) {
    this(fluent, new SignatureCondition());
  }
  
  public SignatureConditionBuilder(SignatureCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SignatureConditionBuilder(SignatureConditionFluent<?> fluent,SignatureCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SignatureCondition build() {
    SignatureCondition buildable = new SignatureCondition(fluent.getLastProbeTime(), fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}