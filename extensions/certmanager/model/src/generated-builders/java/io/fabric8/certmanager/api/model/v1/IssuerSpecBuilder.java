package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IssuerSpecBuilder extends IssuerSpecFluent<IssuerSpecBuilder> implements VisitableBuilder<IssuerSpec,IssuerSpecBuilder>{

  IssuerSpecFluent<?> fluent;

  public IssuerSpecBuilder() {
    this(new IssuerSpec());
  }
  
  public IssuerSpecBuilder(IssuerSpecFluent<?> fluent) {
    this(fluent, new IssuerSpec());
  }
  
  public IssuerSpecBuilder(IssuerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IssuerSpecBuilder(IssuerSpecFluent<?> fluent,IssuerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IssuerSpec build() {
    IssuerSpec buildable = new IssuerSpec(fluent.buildAcme(), fluent.buildCa(), fluent.buildSelfSigned(), fluent.buildVault(), fluent.buildVenafi());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}