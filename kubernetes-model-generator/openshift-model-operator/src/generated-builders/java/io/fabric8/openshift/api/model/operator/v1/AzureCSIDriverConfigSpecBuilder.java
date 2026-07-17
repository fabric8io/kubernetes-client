package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureCSIDriverConfigSpecBuilder extends AzureCSIDriverConfigSpecFluent<AzureCSIDriverConfigSpecBuilder> implements VisitableBuilder<AzureCSIDriverConfigSpec,AzureCSIDriverConfigSpecBuilder>{

  AzureCSIDriverConfigSpecFluent<?> fluent;

  public AzureCSIDriverConfigSpecBuilder() {
    this(new AzureCSIDriverConfigSpec());
  }
  
  public AzureCSIDriverConfigSpecBuilder(AzureCSIDriverConfigSpecFluent<?> fluent) {
    this(fluent, new AzureCSIDriverConfigSpec());
  }
  
  public AzureCSIDriverConfigSpecBuilder(AzureCSIDriverConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureCSIDriverConfigSpecBuilder(AzureCSIDriverConfigSpecFluent<?> fluent,AzureCSIDriverConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureCSIDriverConfigSpec build() {
    AzureCSIDriverConfigSpec buildable = new AzureCSIDriverConfigSpec(fluent.buildDiskEncryptionSet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}