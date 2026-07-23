package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubscriptionConfigBuilder extends SubscriptionConfigFluent<SubscriptionConfigBuilder> implements VisitableBuilder<SubscriptionConfig,SubscriptionConfigBuilder>{

  SubscriptionConfigFluent<?> fluent;

  public SubscriptionConfigBuilder() {
    this(new SubscriptionConfig());
  }
  
  public SubscriptionConfigBuilder(SubscriptionConfigFluent<?> fluent) {
    this(fluent, new SubscriptionConfig());
  }
  
  public SubscriptionConfigBuilder(SubscriptionConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubscriptionConfigBuilder(SubscriptionConfigFluent<?> fluent,SubscriptionConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubscriptionConfig build() {
    SubscriptionConfig buildable = new SubscriptionConfig(fluent.getAffinity(), fluent.getAnnotations(), fluent.buildEnv(), fluent.getEnvFrom(), fluent.getNodeSelector(), fluent.buildResources(), fluent.buildSelector(), fluent.getTolerations(), fluent.buildVolumeMounts(), fluent.buildVolumes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}