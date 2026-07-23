package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServerlessServiceListBuilder extends ServerlessServiceListFluent<ServerlessServiceListBuilder> implements VisitableBuilder<ServerlessServiceList,ServerlessServiceListBuilder>{

  ServerlessServiceListFluent<?> fluent;

  public ServerlessServiceListBuilder() {
    this(new ServerlessServiceList());
  }
  
  public ServerlessServiceListBuilder(ServerlessServiceListFluent<?> fluent) {
    this(fluent, new ServerlessServiceList());
  }
  
  public ServerlessServiceListBuilder(ServerlessServiceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServerlessServiceListBuilder(ServerlessServiceListFluent<?> fluent,ServerlessServiceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServerlessServiceList build() {
    ServerlessServiceList buildable = new ServerlessServiceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}