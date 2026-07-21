package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CidrAndPortBuilder extends CidrAndPortFluent<CidrAndPortBuilder> implements VisitableBuilder<CidrAndPort,CidrAndPortBuilder>{

  CidrAndPortFluent<?> fluent;

  public CidrAndPortBuilder() {
    this(new CidrAndPort());
  }
  
  public CidrAndPortBuilder(CidrAndPortFluent<?> fluent) {
    this(fluent, new CidrAndPort());
  }
  
  public CidrAndPortBuilder(CidrAndPort instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CidrAndPortBuilder(CidrAndPortFluent<?> fluent,CidrAndPort instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CidrAndPort build() {
    CidrAndPort buildable = new CidrAndPort(fluent.getCidr(), fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}