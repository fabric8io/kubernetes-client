package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GenericKubernetesResourceBuilder extends GenericKubernetesResourceFluent<GenericKubernetesResourceBuilder> implements VisitableBuilder<GenericKubernetesResource,GenericKubernetesResourceBuilder>{

  GenericKubernetesResourceFluent<?> fluent;

  public GenericKubernetesResourceBuilder() {
    this(new GenericKubernetesResource());
  }
  
  public GenericKubernetesResourceBuilder(GenericKubernetesResourceFluent<?> fluent) {
    this(fluent, new GenericKubernetesResource());
  }
  
  public GenericKubernetesResourceBuilder(GenericKubernetesResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GenericKubernetesResourceBuilder(GenericKubernetesResourceFluent<?> fluent,GenericKubernetesResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GenericKubernetesResource build() {
    GenericKubernetesResource buildable = new GenericKubernetesResource();
    buildable.setApiVersion(fluent.getApiVersion());
    buildable.setKind(fluent.getKind());
    buildable.setMetadata(fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}