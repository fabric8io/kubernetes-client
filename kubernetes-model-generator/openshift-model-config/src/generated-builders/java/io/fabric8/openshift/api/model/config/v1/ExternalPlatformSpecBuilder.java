package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExternalPlatformSpecBuilder extends ExternalPlatformSpecFluent<ExternalPlatformSpecBuilder> implements VisitableBuilder<ExternalPlatformSpec,ExternalPlatformSpecBuilder>{

  ExternalPlatformSpecFluent<?> fluent;

  public ExternalPlatformSpecBuilder() {
    this(new ExternalPlatformSpec());
  }
  
  public ExternalPlatformSpecBuilder(ExternalPlatformSpecFluent<?> fluent) {
    this(fluent, new ExternalPlatformSpec());
  }
  
  public ExternalPlatformSpecBuilder(ExternalPlatformSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExternalPlatformSpecBuilder(ExternalPlatformSpecFluent<?> fluent,ExternalPlatformSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExternalPlatformSpec build() {
    ExternalPlatformSpec buildable = new ExternalPlatformSpec(fluent.getPlatformName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}