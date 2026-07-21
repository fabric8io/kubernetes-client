package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AwsSqsSourceBuilder extends AwsSqsSourceFluent<AwsSqsSourceBuilder> implements VisitableBuilder<AwsSqsSource,AwsSqsSourceBuilder>{

  AwsSqsSourceFluent<?> fluent;

  public AwsSqsSourceBuilder() {
    this(new AwsSqsSource());
  }
  
  public AwsSqsSourceBuilder(AwsSqsSourceFluent<?> fluent) {
    this(fluent, new AwsSqsSource());
  }
  
  public AwsSqsSourceBuilder(AwsSqsSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AwsSqsSourceBuilder(AwsSqsSourceFluent<?> fluent,AwsSqsSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AwsSqsSource build() {
    AwsSqsSource buildable = new AwsSqsSource(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}