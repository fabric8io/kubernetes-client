package io.fabric8.openshift.api.model.operator.controlplane.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodNetworkConnectivityCheckSpecBuilder extends PodNetworkConnectivityCheckSpecFluent<PodNetworkConnectivityCheckSpecBuilder> implements VisitableBuilder<PodNetworkConnectivityCheckSpec,PodNetworkConnectivityCheckSpecBuilder>{

  PodNetworkConnectivityCheckSpecFluent<?> fluent;

  public PodNetworkConnectivityCheckSpecBuilder() {
    this(new PodNetworkConnectivityCheckSpec());
  }
  
  public PodNetworkConnectivityCheckSpecBuilder(PodNetworkConnectivityCheckSpecFluent<?> fluent) {
    this(fluent, new PodNetworkConnectivityCheckSpec());
  }
  
  public PodNetworkConnectivityCheckSpecBuilder(PodNetworkConnectivityCheckSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodNetworkConnectivityCheckSpecBuilder(PodNetworkConnectivityCheckSpecFluent<?> fluent,PodNetworkConnectivityCheckSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodNetworkConnectivityCheckSpec build() {
    PodNetworkConnectivityCheckSpec buildable = new PodNetworkConnectivityCheckSpec(fluent.getSourcePod(), fluent.getTargetEndpoint(), fluent.getTlsClientCert());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}