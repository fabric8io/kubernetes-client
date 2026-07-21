package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServerlessServiceSpecBuilder extends ServerlessServiceSpecFluent<ServerlessServiceSpecBuilder> implements VisitableBuilder<ServerlessServiceSpec,ServerlessServiceSpecBuilder>{

  ServerlessServiceSpecFluent<?> fluent;

  public ServerlessServiceSpecBuilder() {
    this(new ServerlessServiceSpec());
  }
  
  public ServerlessServiceSpecBuilder(ServerlessServiceSpecFluent<?> fluent) {
    this(fluent, new ServerlessServiceSpec());
  }
  
  public ServerlessServiceSpecBuilder(ServerlessServiceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServerlessServiceSpecBuilder(ServerlessServiceSpecFluent<?> fluent,ServerlessServiceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServerlessServiceSpec build() {
    ServerlessServiceSpec buildable = new ServerlessServiceSpec(fluent.getMode(), fluent.getNumActivators(), fluent.buildObjectRef(), fluent.getProtocolType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}