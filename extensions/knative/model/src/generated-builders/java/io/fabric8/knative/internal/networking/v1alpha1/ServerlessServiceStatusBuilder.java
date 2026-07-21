package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServerlessServiceStatusBuilder extends ServerlessServiceStatusFluent<ServerlessServiceStatusBuilder> implements VisitableBuilder<ServerlessServiceStatus,ServerlessServiceStatusBuilder>{

  ServerlessServiceStatusFluent<?> fluent;

  public ServerlessServiceStatusBuilder() {
    this(new ServerlessServiceStatus());
  }
  
  public ServerlessServiceStatusBuilder(ServerlessServiceStatusFluent<?> fluent) {
    this(fluent, new ServerlessServiceStatus());
  }
  
  public ServerlessServiceStatusBuilder(ServerlessServiceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServerlessServiceStatusBuilder(ServerlessServiceStatusFluent<?> fluent,ServerlessServiceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServerlessServiceStatus build() {
    ServerlessServiceStatus buildable = new ServerlessServiceStatus(fluent.getAnnotations(), fluent.buildConditions(), fluent.getObservedGeneration(), fluent.getPrivateServiceName(), fluent.getServiceName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}