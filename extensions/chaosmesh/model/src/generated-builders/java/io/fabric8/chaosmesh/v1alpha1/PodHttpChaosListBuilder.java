package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodHttpChaosListBuilder extends PodHttpChaosListFluent<PodHttpChaosListBuilder> implements VisitableBuilder<PodHttpChaosList,PodHttpChaosListBuilder>{

  PodHttpChaosListFluent<?> fluent;

  public PodHttpChaosListBuilder() {
    this(new PodHttpChaosList());
  }
  
  public PodHttpChaosListBuilder(PodHttpChaosListFluent<?> fluent) {
    this(fluent, new PodHttpChaosList());
  }
  
  public PodHttpChaosListBuilder(PodHttpChaosList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodHttpChaosListBuilder(PodHttpChaosListFluent<?> fluent,PodHttpChaosList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodHttpChaosList build() {
    PodHttpChaosList buildable = new PodHttpChaosList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}