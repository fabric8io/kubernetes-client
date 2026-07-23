package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIServerEncryptionBuilder extends APIServerEncryptionFluent<APIServerEncryptionBuilder> implements VisitableBuilder<APIServerEncryption,APIServerEncryptionBuilder>{

  APIServerEncryptionFluent<?> fluent;

  public APIServerEncryptionBuilder() {
    this(new APIServerEncryption());
  }
  
  public APIServerEncryptionBuilder(APIServerEncryptionFluent<?> fluent) {
    this(fluent, new APIServerEncryption());
  }
  
  public APIServerEncryptionBuilder(APIServerEncryption instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIServerEncryptionBuilder(APIServerEncryptionFluent<?> fluent,APIServerEncryption instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIServerEncryption build() {
    APIServerEncryption buildable = new APIServerEncryption(fluent.buildKms(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}