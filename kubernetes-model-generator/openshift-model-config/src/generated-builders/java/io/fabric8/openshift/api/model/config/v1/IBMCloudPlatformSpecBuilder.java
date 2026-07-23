package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IBMCloudPlatformSpecBuilder extends IBMCloudPlatformSpecFluent<IBMCloudPlatformSpecBuilder> implements VisitableBuilder<IBMCloudPlatformSpec,IBMCloudPlatformSpecBuilder>{

  IBMCloudPlatformSpecFluent<?> fluent;

  public IBMCloudPlatformSpecBuilder() {
    this(new IBMCloudPlatformSpec());
  }
  
  public IBMCloudPlatformSpecBuilder(IBMCloudPlatformSpecFluent<?> fluent) {
    this(fluent, new IBMCloudPlatformSpec());
  }
  
  public IBMCloudPlatformSpecBuilder(IBMCloudPlatformSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IBMCloudPlatformSpecBuilder(IBMCloudPlatformSpecFluent<?> fluent,IBMCloudPlatformSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IBMCloudPlatformSpec build() {
    IBMCloudPlatformSpec buildable = new IBMCloudPlatformSpec(fluent.buildServiceEndpoints());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}