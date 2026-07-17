package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PublicKeyBuilder extends PublicKeyFluent<PublicKeyBuilder> implements VisitableBuilder<PublicKey,PublicKeyBuilder>{

  PublicKeyFluent<?> fluent;

  public PublicKeyBuilder() {
    this(new PublicKey());
  }
  
  public PublicKeyBuilder(PublicKeyFluent<?> fluent) {
    this(fluent, new PublicKey());
  }
  
  public PublicKeyBuilder(PublicKey instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PublicKeyBuilder(PublicKeyFluent<?> fluent,PublicKey instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PublicKey build() {
    PublicKey buildable = new PublicKey(fluent.getKeyData(), fluent.getRekorKeyData());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}