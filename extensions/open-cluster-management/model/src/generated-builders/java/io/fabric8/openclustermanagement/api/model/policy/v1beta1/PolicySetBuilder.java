package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicySetBuilder extends PolicySetFluent<PolicySetBuilder> implements VisitableBuilder<PolicySet,PolicySetBuilder>{

  PolicySetFluent<?> fluent;

  public PolicySetBuilder() {
    this(new PolicySet());
  }
  
  public PolicySetBuilder(PolicySetFluent<?> fluent) {
    this(fluent, new PolicySet());
  }
  
  public PolicySetBuilder(PolicySet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicySetBuilder(PolicySetFluent<?> fluent,PolicySet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicySet build() {
    PolicySet buildable = new PolicySet(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}