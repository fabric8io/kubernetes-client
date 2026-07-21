package io.fabric8.knative.duck.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CloudEventOverridesBuilder extends CloudEventOverridesFluent<CloudEventOverridesBuilder> implements VisitableBuilder<CloudEventOverrides,CloudEventOverridesBuilder>{

  CloudEventOverridesFluent<?> fluent;

  public CloudEventOverridesBuilder() {
    this(new CloudEventOverrides());
  }
  
  public CloudEventOverridesBuilder(CloudEventOverridesFluent<?> fluent) {
    this(fluent, new CloudEventOverrides());
  }
  
  public CloudEventOverridesBuilder(CloudEventOverrides instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CloudEventOverridesBuilder(CloudEventOverridesFluent<?> fluent,CloudEventOverrides instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CloudEventOverrides build() {
    CloudEventOverrides buildable = new CloudEventOverrides(fluent.getExtensions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}