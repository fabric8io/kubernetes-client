package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecretArgsBuilder extends SecretArgsFluent<SecretArgsBuilder> implements VisitableBuilder<SecretArgs,SecretArgsBuilder>{

  SecretArgsFluent<?> fluent;

  public SecretArgsBuilder() {
    this(new SecretArgs());
  }
  
  public SecretArgsBuilder(SecretArgsFluent<?> fluent) {
    this(fluent, new SecretArgs());
  }
  
  public SecretArgsBuilder(SecretArgs instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecretArgsBuilder(SecretArgsFluent<?> fluent,SecretArgs instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecretArgs build() {
    SecretArgs buildable = new SecretArgs(fluent.getBehavior(), fluent.getEnv(), fluent.getEnvs(), fluent.getFiles(), fluent.getLiterals(), fluent.getName(), fluent.getNamespace(), fluent.buildOptions(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}