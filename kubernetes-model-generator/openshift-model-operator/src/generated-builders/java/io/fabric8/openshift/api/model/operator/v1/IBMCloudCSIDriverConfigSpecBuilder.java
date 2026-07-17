package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IBMCloudCSIDriverConfigSpecBuilder extends IBMCloudCSIDriverConfigSpecFluent<IBMCloudCSIDriverConfigSpecBuilder> implements VisitableBuilder<IBMCloudCSIDriverConfigSpec,IBMCloudCSIDriverConfigSpecBuilder>{

  IBMCloudCSIDriverConfigSpecFluent<?> fluent;

  public IBMCloudCSIDriverConfigSpecBuilder() {
    this(new IBMCloudCSIDriverConfigSpec());
  }
  
  public IBMCloudCSIDriverConfigSpecBuilder(IBMCloudCSIDriverConfigSpecFluent<?> fluent) {
    this(fluent, new IBMCloudCSIDriverConfigSpec());
  }
  
  public IBMCloudCSIDriverConfigSpecBuilder(IBMCloudCSIDriverConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IBMCloudCSIDriverConfigSpecBuilder(IBMCloudCSIDriverConfigSpecFluent<?> fluent,IBMCloudCSIDriverConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IBMCloudCSIDriverConfigSpec build() {
    IBMCloudCSIDriverConfigSpec buildable = new IBMCloudCSIDriverConfigSpec(fluent.getEncryptionKeyCRN());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}