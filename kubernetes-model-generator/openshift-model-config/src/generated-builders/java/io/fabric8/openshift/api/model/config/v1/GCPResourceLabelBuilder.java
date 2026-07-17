package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPResourceLabelBuilder extends GCPResourceLabelFluent<GCPResourceLabelBuilder> implements VisitableBuilder<GCPResourceLabel,GCPResourceLabelBuilder>{

  GCPResourceLabelFluent<?> fluent;

  public GCPResourceLabelBuilder() {
    this(new GCPResourceLabel());
  }
  
  public GCPResourceLabelBuilder(GCPResourceLabelFluent<?> fluent) {
    this(fluent, new GCPResourceLabel());
  }
  
  public GCPResourceLabelBuilder(GCPResourceLabel instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPResourceLabelBuilder(GCPResourceLabelFluent<?> fluent,GCPResourceLabel instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPResourceLabel build() {
    GCPResourceLabel buildable = new GCPResourceLabel(fluent.getKey(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}