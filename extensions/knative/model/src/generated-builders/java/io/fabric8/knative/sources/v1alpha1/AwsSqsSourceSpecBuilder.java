package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AwsSqsSourceSpecBuilder extends AwsSqsSourceSpecFluent<AwsSqsSourceSpecBuilder> implements VisitableBuilder<AwsSqsSourceSpec,AwsSqsSourceSpecBuilder>{

  AwsSqsSourceSpecFluent<?> fluent;

  public AwsSqsSourceSpecBuilder() {
    this(new AwsSqsSourceSpec());
  }
  
  public AwsSqsSourceSpecBuilder(AwsSqsSourceSpecFluent<?> fluent) {
    this(fluent, new AwsSqsSourceSpec());
  }
  
  public AwsSqsSourceSpecBuilder(AwsSqsSourceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AwsSqsSourceSpecBuilder(AwsSqsSourceSpecFluent<?> fluent,AwsSqsSourceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AwsSqsSourceSpec build() {
    AwsSqsSourceSpec buildable = new AwsSqsSourceSpec(fluent.getAnnotations(), fluent.getAwsCredsSecret(), fluent.getQueueUrl(), fluent.getServiceAccountName(), fluent.buildSink());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}