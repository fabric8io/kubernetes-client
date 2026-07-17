package io.fabric8.openshift.api.model.operator.controlplane.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodNetworkConnectivityCheckStatusBuilder extends PodNetworkConnectivityCheckStatusFluent<PodNetworkConnectivityCheckStatusBuilder> implements VisitableBuilder<PodNetworkConnectivityCheckStatus,PodNetworkConnectivityCheckStatusBuilder>{

  PodNetworkConnectivityCheckStatusFluent<?> fluent;

  public PodNetworkConnectivityCheckStatusBuilder() {
    this(new PodNetworkConnectivityCheckStatus());
  }
  
  public PodNetworkConnectivityCheckStatusBuilder(PodNetworkConnectivityCheckStatusFluent<?> fluent) {
    this(fluent, new PodNetworkConnectivityCheckStatus());
  }
  
  public PodNetworkConnectivityCheckStatusBuilder(PodNetworkConnectivityCheckStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodNetworkConnectivityCheckStatusBuilder(PodNetworkConnectivityCheckStatusFluent<?> fluent,PodNetworkConnectivityCheckStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodNetworkConnectivityCheckStatus build() {
    PodNetworkConnectivityCheckStatus buildable = new PodNetworkConnectivityCheckStatus(fluent.buildConditions(), fluent.buildFailures(), fluent.buildOutages(), fluent.buildSuccesses());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}