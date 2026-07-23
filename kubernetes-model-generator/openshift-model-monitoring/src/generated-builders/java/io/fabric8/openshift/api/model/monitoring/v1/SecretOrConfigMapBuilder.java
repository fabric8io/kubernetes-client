package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecretOrConfigMapBuilder extends SecretOrConfigMapFluent<SecretOrConfigMapBuilder> implements VisitableBuilder<SecretOrConfigMap,SecretOrConfigMapBuilder>{

  SecretOrConfigMapFluent<?> fluent;

  public SecretOrConfigMapBuilder() {
    this(new SecretOrConfigMap());
  }
  
  public SecretOrConfigMapBuilder(SecretOrConfigMapFluent<?> fluent) {
    this(fluent, new SecretOrConfigMap());
  }
  
  public SecretOrConfigMapBuilder(SecretOrConfigMap instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecretOrConfigMapBuilder(SecretOrConfigMapFluent<?> fluent,SecretOrConfigMap instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecretOrConfigMap build() {
    SecretOrConfigMap buildable = new SecretOrConfigMap(fluent.getConfigMap(), fluent.getSecret());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}