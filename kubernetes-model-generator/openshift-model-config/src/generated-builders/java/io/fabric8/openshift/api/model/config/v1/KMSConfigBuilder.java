package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KMSConfigBuilder extends KMSConfigFluent<KMSConfigBuilder> implements VisitableBuilder<KMSConfig,KMSConfigBuilder>{

  KMSConfigFluent<?> fluent;

  public KMSConfigBuilder() {
    this(new KMSConfig());
  }
  
  public KMSConfigBuilder(KMSConfigFluent<?> fluent) {
    this(fluent, new KMSConfig());
  }
  
  public KMSConfigBuilder(KMSConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KMSConfigBuilder(KMSConfigFluent<?> fluent,KMSConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KMSConfig build() {
    KMSConfig buildable = new KMSConfig(fluent.buildAws(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}