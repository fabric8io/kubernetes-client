package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KeyToPathBuilder extends KeyToPathFluent<KeyToPathBuilder> implements VisitableBuilder<KeyToPath,KeyToPathBuilder>{

  KeyToPathFluent<?> fluent;

  public KeyToPathBuilder() {
    this(new KeyToPath());
  }
  
  public KeyToPathBuilder(KeyToPathFluent<?> fluent) {
    this(fluent, new KeyToPath());
  }
  
  public KeyToPathBuilder(KeyToPath instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KeyToPathBuilder(KeyToPathFluent<?> fluent,KeyToPath instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KeyToPath build() {
    KeyToPath buildable = new KeyToPath(fluent.getKey(), fluent.getMode(), fluent.getPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}