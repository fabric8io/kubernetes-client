package io.fabric8.kubernetes.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSecurityPolicyListBuilder extends PodSecurityPolicyListFluent<PodSecurityPolicyListBuilder> implements VisitableBuilder<PodSecurityPolicyList,PodSecurityPolicyListBuilder>{

  PodSecurityPolicyListFluent<?> fluent;

  public PodSecurityPolicyListBuilder() {
    this(new PodSecurityPolicyList());
  }
  
  public PodSecurityPolicyListBuilder(PodSecurityPolicyListFluent<?> fluent) {
    this(fluent, new PodSecurityPolicyList());
  }
  
  public PodSecurityPolicyListBuilder(PodSecurityPolicyList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSecurityPolicyListBuilder(PodSecurityPolicyListFluent<?> fluent,PodSecurityPolicyList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSecurityPolicyList build() {
    PodSecurityPolicyList buildable = new PodSecurityPolicyList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}