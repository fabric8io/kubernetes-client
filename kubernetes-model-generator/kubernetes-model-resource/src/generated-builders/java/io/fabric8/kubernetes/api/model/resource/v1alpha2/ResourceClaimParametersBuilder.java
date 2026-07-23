package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceClaimParametersBuilder extends ResourceClaimParametersFluent<ResourceClaimParametersBuilder> implements VisitableBuilder<ResourceClaimParameters,ResourceClaimParametersBuilder>{

  ResourceClaimParametersFluent<?> fluent;

  public ResourceClaimParametersBuilder() {
    this(new ResourceClaimParameters());
  }
  
  public ResourceClaimParametersBuilder(ResourceClaimParametersFluent<?> fluent) {
    this(fluent, new ResourceClaimParameters());
  }
  
  public ResourceClaimParametersBuilder(ResourceClaimParameters instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceClaimParametersBuilder(ResourceClaimParametersFluent<?> fluent,ResourceClaimParameters instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceClaimParameters build() {
    ResourceClaimParameters buildable = new ResourceClaimParameters(fluent.getApiVersion(), fluent.buildDriverRequests(), fluent.buildGeneratedFrom(), fluent.getKind(), fluent.buildMetadata(), fluent.getShareable());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}