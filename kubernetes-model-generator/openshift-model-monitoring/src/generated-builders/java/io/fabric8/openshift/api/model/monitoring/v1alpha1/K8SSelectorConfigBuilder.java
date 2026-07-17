package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class K8SSelectorConfigBuilder extends K8SSelectorConfigFluent<K8SSelectorConfigBuilder> implements VisitableBuilder<K8SSelectorConfig,K8SSelectorConfigBuilder>{

  K8SSelectorConfigFluent<?> fluent;

  public K8SSelectorConfigBuilder() {
    this(new K8SSelectorConfig());
  }
  
  public K8SSelectorConfigBuilder(K8SSelectorConfigFluent<?> fluent) {
    this(fluent, new K8SSelectorConfig());
  }
  
  public K8SSelectorConfigBuilder(K8SSelectorConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public K8SSelectorConfigBuilder(K8SSelectorConfigFluent<?> fluent,K8SSelectorConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public K8SSelectorConfig build() {
    K8SSelectorConfig buildable = new K8SSelectorConfig(fluent.getField(), fluent.getLabel(), fluent.getRole());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}