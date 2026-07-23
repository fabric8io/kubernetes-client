package io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSDDBStreamsBuilder extends AWSDDBStreamsFluent<AWSDDBStreamsBuilder> implements VisitableBuilder<AWSDDBStreams,AWSDDBStreamsBuilder>{

  AWSDDBStreamsFluent<?> fluent;

  public AWSDDBStreamsBuilder() {
    this(new AWSDDBStreams());
  }
  
  public AWSDDBStreamsBuilder(AWSDDBStreamsFluent<?> fluent) {
    this(fluent, new AWSDDBStreams());
  }
  
  public AWSDDBStreamsBuilder(AWSDDBStreams instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSDDBStreamsBuilder(AWSDDBStreamsFluent<?> fluent,AWSDDBStreams instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSDDBStreams build() {
    AWSDDBStreams buildable = new AWSDDBStreams(fluent.getDelay(), fluent.getOverrideEndpoint(), fluent.getRegion(), fluent.getStreamIteratorType(), fluent.getTable(), fluent.getUriEndpointOverride());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}