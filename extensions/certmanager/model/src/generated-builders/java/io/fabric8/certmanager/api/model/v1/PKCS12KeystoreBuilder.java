package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PKCS12KeystoreBuilder extends PKCS12KeystoreFluent<PKCS12KeystoreBuilder> implements VisitableBuilder<PKCS12Keystore,PKCS12KeystoreBuilder>{

  PKCS12KeystoreFluent<?> fluent;

  public PKCS12KeystoreBuilder() {
    this(new PKCS12Keystore());
  }
  
  public PKCS12KeystoreBuilder(PKCS12KeystoreFluent<?> fluent) {
    this(fluent, new PKCS12Keystore());
  }
  
  public PKCS12KeystoreBuilder(PKCS12Keystore instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PKCS12KeystoreBuilder(PKCS12KeystoreFluent<?> fluent,PKCS12Keystore instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PKCS12Keystore build() {
    PKCS12Keystore buildable = new PKCS12Keystore(fluent.getCreate(), fluent.getPassword(), fluent.buildPasswordSecretRef(), fluent.getProfile());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}