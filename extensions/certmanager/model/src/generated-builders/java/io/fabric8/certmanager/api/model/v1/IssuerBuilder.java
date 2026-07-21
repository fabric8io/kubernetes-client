package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IssuerBuilder extends IssuerFluent<IssuerBuilder> implements VisitableBuilder<Issuer,IssuerBuilder>{

  IssuerFluent<?> fluent;

  public IssuerBuilder() {
    this(new Issuer());
  }
  
  public IssuerBuilder(IssuerFluent<?> fluent) {
    this(fluent, new Issuer());
  }
  
  public IssuerBuilder(Issuer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IssuerBuilder(IssuerFluent<?> fluent,Issuer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Issuer build() {
    Issuer buildable = new Issuer(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}