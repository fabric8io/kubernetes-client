package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BackendRefBuilder extends BackendRefFluent<BackendRefBuilder> implements VisitableBuilder<BackendRef,BackendRefBuilder>{

  BackendRefFluent<?> fluent;

  public BackendRefBuilder() {
    this(new BackendRef());
  }
  
  public BackendRefBuilder(BackendRefFluent<?> fluent) {
    this(fluent, new BackendRef());
  }
  
  public BackendRefBuilder(BackendRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BackendRefBuilder(BackendRefFluent<?> fluent,BackendRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BackendRef build() {
    BackendRef buildable = new BackendRef(fluent.getGroup(), fluent.getKind(), fluent.getName(), fluent.getNamespace(), fluent.getPort(), fluent.getWeight());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}