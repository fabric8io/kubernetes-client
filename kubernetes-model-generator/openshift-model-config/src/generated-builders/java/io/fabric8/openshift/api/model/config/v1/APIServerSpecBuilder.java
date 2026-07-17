package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIServerSpecBuilder extends APIServerSpecFluent<APIServerSpecBuilder> implements VisitableBuilder<APIServerSpec,APIServerSpecBuilder>{

  APIServerSpecFluent<?> fluent;

  public APIServerSpecBuilder() {
    this(new APIServerSpec());
  }
  
  public APIServerSpecBuilder(APIServerSpecFluent<?> fluent) {
    this(fluent, new APIServerSpec());
  }
  
  public APIServerSpecBuilder(APIServerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIServerSpecBuilder(APIServerSpecFluent<?> fluent,APIServerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIServerSpec build() {
    APIServerSpec buildable = new APIServerSpec(fluent.getAdditionalCORSAllowedOrigins(), fluent.buildAudit(), fluent.buildClientCA(), fluent.buildEncryption(), fluent.buildServingCerts(), fluent.buildTlsSecurityProfile());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}