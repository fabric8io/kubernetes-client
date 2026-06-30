package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceQuotaListBuilder extends ResourceQuotaListFluent<ResourceQuotaListBuilder> implements VisitableBuilder<ResourceQuotaList,ResourceQuotaListBuilder>{

  ResourceQuotaListFluent<?> fluent;

  public ResourceQuotaListBuilder() {
    this(new ResourceQuotaList());
  }
  
  public ResourceQuotaListBuilder(ResourceQuotaListFluent<?> fluent) {
    this(fluent, new ResourceQuotaList());
  }
  
  public ResourceQuotaListBuilder(ResourceQuotaList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceQuotaListBuilder(ResourceQuotaListFluent<?> fluent,ResourceQuotaList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceQuotaList build() {
    ResourceQuotaList buildable = new ResourceQuotaList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}