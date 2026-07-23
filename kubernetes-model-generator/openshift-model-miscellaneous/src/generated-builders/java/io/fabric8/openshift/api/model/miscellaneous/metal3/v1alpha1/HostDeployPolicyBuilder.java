package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostDeployPolicyBuilder extends HostDeployPolicyFluent<HostDeployPolicyBuilder> implements VisitableBuilder<HostDeployPolicy,HostDeployPolicyBuilder>{

  HostDeployPolicyFluent<?> fluent;

  public HostDeployPolicyBuilder() {
    this(new HostDeployPolicy());
  }
  
  public HostDeployPolicyBuilder(HostDeployPolicyFluent<?> fluent) {
    this(fluent, new HostDeployPolicy());
  }
  
  public HostDeployPolicyBuilder(HostDeployPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostDeployPolicyBuilder(HostDeployPolicyFluent<?> fluent,HostDeployPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostDeployPolicy build() {
    HostDeployPolicy buildable = new HostDeployPolicy(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}