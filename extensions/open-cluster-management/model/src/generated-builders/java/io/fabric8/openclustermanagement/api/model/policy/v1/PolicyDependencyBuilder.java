package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyDependencyBuilder extends PolicyDependencyFluent<PolicyDependencyBuilder> implements VisitableBuilder<PolicyDependency,PolicyDependencyBuilder>{

  PolicyDependencyFluent<?> fluent;

  public PolicyDependencyBuilder() {
    this(new PolicyDependency());
  }
  
  public PolicyDependencyBuilder(PolicyDependencyFluent<?> fluent) {
    this(fluent, new PolicyDependency());
  }
  
  public PolicyDependencyBuilder(PolicyDependency instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyDependencyBuilder(PolicyDependencyFluent<?> fluent,PolicyDependency instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicyDependency build() {
    PolicyDependency buildable = new PolicyDependency(fluent.getApiVersion(), fluent.getCompliance(), fluent.getKind(), fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}