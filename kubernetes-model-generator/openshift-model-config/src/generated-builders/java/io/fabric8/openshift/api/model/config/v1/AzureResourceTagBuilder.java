package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureResourceTagBuilder extends AzureResourceTagFluent<AzureResourceTagBuilder> implements VisitableBuilder<AzureResourceTag,AzureResourceTagBuilder>{

  AzureResourceTagFluent<?> fluent;

  public AzureResourceTagBuilder() {
    this(new AzureResourceTag());
  }
  
  public AzureResourceTagBuilder(AzureResourceTagFluent<?> fluent) {
    this(fluent, new AzureResourceTag());
  }
  
  public AzureResourceTagBuilder(AzureResourceTag instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureResourceTagBuilder(AzureResourceTagFluent<?> fluent,AzureResourceTag instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureResourceTag build() {
    AzureResourceTag buildable = new AzureResourceTag(fluent.getKey(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}