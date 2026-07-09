package io.fabric8.kubernetes.api.model.scheduling.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PriorityClassBuilder extends PriorityClassFluent<PriorityClassBuilder> implements VisitableBuilder<PriorityClass,PriorityClassBuilder>{

  PriorityClassFluent<?> fluent;

  public PriorityClassBuilder() {
    this(new PriorityClass());
  }
  
  public PriorityClassBuilder(PriorityClassFluent<?> fluent) {
    this(fluent, new PriorityClass());
  }
  
  public PriorityClassBuilder(PriorityClass instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PriorityClassBuilder(PriorityClassFluent<?> fluent,PriorityClass instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PriorityClass build() {
    PriorityClass buildable = new PriorityClass(fluent.getApiVersion(), fluent.getDescription(), fluent.getGlobalDefault(), fluent.getKind(), fluent.buildMetadata(), fluent.getPreemptionPolicy(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}