package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkInfoBuilder extends NetworkInfoFluent<NetworkInfoBuilder> implements VisitableBuilder<NetworkInfo,NetworkInfoBuilder>{

  NetworkInfoFluent<?> fluent;

  public NetworkInfoBuilder() {
    this(new NetworkInfo());
  }
  
  public NetworkInfoBuilder(NetworkInfoFluent<?> fluent) {
    this(fluent, new NetworkInfo());
  }
  
  public NetworkInfoBuilder(NetworkInfo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkInfoBuilder(NetworkInfoFluent<?> fluent,NetworkInfo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkInfo build() {
    NetworkInfo buildable = new NetworkInfo(fluent.getMtuMigration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}