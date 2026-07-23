package io.fabric8.openshift.api.model.installer.openstack.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkFilterBuilder extends NetworkFilterFluent<NetworkFilterBuilder> implements VisitableBuilder<NetworkFilter,NetworkFilterBuilder>{

  NetworkFilterFluent<?> fluent;

  public NetworkFilterBuilder() {
    this(new NetworkFilter());
  }
  
  public NetworkFilterBuilder(NetworkFilterFluent<?> fluent) {
    this(fluent, new NetworkFilter());
  }
  
  public NetworkFilterBuilder(NetworkFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkFilterBuilder(NetworkFilterFluent<?> fluent,NetworkFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkFilter build() {
    NetworkFilter buildable = new NetworkFilter(fluent.getId(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}