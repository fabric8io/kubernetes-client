package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EmbeddedObjectMetadataBuilder extends EmbeddedObjectMetadataFluent<EmbeddedObjectMetadataBuilder> implements VisitableBuilder<EmbeddedObjectMetadata,EmbeddedObjectMetadataBuilder>{

  EmbeddedObjectMetadataFluent<?> fluent;

  public EmbeddedObjectMetadataBuilder() {
    this(new EmbeddedObjectMetadata());
  }
  
  public EmbeddedObjectMetadataBuilder(EmbeddedObjectMetadataFluent<?> fluent) {
    this(fluent, new EmbeddedObjectMetadata());
  }
  
  public EmbeddedObjectMetadataBuilder(EmbeddedObjectMetadata instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EmbeddedObjectMetadataBuilder(EmbeddedObjectMetadataFluent<?> fluent,EmbeddedObjectMetadata instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EmbeddedObjectMetadata build() {
    EmbeddedObjectMetadata buildable = new EmbeddedObjectMetadata(fluent.getAnnotations(), fluent.getLabels(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}