package io.fabric8.openshift.api.model.config.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GatherersBuilder extends GatherersFluent<GatherersBuilder> implements VisitableBuilder<Gatherers,GatherersBuilder>{

  GatherersFluent<?> fluent;

  public GatherersBuilder() {
    this(new Gatherers());
  }
  
  public GatherersBuilder(GatherersFluent<?> fluent) {
    this(fluent, new Gatherers());
  }
  
  public GatherersBuilder(Gatherers instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GatherersBuilder(GatherersFluent<?> fluent,Gatherers instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Gatherers build() {
    Gatherers buildable = new Gatherers(fluent.buildCustom(), fluent.getMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}