package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceHintBuilder extends ResourceHintFluent<ResourceHintBuilder> implements VisitableBuilder<ResourceHint,ResourceHintBuilder>{

  ResourceHintFluent<?> fluent;

  public ResourceHintBuilder() {
    this(new ResourceHint());
  }
  
  public ResourceHintBuilder(ResourceHintFluent<?> fluent) {
    this(fluent, new ResourceHint());
  }
  
  public ResourceHintBuilder(ResourceHint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceHintBuilder(ResourceHintFluent<?> fluent,ResourceHint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceHint build() {
    ResourceHint buildable = new ResourceHint(fluent.getOrder(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}