package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JKSKeystoreBuilder extends JKSKeystoreFluent<JKSKeystoreBuilder> implements VisitableBuilder<JKSKeystore,JKSKeystoreBuilder>{

  JKSKeystoreFluent<?> fluent;

  public JKSKeystoreBuilder() {
    this(new JKSKeystore());
  }
  
  public JKSKeystoreBuilder(JKSKeystoreFluent<?> fluent) {
    this(fluent, new JKSKeystore());
  }
  
  public JKSKeystoreBuilder(JKSKeystore instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JKSKeystoreBuilder(JKSKeystoreFluent<?> fluent,JKSKeystore instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JKSKeystore build() {
    JKSKeystore buildable = new JKSKeystore(fluent.getAlias(), fluent.getCreate(), fluent.getPassword(), fluent.buildPasswordSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}