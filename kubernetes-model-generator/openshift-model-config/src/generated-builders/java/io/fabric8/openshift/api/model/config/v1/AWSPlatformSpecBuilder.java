package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSPlatformSpecBuilder extends AWSPlatformSpecFluent<AWSPlatformSpecBuilder> implements VisitableBuilder<AWSPlatformSpec,AWSPlatformSpecBuilder>{

  AWSPlatformSpecFluent<?> fluent;

  public AWSPlatformSpecBuilder() {
    this(new AWSPlatformSpec());
  }
  
  public AWSPlatformSpecBuilder(AWSPlatformSpecFluent<?> fluent) {
    this(fluent, new AWSPlatformSpec());
  }
  
  public AWSPlatformSpecBuilder(AWSPlatformSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSPlatformSpecBuilder(AWSPlatformSpecFluent<?> fluent,AWSPlatformSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSPlatformSpec build() {
    AWSPlatformSpec buildable = new AWSPlatformSpec(fluent.buildServiceEndpoints());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}