package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEChallengeSolverHTTP01GatewayHTTPRouteBuilder extends ACMEChallengeSolverHTTP01GatewayHTTPRouteFluent<ACMEChallengeSolverHTTP01GatewayHTTPRouteBuilder> implements VisitableBuilder<ACMEChallengeSolverHTTP01GatewayHTTPRoute,ACMEChallengeSolverHTTP01GatewayHTTPRouteBuilder>{

  ACMEChallengeSolverHTTP01GatewayHTTPRouteFluent<?> fluent;

  public ACMEChallengeSolverHTTP01GatewayHTTPRouteBuilder() {
    this(new ACMEChallengeSolverHTTP01GatewayHTTPRoute());
  }
  
  public ACMEChallengeSolverHTTP01GatewayHTTPRouteBuilder(ACMEChallengeSolverHTTP01GatewayHTTPRouteFluent<?> fluent) {
    this(fluent, new ACMEChallengeSolverHTTP01GatewayHTTPRoute());
  }
  
  public ACMEChallengeSolverHTTP01GatewayHTTPRouteBuilder(ACMEChallengeSolverHTTP01GatewayHTTPRoute instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEChallengeSolverHTTP01GatewayHTTPRouteBuilder(ACMEChallengeSolverHTTP01GatewayHTTPRouteFluent<?> fluent,ACMEChallengeSolverHTTP01GatewayHTTPRoute instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEChallengeSolverHTTP01GatewayHTTPRoute build() {
    ACMEChallengeSolverHTTP01GatewayHTTPRoute buildable = new ACMEChallengeSolverHTTP01GatewayHTTPRoute(fluent.getLabels(), fluent.getParentRefs(), fluent.buildPodTemplate(), fluent.getServiceType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}