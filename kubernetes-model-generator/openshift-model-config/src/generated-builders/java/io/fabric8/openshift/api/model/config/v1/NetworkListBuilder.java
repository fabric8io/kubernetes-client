package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkListBuilder extends NetworkListFluent<NetworkListBuilder> implements VisitableBuilder<NetworkList,NetworkListBuilder>{

  NetworkListFluent<?> fluent;

  public NetworkListBuilder() {
    this(new NetworkList());
  }
  
  public NetworkListBuilder(NetworkListFluent<?> fluent) {
    this(fluent, new NetworkList());
  }
  
  public NetworkListBuilder(NetworkList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkListBuilder(NetworkListFluent<?> fluent,NetworkList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkList build() {
    NetworkList buildable = new NetworkList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}