package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PinnedResourceReferenceBuilder extends PinnedResourceReferenceFluent<PinnedResourceReferenceBuilder> implements VisitableBuilder<PinnedResourceReference,PinnedResourceReferenceBuilder>{

  PinnedResourceReferenceFluent<?> fluent;

  public PinnedResourceReferenceBuilder() {
    this(new PinnedResourceReference());
  }
  
  public PinnedResourceReferenceBuilder(PinnedResourceReferenceFluent<?> fluent) {
    this(fluent, new PinnedResourceReference());
  }
  
  public PinnedResourceReferenceBuilder(PinnedResourceReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PinnedResourceReferenceBuilder(PinnedResourceReferenceFluent<?> fluent,PinnedResourceReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PinnedResourceReference build() {
    PinnedResourceReference buildable = new PinnedResourceReference(fluent.getGroup(), fluent.getResource(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}