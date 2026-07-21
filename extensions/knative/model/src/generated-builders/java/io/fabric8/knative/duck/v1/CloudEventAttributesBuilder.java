package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CloudEventAttributesBuilder extends CloudEventAttributesFluent<CloudEventAttributesBuilder> implements VisitableBuilder<CloudEventAttributes,CloudEventAttributesBuilder>{

  CloudEventAttributesFluent<?> fluent;

  public CloudEventAttributesBuilder() {
    this(new CloudEventAttributes());
  }
  
  public CloudEventAttributesBuilder(CloudEventAttributesFluent<?> fluent) {
    this(fluent, new CloudEventAttributes());
  }
  
  public CloudEventAttributesBuilder(CloudEventAttributes instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CloudEventAttributesBuilder(CloudEventAttributesFluent<?> fluent,CloudEventAttributes instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CloudEventAttributes build() {
    CloudEventAttributes buildable = new CloudEventAttributes(fluent.getSource(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}