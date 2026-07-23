package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CommonRouteSpecBuilder extends CommonRouteSpecFluent<CommonRouteSpecBuilder> implements VisitableBuilder<CommonRouteSpec,CommonRouteSpecBuilder>{

  CommonRouteSpecFluent<?> fluent;

  public CommonRouteSpecBuilder() {
    this(new CommonRouteSpec());
  }
  
  public CommonRouteSpecBuilder(CommonRouteSpecFluent<?> fluent) {
    this(fluent, new CommonRouteSpec());
  }
  
  public CommonRouteSpecBuilder(CommonRouteSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CommonRouteSpecBuilder(CommonRouteSpecFluent<?> fluent,CommonRouteSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CommonRouteSpec build() {
    CommonRouteSpec buildable = new CommonRouteSpec(fluent.buildParentRefs(), fluent.getUseDefaultGateways());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}