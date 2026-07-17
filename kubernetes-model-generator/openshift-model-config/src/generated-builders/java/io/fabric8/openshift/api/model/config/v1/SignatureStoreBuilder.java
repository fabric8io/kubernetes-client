package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SignatureStoreBuilder extends SignatureStoreFluent<SignatureStoreBuilder> implements VisitableBuilder<SignatureStore,SignatureStoreBuilder>{

  SignatureStoreFluent<?> fluent;

  public SignatureStoreBuilder() {
    this(new SignatureStore());
  }
  
  public SignatureStoreBuilder(SignatureStoreFluent<?> fluent) {
    this(fluent, new SignatureStore());
  }
  
  public SignatureStoreBuilder(SignatureStore instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SignatureStoreBuilder(SignatureStoreFluent<?> fluent,SignatureStore instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SignatureStore build() {
    SignatureStore buildable = new SignatureStore(fluent.buildCa(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}