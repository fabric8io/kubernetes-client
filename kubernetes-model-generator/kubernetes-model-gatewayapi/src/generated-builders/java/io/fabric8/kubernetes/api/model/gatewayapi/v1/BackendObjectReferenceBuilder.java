package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BackendObjectReferenceBuilder extends BackendObjectReferenceFluent<BackendObjectReferenceBuilder> implements VisitableBuilder<BackendObjectReference,BackendObjectReferenceBuilder>{

  BackendObjectReferenceFluent<?> fluent;

  public BackendObjectReferenceBuilder() {
    this(new BackendObjectReference());
  }
  
  public BackendObjectReferenceBuilder(BackendObjectReferenceFluent<?> fluent) {
    this(fluent, new BackendObjectReference());
  }
  
  public BackendObjectReferenceBuilder(BackendObjectReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BackendObjectReferenceBuilder(BackendObjectReferenceFluent<?> fluent,BackendObjectReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BackendObjectReference build() {
    BackendObjectReference buildable = new BackendObjectReference(fluent.getGroup(), fluent.getKind(), fluent.getName(), fluent.getNamespace(), fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}