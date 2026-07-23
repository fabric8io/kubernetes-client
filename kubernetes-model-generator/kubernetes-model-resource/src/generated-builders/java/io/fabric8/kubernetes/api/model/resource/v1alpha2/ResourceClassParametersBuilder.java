package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceClassParametersBuilder extends ResourceClassParametersFluent<ResourceClassParametersBuilder> implements VisitableBuilder<ResourceClassParameters,ResourceClassParametersBuilder>{

  ResourceClassParametersFluent<?> fluent;

  public ResourceClassParametersBuilder() {
    this(new ResourceClassParameters());
  }
  
  public ResourceClassParametersBuilder(ResourceClassParametersFluent<?> fluent) {
    this(fluent, new ResourceClassParameters());
  }
  
  public ResourceClassParametersBuilder(ResourceClassParameters instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceClassParametersBuilder(ResourceClassParametersFluent<?> fluent,ResourceClassParameters instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceClassParameters build() {
    ResourceClassParameters buildable = new ResourceClassParameters(fluent.getApiVersion(), fluent.buildFilters(), fluent.buildGeneratedFrom(), fluent.getKind(), fluent.buildMetadata(), fluent.buildVendorParameters());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}