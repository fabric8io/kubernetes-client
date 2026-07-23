package io.fabric8.knative.sinks.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AwsBuilder extends AwsFluent<AwsBuilder> implements VisitableBuilder<Aws,AwsBuilder>{

  AwsFluent<?> fluent;

  public AwsBuilder() {
    this(new Aws());
  }
  
  public AwsBuilder(AwsFluent<?> fluent) {
    this(fluent, new Aws());
  }
  
  public AwsBuilder(Aws instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AwsBuilder(AwsFluent<?> fluent,Aws instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Aws build() {
    Aws buildable = new Aws(fluent.buildAuth(), fluent.buildS3(), fluent.buildSns(), fluent.buildSqs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}