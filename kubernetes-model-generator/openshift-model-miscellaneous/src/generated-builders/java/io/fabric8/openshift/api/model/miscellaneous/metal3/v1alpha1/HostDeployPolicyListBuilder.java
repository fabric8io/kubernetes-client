package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostDeployPolicyListBuilder extends HostDeployPolicyListFluent<HostDeployPolicyListBuilder> implements VisitableBuilder<HostDeployPolicyList,HostDeployPolicyListBuilder>{

  HostDeployPolicyListFluent<?> fluent;

  public HostDeployPolicyListBuilder() {
    this(new HostDeployPolicyList());
  }
  
  public HostDeployPolicyListBuilder(HostDeployPolicyListFluent<?> fluent) {
    this(fluent, new HostDeployPolicyList());
  }
  
  public HostDeployPolicyListBuilder(HostDeployPolicyList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostDeployPolicyListBuilder(HostDeployPolicyListFluent<?> fluent,HostDeployPolicyList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostDeployPolicyList build() {
    HostDeployPolicyList buildable = new HostDeployPolicyList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}