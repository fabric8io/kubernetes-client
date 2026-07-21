package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServerURLBuilder extends ServerURLFluent<ServerURLBuilder> implements VisitableBuilder<ServerURL,ServerURLBuilder>{

  ServerURLFluent<?> fluent;

  public ServerURLBuilder() {
    this(new ServerURL());
  }
  
  public ServerURLBuilder(ServerURLFluent<?> fluent) {
    this(fluent, new ServerURL());
  }
  
  public ServerURLBuilder(ServerURL instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServerURLBuilder(ServerURLFluent<?> fluent,ServerURL instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServerURL build() {
    ServerURL buildable = new ServerURL(fluent.getCaBundle(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}