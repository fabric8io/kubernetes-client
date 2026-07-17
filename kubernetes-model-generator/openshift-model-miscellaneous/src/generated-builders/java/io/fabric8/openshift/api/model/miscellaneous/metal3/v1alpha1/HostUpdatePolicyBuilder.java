package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostUpdatePolicyBuilder extends HostUpdatePolicyFluent<HostUpdatePolicyBuilder> implements VisitableBuilder<HostUpdatePolicy,HostUpdatePolicyBuilder>{

  HostUpdatePolicyFluent<?> fluent;

  public HostUpdatePolicyBuilder() {
    this(new HostUpdatePolicy());
  }
  
  public HostUpdatePolicyBuilder(HostUpdatePolicyFluent<?> fluent) {
    this(fluent, new HostUpdatePolicy());
  }
  
  public HostUpdatePolicyBuilder(HostUpdatePolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostUpdatePolicyBuilder(HostUpdatePolicyFluent<?> fluent,HostUpdatePolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostUpdatePolicy build() {
    HostUpdatePolicy buildable = new HostUpdatePolicy(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}