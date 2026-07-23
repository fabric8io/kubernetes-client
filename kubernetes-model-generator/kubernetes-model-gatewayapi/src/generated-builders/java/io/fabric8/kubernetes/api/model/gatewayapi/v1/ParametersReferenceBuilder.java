package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ParametersReferenceBuilder extends ParametersReferenceFluent<ParametersReferenceBuilder> implements VisitableBuilder<ParametersReference,ParametersReferenceBuilder>{

  ParametersReferenceFluent<?> fluent;

  public ParametersReferenceBuilder() {
    this(new ParametersReference());
  }
  
  public ParametersReferenceBuilder(ParametersReferenceFluent<?> fluent) {
    this(fluent, new ParametersReference());
  }
  
  public ParametersReferenceBuilder(ParametersReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ParametersReferenceBuilder(ParametersReferenceFluent<?> fluent,ParametersReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ParametersReference build() {
    ParametersReference buildable = new ParametersReference(fluent.getGroup(), fluent.getKind(), fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}