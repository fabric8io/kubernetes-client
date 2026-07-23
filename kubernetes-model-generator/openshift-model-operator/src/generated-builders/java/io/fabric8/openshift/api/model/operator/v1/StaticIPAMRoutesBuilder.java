package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StaticIPAMRoutesBuilder extends StaticIPAMRoutesFluent<StaticIPAMRoutesBuilder> implements VisitableBuilder<StaticIPAMRoutes,StaticIPAMRoutesBuilder>{

  StaticIPAMRoutesFluent<?> fluent;

  public StaticIPAMRoutesBuilder() {
    this(new StaticIPAMRoutes());
  }
  
  public StaticIPAMRoutesBuilder(StaticIPAMRoutesFluent<?> fluent) {
    this(fluent, new StaticIPAMRoutes());
  }
  
  public StaticIPAMRoutesBuilder(StaticIPAMRoutes instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StaticIPAMRoutesBuilder(StaticIPAMRoutesFluent<?> fluent,StaticIPAMRoutes instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StaticIPAMRoutes build() {
    StaticIPAMRoutes buildable = new StaticIPAMRoutes(fluent.getDestination(), fluent.getGateway());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}