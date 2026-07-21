package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CloudEventDeliveryStateBuilder extends CloudEventDeliveryStateFluent<CloudEventDeliveryStateBuilder> implements VisitableBuilder<CloudEventDeliveryState,CloudEventDeliveryStateBuilder>{

  CloudEventDeliveryStateFluent<?> fluent;

  public CloudEventDeliveryStateBuilder() {
    this(new CloudEventDeliveryState());
  }
  
  public CloudEventDeliveryStateBuilder(CloudEventDeliveryStateFluent<?> fluent) {
    this(fluent, new CloudEventDeliveryState());
  }
  
  public CloudEventDeliveryStateBuilder(CloudEventDeliveryState instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CloudEventDeliveryStateBuilder(CloudEventDeliveryStateFluent<?> fluent,CloudEventDeliveryState instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CloudEventDeliveryState build() {
    CloudEventDeliveryState buildable = new CloudEventDeliveryState(fluent.getCondition(), fluent.getMessage(), fluent.getRetryCount(), fluent.getSentAt());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}