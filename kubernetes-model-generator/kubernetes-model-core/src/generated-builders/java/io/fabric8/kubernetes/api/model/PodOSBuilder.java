package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodOSBuilder extends PodOSFluent<PodOSBuilder> implements VisitableBuilder<PodOS,PodOSBuilder>{

  PodOSFluent<?> fluent;

  public PodOSBuilder() {
    this(new PodOS());
  }
  
  public PodOSBuilder(PodOSFluent<?> fluent) {
    this(fluent, new PodOS());
  }
  
  public PodOSBuilder(PodOS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodOSBuilder(PodOSFluent<?> fluent,PodOS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodOS build() {
    PodOS buildable = new PodOS(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}