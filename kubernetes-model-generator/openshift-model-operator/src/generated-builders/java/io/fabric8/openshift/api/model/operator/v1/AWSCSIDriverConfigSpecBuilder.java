package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSCSIDriverConfigSpecBuilder extends AWSCSIDriverConfigSpecFluent<AWSCSIDriverConfigSpecBuilder> implements VisitableBuilder<AWSCSIDriverConfigSpec,AWSCSIDriverConfigSpecBuilder>{

  AWSCSIDriverConfigSpecFluent<?> fluent;

  public AWSCSIDriverConfigSpecBuilder() {
    this(new AWSCSIDriverConfigSpec());
  }
  
  public AWSCSIDriverConfigSpecBuilder(AWSCSIDriverConfigSpecFluent<?> fluent) {
    this(fluent, new AWSCSIDriverConfigSpec());
  }
  
  public AWSCSIDriverConfigSpecBuilder(AWSCSIDriverConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSCSIDriverConfigSpecBuilder(AWSCSIDriverConfigSpecFluent<?> fluent,AWSCSIDriverConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSCSIDriverConfigSpec build() {
    AWSCSIDriverConfigSpec buildable = new AWSCSIDriverConfigSpec(fluent.buildEfsVolumeMetrics(), fluent.getKmsKeyARN());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}