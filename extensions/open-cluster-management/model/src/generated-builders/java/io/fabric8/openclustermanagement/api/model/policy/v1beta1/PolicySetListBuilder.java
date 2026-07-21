package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicySetListBuilder extends PolicySetListFluent<PolicySetListBuilder> implements VisitableBuilder<PolicySetList,PolicySetListBuilder>{

  PolicySetListFluent<?> fluent;

  public PolicySetListBuilder() {
    this(new PolicySetList());
  }
  
  public PolicySetListBuilder(PolicySetListFluent<?> fluent) {
    this(fluent, new PolicySetList());
  }
  
  public PolicySetListBuilder(PolicySetList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicySetListBuilder(PolicySetListFluent<?> fluent,PolicySetList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicySetList build() {
    PolicySetList buildable = new PolicySetList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}