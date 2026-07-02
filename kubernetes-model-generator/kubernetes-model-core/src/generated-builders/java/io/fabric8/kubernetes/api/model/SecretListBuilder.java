package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecretListBuilder extends SecretListFluent<SecretListBuilder> implements VisitableBuilder<SecretList,SecretListBuilder>{

  SecretListFluent<?> fluent;

  public SecretListBuilder() {
    this(new SecretList());
  }
  
  public SecretListBuilder(SecretListFluent<?> fluent) {
    this(fluent, new SecretList());
  }
  
  public SecretListBuilder(SecretList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecretListBuilder(SecretListFluent<?> fluent,SecretList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecretList build() {
    SecretList buildable = new SecretList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}