package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkBuilder extends NetworkFluent<NetworkBuilder> implements VisitableBuilder<Network,NetworkBuilder>{

  NetworkFluent<?> fluent;

  public NetworkBuilder() {
    this(new Network());
  }
  
  public NetworkBuilder(NetworkFluent<?> fluent) {
    this(fluent, new Network());
  }
  
  public NetworkBuilder(Network instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkBuilder(NetworkFluent<?> fluent,Network instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Network build() {
    Network buildable = new Network(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}