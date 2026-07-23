package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPMetadataBuilder extends GCPMetadataFluent<GCPMetadataBuilder> implements VisitableBuilder<GCPMetadata,GCPMetadataBuilder>{

  GCPMetadataFluent<?> fluent;

  public GCPMetadataBuilder() {
    this(new GCPMetadata());
  }
  
  public GCPMetadataBuilder(GCPMetadataFluent<?> fluent) {
    this(fluent, new GCPMetadata());
  }
  
  public GCPMetadataBuilder(GCPMetadata instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPMetadataBuilder(GCPMetadataFluent<?> fluent,GCPMetadata instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPMetadata build() {
    GCPMetadata buildable = new GCPMetadata(fluent.getKey(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}