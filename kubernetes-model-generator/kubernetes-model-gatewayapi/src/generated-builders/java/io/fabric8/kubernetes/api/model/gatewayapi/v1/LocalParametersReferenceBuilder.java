package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LocalParametersReferenceBuilder extends LocalParametersReferenceFluent<LocalParametersReferenceBuilder> implements VisitableBuilder<LocalParametersReference,LocalParametersReferenceBuilder>{

  LocalParametersReferenceFluent<?> fluent;

  public LocalParametersReferenceBuilder() {
    this(new LocalParametersReference());
  }
  
  public LocalParametersReferenceBuilder(LocalParametersReferenceFluent<?> fluent) {
    this(fluent, new LocalParametersReference());
  }
  
  public LocalParametersReferenceBuilder(LocalParametersReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LocalParametersReferenceBuilder(LocalParametersReferenceFluent<?> fluent,LocalParametersReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LocalParametersReference build() {
    LocalParametersReference buildable = new LocalParametersReference(fluent.getGroup(), fluent.getKind(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}