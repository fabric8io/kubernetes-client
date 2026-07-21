package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkCommonSpecBuilder extends NetworkCommonSpecFluent<NetworkCommonSpecBuilder> implements VisitableBuilder<NetworkCommonSpec,NetworkCommonSpecBuilder>{

  NetworkCommonSpecFluent<?> fluent;

  public NetworkCommonSpecBuilder() {
    this(new NetworkCommonSpec());
  }
  
  public NetworkCommonSpecBuilder(NetworkCommonSpecFluent<?> fluent) {
    this(fluent, new NetworkCommonSpec());
  }
  
  public NetworkCommonSpecBuilder(NetworkCommonSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkCommonSpecBuilder(NetworkCommonSpecFluent<?> fluent,NetworkCommonSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkCommonSpec build() {
    NetworkCommonSpec buildable = new NetworkCommonSpec(fluent.getCorrelation(), fluent.getDevice(), fluent.getEgressPort(), fluent.getHostname(), fluent.getIpAddress(), fluent.getIpProtocol(), fluent.getSourcePort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}