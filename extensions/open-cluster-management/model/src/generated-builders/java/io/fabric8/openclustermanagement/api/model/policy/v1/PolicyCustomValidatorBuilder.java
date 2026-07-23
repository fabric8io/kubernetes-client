package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyCustomValidatorBuilder extends PolicyCustomValidatorFluent<PolicyCustomValidatorBuilder> implements VisitableBuilder<PolicyCustomValidator,PolicyCustomValidatorBuilder>{

  PolicyCustomValidatorFluent<?> fluent;

  public PolicyCustomValidatorBuilder() {
    this(new PolicyCustomValidator());
  }
  
  public PolicyCustomValidatorBuilder(PolicyCustomValidatorFluent<?> fluent) {
    this(fluent, new PolicyCustomValidator());
  }
  
  public PolicyCustomValidatorBuilder(PolicyCustomValidator instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyCustomValidatorBuilder(PolicyCustomValidatorFluent<?> fluent,PolicyCustomValidator instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicyCustomValidator build() {
    PolicyCustomValidator buildable = new PolicyCustomValidator();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}