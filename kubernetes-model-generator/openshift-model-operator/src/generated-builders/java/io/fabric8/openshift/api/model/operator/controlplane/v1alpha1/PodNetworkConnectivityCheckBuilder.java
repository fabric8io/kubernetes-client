package io.fabric8.openshift.api.model.operator.controlplane.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodNetworkConnectivityCheckBuilder extends PodNetworkConnectivityCheckFluent<PodNetworkConnectivityCheckBuilder> implements VisitableBuilder<PodNetworkConnectivityCheck,PodNetworkConnectivityCheckBuilder>{

  PodNetworkConnectivityCheckFluent<?> fluent;

  public PodNetworkConnectivityCheckBuilder() {
    this(new PodNetworkConnectivityCheck());
  }
  
  public PodNetworkConnectivityCheckBuilder(PodNetworkConnectivityCheckFluent<?> fluent) {
    this(fluent, new PodNetworkConnectivityCheck());
  }
  
  public PodNetworkConnectivityCheckBuilder(PodNetworkConnectivityCheck instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodNetworkConnectivityCheckBuilder(PodNetworkConnectivityCheckFluent<?> fluent,PodNetworkConnectivityCheck instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodNetworkConnectivityCheck build() {
    PodNetworkConnectivityCheck buildable = new PodNetworkConnectivityCheck(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}