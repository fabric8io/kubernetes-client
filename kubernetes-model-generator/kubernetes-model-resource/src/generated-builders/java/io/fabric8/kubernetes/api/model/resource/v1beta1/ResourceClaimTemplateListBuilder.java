package io.fabric8.kubernetes.api.model.resource.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceClaimTemplateListBuilder extends ResourceClaimTemplateListFluent<ResourceClaimTemplateListBuilder> implements VisitableBuilder<ResourceClaimTemplateList,ResourceClaimTemplateListBuilder>{

  ResourceClaimTemplateListFluent<?> fluent;

  public ResourceClaimTemplateListBuilder() {
    this(new ResourceClaimTemplateList());
  }
  
  public ResourceClaimTemplateListBuilder(ResourceClaimTemplateListFluent<?> fluent) {
    this(fluent, new ResourceClaimTemplateList());
  }
  
  public ResourceClaimTemplateListBuilder(ResourceClaimTemplateList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceClaimTemplateListBuilder(ResourceClaimTemplateListFluent<?> fluent,ResourceClaimTemplateList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceClaimTemplateList build() {
    ResourceClaimTemplateList buildable = new ResourceClaimTemplateList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}