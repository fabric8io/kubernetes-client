package io.fabric8.istio.api.extensions.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TrafficExtensionListBuilder extends TrafficExtensionListFluent<TrafficExtensionListBuilder> implements VisitableBuilder<TrafficExtensionList,TrafficExtensionListBuilder>{

  TrafficExtensionListFluent<?> fluent;

  public TrafficExtensionListBuilder() {
    this(new TrafficExtensionList());
  }
  
  public TrafficExtensionListBuilder(TrafficExtensionListFluent<?> fluent) {
    this(fluent, new TrafficExtensionList());
  }
  
  public TrafficExtensionListBuilder(TrafficExtensionList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TrafficExtensionListBuilder(TrafficExtensionListFluent<?> fluent,TrafficExtensionList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TrafficExtensionList build() {
    TrafficExtensionList buildable = new TrafficExtensionList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}