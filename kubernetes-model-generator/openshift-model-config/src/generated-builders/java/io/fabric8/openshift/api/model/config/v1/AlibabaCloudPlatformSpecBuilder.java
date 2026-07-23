package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlibabaCloudPlatformSpecBuilder extends AlibabaCloudPlatformSpecFluent<AlibabaCloudPlatformSpecBuilder> implements VisitableBuilder<AlibabaCloudPlatformSpec,AlibabaCloudPlatformSpecBuilder>{

  AlibabaCloudPlatformSpecFluent<?> fluent;

  public AlibabaCloudPlatformSpecBuilder() {
    this(new AlibabaCloudPlatformSpec());
  }
  
  public AlibabaCloudPlatformSpecBuilder(AlibabaCloudPlatformSpecFluent<?> fluent) {
    this(fluent, new AlibabaCloudPlatformSpec());
  }
  
  public AlibabaCloudPlatformSpecBuilder(AlibabaCloudPlatformSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlibabaCloudPlatformSpecBuilder(AlibabaCloudPlatformSpecFluent<?> fluent,AlibabaCloudPlatformSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlibabaCloudPlatformSpec build() {
    AlibabaCloudPlatformSpec buildable = new AlibabaCloudPlatformSpec();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}