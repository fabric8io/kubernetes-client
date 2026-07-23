package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSSelectorBuilder extends AWSSelectorFluent<AWSSelectorBuilder> implements VisitableBuilder<AWSSelector,AWSSelectorBuilder>{

  AWSSelectorFluent<?> fluent;

  public AWSSelectorBuilder() {
    this(new AWSSelector());
  }
  
  public AWSSelectorBuilder(AWSSelectorFluent<?> fluent) {
    this(fluent, new AWSSelector());
  }
  
  public AWSSelectorBuilder(AWSSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSSelectorBuilder(AWSSelectorFluent<?> fluent,AWSSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSSelector build() {
    AWSSelector buildable = new AWSSelector(fluent.getAwsRegion(), fluent.getDeviceName(), fluent.getEc2Instance(), fluent.getEndpoint(), fluent.getVolumeID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}