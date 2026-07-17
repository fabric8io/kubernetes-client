package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class ClusterDeprovisionPlatformFluent<A extends io.fabric8.openshift.api.model.hive.v1.ClusterDeprovisionPlatformFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AWSClusterDeprovisionBuilder aws;
  private AzureClusterDeprovisionBuilder azure;
  private GCPClusterDeprovisionBuilder gcp;
  private IBMClusterDeprovisionBuilder ibmcloud;
  private OpenStackClusterDeprovisionBuilder openstack;
  private OvirtClusterDeprovisionBuilder ovirt;
  private VSphereClusterDeprovisionBuilder vsphere;

  public ClusterDeprovisionPlatformFluent() {
  }
  
  public ClusterDeprovisionPlatformFluent(ClusterDeprovisionPlatform instance) {
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
  
  public AWSClusterDeprovision buildAws() {
    return this.aws != null ? this.aws.build() : null;
  }
  
  public AzureClusterDeprovision buildAzure() {
    return this.azure != null ? this.azure.build() : null;
  }
  
  public GCPClusterDeprovision buildGcp() {
    return this.gcp != null ? this.gcp.build() : null;
  }
  
  public IBMClusterDeprovision buildIbmcloud() {
    return this.ibmcloud != null ? this.ibmcloud.build() : null;
  }
  
  public OpenStackClusterDeprovision buildOpenstack() {
    return this.openstack != null ? this.openstack.build() : null;
  }
  
  public OvirtClusterDeprovision buildOvirt() {
    return this.ovirt != null ? this.ovirt.build() : null;
  }
  
  public VSphereClusterDeprovision buildVsphere() {
    return this.vsphere != null ? this.vsphere.build() : null;
  }
  
  protected void copyInstance(ClusterDeprovisionPlatform instance) {
    instance = instance != null ? instance : new ClusterDeprovisionPlatform();
    if (instance != null) {
        this.withAws(instance.getAws());
        this.withAzure(instance.getAzure());
        this.withGcp(instance.getGcp());
        this.withIbmcloud(instance.getIbmcloud());
        this.withOpenstack(instance.getOpenstack());
        this.withOvirt(instance.getOvirt());
        this.withVsphere(instance.getVsphere());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AwsNested<A> editAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(null));
  }
  
  public AzureNested<A> editAzure() {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(null));
  }
  
  public GcpNested<A> editGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(null));
  }
  
  public IbmcloudNested<A> editIbmcloud() {
    return this.withNewIbmcloudLike(Optional.ofNullable(this.buildIbmcloud()).orElse(null));
  }
  
  public OpenstackNested<A> editOpenstack() {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(null));
  }
  
  public AwsNested<A> editOrNewAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(new AWSClusterDeprovisionBuilder().build()));
  }
  
  public AwsNested<A> editOrNewAwsLike(AWSClusterDeprovision item) {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(item));
  }
  
  public AzureNested<A> editOrNewAzure() {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(new AzureClusterDeprovisionBuilder().build()));
  }
  
  public AzureNested<A> editOrNewAzureLike(AzureClusterDeprovision item) {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(item));
  }
  
  public GcpNested<A> editOrNewGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(new GCPClusterDeprovisionBuilder().build()));
  }
  
  public GcpNested<A> editOrNewGcpLike(GCPClusterDeprovision item) {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(item));
  }
  
  public IbmcloudNested<A> editOrNewIbmcloud() {
    return this.withNewIbmcloudLike(Optional.ofNullable(this.buildIbmcloud()).orElse(new IBMClusterDeprovisionBuilder().build()));
  }
  
  public IbmcloudNested<A> editOrNewIbmcloudLike(IBMClusterDeprovision item) {
    return this.withNewIbmcloudLike(Optional.ofNullable(this.buildIbmcloud()).orElse(item));
  }
  
  public OpenstackNested<A> editOrNewOpenstack() {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(new OpenStackClusterDeprovisionBuilder().build()));
  }
  
  public OpenstackNested<A> editOrNewOpenstackLike(OpenStackClusterDeprovision item) {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(item));
  }
  
  public OvirtNested<A> editOrNewOvirt() {
    return this.withNewOvirtLike(Optional.ofNullable(this.buildOvirt()).orElse(new OvirtClusterDeprovisionBuilder().build()));
  }
  
  public OvirtNested<A> editOrNewOvirtLike(OvirtClusterDeprovision item) {
    return this.withNewOvirtLike(Optional.ofNullable(this.buildOvirt()).orElse(item));
  }
  
  public VsphereNested<A> editOrNewVsphere() {
    return this.withNewVsphereLike(Optional.ofNullable(this.buildVsphere()).orElse(new VSphereClusterDeprovisionBuilder().build()));
  }
  
  public VsphereNested<A> editOrNewVsphereLike(VSphereClusterDeprovision item) {
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
    ClusterDeprovisionPlatformFluent that = (ClusterDeprovisionPlatformFluent) o;
    if (!(Objects.equals(aws, that.aws))) {
      return false;
    }
    if (!(Objects.equals(azure, that.azure))) {
      return false;
    }
    if (!(Objects.equals(gcp, that.gcp))) {
      return false;
    }
    if (!(Objects.equals(ibmcloud, that.ibmcloud))) {
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
  
  public boolean hasAws() {
    return this.aws != null;
  }
  
  public boolean hasAzure() {
    return this.azure != null;
  }
  
  public boolean hasGcp() {
    return this.gcp != null;
  }
  
  public boolean hasIbmcloud() {
    return this.ibmcloud != null;
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
    return Objects.hash(aws, azure, gcp, ibmcloud, openstack, ovirt, vsphere, additionalProperties);
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
  
  public A withAws(AWSClusterDeprovision aws) {
    this._visitables.remove("aws");
    if (aws != null) {
        this.aws = new AWSClusterDeprovisionBuilder(aws);
        this._visitables.get("aws").add(this.aws);
    } else {
        this.aws = null;
        this._visitables.get("aws").remove(this.aws);
    }
    return (A) this;
  }
  
  public A withAzure(AzureClusterDeprovision azure) {
    this._visitables.remove("azure");
    if (azure != null) {
        this.azure = new AzureClusterDeprovisionBuilder(azure);
        this._visitables.get("azure").add(this.azure);
    } else {
        this.azure = null;
        this._visitables.get("azure").remove(this.azure);
    }
    return (A) this;
  }
  
  public A withGcp(GCPClusterDeprovision gcp) {
    this._visitables.remove("gcp");
    if (gcp != null) {
        this.gcp = new GCPClusterDeprovisionBuilder(gcp);
        this._visitables.get("gcp").add(this.gcp);
    } else {
        this.gcp = null;
        this._visitables.get("gcp").remove(this.gcp);
    }
    return (A) this;
  }
  
  public A withIbmcloud(IBMClusterDeprovision ibmcloud) {
    this._visitables.remove("ibmcloud");
    if (ibmcloud != null) {
        this.ibmcloud = new IBMClusterDeprovisionBuilder(ibmcloud);
        this._visitables.get("ibmcloud").add(this.ibmcloud);
    } else {
        this.ibmcloud = null;
        this._visitables.get("ibmcloud").remove(this.ibmcloud);
    }
    return (A) this;
  }
  
  public AwsNested<A> withNewAws() {
    return new AwsNested(null);
  }
  
  public AwsNested<A> withNewAwsLike(AWSClusterDeprovision item) {
    return new AwsNested(item);
  }
  
  public AzureNested<A> withNewAzure() {
    return new AzureNested(null);
  }
  
  public AzureNested<A> withNewAzureLike(AzureClusterDeprovision item) {
    return new AzureNested(item);
  }
  
  public GcpNested<A> withNewGcp() {
    return new GcpNested(null);
  }
  
  public GcpNested<A> withNewGcpLike(GCPClusterDeprovision item) {
    return new GcpNested(item);
  }
  
  public IbmcloudNested<A> withNewIbmcloud() {
    return new IbmcloudNested(null);
  }
  
  public IbmcloudNested<A> withNewIbmcloudLike(IBMClusterDeprovision item) {
    return new IbmcloudNested(item);
  }
  
  public OpenstackNested<A> withNewOpenstack() {
    return new OpenstackNested(null);
  }
  
  public OpenstackNested<A> withNewOpenstackLike(OpenStackClusterDeprovision item) {
    return new OpenstackNested(item);
  }
  
  public OvirtNested<A> withNewOvirt() {
    return new OvirtNested(null);
  }
  
  public OvirtNested<A> withNewOvirtLike(OvirtClusterDeprovision item) {
    return new OvirtNested(item);
  }
  
  public VsphereNested<A> withNewVsphere() {
    return new VsphereNested(null);
  }
  
  public VsphereNested<A> withNewVsphereLike(VSphereClusterDeprovision item) {
    return new VsphereNested(item);
  }
  
  public A withOpenstack(OpenStackClusterDeprovision openstack) {
    this._visitables.remove("openstack");
    if (openstack != null) {
        this.openstack = new OpenStackClusterDeprovisionBuilder(openstack);
        this._visitables.get("openstack").add(this.openstack);
    } else {
        this.openstack = null;
        this._visitables.get("openstack").remove(this.openstack);
    }
    return (A) this;
  }
  
  public A withOvirt(OvirtClusterDeprovision ovirt) {
    this._visitables.remove("ovirt");
    if (ovirt != null) {
        this.ovirt = new OvirtClusterDeprovisionBuilder(ovirt);
        this._visitables.get("ovirt").add(this.ovirt);
    } else {
        this.ovirt = null;
        this._visitables.get("ovirt").remove(this.ovirt);
    }
    return (A) this;
  }
  
  public A withVsphere(VSphereClusterDeprovision vsphere) {
    this._visitables.remove("vsphere");
    if (vsphere != null) {
        this.vsphere = new VSphereClusterDeprovisionBuilder(vsphere);
        this._visitables.get("vsphere").add(this.vsphere);
    } else {
        this.vsphere = null;
        this._visitables.get("vsphere").remove(this.vsphere);
    }
    return (A) this;
  }
  public class AwsNested<N> extends AWSClusterDeprovisionFluent<AwsNested<N>> implements Nested<N>{
  
    AWSClusterDeprovisionBuilder builder;
  
    AwsNested(AWSClusterDeprovision item) {
      this.builder = new AWSClusterDeprovisionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeprovisionPlatformFluent.this.withAws(builder.build());
    }
    
    public N endAws() {
      return and();
    }
    
  }
  public class AzureNested<N> extends AzureClusterDeprovisionFluent<AzureNested<N>> implements Nested<N>{
  
    AzureClusterDeprovisionBuilder builder;
  
    AzureNested(AzureClusterDeprovision item) {
      this.builder = new AzureClusterDeprovisionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeprovisionPlatformFluent.this.withAzure(builder.build());
    }
    
    public N endAzure() {
      return and();
    }
    
  }
  public class GcpNested<N> extends GCPClusterDeprovisionFluent<GcpNested<N>> implements Nested<N>{
  
    GCPClusterDeprovisionBuilder builder;
  
    GcpNested(GCPClusterDeprovision item) {
      this.builder = new GCPClusterDeprovisionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeprovisionPlatformFluent.this.withGcp(builder.build());
    }
    
    public N endGcp() {
      return and();
    }
    
  }
  public class IbmcloudNested<N> extends IBMClusterDeprovisionFluent<IbmcloudNested<N>> implements Nested<N>{
  
    IBMClusterDeprovisionBuilder builder;
  
    IbmcloudNested(IBMClusterDeprovision item) {
      this.builder = new IBMClusterDeprovisionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeprovisionPlatformFluent.this.withIbmcloud(builder.build());
    }
    
    public N endIbmcloud() {
      return and();
    }
    
  }
  public class OpenstackNested<N> extends OpenStackClusterDeprovisionFluent<OpenstackNested<N>> implements Nested<N>{
  
    OpenStackClusterDeprovisionBuilder builder;
  
    OpenstackNested(OpenStackClusterDeprovision item) {
      this.builder = new OpenStackClusterDeprovisionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeprovisionPlatformFluent.this.withOpenstack(builder.build());
    }
    
    public N endOpenstack() {
      return and();
    }
    
  }
  public class OvirtNested<N> extends OvirtClusterDeprovisionFluent<OvirtNested<N>> implements Nested<N>{
  
    OvirtClusterDeprovisionBuilder builder;
  
    OvirtNested(OvirtClusterDeprovision item) {
      this.builder = new OvirtClusterDeprovisionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeprovisionPlatformFluent.this.withOvirt(builder.build());
    }
    
    public N endOvirt() {
      return and();
    }
    
  }
  public class VsphereNested<N> extends VSphereClusterDeprovisionFluent<VsphereNested<N>> implements Nested<N>{
  
    VSphereClusterDeprovisionBuilder builder;
  
    VsphereNested(VSphereClusterDeprovision item) {
      this.builder = new VSphereClusterDeprovisionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeprovisionPlatformFluent.this.withVsphere(builder.build());
    }
    
    public N endVsphere() {
      return and();
    }
    
  }
}