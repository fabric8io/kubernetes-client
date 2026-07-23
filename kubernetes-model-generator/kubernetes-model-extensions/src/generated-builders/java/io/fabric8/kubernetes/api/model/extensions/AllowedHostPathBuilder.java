package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AllowedHostPathBuilder extends AllowedHostPathFluent<AllowedHostPathBuilder> implements VisitableBuilder<AllowedHostPath,AllowedHostPathBuilder>{

  AllowedHostPathFluent<?> fluent;

  public AllowedHostPathBuilder() {
    this(new AllowedHostPath());
  }
  
  public AllowedHostPathBuilder(AllowedHostPathFluent<?> fluent) {
    this(fluent, new AllowedHostPath());
  }
  
  public AllowedHostPathBuilder(AllowedHostPath instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AllowedHostPathBuilder(AllowedHostPathFluent<?> fluent,AllowedHostPath instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AllowedHostPath build() {
    AllowedHostPath buildable = new AllowedHostPath(fluent.getPathPrefix(), fluent.getReadOnly());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}