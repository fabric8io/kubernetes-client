package io.fabric8.openshift.api.model.miscellaneous.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterNetworkBuilder extends ClusterNetworkFluent<ClusterNetworkBuilder> implements VisitableBuilder<ClusterNetwork,ClusterNetworkBuilder>{

  ClusterNetworkFluent<?> fluent;

  public ClusterNetworkBuilder() {
    this(new ClusterNetwork());
  }
  
  public ClusterNetworkBuilder(ClusterNetworkFluent<?> fluent) {
    this(fluent, new ClusterNetwork());
  }
  
  public ClusterNetworkBuilder(ClusterNetwork instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterNetworkBuilder(ClusterNetworkFluent<?> fluent,ClusterNetwork instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterNetwork build() {
    ClusterNetwork buildable = new ClusterNetwork(fluent.getApiVersion(), fluent.buildClusterNetworks(), fluent.getHostsubnetlength(), fluent.getKind(), fluent.buildMetadata(), fluent.getMtu(), fluent.getNetwork(), fluent.getPluginName(), fluent.getServiceNetwork(), fluent.getVxlanPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}