package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostDeployPolicySpecBuilder extends HostDeployPolicySpecFluent<HostDeployPolicySpecBuilder> implements VisitableBuilder<HostDeployPolicySpec,HostDeployPolicySpecBuilder>{

  HostDeployPolicySpecFluent<?> fluent;

  public HostDeployPolicySpecBuilder() {
    this(new HostDeployPolicySpec());
  }
  
  public HostDeployPolicySpecBuilder(HostDeployPolicySpecFluent<?> fluent) {
    this(fluent, new HostDeployPolicySpec());
  }
  
  public HostDeployPolicySpecBuilder(HostDeployPolicySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostDeployPolicySpecBuilder(HostDeployPolicySpecFluent<?> fluent,HostDeployPolicySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostDeployPolicySpec build() {
    HostDeployPolicySpec buildable = new HostDeployPolicySpec(fluent.buildHostClaimNamespaces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}