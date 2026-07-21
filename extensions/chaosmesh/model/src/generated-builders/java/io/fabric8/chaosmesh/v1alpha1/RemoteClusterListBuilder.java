package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RemoteClusterListBuilder extends RemoteClusterListFluent<RemoteClusterListBuilder> implements VisitableBuilder<RemoteClusterList,RemoteClusterListBuilder>{

  RemoteClusterListFluent<?> fluent;

  public RemoteClusterListBuilder() {
    this(new RemoteClusterList());
  }
  
  public RemoteClusterListBuilder(RemoteClusterListFluent<?> fluent) {
    this(fluent, new RemoteClusterList());
  }
  
  public RemoteClusterListBuilder(RemoteClusterList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RemoteClusterListBuilder(RemoteClusterListFluent<?> fluent,RemoteClusterList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RemoteClusterList build() {
    RemoteClusterList buildable = new RemoteClusterList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}