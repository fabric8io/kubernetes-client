package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceQuotaStatusBuilder extends ResourceQuotaStatusFluent<ResourceQuotaStatusBuilder> implements VisitableBuilder<ResourceQuotaStatus,ResourceQuotaStatusBuilder>{

  ResourceQuotaStatusFluent<?> fluent;

  public ResourceQuotaStatusBuilder() {
    this(new ResourceQuotaStatus());
  }
  
  public ResourceQuotaStatusBuilder(ResourceQuotaStatusFluent<?> fluent) {
    this(fluent, new ResourceQuotaStatus());
  }
  
  public ResourceQuotaStatusBuilder(ResourceQuotaStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceQuotaStatusBuilder(ResourceQuotaStatusFluent<?> fluent,ResourceQuotaStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceQuotaStatus build() {
    ResourceQuotaStatus buildable = new ResourceQuotaStatus(fluent.getHard(), fluent.getUsed());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}