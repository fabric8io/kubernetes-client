package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressPlatformSpecBuilder extends IngressPlatformSpecFluent<IngressPlatformSpecBuilder> implements VisitableBuilder<IngressPlatformSpec,IngressPlatformSpecBuilder>{

  IngressPlatformSpecFluent<?> fluent;

  public IngressPlatformSpecBuilder() {
    this(new IngressPlatformSpec());
  }
  
  public IngressPlatformSpecBuilder(IngressPlatformSpecFluent<?> fluent) {
    this(fluent, new IngressPlatformSpec());
  }
  
  public IngressPlatformSpecBuilder(IngressPlatformSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressPlatformSpecBuilder(IngressPlatformSpecFluent<?> fluent,IngressPlatformSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressPlatformSpec build() {
    IngressPlatformSpec buildable = new IngressPlatformSpec(fluent.buildAws(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}