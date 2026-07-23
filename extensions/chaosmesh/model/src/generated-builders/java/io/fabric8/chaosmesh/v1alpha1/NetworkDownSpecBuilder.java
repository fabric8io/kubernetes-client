package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDownSpecBuilder extends NetworkDownSpecFluent<NetworkDownSpecBuilder> implements VisitableBuilder<NetworkDownSpec,NetworkDownSpecBuilder>{

  NetworkDownSpecFluent<?> fluent;

  public NetworkDownSpecBuilder() {
    this(new NetworkDownSpec());
  }
  
  public NetworkDownSpecBuilder(NetworkDownSpecFluent<?> fluent) {
    this(fluent, new NetworkDownSpec());
  }
  
  public NetworkDownSpecBuilder(NetworkDownSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDownSpecBuilder(NetworkDownSpecFluent<?> fluent,NetworkDownSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDownSpec build() {
    NetworkDownSpec buildable = new NetworkDownSpec(fluent.getDevice(), fluent.getDuration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}