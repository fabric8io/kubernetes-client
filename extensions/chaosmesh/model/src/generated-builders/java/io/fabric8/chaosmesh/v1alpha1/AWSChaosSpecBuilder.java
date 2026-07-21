package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSChaosSpecBuilder extends AWSChaosSpecFluent<AWSChaosSpecBuilder> implements VisitableBuilder<AWSChaosSpec,AWSChaosSpecBuilder>{

  AWSChaosSpecFluent<?> fluent;

  public AWSChaosSpecBuilder() {
    this(new AWSChaosSpec());
  }
  
  public AWSChaosSpecBuilder(AWSChaosSpecFluent<?> fluent) {
    this(fluent, new AWSChaosSpec());
  }
  
  public AWSChaosSpecBuilder(AWSChaosSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSChaosSpecBuilder(AWSChaosSpecFluent<?> fluent,AWSChaosSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSChaosSpec build() {
    AWSChaosSpec buildable = new AWSChaosSpec(fluent.getAction(), fluent.getAwsRegion(), fluent.getDeviceName(), fluent.getDuration(), fluent.getEc2Instance(), fluent.getEndpoint(), fluent.getRemoteCluster(), fluent.getSecretName(), fluent.getVolumeID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}