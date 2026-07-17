package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIServerServingCertsBuilder extends APIServerServingCertsFluent<APIServerServingCertsBuilder> implements VisitableBuilder<APIServerServingCerts,APIServerServingCertsBuilder>{

  APIServerServingCertsFluent<?> fluent;

  public APIServerServingCertsBuilder() {
    this(new APIServerServingCerts());
  }
  
  public APIServerServingCertsBuilder(APIServerServingCertsFluent<?> fluent) {
    this(fluent, new APIServerServingCerts());
  }
  
  public APIServerServingCertsBuilder(APIServerServingCerts instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIServerServingCertsBuilder(APIServerServingCertsFluent<?> fluent,APIServerServingCerts instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIServerServingCerts build() {
    APIServerServingCerts buildable = new APIServerServingCerts(fluent.buildNamedCertificates());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}