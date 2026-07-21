package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlacementBindingBuilder extends PlacementBindingFluent<PlacementBindingBuilder> implements VisitableBuilder<PlacementBinding,PlacementBindingBuilder>{

  PlacementBindingFluent<?> fluent;

  public PlacementBindingBuilder() {
    this(new PlacementBinding());
  }
  
  public PlacementBindingBuilder(PlacementBindingFluent<?> fluent) {
    this(fluent, new PlacementBinding());
  }
  
  public PlacementBindingBuilder(PlacementBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlacementBindingBuilder(PlacementBindingFluent<?> fluent,PlacementBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlacementBinding build() {
    PlacementBinding buildable = new PlacementBinding(fluent.getApiVersion(), fluent.buildBindingOverrides(), fluent.getKind(), fluent.buildMetadata(), fluent.buildPlacementRef(), fluent.buildStatus(), fluent.getSubFilter(), fluent.buildSubjects());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}