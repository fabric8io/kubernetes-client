package io.fabric8.openclustermanagement.api.model.cluster.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManagedClusterListBuilder extends ManagedClusterListFluent<ManagedClusterListBuilder> implements VisitableBuilder<ManagedClusterList,ManagedClusterListBuilder>{

  ManagedClusterListFluent<?> fluent;

  public ManagedClusterListBuilder() {
    this(new ManagedClusterList());
  }
  
  public ManagedClusterListBuilder(ManagedClusterListFluent<?> fluent) {
    this(fluent, new ManagedClusterList());
  }
  
  public ManagedClusterListBuilder(ManagedClusterList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManagedClusterListBuilder(ManagedClusterListFluent<?> fluent,ManagedClusterList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManagedClusterList build() {
    ManagedClusterList buildable = new ManagedClusterList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}