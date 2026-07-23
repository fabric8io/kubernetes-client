package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubernetesResourceBuilder extends KubernetesResourceFluent<KubernetesResourceBuilder> implements VisitableBuilder<KubernetesResource,KubernetesResourceBuilder>{

  KubernetesResourceFluent<?> fluent;

  public KubernetesResourceBuilder() {
    this(new KubernetesResource());
  }
  
  public KubernetesResourceBuilder(KubernetesResourceFluent<?> fluent) {
    this(fluent, new KubernetesResource());
  }
  
  public KubernetesResourceBuilder(KubernetesResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubernetesResourceBuilder(KubernetesResourceFluent<?> fluent,KubernetesResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubernetesResource build() {
    KubernetesResource buildable = new KubernetesResource(fluent.getReplicas(), fluent.getServiceType(), fluent.getSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}