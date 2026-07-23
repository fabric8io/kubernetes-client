package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceQuotaStatusByNamespaceBuilder extends ResourceQuotaStatusByNamespaceFluent<ResourceQuotaStatusByNamespaceBuilder> implements VisitableBuilder<ResourceQuotaStatusByNamespace,ResourceQuotaStatusByNamespaceBuilder>{

  ResourceQuotaStatusByNamespaceFluent<?> fluent;

  public ResourceQuotaStatusByNamespaceBuilder() {
    this(new ResourceQuotaStatusByNamespace());
  }
  
  public ResourceQuotaStatusByNamespaceBuilder(ResourceQuotaStatusByNamespaceFluent<?> fluent) {
    this(fluent, new ResourceQuotaStatusByNamespace());
  }
  
  public ResourceQuotaStatusByNamespaceBuilder(ResourceQuotaStatusByNamespace instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceQuotaStatusByNamespaceBuilder(ResourceQuotaStatusByNamespaceFluent<?> fluent,ResourceQuotaStatusByNamespace instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceQuotaStatusByNamespace build() {
    ResourceQuotaStatusByNamespace buildable = new ResourceQuotaStatusByNamespace(fluent.getNamespace(), fluent.getStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}