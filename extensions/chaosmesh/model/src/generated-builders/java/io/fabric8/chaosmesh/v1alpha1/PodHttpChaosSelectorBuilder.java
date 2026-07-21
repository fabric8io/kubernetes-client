package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodHttpChaosSelectorBuilder extends PodHttpChaosSelectorFluent<PodHttpChaosSelectorBuilder> implements VisitableBuilder<PodHttpChaosSelector,PodHttpChaosSelectorBuilder>{

  PodHttpChaosSelectorFluent<?> fluent;

  public PodHttpChaosSelectorBuilder() {
    this(new PodHttpChaosSelector());
  }
  
  public PodHttpChaosSelectorBuilder(PodHttpChaosSelectorFluent<?> fluent) {
    this(fluent, new PodHttpChaosSelector());
  }
  
  public PodHttpChaosSelectorBuilder(PodHttpChaosSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodHttpChaosSelectorBuilder(PodHttpChaosSelectorFluent<?> fluent,PodHttpChaosSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodHttpChaosSelector build() {
    PodHttpChaosSelector buildable = new PodHttpChaosSelector(fluent.getCode(), fluent.getMethod(), fluent.getPath(), fluent.getPort(), fluent.getRequestHeaders(), fluent.getResponseHeaders());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}