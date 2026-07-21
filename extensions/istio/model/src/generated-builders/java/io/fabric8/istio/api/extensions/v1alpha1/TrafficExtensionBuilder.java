package io.fabric8.istio.api.extensions.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TrafficExtensionBuilder extends TrafficExtensionFluent<TrafficExtensionBuilder> implements VisitableBuilder<TrafficExtension,TrafficExtensionBuilder>{

  TrafficExtensionFluent<?> fluent;

  public TrafficExtensionBuilder() {
    this(new TrafficExtension());
  }
  
  public TrafficExtensionBuilder(TrafficExtensionFluent<?> fluent) {
    this(fluent, new TrafficExtension());
  }
  
  public TrafficExtensionBuilder(TrafficExtension instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TrafficExtensionBuilder(TrafficExtensionFluent<?> fluent,TrafficExtension instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TrafficExtension build() {
    TrafficExtension buildable = new TrafficExtension(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}