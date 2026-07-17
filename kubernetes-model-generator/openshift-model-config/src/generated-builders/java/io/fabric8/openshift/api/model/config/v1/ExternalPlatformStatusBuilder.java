package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExternalPlatformStatusBuilder extends ExternalPlatformStatusFluent<ExternalPlatformStatusBuilder> implements VisitableBuilder<ExternalPlatformStatus,ExternalPlatformStatusBuilder>{

  ExternalPlatformStatusFluent<?> fluent;

  public ExternalPlatformStatusBuilder() {
    this(new ExternalPlatformStatus());
  }
  
  public ExternalPlatformStatusBuilder(ExternalPlatformStatusFluent<?> fluent) {
    this(fluent, new ExternalPlatformStatus());
  }
  
  public ExternalPlatformStatusBuilder(ExternalPlatformStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExternalPlatformStatusBuilder(ExternalPlatformStatusFluent<?> fluent,ExternalPlatformStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExternalPlatformStatus build() {
    ExternalPlatformStatus buildable = new ExternalPlatformStatus(fluent.buildCloudControllerManager());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}