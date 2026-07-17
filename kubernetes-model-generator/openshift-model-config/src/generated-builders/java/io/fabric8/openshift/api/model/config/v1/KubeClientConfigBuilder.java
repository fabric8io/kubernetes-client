package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeClientConfigBuilder extends KubeClientConfigFluent<KubeClientConfigBuilder> implements VisitableBuilder<KubeClientConfig,KubeClientConfigBuilder>{

  KubeClientConfigFluent<?> fluent;

  public KubeClientConfigBuilder() {
    this(new KubeClientConfig());
  }
  
  public KubeClientConfigBuilder(KubeClientConfigFluent<?> fluent) {
    this(fluent, new KubeClientConfig());
  }
  
  public KubeClientConfigBuilder(KubeClientConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeClientConfigBuilder(KubeClientConfigFluent<?> fluent,KubeClientConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeClientConfig build() {
    KubeClientConfig buildable = new KubeClientConfig(fluent.buildConnectionOverrides(), fluent.getKubeConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}