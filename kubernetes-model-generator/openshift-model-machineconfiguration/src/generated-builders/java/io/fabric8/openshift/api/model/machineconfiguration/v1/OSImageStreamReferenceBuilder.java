package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OSImageStreamReferenceBuilder extends OSImageStreamReferenceFluent<OSImageStreamReferenceBuilder> implements VisitableBuilder<OSImageStreamReference,OSImageStreamReferenceBuilder>{

  OSImageStreamReferenceFluent<?> fluent;

  public OSImageStreamReferenceBuilder() {
    this(new OSImageStreamReference());
  }
  
  public OSImageStreamReferenceBuilder(OSImageStreamReferenceFluent<?> fluent) {
    this(fluent, new OSImageStreamReference());
  }
  
  public OSImageStreamReferenceBuilder(OSImageStreamReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OSImageStreamReferenceBuilder(OSImageStreamReferenceFluent<?> fluent,OSImageStreamReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OSImageStreamReference build() {
    OSImageStreamReference buildable = new OSImageStreamReference(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}