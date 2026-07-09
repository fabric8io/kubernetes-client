package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceClassParametersReferenceBuilder extends ResourceClassParametersReferenceFluent<ResourceClassParametersReferenceBuilder> implements VisitableBuilder<ResourceClassParametersReference,ResourceClassParametersReferenceBuilder>{

  ResourceClassParametersReferenceFluent<?> fluent;

  public ResourceClassParametersReferenceBuilder() {
    this(new ResourceClassParametersReference());
  }
  
  public ResourceClassParametersReferenceBuilder(ResourceClassParametersReferenceFluent<?> fluent) {
    this(fluent, new ResourceClassParametersReference());
  }
  
  public ResourceClassParametersReferenceBuilder(ResourceClassParametersReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceClassParametersReferenceBuilder(ResourceClassParametersReferenceFluent<?> fluent,ResourceClassParametersReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceClassParametersReference build() {
    ResourceClassParametersReference buildable = new ResourceClassParametersReference(fluent.getApiGroup(), fluent.getKind(), fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}