package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamedResourcesAttributeBuilder extends NamedResourcesAttributeFluent<NamedResourcesAttributeBuilder> implements VisitableBuilder<NamedResourcesAttribute,NamedResourcesAttributeBuilder>{

  NamedResourcesAttributeFluent<?> fluent;

  public NamedResourcesAttributeBuilder() {
    this(new NamedResourcesAttribute());
  }
  
  public NamedResourcesAttributeBuilder(NamedResourcesAttributeFluent<?> fluent) {
    this(fluent, new NamedResourcesAttribute());
  }
  
  public NamedResourcesAttributeBuilder(NamedResourcesAttribute instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamedResourcesAttributeBuilder(NamedResourcesAttributeFluent<?> fluent,NamedResourcesAttribute instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamedResourcesAttribute build() {
    NamedResourcesAttribute buildable = new NamedResourcesAttribute(fluent.getBool(), fluent.getInt(), fluent.buildIntSlice(), fluent.getName(), fluent.getQuantity(), fluent.getString(), fluent.buildStringSlice(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}