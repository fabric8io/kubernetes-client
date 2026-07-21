package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyListBuilder extends PolicyListFluent<PolicyListBuilder> implements VisitableBuilder<PolicyList,PolicyListBuilder>{

  PolicyListFluent<?> fluent;

  public PolicyListBuilder() {
    this(new PolicyList());
  }
  
  public PolicyListBuilder(PolicyListFluent<?> fluent) {
    this(fluent, new PolicyList());
  }
  
  public PolicyListBuilder(PolicyList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyListBuilder(PolicyListFluent<?> fluent,PolicyList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicyList build() {
    PolicyList buildable = new PolicyList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}