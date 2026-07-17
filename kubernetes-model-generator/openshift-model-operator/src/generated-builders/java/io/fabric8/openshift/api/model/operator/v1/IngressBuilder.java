package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressBuilder extends IngressFluent<IngressBuilder> implements VisitableBuilder<Ingress,IngressBuilder>{

  IngressFluent<?> fluent;

  public IngressBuilder() {
    this(new Ingress());
  }
  
  public IngressBuilder(IngressFluent<?> fluent) {
    this(fluent, new Ingress());
  }
  
  public IngressBuilder(Ingress instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressBuilder(IngressFluent<?> fluent,Ingress instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Ingress build() {
    Ingress buildable = new Ingress(fluent.getClientDownloadsURL(), fluent.getConsoleURL());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}