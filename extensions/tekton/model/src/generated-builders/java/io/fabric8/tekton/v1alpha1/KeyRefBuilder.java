package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KeyRefBuilder extends KeyRefFluent<KeyRefBuilder> implements VisitableBuilder<KeyRef,KeyRefBuilder>{

  KeyRefFluent<?> fluent;

  public KeyRefBuilder() {
    this(new KeyRef());
  }
  
  public KeyRefBuilder(KeyRefFluent<?> fluent) {
    this(fluent, new KeyRef());
  }
  
  public KeyRefBuilder(KeyRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KeyRefBuilder(KeyRefFluent<?> fluent,KeyRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KeyRef build() {
    KeyRef buildable = new KeyRef(fluent.getData(), fluent.getHashAlgorithm(), fluent.getKms(), fluent.getSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}