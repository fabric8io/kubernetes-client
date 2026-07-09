package io.fabric8.kubernetes.api.model.admissionregistration.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RuleWithOperationsBuilder extends RuleWithOperationsFluent<RuleWithOperationsBuilder> implements VisitableBuilder<RuleWithOperations,RuleWithOperationsBuilder>{

  RuleWithOperationsFluent<?> fluent;

  public RuleWithOperationsBuilder() {
    this(new RuleWithOperations());
  }
  
  public RuleWithOperationsBuilder(RuleWithOperationsFluent<?> fluent) {
    this(fluent, new RuleWithOperations());
  }
  
  public RuleWithOperationsBuilder(RuleWithOperations instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RuleWithOperationsBuilder(RuleWithOperationsFluent<?> fluent,RuleWithOperations instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RuleWithOperations build() {
    RuleWithOperations buildable = new RuleWithOperations(fluent.getApiGroups(), fluent.getApiVersions(), fluent.getOperations(), fluent.getResources(), fluent.getScope());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}