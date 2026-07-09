package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceClaimTemplateBuilder extends ResourceClaimTemplateFluent<ResourceClaimTemplateBuilder> implements VisitableBuilder<ResourceClaimTemplate,ResourceClaimTemplateBuilder>{

  ResourceClaimTemplateFluent<?> fluent;

  public ResourceClaimTemplateBuilder() {
    this(new ResourceClaimTemplate());
  }
  
  public ResourceClaimTemplateBuilder(ResourceClaimTemplateFluent<?> fluent) {
    this(fluent, new ResourceClaimTemplate());
  }
  
  public ResourceClaimTemplateBuilder(ResourceClaimTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceClaimTemplateBuilder(ResourceClaimTemplateFluent<?> fluent,ResourceClaimTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceClaimTemplate build() {
    ResourceClaimTemplate buildable = new ResourceClaimTemplate(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}