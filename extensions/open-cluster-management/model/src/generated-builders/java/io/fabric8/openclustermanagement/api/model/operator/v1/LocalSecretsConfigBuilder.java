package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LocalSecretsConfigBuilder extends LocalSecretsConfigFluent<LocalSecretsConfigBuilder> implements VisitableBuilder<LocalSecretsConfig,LocalSecretsConfigBuilder>{

  LocalSecretsConfigFluent<?> fluent;

  public LocalSecretsConfigBuilder() {
    this(new LocalSecretsConfig());
  }
  
  public LocalSecretsConfigBuilder(LocalSecretsConfigFluent<?> fluent) {
    this(fluent, new LocalSecretsConfig());
  }
  
  public LocalSecretsConfigBuilder(LocalSecretsConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LocalSecretsConfigBuilder(LocalSecretsConfigFluent<?> fluent,LocalSecretsConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LocalSecretsConfig build() {
    LocalSecretsConfig buildable = new LocalSecretsConfig(fluent.getHubConnectionTimeoutSeconds(), fluent.buildKubeConfigSecrets());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}