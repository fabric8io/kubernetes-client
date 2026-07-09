package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceClaimParametersListBuilder extends ResourceClaimParametersListFluent<ResourceClaimParametersListBuilder> implements VisitableBuilder<ResourceClaimParametersList,ResourceClaimParametersListBuilder>{

  ResourceClaimParametersListFluent<?> fluent;

  public ResourceClaimParametersListBuilder() {
    this(new ResourceClaimParametersList());
  }
  
  public ResourceClaimParametersListBuilder(ResourceClaimParametersListFluent<?> fluent) {
    this(fluent, new ResourceClaimParametersList());
  }
  
  public ResourceClaimParametersListBuilder(ResourceClaimParametersList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceClaimParametersListBuilder(ResourceClaimParametersListFluent<?> fluent,ResourceClaimParametersList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceClaimParametersList build() {
    ResourceClaimParametersList buildable = new ResourceClaimParametersList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}