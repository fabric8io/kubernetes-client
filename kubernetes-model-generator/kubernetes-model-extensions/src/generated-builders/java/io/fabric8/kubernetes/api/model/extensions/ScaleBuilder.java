package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ScaleBuilder extends ScaleFluent<ScaleBuilder> implements VisitableBuilder<Scale,ScaleBuilder>{

  ScaleFluent<?> fluent;

  public ScaleBuilder() {
    this(new Scale());
  }
  
  public ScaleBuilder(ScaleFluent<?> fluent) {
    this(fluent, new Scale());
  }
  
  public ScaleBuilder(Scale instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ScaleBuilder(ScaleFluent<?> fluent,Scale instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Scale build() {
    Scale buildable = new Scale(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}