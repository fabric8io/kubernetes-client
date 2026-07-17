package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIServerNamedServingCertBuilder extends APIServerNamedServingCertFluent<APIServerNamedServingCertBuilder> implements VisitableBuilder<APIServerNamedServingCert,APIServerNamedServingCertBuilder>{

  APIServerNamedServingCertFluent<?> fluent;

  public APIServerNamedServingCertBuilder() {
    this(new APIServerNamedServingCert());
  }
  
  public APIServerNamedServingCertBuilder(APIServerNamedServingCertFluent<?> fluent) {
    this(fluent, new APIServerNamedServingCert());
  }
  
  public APIServerNamedServingCertBuilder(APIServerNamedServingCert instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIServerNamedServingCertBuilder(APIServerNamedServingCertFluent<?> fluent,APIServerNamedServingCert instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIServerNamedServingCert build() {
    APIServerNamedServingCert buildable = new APIServerNamedServingCert(fluent.getNames(), fluent.buildServingCertificate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}