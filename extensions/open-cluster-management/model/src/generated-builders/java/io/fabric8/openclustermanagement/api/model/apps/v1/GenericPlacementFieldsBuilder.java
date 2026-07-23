package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GenericPlacementFieldsBuilder extends GenericPlacementFieldsFluent<GenericPlacementFieldsBuilder> implements VisitableBuilder<GenericPlacementFields,GenericPlacementFieldsBuilder>{

  GenericPlacementFieldsFluent<?> fluent;

  public GenericPlacementFieldsBuilder() {
    this(new GenericPlacementFields());
  }
  
  public GenericPlacementFieldsBuilder(GenericPlacementFieldsFluent<?> fluent) {
    this(fluent, new GenericPlacementFields());
  }
  
  public GenericPlacementFieldsBuilder(GenericPlacementFields instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GenericPlacementFieldsBuilder(GenericPlacementFieldsFluent<?> fluent,GenericPlacementFields instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GenericPlacementFields build() {
    GenericPlacementFields buildable = new GenericPlacementFields(fluent.buildClusterSelector(), fluent.buildClusters());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}