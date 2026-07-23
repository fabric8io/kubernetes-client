package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServerBuilder extends ServerFluent<ServerBuilder> implements VisitableBuilder<Server,ServerBuilder>{

  ServerFluent<?> fluent;

  public ServerBuilder() {
    this(new Server());
  }
  
  public ServerBuilder(ServerFluent<?> fluent) {
    this(fluent, new Server());
  }
  
  public ServerBuilder(Server instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServerBuilder(ServerFluent<?> fluent,Server instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Server build() {
    Server buildable = new Server(fluent.getBind(), fluent.getDefaultEndpoint(), fluent.getHosts(), fluent.getName(), fluent.buildPort(), fluent.buildTls());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}