package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceClassParametersListBuilder extends ResourceClassParametersListFluent<ResourceClassParametersListBuilder> implements VisitableBuilder<ResourceClassParametersList,ResourceClassParametersListBuilder>{

  ResourceClassParametersListFluent<?> fluent;

  public ResourceClassParametersListBuilder() {
    this(new ResourceClassParametersList());
  }
  
  public ResourceClassParametersListBuilder(ResourceClassParametersListFluent<?> fluent) {
    this(fluent, new ResourceClassParametersList());
  }
  
  public ResourceClassParametersListBuilder(ResourceClassParametersList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceClassParametersListBuilder(ResourceClassParametersListFluent<?> fluent,ResourceClassParametersList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceClassParametersList build() {
    ResourceClassParametersList buildable = new ResourceClassParametersList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}