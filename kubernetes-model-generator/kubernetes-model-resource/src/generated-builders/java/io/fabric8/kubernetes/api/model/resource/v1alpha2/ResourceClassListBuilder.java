package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceClassListBuilder extends ResourceClassListFluent<ResourceClassListBuilder> implements VisitableBuilder<ResourceClassList,ResourceClassListBuilder>{

  ResourceClassListFluent<?> fluent;

  public ResourceClassListBuilder() {
    this(new ResourceClassList());
  }
  
  public ResourceClassListBuilder(ResourceClassListFluent<?> fluent) {
    this(fluent, new ResourceClassList());
  }
  
  public ResourceClassListBuilder(ResourceClassList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceClassListBuilder(ResourceClassListFluent<?> fluent,ResourceClassList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceClassList build() {
    ResourceClassList buildable = new ResourceClassList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}