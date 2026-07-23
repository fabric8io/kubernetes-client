package io.fabric8.openshift.api.model.operator.controlplane.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodNetworkConnectivityCheckConditionBuilder extends PodNetworkConnectivityCheckConditionFluent<PodNetworkConnectivityCheckConditionBuilder> implements VisitableBuilder<PodNetworkConnectivityCheckCondition,PodNetworkConnectivityCheckConditionBuilder>{

  PodNetworkConnectivityCheckConditionFluent<?> fluent;

  public PodNetworkConnectivityCheckConditionBuilder() {
    this(new PodNetworkConnectivityCheckCondition());
  }
  
  public PodNetworkConnectivityCheckConditionBuilder(PodNetworkConnectivityCheckConditionFluent<?> fluent) {
    this(fluent, new PodNetworkConnectivityCheckCondition());
  }
  
  public PodNetworkConnectivityCheckConditionBuilder(PodNetworkConnectivityCheckCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodNetworkConnectivityCheckConditionBuilder(PodNetworkConnectivityCheckConditionFluent<?> fluent,PodNetworkConnectivityCheckCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodNetworkConnectivityCheckCondition build() {
    PodNetworkConnectivityCheckCondition buildable = new PodNetworkConnectivityCheckCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}