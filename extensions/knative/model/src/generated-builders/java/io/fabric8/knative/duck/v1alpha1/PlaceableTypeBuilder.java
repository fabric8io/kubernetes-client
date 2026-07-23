package io.fabric8.knative.duck.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlaceableTypeBuilder extends PlaceableTypeFluent<PlaceableTypeBuilder> implements VisitableBuilder<PlaceableType,PlaceableTypeBuilder>{

  PlaceableTypeFluent<?> fluent;

  public PlaceableTypeBuilder() {
    this(new PlaceableType());
  }
  
  public PlaceableTypeBuilder(PlaceableTypeFluent<?> fluent) {
    this(fluent, new PlaceableType());
  }
  
  public PlaceableTypeBuilder(PlaceableType instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlaceableTypeBuilder(PlaceableTypeFluent<?> fluent,PlaceableType instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlaceableType build() {
    PlaceableType buildable = new PlaceableType(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}