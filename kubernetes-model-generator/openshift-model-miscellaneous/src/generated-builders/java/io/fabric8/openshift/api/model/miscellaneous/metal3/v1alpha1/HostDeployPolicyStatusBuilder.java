package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostDeployPolicyStatusBuilder extends HostDeployPolicyStatusFluent<HostDeployPolicyStatusBuilder> implements VisitableBuilder<HostDeployPolicyStatus,HostDeployPolicyStatusBuilder>{

  HostDeployPolicyStatusFluent<?> fluent;

  public HostDeployPolicyStatusBuilder() {
    this(new HostDeployPolicyStatus());
  }
  
  public HostDeployPolicyStatusBuilder(HostDeployPolicyStatusFluent<?> fluent) {
    this(fluent, new HostDeployPolicyStatus());
  }
  
  public HostDeployPolicyStatusBuilder(HostDeployPolicyStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostDeployPolicyStatusBuilder(HostDeployPolicyStatusFluent<?> fluent,HostDeployPolicyStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostDeployPolicyStatus build() {
    HostDeployPolicyStatus buildable = new HostDeployPolicyStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}