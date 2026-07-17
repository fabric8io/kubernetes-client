package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openshift.api.model.hive.agent.v1.BareMetalPlatform;
import io.fabric8.openshift.api.model.hive.agent.v1.BareMetalPlatformBuilder;
import io.fabric8.openshift.api.model.hive.agent.v1.BareMetalPlatformFluent;
import io.fabric8.openshift.api.model.hive.aws.v1.Platform;
import io.fabric8.openshift.api.model.hive.aws.v1.PlatformBuilder;
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
public class PlatformFluent<A extends io.fabric8.openshift.api.model.hive.v1.PlatformFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private BareMetalPlatformBuilder agentBareMetal;
  private PlatformBuilder aws;
  private io.fabric8.openshift.api.model.hive.azure.v1.PlatformBuilder azure;
  private io.fabric8.openshift.api.model.hive.baremetal.v1.PlatformBuilder baremetal;
  private io.fabric8.openshift.api.model.hive.gcp.v1.PlatformBuilder gcp;
  private io.fabric8.openshift.api.model.hive.ibmcloud.v1.PlatformBuilder ibmcloud;
  private io.fabric8.openshift.api.model.hive.none.v1.PlatformBuilder none;
  private io.fabric8.openshift.api.model.hive.openstack.v1.PlatformBuilder openstack;
  private io.fabric8.openshift.api.model.hive.ovirt.v1.PlatformBuilder ovirt;
  private io.fabric8.openshift.api.model.hive.vsphere.v1.PlatformBuilder vsphere;

  public PlatformFluent() {
  }
  
  public PlatformFluent(io.fabric8.openshift.api.model.hive.v1.Platform instance) {
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
  
  public BareMetalPlatform buildAgentBareMetal() {
    return this.agentBareMetal != null ? this.agentBareMetal.build() : null;
  }
  
  public Platform buildAws() {
    return this.aws != null ? this.aws.build() : null;
  }
  
  public io.fabric8.openshift.api.model.hive.azure.v1.Platform buildAzure() {
    return this.azure != null ? this.azure.build() : null;
  }
  
  public io.fabric8.openshift.api.model.hive.baremetal.v1.Platform buildBaremetal() {
    return this.baremetal != null ? this.baremetal.build() : null;
  }
  
  public io.fabric8.openshift.api.model.hive.gcp.v1.Platform buildGcp() {
    return this.gcp != null ? this.gcp.build() : null;
  }
  
  public io.fabric8.openshift.api.model.hive.ibmcloud.v1.Platform buildIbmcloud() {
    return this.ibmcloud != null ? this.ibmcloud.build() : null;
  }
  
  public io.fabric8.openshift.api.model.hive.none.v1.Platform buildNone() {
    return this.none != null ? this.none.build() : null;
  }
  
  public io.fabric8.openshift.api.model.hive.openstack.v1.Platform buildOpenstack() {
    return this.openstack != null ? this.openstack.build() : null;
  }
  
  public io.fabric8.openshift.api.model.hive.ovirt.v1.Platform buildOvirt() {
    return this.ovirt != null ? this.ovirt.build() : null;
  }
  
  public io.fabric8.openshift.api.model.hive.vsphere.v1.Platform buildVsphere() {
    return this.vsphere != null ? this.vsphere.build() : null;
  }
  
  protected void copyInstance(io.fabric8.openshift.api.model.hive.v1.Platform instance) {
    instance = instance != null ? instance : new io.fabric8.openshift.api.model.hive.v1.Platform();
    if (instance != null) {
        this.withAgentBareMetal(instance.getAgentBareMetal());
        this.withAws(instance.getAws());
        this.withAzure(instance.getAzure());
        this.withBaremetal(instance.getBaremetal());
        this.withGcp(instance.getGcp());
        this.withIbmcloud(instance.getIbmcloud());
        this.withNone(instance.getNone());
        this.withOpenstack(instance.getOpenstack());
        this.withOvirt(instance.getOvirt());
        this.withVsphere(instance.getVsphere());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AgentBareMetalNested<A> editAgentBareMetal() {
    return this.withNewAgentBareMetalLike(Optional.ofNullable(this.buildAgentBareMetal()).orElse(null));
  }
  
  public AwsNested<A> editAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(null));
  }
  
  public AzureNested<A> editAzure() {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(null));
  }
  
  public BaremetalNested<A> editBaremetal() {
    return this.withNewBaremetalLike(Optional.ofNullable(this.buildBaremetal()).orElse(null));
  }
  
  public GcpNested<A> editGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(null));
  }
  
  public IbmcloudNested<A> editIbmcloud() {
    return this.withNewIbmcloudLike(Optional.ofNullable(this.buildIbmcloud()).orElse(null));
  }
  
  public NoneNested<A> editNone() {
    return this.withNewNoneLike(Optional.ofNullable(this.buildNone()).orElse(null));
  }
  
  public OpenstackNested<A> editOpenstack() {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(null));
  }
  
  public AgentBareMetalNested<A> editOrNewAgentBareMetal() {
    return this.withNewAgentBareMetalLike(Optional.ofNullable(this.buildAgentBareMetal()).orElse(new BareMetalPlatformBuilder().build()));
  }
  
  public AgentBareMetalNested<A> editOrNewAgentBareMetalLike(BareMetalPlatform item) {
    return this.withNewAgentBareMetalLike(Optional.ofNullable(this.buildAgentBareMetal()).orElse(item));
  }
  
  public AwsNested<A> editOrNewAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(new PlatformBuilder().build()));
  }
  
  public AwsNested<A> editOrNewAwsLike(Platform item) {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(item));
  }
  
  public AzureNested<A> editOrNewAzure() {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(new io.fabric8.openshift.api.model.hive.azure.v1.PlatformBuilder().build()));
  }
  
  public AzureNested<A> editOrNewAzureLike(io.fabric8.openshift.api.model.hive.azure.v1.Platform item) {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(item));
  }
  
  public BaremetalNested<A> editOrNewBaremetal() {
    return this.withNewBaremetalLike(Optional.ofNullable(this.buildBaremetal()).orElse(new io.fabric8.openshift.api.model.hive.baremetal.v1.PlatformBuilder().build()));
  }
  
  public BaremetalNested<A> editOrNewBaremetalLike(io.fabric8.openshift.api.model.hive.baremetal.v1.Platform item) {
    return this.withNewBaremetalLike(Optional.ofNullable(this.buildBaremetal()).orElse(item));
  }
  
  public GcpNested<A> editOrNewGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(new io.fabric8.openshift.api.model.hive.gcp.v1.PlatformBuilder().build()));
  }
  
  public GcpNested<A> editOrNewGcpLike(io.fabric8.openshift.api.model.hive.gcp.v1.Platform item) {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(item));
  }
  
  public IbmcloudNested<A> editOrNewIbmcloud() {
    return this.withNewIbmcloudLike(Optional.ofNullable(this.buildIbmcloud()).orElse(new io.fabric8.openshift.api.model.hive.ibmcloud.v1.PlatformBuilder().build()));
  }
  
  public IbmcloudNested<A> editOrNewIbmcloudLike(io.fabric8.openshift.api.model.hive.ibmcloud.v1.Platform item) {
    return this.withNewIbmcloudLike(Optional.ofNullable(this.buildIbmcloud()).orElse(item));
  }
  
  public NoneNested<A> editOrNewNone() {
    return this.withNewNoneLike(Optional.ofNullable(this.buildNone()).orElse(new io.fabric8.openshift.api.model.hive.none.v1.PlatformBuilder().build()));
  }
  
  public NoneNested<A> editOrNewNoneLike(io.fabric8.openshift.api.model.hive.none.v1.Platform item) {
    return this.withNewNoneLike(Optional.ofNullable(this.buildNone()).orElse(item));
  }
  
  public OpenstackNested<A> editOrNewOpenstack() {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(new io.fabric8.openshift.api.model.hive.openstack.v1.PlatformBuilder().build()));
  }
  
  public OpenstackNested<A> editOrNewOpenstackLike(io.fabric8.openshift.api.model.hive.openstack.v1.Platform item) {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(item));
  }
  
  public OvirtNested<A> editOrNewOvirt() {
    return this.withNewOvirtLike(Optional.ofNullable(this.buildOvirt()).orElse(new io.fabric8.openshift.api.model.hive.ovirt.v1.PlatformBuilder().build()));
  }
  
  public OvirtNested<A> editOrNewOvirtLike(io.fabric8.openshift.api.model.hive.ovirt.v1.Platform item) {
    return this.withNewOvirtLike(Optional.ofNullable(this.buildOvirt()).orElse(item));
  }
  
  public VsphereNested<A> editOrNewVsphere() {
    return this.withNewVsphereLike(Optional.ofNullable(this.buildVsphere()).orElse(new io.fabric8.openshift.api.model.hive.vsphere.v1.PlatformBuilder().build()));
  }
  
  public VsphereNested<A> editOrNewVsphereLike(io.fabric8.openshift.api.model.hive.vsphere.v1.Platform item) {
    return this.withNewVsphereLike(Optional.ofNullable(this.buildVsphere()).orElse(item));
  }
  
  public OvirtNested<A> editOvirt() {
    return this.withNewOvirtLike(Optional.ofNullable(this.buildOvirt()).orElse(null));
  }
  
  public VsphereNested<A> editVsphere() {
    return this.withNewVsphereLike(Optional.ofNullable(this.buildVsphere()).orElse(null));
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
    PlatformFluent that = (PlatformFluent) o;
    if (!(Objects.equals(agentBareMetal, that.agentBareMetal))) {
      return false;
    }
    if (!(Objects.equals(aws, that.aws))) {
      return false;
    }
    if (!(Objects.equals(azure, that.azure))) {
      return false;
    }
    if (!(Objects.equals(baremetal, that.baremetal))) {
      return false;
    }
    if (!(Objects.equals(gcp, that.gcp))) {
      return false;
    }
    if (!(Objects.equals(ibmcloud, that.ibmcloud))) {
      return false;
    }
    if (!(Objects.equals(none, that.none))) {
      return false;
    }
    if (!(Objects.equals(openstack, that.openstack))) {
      return false;
    }
    if (!(Objects.equals(ovirt, that.ovirt))) {
      return false;
    }
    if (!(Objects.equals(vsphere, that.vsphere))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAgentBareMetal() {
    return this.agentBareMetal != null;
  }
  
  public boolean hasAws() {
    return this.aws != null;
  }
  
  public boolean hasAzure() {
    return this.azure != null;
  }
  
  public boolean hasBaremetal() {
    return this.baremetal != null;
  }
  
  public boolean hasGcp() {
    return this.gcp != null;
  }
  
  public boolean hasIbmcloud() {
    return this.ibmcloud != null;
  }
  
  public boolean hasNone() {
    return this.none != null;
  }
  
  public boolean hasOpenstack() {
    return this.openstack != null;
  }
  
  public boolean hasOvirt() {
    return this.ovirt != null;
  }
  
  public boolean hasVsphere() {
    return this.vsphere != null;
  }
  
  public int hashCode() {
    return Objects.hash(agentBareMetal, aws, azure, baremetal, gcp, ibmcloud, none, openstack, ovirt, vsphere, additionalProperties);
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
    if (!(agentBareMetal == null)) {
        sb.append("agentBareMetal:");
        sb.append(agentBareMetal);
        sb.append(",");
    }
    if (!(aws == null)) {
        sb.append("aws:");
        sb.append(aws);
        sb.append(",");
    }
    if (!(azure == null)) {
        sb.append("azure:");
        sb.append(azure);
        sb.append(",");
    }
    if (!(baremetal == null)) {
        sb.append("baremetal:");
        sb.append(baremetal);
        sb.append(",");
    }
    if (!(gcp == null)) {
        sb.append("gcp:");
        sb.append(gcp);
        sb.append(",");
    }
    if (!(ibmcloud == null)) {
        sb.append("ibmcloud:");
        sb.append(ibmcloud);
        sb.append(",");
    }
    if (!(none == null)) {
        sb.append("none:");
        sb.append(none);
        sb.append(",");
    }
    if (!(openstack == null)) {
        sb.append("openstack:");
        sb.append(openstack);
        sb.append(",");
    }
    if (!(ovirt == null)) {
        sb.append("ovirt:");
        sb.append(ovirt);
        sb.append(",");
    }
    if (!(vsphere == null)) {
        sb.append("vsphere:");
        sb.append(vsphere);
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
  
  public A withAgentBareMetal(BareMetalPlatform agentBareMetal) {
    this._visitables.remove("agentBareMetal");
    if (agentBareMetal != null) {
        this.agentBareMetal = new BareMetalPlatformBuilder(agentBareMetal);
        this._visitables.get("agentBareMetal").add(this.agentBareMetal);
    } else {
        this.agentBareMetal = null;
        this._visitables.get("agentBareMetal").remove(this.agentBareMetal);
    }
    return (A) this;
  }
  
  public A withAws(Platform aws) {
    this._visitables.remove("aws");
    if (aws != null) {
        this.aws = new PlatformBuilder(aws);
        this._visitables.get("aws").add(this.aws);
    } else {
        this.aws = null;
        this._visitables.get("aws").remove(this.aws);
    }
    return (A) this;
  }
  
  public A withAzure(io.fabric8.openshift.api.model.hive.azure.v1.Platform azure) {
    this._visitables.remove("azure");
    if (azure != null) {
        this.azure = new io.fabric8.openshift.api.model.hive.azure.v1.PlatformBuilder(azure);
        this._visitables.get("azure").add(this.azure);
    } else {
        this.azure = null;
        this._visitables.get("azure").remove(this.azure);
    }
    return (A) this;
  }
  
  public A withBaremetal(io.fabric8.openshift.api.model.hive.baremetal.v1.Platform baremetal) {
    this._visitables.remove("baremetal");
    if (baremetal != null) {
        this.baremetal = new io.fabric8.openshift.api.model.hive.baremetal.v1.PlatformBuilder(baremetal);
        this._visitables.get("baremetal").add(this.baremetal);
    } else {
        this.baremetal = null;
        this._visitables.get("baremetal").remove(this.baremetal);
    }
    return (A) this;
  }
  
  public A withGcp(io.fabric8.openshift.api.model.hive.gcp.v1.Platform gcp) {
    this._visitables.remove("gcp");
    if (gcp != null) {
        this.gcp = new io.fabric8.openshift.api.model.hive.gcp.v1.PlatformBuilder(gcp);
        this._visitables.get("gcp").add(this.gcp);
    } else {
        this.gcp = null;
        this._visitables.get("gcp").remove(this.gcp);
    }
    return (A) this;
  }
  
  public A withIbmcloud(io.fabric8.openshift.api.model.hive.ibmcloud.v1.Platform ibmcloud) {
    this._visitables.remove("ibmcloud");
    if (ibmcloud != null) {
        this.ibmcloud = new io.fabric8.openshift.api.model.hive.ibmcloud.v1.PlatformBuilder(ibmcloud);
        this._visitables.get("ibmcloud").add(this.ibmcloud);
    } else {
        this.ibmcloud = null;
        this._visitables.get("ibmcloud").remove(this.ibmcloud);
    }
    return (A) this;
  }
  
  public AgentBareMetalNested<A> withNewAgentBareMetal() {
    return new AgentBareMetalNested(null);
  }
  
  public AgentBareMetalNested<A> withNewAgentBareMetalLike(BareMetalPlatform item) {
    return new AgentBareMetalNested(item);
  }
  
  public AwsNested<A> withNewAws() {
    return new AwsNested(null);
  }
  
  public AwsNested<A> withNewAwsLike(Platform item) {
    return new AwsNested(item);
  }
  
  public AzureNested<A> withNewAzure() {
    return new AzureNested(null);
  }
  
  public AzureNested<A> withNewAzureLike(io.fabric8.openshift.api.model.hive.azure.v1.Platform item) {
    return new AzureNested(item);
  }
  
  public BaremetalNested<A> withNewBaremetal() {
    return new BaremetalNested(null);
  }
  
  public BaremetalNested<A> withNewBaremetalLike(io.fabric8.openshift.api.model.hive.baremetal.v1.Platform item) {
    return new BaremetalNested(item);
  }
  
  public GcpNested<A> withNewGcp() {
    return new GcpNested(null);
  }
  
  public GcpNested<A> withNewGcpLike(io.fabric8.openshift.api.model.hive.gcp.v1.Platform item) {
    return new GcpNested(item);
  }
  
  public IbmcloudNested<A> withNewIbmcloud() {
    return new IbmcloudNested(null);
  }
  
  public IbmcloudNested<A> withNewIbmcloudLike(io.fabric8.openshift.api.model.hive.ibmcloud.v1.Platform item) {
    return new IbmcloudNested(item);
  }
  
  public NoneNested<A> withNewNone() {
    return new NoneNested(null);
  }
  
  public NoneNested<A> withNewNoneLike(io.fabric8.openshift.api.model.hive.none.v1.Platform item) {
    return new NoneNested(item);
  }
  
  public OpenstackNested<A> withNewOpenstack() {
    return new OpenstackNested(null);
  }
  
  public OpenstackNested<A> withNewOpenstackLike(io.fabric8.openshift.api.model.hive.openstack.v1.Platform item) {
    return new OpenstackNested(item);
  }
  
  public OvirtNested<A> withNewOvirt() {
    return new OvirtNested(null);
  }
  
  public OvirtNested<A> withNewOvirtLike(io.fabric8.openshift.api.model.hive.ovirt.v1.Platform item) {
    return new OvirtNested(item);
  }
  
  public VsphereNested<A> withNewVsphere() {
    return new VsphereNested(null);
  }
  
  public VsphereNested<A> withNewVsphereLike(io.fabric8.openshift.api.model.hive.vsphere.v1.Platform item) {
    return new VsphereNested(item);
  }
  
  public A withNone(io.fabric8.openshift.api.model.hive.none.v1.Platform none) {
    this._visitables.remove("none");
    if (none != null) {
        this.none = new io.fabric8.openshift.api.model.hive.none.v1.PlatformBuilder(none);
        this._visitables.get("none").add(this.none);
    } else {
        this.none = null;
        this._visitables.get("none").remove(this.none);
    }
    return (A) this;
  }
  
  public A withOpenstack(io.fabric8.openshift.api.model.hive.openstack.v1.Platform openstack) {
    this._visitables.remove("openstack");
    if (openstack != null) {
        this.openstack = new io.fabric8.openshift.api.model.hive.openstack.v1.PlatformBuilder(openstack);
        this._visitables.get("openstack").add(this.openstack);
    } else {
        this.openstack = null;
        this._visitables.get("openstack").remove(this.openstack);
    }
    return (A) this;
  }
  
  public A withOvirt(io.fabric8.openshift.api.model.hive.ovirt.v1.Platform ovirt) {
    this._visitables.remove("ovirt");
    if (ovirt != null) {
        this.ovirt = new io.fabric8.openshift.api.model.hive.ovirt.v1.PlatformBuilder(ovirt);
        this._visitables.get("ovirt").add(this.ovirt);
    } else {
        this.ovirt = null;
        this._visitables.get("ovirt").remove(this.ovirt);
    }
    return (A) this;
  }
  
  public A withVsphere(io.fabric8.openshift.api.model.hive.vsphere.v1.Platform vsphere) {
    this._visitables.remove("vsphere");
    if (vsphere != null) {
        this.vsphere = new io.fabric8.openshift.api.model.hive.vsphere.v1.PlatformBuilder(vsphere);
        this._visitables.get("vsphere").add(this.vsphere);
    } else {
        this.vsphere = null;
        this._visitables.get("vsphere").remove(this.vsphere);
    }
    return (A) this;
  }
  public class AgentBareMetalNested<N> extends BareMetalPlatformFluent<AgentBareMetalNested<N>> implements Nested<N>{
  
    BareMetalPlatformBuilder builder;
  
    AgentBareMetalNested(BareMetalPlatform item) {
      this.builder = new BareMetalPlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withAgentBareMetal(builder.build());
    }
    
    public N endAgentBareMetal() {
      return and();
    }
    
  }
  public class AwsNested<N> extends io.fabric8.openshift.api.model.hive.aws.v1.PlatformFluent<AwsNested<N>> implements Nested<N>{
  
    PlatformBuilder builder;
  
    AwsNested(Platform item) {
      this.builder = new PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withAws(builder.build());
    }
    
    public N endAws() {
      return and();
    }
    
  }
  public class AzureNested<N> extends io.fabric8.openshift.api.model.hive.azure.v1.PlatformFluent<AzureNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.hive.azure.v1.PlatformBuilder builder;
  
    AzureNested(io.fabric8.openshift.api.model.hive.azure.v1.Platform item) {
      this.builder = new io.fabric8.openshift.api.model.hive.azure.v1.PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withAzure(builder.build());
    }
    
    public N endAzure() {
      return and();
    }
    
  }
  public class BaremetalNested<N> extends io.fabric8.openshift.api.model.hive.baremetal.v1.PlatformFluent<BaremetalNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.hive.baremetal.v1.PlatformBuilder builder;
  
    BaremetalNested(io.fabric8.openshift.api.model.hive.baremetal.v1.Platform item) {
      this.builder = new io.fabric8.openshift.api.model.hive.baremetal.v1.PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withBaremetal(builder.build());
    }
    
    public N endBaremetal() {
      return and();
    }
    
  }
  public class GcpNested<N> extends io.fabric8.openshift.api.model.hive.gcp.v1.PlatformFluent<GcpNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.hive.gcp.v1.PlatformBuilder builder;
  
    GcpNested(io.fabric8.openshift.api.model.hive.gcp.v1.Platform item) {
      this.builder = new io.fabric8.openshift.api.model.hive.gcp.v1.PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withGcp(builder.build());
    }
    
    public N endGcp() {
      return and();
    }
    
  }
  public class IbmcloudNested<N> extends io.fabric8.openshift.api.model.hive.ibmcloud.v1.PlatformFluent<IbmcloudNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.hive.ibmcloud.v1.PlatformBuilder builder;
  
    IbmcloudNested(io.fabric8.openshift.api.model.hive.ibmcloud.v1.Platform item) {
      this.builder = new io.fabric8.openshift.api.model.hive.ibmcloud.v1.PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withIbmcloud(builder.build());
    }
    
    public N endIbmcloud() {
      return and();
    }
    
  }
  public class NoneNested<N> extends io.fabric8.openshift.api.model.hive.none.v1.PlatformFluent<NoneNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.hive.none.v1.PlatformBuilder builder;
  
    NoneNested(io.fabric8.openshift.api.model.hive.none.v1.Platform item) {
      this.builder = new io.fabric8.openshift.api.model.hive.none.v1.PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withNone(builder.build());
    }
    
    public N endNone() {
      return and();
    }
    
  }
  public class OpenstackNested<N> extends io.fabric8.openshift.api.model.hive.openstack.v1.PlatformFluent<OpenstackNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.hive.openstack.v1.PlatformBuilder builder;
  
    OpenstackNested(io.fabric8.openshift.api.model.hive.openstack.v1.Platform item) {
      this.builder = new io.fabric8.openshift.api.model.hive.openstack.v1.PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withOpenstack(builder.build());
    }
    
    public N endOpenstack() {
      return and();
    }
    
  }
  public class OvirtNested<N> extends io.fabric8.openshift.api.model.hive.ovirt.v1.PlatformFluent<OvirtNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.hive.ovirt.v1.PlatformBuilder builder;
  
    OvirtNested(io.fabric8.openshift.api.model.hive.ovirt.v1.Platform item) {
      this.builder = new io.fabric8.openshift.api.model.hive.ovirt.v1.PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withOvirt(builder.build());
    }
    
    public N endOvirt() {
      return and();
    }
    
  }
  public class VsphereNested<N> extends io.fabric8.openshift.api.model.hive.vsphere.v1.PlatformFluent<VsphereNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.hive.vsphere.v1.PlatformBuilder builder;
  
    VsphereNested(io.fabric8.openshift.api.model.hive.vsphere.v1.Platform item) {
      this.builder = new io.fabric8.openshift.api.model.hive.vsphere.v1.PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withVsphere(builder.build());
    }
    
    public N endVsphere() {
      return and();
    }
    
  }
}