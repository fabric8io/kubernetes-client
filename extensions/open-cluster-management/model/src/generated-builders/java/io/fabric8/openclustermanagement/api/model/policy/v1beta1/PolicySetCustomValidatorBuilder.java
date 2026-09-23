package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicySetCustomValidatorBuilder extends PolicySetCustomValidatorFluent<PolicySetCustomValidatorBuilder> implements VisitableBuilder<PolicySetCustomValidator,PolicySetCustomValidatorBuilder>{

  PolicySetCustomValidatorFluent<?> fluent;

  public PolicySetCustomValidatorBuilder() {
    this(new PolicySetCustomValidator());
  }
  
  public PolicySetCustomValidatorBuilder(PolicySetCustomValidatorFluent<?> fluent) {
    this(fluent, new PolicySetCustomValidator());
  }
  
  public PolicySetCustomValidatorBuilder(PolicySetCustomValidator instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicySetCustomValidatorBuilder(PolicySetCustomValidatorFluent<?> fluent,PolicySetCustomValidator instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicySetCustomValidator build() {
    PolicySetCustomValidator buildable = new PolicySetCustomValidator();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}