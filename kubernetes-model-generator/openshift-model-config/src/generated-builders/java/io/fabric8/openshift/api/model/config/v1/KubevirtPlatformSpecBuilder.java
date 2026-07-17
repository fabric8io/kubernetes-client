package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubevirtPlatformSpecBuilder extends KubevirtPlatformSpecFluent<KubevirtPlatformSpecBuilder> implements VisitableBuilder<KubevirtPlatformSpec,KubevirtPlatformSpecBuilder>{

  KubevirtPlatformSpecFluent<?> fluent;

  public KubevirtPlatformSpecBuilder() {
    this(new KubevirtPlatformSpec());
  }
  
  public KubevirtPlatformSpecBuilder(KubevirtPlatformSpecFluent<?> fluent) {
    this(fluent, new KubevirtPlatformSpec());
  }
  
  public KubevirtPlatformSpecBuilder(KubevirtPlatformSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubevirtPlatformSpecBuilder(KubevirtPlatformSpecFluent<?> fluent,KubevirtPlatformSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubevirtPlatformSpec build() {
    KubevirtPlatformSpec buildable = new KubevirtPlatformSpec();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}