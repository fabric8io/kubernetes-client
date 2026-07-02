package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceQuotaBuilder extends ResourceQuotaFluent<ResourceQuotaBuilder> implements VisitableBuilder<ResourceQuota,ResourceQuotaBuilder>{

  ResourceQuotaFluent<?> fluent;

  public ResourceQuotaBuilder() {
    this(new ResourceQuota());
  }
  
  public ResourceQuotaBuilder(ResourceQuotaFluent<?> fluent) {
    this(fluent, new ResourceQuota());
  }
  
  public ResourceQuotaBuilder(ResourceQuota instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceQuotaBuilder(ResourceQuotaFluent<?> fluent,ResourceQuota instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceQuota build() {
    ResourceQuota buildable = new ResourceQuota(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}