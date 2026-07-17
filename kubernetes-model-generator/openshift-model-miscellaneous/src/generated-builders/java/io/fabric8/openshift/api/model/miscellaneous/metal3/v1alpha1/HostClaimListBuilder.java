package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostClaimListBuilder extends HostClaimListFluent<HostClaimListBuilder> implements VisitableBuilder<HostClaimList,HostClaimListBuilder>{

  HostClaimListFluent<?> fluent;

  public HostClaimListBuilder() {
    this(new HostClaimList());
  }
  
  public HostClaimListBuilder(HostClaimListFluent<?> fluent) {
    this(fluent, new HostClaimList());
  }
  
  public HostClaimListBuilder(HostClaimList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostClaimListBuilder(HostClaimListFluent<?> fluent,HostClaimList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostClaimList build() {
    HostClaimList buildable = new HostClaimList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}