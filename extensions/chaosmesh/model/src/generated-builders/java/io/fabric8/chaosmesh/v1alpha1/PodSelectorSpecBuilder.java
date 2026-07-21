package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSelectorSpecBuilder extends PodSelectorSpecFluent<PodSelectorSpecBuilder> implements VisitableBuilder<PodSelectorSpec,PodSelectorSpecBuilder>{

  PodSelectorSpecFluent<?> fluent;

  public PodSelectorSpecBuilder() {
    this(new PodSelectorSpec());
  }
  
  public PodSelectorSpecBuilder(PodSelectorSpecFluent<?> fluent) {
    this(fluent, new PodSelectorSpec());
  }
  
  public PodSelectorSpecBuilder(PodSelectorSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSelectorSpecBuilder(PodSelectorSpecFluent<?> fluent,PodSelectorSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSelectorSpec build() {
    PodSelectorSpec buildable = new PodSelectorSpec(fluent.getAnnotationSelectors(), fluent.getFieldSelectors(), fluent.getLabelSelectors(), fluent.getNamespaces(), fluent.getNodeSelectors(), fluent.getNodes(), fluent.getPodPhaseSelectors(), fluent.getPods());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}