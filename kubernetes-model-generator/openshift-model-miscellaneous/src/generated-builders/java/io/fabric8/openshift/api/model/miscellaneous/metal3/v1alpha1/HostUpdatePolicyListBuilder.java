package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostUpdatePolicyListBuilder extends HostUpdatePolicyListFluent<HostUpdatePolicyListBuilder> implements VisitableBuilder<HostUpdatePolicyList,HostUpdatePolicyListBuilder>{

  HostUpdatePolicyListFluent<?> fluent;

  public HostUpdatePolicyListBuilder() {
    this(new HostUpdatePolicyList());
  }
  
  public HostUpdatePolicyListBuilder(HostUpdatePolicyListFluent<?> fluent) {
    this(fluent, new HostUpdatePolicyList());
  }
  
  public HostUpdatePolicyListBuilder(HostUpdatePolicyList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostUpdatePolicyListBuilder(HostUpdatePolicyListFluent<?> fluent,HostUpdatePolicyList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostUpdatePolicyList build() {
    HostUpdatePolicyList buildable = new HostUpdatePolicyList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}