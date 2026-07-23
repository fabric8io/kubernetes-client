package io.fabric8.openshift.api.model.operator.v1;

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
    Server buildable = new Server(fluent.buildForwardPlugin(), fluent.getName(), fluent.getZones());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}