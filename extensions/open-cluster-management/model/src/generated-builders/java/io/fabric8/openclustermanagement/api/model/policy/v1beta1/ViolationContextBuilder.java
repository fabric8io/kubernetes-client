package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ViolationContextBuilder extends ViolationContextFluent<ViolationContextBuilder> implements VisitableBuilder<ViolationContext,ViolationContextBuilder>{

  ViolationContextFluent<?> fluent;

  public ViolationContextBuilder() {
    this(new ViolationContext());
  }
  
  public ViolationContextBuilder(ViolationContextFluent<?> fluent) {
    this(fluent, new ViolationContext());
  }
  
  public ViolationContextBuilder(ViolationContext instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ViolationContextBuilder(ViolationContextFluent<?> fluent,ViolationContext instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ViolationContext build() {
    ViolationContext buildable = new ViolationContext(fluent.getHubCluster(), fluent.getPolicyName(), fluent.getPolicyNamespace(), fluent.getPolicySets(), fluent.getPolicyViolations(), fluent.getTargetClusters());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}