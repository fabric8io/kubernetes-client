package io.fabric8.istio.api.api.security.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SourceBuilder extends SourceFluent<SourceBuilder> implements VisitableBuilder<Source,SourceBuilder>{

  SourceFluent<?> fluent;

  public SourceBuilder() {
    this(new Source());
  }
  
  public SourceBuilder(SourceFluent<?> fluent) {
    this(fluent, new Source());
  }
  
  public SourceBuilder(Source instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SourceBuilder(SourceFluent<?> fluent,Source instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Source build() {
    Source buildable = new Source(fluent.getIpBlocks(), fluent.getNamespaces(), fluent.getNotIpBlocks(), fluent.getNotNamespaces(), fluent.getNotPrincipals(), fluent.getNotRemoteIpBlocks(), fluent.getNotRequestPrincipals(), fluent.getNotServiceAccounts(), fluent.getNotTrustDomains(), fluent.getPrincipals(), fluent.getRemoteIpBlocks(), fluent.getRequestPrincipals(), fluent.getServiceAccounts(), fluent.getTrustDomains());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}