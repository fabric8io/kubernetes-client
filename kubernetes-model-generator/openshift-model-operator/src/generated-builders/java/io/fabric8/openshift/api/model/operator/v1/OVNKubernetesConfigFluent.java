package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class OVNKubernetesConfigFluent<A extends io.fabric8.openshift.api.model.operator.v1.OVNKubernetesConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private EgressIPConfigBuilder egressIPConfig;
  private GatewayConfigBuilder gatewayConfig;
  private Long genevePort;
  private HybridOverlayConfigBuilder hybridOverlayConfig;
  private IPsecConfigBuilder ipsecConfig;
  private IPv4OVNKubernetesConfigBuilder ipv4;
  private IPv6OVNKubernetesConfigBuilder ipv6;
  private Long mtu;
  private PolicyAuditConfigBuilder policyAuditConfig;
  private String routeAdvertisements;
  private String v4InternalSubnet;
  private String v6InternalSubnet;

  public OVNKubernetesConfigFluent() {
  }
  
  public OVNKubernetesConfigFluent(OVNKubernetesConfig instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public EgressIPConfig buildEgressIPConfig() {
    return this.egressIPConfig != null ? this.egressIPConfig.build() : null;
  }
  
  public GatewayConfig buildGatewayConfig() {
    return this.gatewayConfig != null ? this.gatewayConfig.build() : null;
  }
  
  public HybridOverlayConfig buildHybridOverlayConfig() {
    return this.hybridOverlayConfig != null ? this.hybridOverlayConfig.build() : null;
  }
  
  public IPsecConfig buildIpsecConfig() {
    return this.ipsecConfig != null ? this.ipsecConfig.build() : null;
  }
  
  public IPv4OVNKubernetesConfig buildIpv4() {
    return this.ipv4 != null ? this.ipv4.build() : null;
  }
  
  public IPv6OVNKubernetesConfig buildIpv6() {
    return this.ipv6 != null ? this.ipv6.build() : null;
  }
  
  public PolicyAuditConfig buildPolicyAuditConfig() {
    return this.policyAuditConfig != null ? this.policyAuditConfig.build() : null;
  }
  
  protected void copyInstance(OVNKubernetesConfig instance) {
    instance = instance != null ? instance : new OVNKubernetesConfig();
    if (instance != null) {
        this.withEgressIPConfig(instance.getEgressIPConfig());
        this.withGatewayConfig(instance.getGatewayConfig());
        this.withGenevePort(instance.getGenevePort());
        this.withHybridOverlayConfig(instance.getHybridOverlayConfig());
        this.withIpsecConfig(instance.getIpsecConfig());
        this.withIpv4(instance.getIpv4());
        this.withIpv6(instance.getIpv6());
        this.withMtu(instance.getMtu());
        this.withPolicyAuditConfig(instance.getPolicyAuditConfig());
        this.withRouteAdvertisements(instance.getRouteAdvertisements());
        this.withV4InternalSubnet(instance.getV4InternalSubnet());
        this.withV6InternalSubnet(instance.getV6InternalSubnet());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EgressIPConfigNested<A> editEgressIPConfig() {
    return this.withNewEgressIPConfigLike(Optional.ofNullable(this.buildEgressIPConfig()).orElse(null));
  }
  
  public GatewayConfigNested<A> editGatewayConfig() {
    return this.withNewGatewayConfigLike(Optional.ofNullable(this.buildGatewayConfig()).orElse(null));
  }
  
  public HybridOverlayConfigNested<A> editHybridOverlayConfig() {
    return this.withNewHybridOverlayConfigLike(Optional.ofNullable(this.buildHybridOverlayConfig()).orElse(null));
  }
  
  public IpsecConfigNested<A> editIpsecConfig() {
    return this.withNewIpsecConfigLike(Optional.ofNullable(this.buildIpsecConfig()).orElse(null));
  }
  
  public Ipv4Nested<A> editIpv4() {
    return this.withNewIpv4Like(Optional.ofNullable(this.buildIpv4()).orElse(null));
  }
  
  public Ipv6Nested<A> editIpv6() {
    return this.withNewIpv6Like(Optional.ofNullable(this.buildIpv6()).orElse(null));
  }
  
  public EgressIPConfigNested<A> editOrNewEgressIPConfig() {
    return this.withNewEgressIPConfigLike(Optional.ofNullable(this.buildEgressIPConfig()).orElse(new EgressIPConfigBuilder().build()));
  }
  
  public EgressIPConfigNested<A> editOrNewEgressIPConfigLike(EgressIPConfig item) {
    return this.withNewEgressIPConfigLike(Optional.ofNullable(this.buildEgressIPConfig()).orElse(item));
  }
  
  public GatewayConfigNested<A> editOrNewGatewayConfig() {
    return this.withNewGatewayConfigLike(Optional.ofNullable(this.buildGatewayConfig()).orElse(new GatewayConfigBuilder().build()));
  }
  
  public GatewayConfigNested<A> editOrNewGatewayConfigLike(GatewayConfig item) {
    return this.withNewGatewayConfigLike(Optional.ofNullable(this.buildGatewayConfig()).orElse(item));
  }
  
  public HybridOverlayConfigNested<A> editOrNewHybridOverlayConfig() {
    return this.withNewHybridOverlayConfigLike(Optional.ofNullable(this.buildHybridOverlayConfig()).orElse(new HybridOverlayConfigBuilder().build()));
  }
  
  public HybridOverlayConfigNested<A> editOrNewHybridOverlayConfigLike(HybridOverlayConfig item) {
    return this.withNewHybridOverlayConfigLike(Optional.ofNullable(this.buildHybridOverlayConfig()).orElse(item));
  }
  
  public IpsecConfigNested<A> editOrNewIpsecConfig() {
    return this.withNewIpsecConfigLike(Optional.ofNullable(this.buildIpsecConfig()).orElse(new IPsecConfigBuilder().build()));
  }
  
  public IpsecConfigNested<A> editOrNewIpsecConfigLike(IPsecConfig item) {
    return this.withNewIpsecConfigLike(Optional.ofNullable(this.buildIpsecConfig()).orElse(item));
  }
  
  public Ipv4Nested<A> editOrNewIpv4() {
    return this.withNewIpv4Like(Optional.ofNullable(this.buildIpv4()).orElse(new IPv4OVNKubernetesConfigBuilder().build()));
  }
  
  public Ipv4Nested<A> editOrNewIpv4Like(IPv4OVNKubernetesConfig item) {
    return this.withNewIpv4Like(Optional.ofNullable(this.buildIpv4()).orElse(item));
  }
  
  public Ipv6Nested<A> editOrNewIpv6() {
    return this.withNewIpv6Like(Optional.ofNullable(this.buildIpv6()).orElse(new IPv6OVNKubernetesConfigBuilder().build()));
  }
  
  public Ipv6Nested<A> editOrNewIpv6Like(IPv6OVNKubernetesConfig item) {
    return this.withNewIpv6Like(Optional.ofNullable(this.buildIpv6()).orElse(item));
  }
  
  public PolicyAuditConfigNested<A> editOrNewPolicyAuditConfig() {
    return this.withNewPolicyAuditConfigLike(Optional.ofNullable(this.buildPolicyAuditConfig()).orElse(new PolicyAuditConfigBuilder().build()));
  }
  
  public PolicyAuditConfigNested<A> editOrNewPolicyAuditConfigLike(PolicyAuditConfig item) {
    return this.withNewPolicyAuditConfigLike(Optional.ofNullable(this.buildPolicyAuditConfig()).orElse(item));
  }
  
  public PolicyAuditConfigNested<A> editPolicyAuditConfig() {
    return this.withNewPolicyAuditConfigLike(Optional.ofNullable(this.buildPolicyAuditConfig()).orElse(null));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    OVNKubernetesConfigFluent that = (OVNKubernetesConfigFluent) o;
    if (!(Objects.equals(egressIPConfig, that.egressIPConfig))) {
      return false;
    }
    if (!(Objects.equals(gatewayConfig, that.gatewayConfig))) {
      return false;
    }
    if (!(Objects.equals(genevePort, that.genevePort))) {
      return false;
    }
    if (!(Objects.equals(hybridOverlayConfig, that.hybridOverlayConfig))) {
      return false;
    }
    if (!(Objects.equals(ipsecConfig, that.ipsecConfig))) {
      return false;
    }
    if (!(Objects.equals(ipv4, that.ipv4))) {
      return false;
    }
    if (!(Objects.equals(ipv6, that.ipv6))) {
      return false;
    }
    if (!(Objects.equals(mtu, that.mtu))) {
      return false;
    }
    if (!(Objects.equals(policyAuditConfig, that.policyAuditConfig))) {
      return false;
    }
    if (!(Objects.equals(routeAdvertisements, that.routeAdvertisements))) {
      return false;
    }
    if (!(Objects.equals(v4InternalSubnet, that.v4InternalSubnet))) {
      return false;
    }
    if (!(Objects.equals(v6InternalSubnet, that.v6InternalSubnet))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Long getGenevePort() {
    return this.genevePort;
  }
  
  public Long getMtu() {
    return this.mtu;
  }
  
  public String getRouteAdvertisements() {
    return this.routeAdvertisements;
  }
  
  public String getV4InternalSubnet() {
    return this.v4InternalSubnet;
  }
  
  public String getV6InternalSubnet() {
    return this.v6InternalSubnet;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEgressIPConfig() {
    return this.egressIPConfig != null;
  }
  
  public boolean hasGatewayConfig() {
    return this.gatewayConfig != null;
  }
  
  public boolean hasGenevePort() {
    return this.genevePort != null;
  }
  
  public boolean hasHybridOverlayConfig() {
    return this.hybridOverlayConfig != null;
  }
  
  public boolean hasIpsecConfig() {
    return this.ipsecConfig != null;
  }
  
  public boolean hasIpv4() {
    return this.ipv4 != null;
  }
  
  public boolean hasIpv6() {
    return this.ipv6 != null;
  }
  
  public boolean hasMtu() {
    return this.mtu != null;
  }
  
  public boolean hasPolicyAuditConfig() {
    return this.policyAuditConfig != null;
  }
  
  public boolean hasRouteAdvertisements() {
    return this.routeAdvertisements != null;
  }
  
  public boolean hasV4InternalSubnet() {
    return this.v4InternalSubnet != null;
  }
  
  public boolean hasV6InternalSubnet() {
    return this.v6InternalSubnet != null;
  }
  
  public int hashCode() {
    return Objects.hash(egressIPConfig, gatewayConfig, genevePort, hybridOverlayConfig, ipsecConfig, ipv4, ipv6, mtu, policyAuditConfig, routeAdvertisements, v4InternalSubnet, v6InternalSubnet, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(egressIPConfig == null)) {
        sb.append("egressIPConfig:");
        sb.append(egressIPConfig);
        sb.append(",");
    }
    if (!(gatewayConfig == null)) {
        sb.append("gatewayConfig:");
        sb.append(gatewayConfig);
        sb.append(",");
    }
    if (!(genevePort == null)) {
        sb.append("genevePort:");
        sb.append(genevePort);
        sb.append(",");
    }
    if (!(hybridOverlayConfig == null)) {
        sb.append("hybridOverlayConfig:");
        sb.append(hybridOverlayConfig);
        sb.append(",");
    }
    if (!(ipsecConfig == null)) {
        sb.append("ipsecConfig:");
        sb.append(ipsecConfig);
        sb.append(",");
    }
    if (!(ipv4 == null)) {
        sb.append("ipv4:");
        sb.append(ipv4);
        sb.append(",");
    }
    if (!(ipv6 == null)) {
        sb.append("ipv6:");
        sb.append(ipv6);
        sb.append(",");
    }
    if (!(mtu == null)) {
        sb.append("mtu:");
        sb.append(mtu);
        sb.append(",");
    }
    if (!(policyAuditConfig == null)) {
        sb.append("policyAuditConfig:");
        sb.append(policyAuditConfig);
        sb.append(",");
    }
    if (!(routeAdvertisements == null)) {
        sb.append("routeAdvertisements:");
        sb.append(routeAdvertisements);
        sb.append(",");
    }
    if (!(v4InternalSubnet == null)) {
        sb.append("v4InternalSubnet:");
        sb.append(v4InternalSubnet);
        sb.append(",");
    }
    if (!(v6InternalSubnet == null)) {
        sb.append("v6InternalSubnet:");
        sb.append(v6InternalSubnet);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withEgressIPConfig(EgressIPConfig egressIPConfig) {
    this._visitables.remove("egressIPConfig");
    if (egressIPConfig != null) {
        this.egressIPConfig = new EgressIPConfigBuilder(egressIPConfig);
        this._visitables.get("egressIPConfig").add(this.egressIPConfig);
    } else {
        this.egressIPConfig = null;
        this._visitables.get("egressIPConfig").remove(this.egressIPConfig);
    }
    return (A) this;
  }
  
  public A withGatewayConfig(GatewayConfig gatewayConfig) {
    this._visitables.remove("gatewayConfig");
    if (gatewayConfig != null) {
        this.gatewayConfig = new GatewayConfigBuilder(gatewayConfig);
        this._visitables.get("gatewayConfig").add(this.gatewayConfig);
    } else {
        this.gatewayConfig = null;
        this._visitables.get("gatewayConfig").remove(this.gatewayConfig);
    }
    return (A) this;
  }
  
  public A withGenevePort(Long genevePort) {
    this.genevePort = genevePort;
    return (A) this;
  }
  
  public A withHybridOverlayConfig(HybridOverlayConfig hybridOverlayConfig) {
    this._visitables.remove("hybridOverlayConfig");
    if (hybridOverlayConfig != null) {
        this.hybridOverlayConfig = new HybridOverlayConfigBuilder(hybridOverlayConfig);
        this._visitables.get("hybridOverlayConfig").add(this.hybridOverlayConfig);
    } else {
        this.hybridOverlayConfig = null;
        this._visitables.get("hybridOverlayConfig").remove(this.hybridOverlayConfig);
    }
    return (A) this;
  }
  
  public A withIpsecConfig(IPsecConfig ipsecConfig) {
    this._visitables.remove("ipsecConfig");
    if (ipsecConfig != null) {
        this.ipsecConfig = new IPsecConfigBuilder(ipsecConfig);
        this._visitables.get("ipsecConfig").add(this.ipsecConfig);
    } else {
        this.ipsecConfig = null;
        this._visitables.get("ipsecConfig").remove(this.ipsecConfig);
    }
    return (A) this;
  }
  
  public A withIpv4(IPv4OVNKubernetesConfig ipv4) {
    this._visitables.remove("ipv4");
    if (ipv4 != null) {
        this.ipv4 = new IPv4OVNKubernetesConfigBuilder(ipv4);
        this._visitables.get("ipv4").add(this.ipv4);
    } else {
        this.ipv4 = null;
        this._visitables.get("ipv4").remove(this.ipv4);
    }
    return (A) this;
  }
  
  public A withIpv6(IPv6OVNKubernetesConfig ipv6) {
    this._visitables.remove("ipv6");
    if (ipv6 != null) {
        this.ipv6 = new IPv6OVNKubernetesConfigBuilder(ipv6);
        this._visitables.get("ipv6").add(this.ipv6);
    } else {
        this.ipv6 = null;
        this._visitables.get("ipv6").remove(this.ipv6);
    }
    return (A) this;
  }
  
  public A withMtu(Long mtu) {
    this.mtu = mtu;
    return (A) this;
  }
  
  public EgressIPConfigNested<A> withNewEgressIPConfig() {
    return new EgressIPConfigNested(null);
  }
  
  public A withNewEgressIPConfig(Long reachabilityTotalTimeoutSeconds) {
    return (A) this.withEgressIPConfig(new EgressIPConfig(reachabilityTotalTimeoutSeconds));
  }
  
  public EgressIPConfigNested<A> withNewEgressIPConfigLike(EgressIPConfig item) {
    return new EgressIPConfigNested(item);
  }
  
  public GatewayConfigNested<A> withNewGatewayConfig() {
    return new GatewayConfigNested(null);
  }
  
  public GatewayConfigNested<A> withNewGatewayConfigLike(GatewayConfig item) {
    return new GatewayConfigNested(item);
  }
  
  public HybridOverlayConfigNested<A> withNewHybridOverlayConfig() {
    return new HybridOverlayConfigNested(null);
  }
  
  public HybridOverlayConfigNested<A> withNewHybridOverlayConfigLike(HybridOverlayConfig item) {
    return new HybridOverlayConfigNested(item);
  }
  
  public IpsecConfigNested<A> withNewIpsecConfig() {
    return new IpsecConfigNested(null);
  }
  
  public IpsecConfigNested<A> withNewIpsecConfigLike(IPsecConfig item) {
    return new IpsecConfigNested(item);
  }
  
  public Ipv4Nested<A> withNewIpv4() {
    return new Ipv4Nested(null);
  }
  
  public A withNewIpv4(String internalJoinSubnet,String internalTransitSwitchSubnet) {
    return (A) this.withIpv4(new IPv4OVNKubernetesConfig(internalJoinSubnet, internalTransitSwitchSubnet));
  }
  
  public Ipv4Nested<A> withNewIpv4Like(IPv4OVNKubernetesConfig item) {
    return new Ipv4Nested(item);
  }
  
  public Ipv6Nested<A> withNewIpv6() {
    return new Ipv6Nested(null);
  }
  
  public A withNewIpv6(String internalJoinSubnet,String internalTransitSwitchSubnet) {
    return (A) this.withIpv6(new IPv6OVNKubernetesConfig(internalJoinSubnet, internalTransitSwitchSubnet));
  }
  
  public Ipv6Nested<A> withNewIpv6Like(IPv6OVNKubernetesConfig item) {
    return new Ipv6Nested(item);
  }
  
  public PolicyAuditConfigNested<A> withNewPolicyAuditConfig() {
    return new PolicyAuditConfigNested(null);
  }
  
  public A withNewPolicyAuditConfig(String destination,Long maxFileSize,Integer maxLogFiles,Long rateLimit,String syslogFacility) {
    return (A) this.withPolicyAuditConfig(new PolicyAuditConfig(destination, maxFileSize, maxLogFiles, rateLimit, syslogFacility));
  }
  
  public PolicyAuditConfigNested<A> withNewPolicyAuditConfigLike(PolicyAuditConfig item) {
    return new PolicyAuditConfigNested(item);
  }
  
  public A withPolicyAuditConfig(PolicyAuditConfig policyAuditConfig) {
    this._visitables.remove("policyAuditConfig");
    if (policyAuditConfig != null) {
        this.policyAuditConfig = new PolicyAuditConfigBuilder(policyAuditConfig);
        this._visitables.get("policyAuditConfig").add(this.policyAuditConfig);
    } else {
        this.policyAuditConfig = null;
        this._visitables.get("policyAuditConfig").remove(this.policyAuditConfig);
    }
    return (A) this;
  }
  
  public A withRouteAdvertisements(String routeAdvertisements) {
    this.routeAdvertisements = routeAdvertisements;
    return (A) this;
  }
  
  public A withV4InternalSubnet(String v4InternalSubnet) {
    this.v4InternalSubnet = v4InternalSubnet;
    return (A) this;
  }
  
  public A withV6InternalSubnet(String v6InternalSubnet) {
    this.v6InternalSubnet = v6InternalSubnet;
    return (A) this;
  }
  public class EgressIPConfigNested<N> extends EgressIPConfigFluent<EgressIPConfigNested<N>> implements Nested<N>{
  
    EgressIPConfigBuilder builder;
  
    EgressIPConfigNested(EgressIPConfig item) {
      this.builder = new EgressIPConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) OVNKubernetesConfigFluent.this.withEgressIPConfig(builder.build());
    }
    
    public N endEgressIPConfig() {
      return and();
    }
    
  }
  public class GatewayConfigNested<N> extends GatewayConfigFluent<GatewayConfigNested<N>> implements Nested<N>{
  
    GatewayConfigBuilder builder;
  
    GatewayConfigNested(GatewayConfig item) {
      this.builder = new GatewayConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) OVNKubernetesConfigFluent.this.withGatewayConfig(builder.build());
    }
    
    public N endGatewayConfig() {
      return and();
    }
    
  }
  public class HybridOverlayConfigNested<N> extends HybridOverlayConfigFluent<HybridOverlayConfigNested<N>> implements Nested<N>{
  
    HybridOverlayConfigBuilder builder;
  
    HybridOverlayConfigNested(HybridOverlayConfig item) {
      this.builder = new HybridOverlayConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) OVNKubernetesConfigFluent.this.withHybridOverlayConfig(builder.build());
    }
    
    public N endHybridOverlayConfig() {
      return and();
    }
    
  }
  public class IpsecConfigNested<N> extends IPsecConfigFluent<IpsecConfigNested<N>> implements Nested<N>{
  
    IPsecConfigBuilder builder;
  
    IpsecConfigNested(IPsecConfig item) {
      this.builder = new IPsecConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) OVNKubernetesConfigFluent.this.withIpsecConfig(builder.build());
    }
    
    public N endIpsecConfig() {
      return and();
    }
    
  }
  public class Ipv4Nested<N> extends IPv4OVNKubernetesConfigFluent<Ipv4Nested<N>> implements Nested<N>{
  
    IPv4OVNKubernetesConfigBuilder builder;
  
    Ipv4Nested(IPv4OVNKubernetesConfig item) {
      this.builder = new IPv4OVNKubernetesConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) OVNKubernetesConfigFluent.this.withIpv4(builder.build());
    }
    
    public N endIpv4() {
      return and();
    }
    
  }
  public class Ipv6Nested<N> extends IPv6OVNKubernetesConfigFluent<Ipv6Nested<N>> implements Nested<N>{
  
    IPv6OVNKubernetesConfigBuilder builder;
  
    Ipv6Nested(IPv6OVNKubernetesConfig item) {
      this.builder = new IPv6OVNKubernetesConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) OVNKubernetesConfigFluent.this.withIpv6(builder.build());
    }
    
    public N endIpv6() {
      return and();
    }
    
  }
  public class PolicyAuditConfigNested<N> extends PolicyAuditConfigFluent<PolicyAuditConfigNested<N>> implements Nested<N>{
  
    PolicyAuditConfigBuilder builder;
  
    PolicyAuditConfigNested(PolicyAuditConfig item) {
      this.builder = new PolicyAuditConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) OVNKubernetesConfigFluent.this.withPolicyAuditConfig(builder.build());
    }
    
    public N endPolicyAuditConfig() {
      return and();
    }
    
  }
}