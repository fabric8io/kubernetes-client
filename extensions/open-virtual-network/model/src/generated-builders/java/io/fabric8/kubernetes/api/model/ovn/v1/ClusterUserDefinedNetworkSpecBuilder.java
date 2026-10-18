package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterUserDefinedNetworkSpecBuilder extends ClusterUserDefinedNetworkSpecFluent<ClusterUserDefinedNetworkSpecBuilder> implements VisitableBuilder<ClusterUserDefinedNetworkSpec,ClusterUserDefinedNetworkSpecBuilder>{

  ClusterUserDefinedNetworkSpecFluent<?> fluent;

  public ClusterUserDefinedNetworkSpecBuilder() {
    this(new ClusterUserDefinedNetworkSpec());
  }
  
  public ClusterUserDefinedNetworkSpecBuilder(ClusterUserDefinedNetworkSpecFluent<?> fluent) {
    this(fluent, new ClusterUserDefinedNetworkSpec());
  }
  
  public ClusterUserDefinedNetworkSpecBuilder(ClusterUserDefinedNetworkSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterUserDefinedNetworkSpecBuilder(ClusterUserDefinedNetworkSpecFluent<?> fluent,ClusterUserDefinedNetworkSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterUserDefinedNetworkSpec build() {
    ClusterUserDefinedNetworkSpec buildable = new ClusterUserDefinedNetworkSpec(fluent.buildNamespaceSelector(), fluent.buildNetwork(), fluent.getUplinks());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}