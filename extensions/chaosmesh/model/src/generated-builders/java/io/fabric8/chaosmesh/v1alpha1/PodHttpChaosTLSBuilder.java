package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodHttpChaosTLSBuilder extends PodHttpChaosTLSFluent<PodHttpChaosTLSBuilder> implements VisitableBuilder<PodHttpChaosTLS,PodHttpChaosTLSBuilder>{

  PodHttpChaosTLSFluent<?> fluent;

  public PodHttpChaosTLSBuilder() {
    this(new PodHttpChaosTLS());
  }
  
  public PodHttpChaosTLSBuilder(PodHttpChaosTLSFluent<?> fluent) {
    this(fluent, new PodHttpChaosTLS());
  }
  
  public PodHttpChaosTLSBuilder(PodHttpChaosTLS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodHttpChaosTLSBuilder(PodHttpChaosTLSFluent<?> fluent,PodHttpChaosTLS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodHttpChaosTLS build() {
    PodHttpChaosTLS buildable = new PodHttpChaosTLS(fluent.getCaName(), fluent.getCertName(), fluent.getKeyName(), fluent.getSecretName(), fluent.getSecretNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}