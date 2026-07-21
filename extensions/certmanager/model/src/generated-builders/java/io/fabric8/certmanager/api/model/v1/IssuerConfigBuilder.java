package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IssuerConfigBuilder extends IssuerConfigFluent<IssuerConfigBuilder> implements VisitableBuilder<IssuerConfig,IssuerConfigBuilder>{

  IssuerConfigFluent<?> fluent;

  public IssuerConfigBuilder() {
    this(new IssuerConfig());
  }
  
  public IssuerConfigBuilder(IssuerConfigFluent<?> fluent) {
    this(fluent, new IssuerConfig());
  }
  
  public IssuerConfigBuilder(IssuerConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IssuerConfigBuilder(IssuerConfigFluent<?> fluent,IssuerConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IssuerConfig build() {
    IssuerConfig buildable = new IssuerConfig(fluent.buildAcme(), fluent.buildCa(), fluent.buildSelfSigned(), fluent.buildVault(), fluent.buildVenafi());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}