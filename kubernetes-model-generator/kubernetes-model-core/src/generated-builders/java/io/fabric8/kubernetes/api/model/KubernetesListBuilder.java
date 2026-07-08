package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubernetesListBuilder extends KubernetesListFluent<KubernetesListBuilder> implements VisitableBuilder<KubernetesList,KubernetesListBuilder>{

  KubernetesListFluent<?> fluent;

  public KubernetesListBuilder() {
    this(new KubernetesList());
  }
  
  public KubernetesListBuilder(KubernetesListFluent<?> fluent) {
    this(fluent, new KubernetesList());
  }
  
  public KubernetesListBuilder(KubernetesList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubernetesListBuilder(KubernetesListFluent<?> fluent,KubernetesList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubernetesList build() {
    KubernetesList buildable = new KubernetesList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.buildMetadata());
    return buildable;
  }
  
}