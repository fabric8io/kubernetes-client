package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlacementSubjectBuilder extends PlacementSubjectFluent<PlacementSubjectBuilder> implements VisitableBuilder<PlacementSubject,PlacementSubjectBuilder>{

  PlacementSubjectFluent<?> fluent;

  public PlacementSubjectBuilder() {
    this(new PlacementSubject());
  }
  
  public PlacementSubjectBuilder(PlacementSubjectFluent<?> fluent) {
    this(fluent, new PlacementSubject());
  }
  
  public PlacementSubjectBuilder(PlacementSubject instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlacementSubjectBuilder(PlacementSubjectFluent<?> fluent,PlacementSubject instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlacementSubject build() {
    PlacementSubject buildable = new PlacementSubject(fluent.getApiGroup(), fluent.getKind(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}