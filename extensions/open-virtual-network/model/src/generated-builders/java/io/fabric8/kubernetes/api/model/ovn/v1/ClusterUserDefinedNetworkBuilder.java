package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterUserDefinedNetworkBuilder extends ClusterUserDefinedNetworkFluent<ClusterUserDefinedNetworkBuilder> implements VisitableBuilder<ClusterUserDefinedNetwork,ClusterUserDefinedNetworkBuilder>{

  ClusterUserDefinedNetworkFluent<?> fluent;

  public ClusterUserDefinedNetworkBuilder() {
    this(new ClusterUserDefinedNetwork());
  }
  
  public ClusterUserDefinedNetworkBuilder(ClusterUserDefinedNetworkFluent<?> fluent) {
    this(fluent, new ClusterUserDefinedNetwork());
  }
  
  public ClusterUserDefinedNetworkBuilder(ClusterUserDefinedNetwork instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterUserDefinedNetworkBuilder(ClusterUserDefinedNetworkFluent<?> fluent,ClusterUserDefinedNetwork instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterUserDefinedNetwork build() {
    ClusterUserDefinedNetwork buildable = new ClusterUserDefinedNetwork(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}