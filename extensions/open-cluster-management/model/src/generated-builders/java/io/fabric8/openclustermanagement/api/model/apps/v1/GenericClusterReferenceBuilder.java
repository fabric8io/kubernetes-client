package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GenericClusterReferenceBuilder extends GenericClusterReferenceFluent<GenericClusterReferenceBuilder> implements VisitableBuilder<GenericClusterReference,GenericClusterReferenceBuilder>{

  GenericClusterReferenceFluent<?> fluent;

  public GenericClusterReferenceBuilder() {
    this(new GenericClusterReference());
  }
  
  public GenericClusterReferenceBuilder(GenericClusterReferenceFluent<?> fluent) {
    this(fluent, new GenericClusterReference());
  }
  
  public GenericClusterReferenceBuilder(GenericClusterReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GenericClusterReferenceBuilder(GenericClusterReferenceFluent<?> fluent,GenericClusterReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GenericClusterReference build() {
    GenericClusterReference buildable = new GenericClusterReference(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}