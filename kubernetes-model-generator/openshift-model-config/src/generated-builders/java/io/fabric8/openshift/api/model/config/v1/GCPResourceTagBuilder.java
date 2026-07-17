package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPResourceTagBuilder extends GCPResourceTagFluent<GCPResourceTagBuilder> implements VisitableBuilder<GCPResourceTag,GCPResourceTagBuilder>{

  GCPResourceTagFluent<?> fluent;

  public GCPResourceTagBuilder() {
    this(new GCPResourceTag());
  }
  
  public GCPResourceTagBuilder(GCPResourceTagFluent<?> fluent) {
    this(fluent, new GCPResourceTag());
  }
  
  public GCPResourceTagBuilder(GCPResourceTag instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPResourceTagBuilder(GCPResourceTagFluent<?> fluent,GCPResourceTag instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPResourceTag build() {
    GCPResourceTag buildable = new GCPResourceTag(fluent.getKey(), fluent.getParentID(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}