package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeConfigSecretBuilder extends KubeConfigSecretFluent<KubeConfigSecretBuilder> implements VisitableBuilder<KubeConfigSecret,KubeConfigSecretBuilder>{

  KubeConfigSecretFluent<?> fluent;

  public KubeConfigSecretBuilder() {
    this(new KubeConfigSecret());
  }
  
  public KubeConfigSecretBuilder(KubeConfigSecretFluent<?> fluent) {
    this(fluent, new KubeConfigSecret());
  }
  
  public KubeConfigSecretBuilder(KubeConfigSecret instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeConfigSecretBuilder(KubeConfigSecretFluent<?> fluent,KubeConfigSecret instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeConfigSecret build() {
    KubeConfigSecret buildable = new KubeConfigSecret(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}