package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSelectorBuilder extends PodSelectorFluent<PodSelectorBuilder> implements VisitableBuilder<PodSelector,PodSelectorBuilder>{

  PodSelectorFluent<?> fluent;

  public PodSelectorBuilder() {
    this(new PodSelector());
  }
  
  public PodSelectorBuilder(PodSelectorFluent<?> fluent) {
    this(fluent, new PodSelector());
  }
  
  public PodSelectorBuilder(PodSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSelectorBuilder(PodSelectorFluent<?> fluent,PodSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSelector build() {
    PodSelector buildable = new PodSelector(fluent.getMode(), fluent.buildSelector(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}