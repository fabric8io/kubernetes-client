package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceListBuilder extends ResourceListFluent<ResourceListBuilder> implements VisitableBuilder<ResourceList,ResourceListBuilder>{

  ResourceListFluent<?> fluent;

  public ResourceListBuilder() {
    this(new ResourceList());
  }
  
  public ResourceListBuilder(ResourceListFluent<?> fluent) {
    this(fluent, new ResourceList());
  }
  
  public ResourceListBuilder(ResourceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceListBuilder(ResourceListFluent<?> fluent,ResourceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceList build() {
    ResourceList buildable = new ResourceList(fluent.getGroup(), fluent.buildInstances(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}