package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PerspectiveBuilder extends PerspectiveFluent<PerspectiveBuilder> implements VisitableBuilder<Perspective,PerspectiveBuilder>{

  PerspectiveFluent<?> fluent;

  public PerspectiveBuilder() {
    this(new Perspective());
  }
  
  public PerspectiveBuilder(PerspectiveFluent<?> fluent) {
    this(fluent, new Perspective());
  }
  
  public PerspectiveBuilder(Perspective instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PerspectiveBuilder(PerspectiveFluent<?> fluent,Perspective instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Perspective build() {
    Perspective buildable = new Perspective(fluent.getId(), fluent.buildPinnedResources(), fluent.buildVisibility());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}