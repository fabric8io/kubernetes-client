package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CloudEventDeliveryBuilder extends CloudEventDeliveryFluent<CloudEventDeliveryBuilder> implements VisitableBuilder<CloudEventDelivery,CloudEventDeliveryBuilder>{

  CloudEventDeliveryFluent<?> fluent;

  public CloudEventDeliveryBuilder() {
    this(new CloudEventDelivery());
  }
  
  public CloudEventDeliveryBuilder(CloudEventDeliveryFluent<?> fluent) {
    this(fluent, new CloudEventDelivery());
  }
  
  public CloudEventDeliveryBuilder(CloudEventDelivery instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CloudEventDeliveryBuilder(CloudEventDeliveryFluent<?> fluent,CloudEventDelivery instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CloudEventDelivery build() {
    CloudEventDelivery buildable = new CloudEventDelivery(fluent.buildStatus(), fluent.getTarget());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}