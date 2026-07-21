package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPSelectorBuilder extends GCPSelectorFluent<GCPSelectorBuilder> implements VisitableBuilder<GCPSelector,GCPSelectorBuilder>{

  GCPSelectorFluent<?> fluent;

  public GCPSelectorBuilder() {
    this(new GCPSelector());
  }
  
  public GCPSelectorBuilder(GCPSelectorFluent<?> fluent) {
    this(fluent, new GCPSelector());
  }
  
  public GCPSelectorBuilder(GCPSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPSelectorBuilder(GCPSelectorFluent<?> fluent,GCPSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPSelector build() {
    GCPSelector buildable = new GCPSelector(fluent.getDeviceNames(), fluent.getInstance(), fluent.getProject(), fluent.getZone());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}