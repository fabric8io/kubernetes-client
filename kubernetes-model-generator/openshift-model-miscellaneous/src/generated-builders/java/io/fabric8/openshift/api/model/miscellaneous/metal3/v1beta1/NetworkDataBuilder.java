package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDataBuilder extends NetworkDataFluent<NetworkDataBuilder> implements VisitableBuilder<NetworkData,NetworkDataBuilder>{

  NetworkDataFluent<?> fluent;

  public NetworkDataBuilder() {
    this(new NetworkData());
  }
  
  public NetworkDataBuilder(NetworkDataFluent<?> fluent) {
    this(fluent, new NetworkData());
  }
  
  public NetworkDataBuilder(NetworkData instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDataBuilder(NetworkDataFluent<?> fluent,NetworkData instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkData build() {
    NetworkData buildable = new NetworkData(fluent.buildLinks(), fluent.buildNetworks(), fluent.buildServices());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}