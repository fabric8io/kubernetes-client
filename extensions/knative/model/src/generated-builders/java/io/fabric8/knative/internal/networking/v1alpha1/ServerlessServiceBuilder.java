package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServerlessServiceBuilder extends ServerlessServiceFluent<ServerlessServiceBuilder> implements VisitableBuilder<ServerlessService,ServerlessServiceBuilder>{

  ServerlessServiceFluent<?> fluent;

  public ServerlessServiceBuilder() {
    this(new ServerlessService());
  }
  
  public ServerlessServiceBuilder(ServerlessServiceFluent<?> fluent) {
    this(fluent, new ServerlessService());
  }
  
  public ServerlessServiceBuilder(ServerlessService instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServerlessServiceBuilder(ServerlessServiceFluent<?> fluent,ServerlessService instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServerlessService build() {
    ServerlessService buildable = new ServerlessService(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}