package io.fabric8.openshift.api.model.miscellaneous.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostSubnetListBuilder extends HostSubnetListFluent<HostSubnetListBuilder> implements VisitableBuilder<HostSubnetList,HostSubnetListBuilder>{

  HostSubnetListFluent<?> fluent;

  public HostSubnetListBuilder() {
    this(new HostSubnetList());
  }
  
  public HostSubnetListBuilder(HostSubnetListFluent<?> fluent) {
    this(fluent, new HostSubnetList());
  }
  
  public HostSubnetListBuilder(HostSubnetList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostSubnetListBuilder(HostSubnetListFluent<?> fluent,HostSubnetList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostSubnetList build() {
    HostSubnetList buildable = new HostSubnetList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}