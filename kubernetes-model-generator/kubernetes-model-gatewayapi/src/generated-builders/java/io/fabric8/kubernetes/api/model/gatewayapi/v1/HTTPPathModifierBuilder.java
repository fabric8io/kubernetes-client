package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPPathModifierBuilder extends HTTPPathModifierFluent<HTTPPathModifierBuilder> implements VisitableBuilder<HTTPPathModifier,HTTPPathModifierBuilder>{

  HTTPPathModifierFluent<?> fluent;

  public HTTPPathModifierBuilder() {
    this(new HTTPPathModifier());
  }
  
  public HTTPPathModifierBuilder(HTTPPathModifierFluent<?> fluent) {
    this(fluent, new HTTPPathModifier());
  }
  
  public HTTPPathModifierBuilder(HTTPPathModifier instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPPathModifierBuilder(HTTPPathModifierFluent<?> fluent,HTTPPathModifier instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPPathModifier build() {
    HTTPPathModifier buildable = new HTTPPathModifier(fluent.getReplaceFullPath(), fluent.getReplacePrefixMatch(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}