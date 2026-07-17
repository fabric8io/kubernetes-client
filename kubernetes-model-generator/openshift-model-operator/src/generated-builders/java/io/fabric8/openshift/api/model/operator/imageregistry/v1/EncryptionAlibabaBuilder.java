package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EncryptionAlibabaBuilder extends EncryptionAlibabaFluent<EncryptionAlibabaBuilder> implements VisitableBuilder<EncryptionAlibaba,EncryptionAlibabaBuilder>{

  EncryptionAlibabaFluent<?> fluent;

  public EncryptionAlibabaBuilder() {
    this(new EncryptionAlibaba());
  }
  
  public EncryptionAlibabaBuilder(EncryptionAlibabaFluent<?> fluent) {
    this(fluent, new EncryptionAlibaba());
  }
  
  public EncryptionAlibabaBuilder(EncryptionAlibaba instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EncryptionAlibabaBuilder(EncryptionAlibabaFluent<?> fluent,EncryptionAlibaba instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EncryptionAlibaba build() {
    EncryptionAlibaba buildable = new EncryptionAlibaba(fluent.buildKms(), fluent.getMethod());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}