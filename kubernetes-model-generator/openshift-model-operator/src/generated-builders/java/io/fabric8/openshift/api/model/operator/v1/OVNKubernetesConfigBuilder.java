package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OVNKubernetesConfigBuilder extends OVNKubernetesConfigFluent<OVNKubernetesConfigBuilder> implements VisitableBuilder<OVNKubernetesConfig,OVNKubernetesConfigBuilder>{

  OVNKubernetesConfigFluent<?> fluent;

  public OVNKubernetesConfigBuilder() {
    this(new OVNKubernetesConfig());
  }
  
  public OVNKubernetesConfigBuilder(OVNKubernetesConfigFluent<?> fluent) {
    this(fluent, new OVNKubernetesConfig());
  }
  
  public OVNKubernetesConfigBuilder(OVNKubernetesConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OVNKubernetesConfigBuilder(OVNKubernetesConfigFluent<?> fluent,OVNKubernetesConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OVNKubernetesConfig build() {
    OVNKubernetesConfig buildable = new OVNKubernetesConfig(fluent.buildEgressIPConfig(), fluent.buildGatewayConfig(), fluent.getGenevePort(), fluent.buildHybridOverlayConfig(), fluent.buildIpsecConfig(), fluent.buildIpv4(), fluent.buildIpv6(), fluent.getMtu(), fluent.buildPolicyAuditConfig(), fluent.getRouteAdvertisements(), fluent.getV4InternalSubnet(), fluent.getV6InternalSubnet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}