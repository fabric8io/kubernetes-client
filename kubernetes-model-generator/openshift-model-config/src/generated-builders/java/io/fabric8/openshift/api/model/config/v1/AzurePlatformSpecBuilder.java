package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzurePlatformSpecBuilder extends AzurePlatformSpecFluent<AzurePlatformSpecBuilder> implements VisitableBuilder<AzurePlatformSpec,AzurePlatformSpecBuilder>{

  AzurePlatformSpecFluent<?> fluent;

  public AzurePlatformSpecBuilder() {
    this(new AzurePlatformSpec());
  }
  
  public AzurePlatformSpecBuilder(AzurePlatformSpecFluent<?> fluent) {
    this(fluent, new AzurePlatformSpec());
  }
  
  public AzurePlatformSpecBuilder(AzurePlatformSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzurePlatformSpecBuilder(AzurePlatformSpecFluent<?> fluent,AzurePlatformSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzurePlatformSpec build() {
    AzurePlatformSpec buildable = new AzurePlatformSpec();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}