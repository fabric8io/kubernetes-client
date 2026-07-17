package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteAdmissionPolicyBuilder extends RouteAdmissionPolicyFluent<RouteAdmissionPolicyBuilder> implements VisitableBuilder<RouteAdmissionPolicy,RouteAdmissionPolicyBuilder>{

  RouteAdmissionPolicyFluent<?> fluent;

  public RouteAdmissionPolicyBuilder() {
    this(new RouteAdmissionPolicy());
  }
  
  public RouteAdmissionPolicyBuilder(RouteAdmissionPolicyFluent<?> fluent) {
    this(fluent, new RouteAdmissionPolicy());
  }
  
  public RouteAdmissionPolicyBuilder(RouteAdmissionPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteAdmissionPolicyBuilder(RouteAdmissionPolicyFluent<?> fluent,RouteAdmissionPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteAdmissionPolicy build() {
    RouteAdmissionPolicy buildable = new RouteAdmissionPolicy(fluent.getNamespaceOwnership(), fluent.getWildcardPolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}