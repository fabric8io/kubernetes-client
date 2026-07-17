package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubevirtPlatformStatusBuilder extends KubevirtPlatformStatusFluent<KubevirtPlatformStatusBuilder> implements VisitableBuilder<KubevirtPlatformStatus,KubevirtPlatformStatusBuilder>{

  KubevirtPlatformStatusFluent<?> fluent;

  public KubevirtPlatformStatusBuilder() {
    this(new KubevirtPlatformStatus());
  }
  
  public KubevirtPlatformStatusBuilder(KubevirtPlatformStatusFluent<?> fluent) {
    this(fluent, new KubevirtPlatformStatus());
  }
  
  public KubevirtPlatformStatusBuilder(KubevirtPlatformStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubevirtPlatformStatusBuilder(KubevirtPlatformStatusFluent<?> fluent,KubevirtPlatformStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubevirtPlatformStatus build() {
    KubevirtPlatformStatus buildable = new KubevirtPlatformStatus(fluent.getApiServerInternalIP(), fluent.getIngressIP());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}