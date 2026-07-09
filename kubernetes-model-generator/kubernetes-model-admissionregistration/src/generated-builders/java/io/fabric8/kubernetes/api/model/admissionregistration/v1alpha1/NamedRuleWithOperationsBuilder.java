package io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamedRuleWithOperationsBuilder extends NamedRuleWithOperationsFluent<NamedRuleWithOperationsBuilder> implements VisitableBuilder<NamedRuleWithOperations,NamedRuleWithOperationsBuilder>{

  NamedRuleWithOperationsFluent<?> fluent;

  public NamedRuleWithOperationsBuilder() {
    this(new NamedRuleWithOperations());
  }
  
  public NamedRuleWithOperationsBuilder(NamedRuleWithOperationsFluent<?> fluent) {
    this(fluent, new NamedRuleWithOperations());
  }
  
  public NamedRuleWithOperationsBuilder(NamedRuleWithOperations instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamedRuleWithOperationsBuilder(NamedRuleWithOperationsFluent<?> fluent,NamedRuleWithOperations instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamedRuleWithOperations build() {
    NamedRuleWithOperations buildable = new NamedRuleWithOperations(fluent.getApiGroups(), fluent.getApiVersions(), fluent.getOperations(), fluent.getResourceNames(), fluent.getResources(), fluent.getScope());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}