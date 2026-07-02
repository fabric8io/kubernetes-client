package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodIPBuilder extends PodIPFluent<PodIPBuilder> implements VisitableBuilder<PodIP,PodIPBuilder>{

  PodIPFluent<?> fluent;

  public PodIPBuilder() {
    this(new PodIP());
  }
  
  public PodIPBuilder(PodIPFluent<?> fluent) {
    this(fluent, new PodIP());
  }
  
  public PodIPBuilder(PodIP instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodIPBuilder(PodIPFluent<?> fluent,PodIP instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodIP build() {
    PodIP buildable = new PodIP(fluent.getIp());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}