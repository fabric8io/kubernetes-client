package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSIngressSpecBuilder extends AWSIngressSpecFluent<AWSIngressSpecBuilder> implements VisitableBuilder<AWSIngressSpec,AWSIngressSpecBuilder>{

  AWSIngressSpecFluent<?> fluent;

  public AWSIngressSpecBuilder() {
    this(new AWSIngressSpec());
  }
  
  public AWSIngressSpecBuilder(AWSIngressSpecFluent<?> fluent) {
    this(fluent, new AWSIngressSpec());
  }
  
  public AWSIngressSpecBuilder(AWSIngressSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSIngressSpecBuilder(AWSIngressSpecFluent<?> fluent,AWSIngressSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSIngressSpec build() {
    AWSIngressSpec buildable = new AWSIngressSpec(fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}