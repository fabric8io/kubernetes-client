package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodHttpChaosBuilder extends PodHttpChaosFluent<PodHttpChaosBuilder> implements VisitableBuilder<PodHttpChaos,PodHttpChaosBuilder>{

  PodHttpChaosFluent<?> fluent;

  public PodHttpChaosBuilder() {
    this(new PodHttpChaos());
  }
  
  public PodHttpChaosBuilder(PodHttpChaosFluent<?> fluent) {
    this(fluent, new PodHttpChaos());
  }
  
  public PodHttpChaosBuilder(PodHttpChaos instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodHttpChaosBuilder(PodHttpChaosFluent<?> fluent,PodHttpChaos instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodHttpChaos build() {
    PodHttpChaos buildable = new PodHttpChaos(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}