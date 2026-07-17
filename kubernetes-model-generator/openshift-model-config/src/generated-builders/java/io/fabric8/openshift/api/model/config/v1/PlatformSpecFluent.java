package io.fabric8.openshift.api.model.config.v1;

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
public class PlatformSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.PlatformSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AlibabaCloudPlatformSpecBuilder alibabaCloud;
  private AWSPlatformSpecBuilder aws;
  private AzurePlatformSpecBuilder azure;
  private BareMetalPlatformSpecBuilder baremetal;
  private EquinixMetalPlatformSpecBuilder equinixMetal;
  private ExternalPlatformSpecBuilder external;
  private GCPPlatformSpecBuilder gcp;
  private IBMCloudPlatformSpecBuilder ibmcloud;
  private KubevirtPlatformSpecBuilder kubevirt;
  private NutanixPlatformSpecBuilder nutanix;
  private OpenStackPlatformSpecBuilder openstack;
  private OvirtPlatformSpecBuilder ovirt;
  private PowerVSPlatformSpecBuilder powervs;
  private String type;
  private VSpherePlatformSpecBuilder vsphere;

  public PlatformSpecFluent() {
  }
  
  public PlatformSpecFluent(PlatformSpec instance) {
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
  
  public AlibabaCloudPlatformSpec buildAlibabaCloud() {
    return this.alibabaCloud != null ? this.alibabaCloud.build() : null;
  }
  
  public AWSPlatformSpec buildAws() {
    return this.aws != null ? this.aws.build() : null;
  }
  
  public AzurePlatformSpec buildAzure() {
    return this.azure != null ? this.azure.build() : null;
  }
  
  public BareMetalPlatformSpec buildBaremetal() {
    return this.baremetal != null ? this.baremetal.build() : null;
  }
  
  public EquinixMetalPlatformSpec buildEquinixMetal() {
    return this.equinixMetal != null ? this.equinixMetal.build() : null;
  }
  
  public ExternalPlatformSpec buildExternal() {
    return this.external != null ? this.external.build() : null;
  }
  
  public GCPPlatformSpec buildGcp() {
    return this.gcp != null ? this.gcp.build() : null;
  }
  
  public IBMCloudPlatformSpec buildIbmcloud() {
    return this.ibmcloud != null ? this.ibmcloud.build() : null;
  }
  
  public KubevirtPlatformSpec buildKubevirt() {
    return this.kubevirt != null ? this.kubevirt.build() : null;
  }
  
  public NutanixPlatformSpec buildNutanix() {
    return this.nutanix != null ? this.nutanix.build() : null;
  }
  
  public OpenStackPlatformSpec buildOpenstack() {
    return this.openstack != null ? this.openstack.build() : null;
  }
  
  public OvirtPlatformSpec buildOvirt() {
    return this.ovirt != null ? this.ovirt.build() : null;
  }
  
  public PowerVSPlatformSpec buildPowervs() {
    return this.powervs != null ? this.powervs.build() : null;
  }
  
  public VSpherePlatformSpec buildVsphere() {
    return this.vsphere != null ? this.vsphere.build() : null;
  }
  
  protected void copyInstance(PlatformSpec instance) {
    instance = instance != null ? instance : new PlatformSpec();
    if (instance != null) {
        this.withAlibabaCloud(instance.getAlibabaCloud());
        this.withAws(instance.getAws());
        this.withAzure(instance.getAzure());
        this.withBaremetal(instance.getBaremetal());
        this.withEquinixMetal(instance.getEquinixMetal());
        this.withExternal(instance.getExternal());
        this.withGcp(instance.getGcp());
        this.withIbmcloud(instance.getIbmcloud());
        this.withKubevirt(instance.getKubevirt());
        this.withNutanix(instance.getNutanix());
        this.withOpenstack(instance.getOpenstack());
        this.withOvirt(instance.getOvirt());
        this.withPowervs(instance.getPowervs());
        this.withType(instance.getType());
        this.withVsphere(instance.getVsphere());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AlibabaCloudNested<A> editAlibabaCloud() {
    return this.withNewAlibabaCloudLike(Optional.ofNullable(this.buildAlibabaCloud()).orElse(null));
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
  
  public EquinixMetalNested<A> editEquinixMetal() {
    return this.withNewEquinixMetalLike(Optional.ofNullable(this.buildEquinixMetal()).orElse(null));
  }
  
  public ExternalNested<A> editExternal() {
    return this.withNewExternalLike(Optional.ofNullable(this.buildExternal()).orElse(null));
  }
  
  public GcpNested<A> editGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(null));
  }
  
  public IbmcloudNested<A> editIbmcloud() {
    return this.withNewIbmcloudLike(Optional.ofNullable(this.buildIbmcloud()).orElse(null));
  }
  
  public KubevirtNested<A> editKubevirt() {
    return this.withNewKubevirtLike(Optional.ofNullable(this.buildKubevirt()).orElse(null));
  }
  
  public NutanixNested<A> editNutanix() {
    return this.withNewNutanixLike(Optional.ofNullable(this.buildNutanix()).orElse(null));
  }
  
  public OpenstackNested<A> editOpenstack() {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(null));
  }
  
  public AlibabaCloudNested<A> editOrNewAlibabaCloud() {
    return this.withNewAlibabaCloudLike(Optional.ofNullable(this.buildAlibabaCloud()).orElse(new AlibabaCloudPlatformSpecBuilder().build()));
  }
  
  public AlibabaCloudNested<A> editOrNewAlibabaCloudLike(AlibabaCloudPlatformSpec item) {
    return this.withNewAlibabaCloudLike(Optional.ofNullable(this.buildAlibabaCloud()).orElse(item));
  }
  
  public AwsNested<A> editOrNewAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(new AWSPlatformSpecBuilder().build()));
  }
  
  public AwsNested<A> editOrNewAwsLike(AWSPlatformSpec item) {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(item));
  }
  
  public AzureNested<A> editOrNewAzure() {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(new AzurePlatformSpecBuilder().build()));
  }
  
  public AzureNested<A> editOrNewAzureLike(AzurePlatformSpec item) {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(item));
  }
  
  public BaremetalNested<A> editOrNewBaremetal() {
    return this.withNewBaremetalLike(Optional.ofNullable(this.buildBaremetal()).orElse(new BareMetalPlatformSpecBuilder().build()));
  }
  
  public BaremetalNested<A> editOrNewBaremetalLike(BareMetalPlatformSpec item) {
    return this.withNewBaremetalLike(Optional.ofNullable(this.buildBaremetal()).orElse(item));
  }
  
  public EquinixMetalNested<A> editOrNewEquinixMetal() {
    return this.withNewEquinixMetalLike(Optional.ofNullable(this.buildEquinixMetal()).orElse(new EquinixMetalPlatformSpecBuilder().build()));
  }
  
  public EquinixMetalNested<A> editOrNewEquinixMetalLike(EquinixMetalPlatformSpec item) {
    return this.withNewEquinixMetalLike(Optional.ofNullable(this.buildEquinixMetal()).orElse(item));
  }
  
  public ExternalNested<A> editOrNewExternal() {
    return this.withNewExternalLike(Optional.ofNullable(this.buildExternal()).orElse(new ExternalPlatformSpecBuilder().build()));
  }
  
  public ExternalNested<A> editOrNewExternalLike(ExternalPlatformSpec item) {
    return this.withNewExternalLike(Optional.ofNullable(this.buildExternal()).orElse(item));
  }
  
  public GcpNested<A> editOrNewGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(new GCPPlatformSpecBuilder().build()));
  }
  
  public GcpNested<A> editOrNewGcpLike(GCPPlatformSpec item) {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(item));
  }
  
  public IbmcloudNested<A> editOrNewIbmcloud() {
    return this.withNewIbmcloudLike(Optional.ofNullable(this.buildIbmcloud()).orElse(new IBMCloudPlatformSpecBuilder().build()));
  }
  
  public IbmcloudNested<A> editOrNewIbmcloudLike(IBMCloudPlatformSpec item) {
    return this.withNewIbmcloudLike(Optional.ofNullable(this.buildIbmcloud()).orElse(item));
  }
  
  public KubevirtNested<A> editOrNewKubevirt() {
    return this.withNewKubevirtLike(Optional.ofNullable(this.buildKubevirt()).orElse(new KubevirtPlatformSpecBuilder().build()));
  }
  
  public KubevirtNested<A> editOrNewKubevirtLike(KubevirtPlatformSpec item) {
    return this.withNewKubevirtLike(Optional.ofNullable(this.buildKubevirt()).orElse(item));
  }
  
  public NutanixNested<A> editOrNewNutanix() {
    return this.withNewNutanixLike(Optional.ofNullable(this.buildNutanix()).orElse(new NutanixPlatformSpecBuilder().build()));
  }
  
  public NutanixNested<A> editOrNewNutanixLike(NutanixPlatformSpec item) {
    return this.withNewNutanixLike(Optional.ofNullable(this.buildNutanix()).orElse(item));
  }
  
  public OpenstackNested<A> editOrNewOpenstack() {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(new OpenStackPlatformSpecBuilder().build()));
  }
  
  public OpenstackNested<A> editOrNewOpenstackLike(OpenStackPlatformSpec item) {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(item));
  }
  
  public OvirtNested<A> editOrNewOvirt() {
    return this.withNewOvirtLike(Optional.ofNullable(this.buildOvirt()).orElse(new OvirtPlatformSpecBuilder().build()));
  }
  
  public OvirtNested<A> editOrNewOvirtLike(OvirtPlatformSpec item) {
    return this.withNewOvirtLike(Optional.ofNullable(this.buildOvirt()).orElse(item));
  }
  
  public PowervsNested<A> editOrNewPowervs() {
    return this.withNewPowervsLike(Optional.ofNullable(this.buildPowervs()).orElse(new PowerVSPlatformSpecBuilder().build()));
  }
  
  public PowervsNested<A> editOrNewPowervsLike(PowerVSPlatformSpec item) {
    return this.withNewPowervsLike(Optional.ofNullable(this.buildPowervs()).orElse(item));
  }
  
  public VsphereNested<A> editOrNewVsphere() {
    return this.withNewVsphereLike(Optional.ofNullable(this.buildVsphere()).orElse(new VSpherePlatformSpecBuilder().build()));
  }
  
  public VsphereNested<A> editOrNewVsphereLike(VSpherePlatformSpec item) {
    return this.withNewVsphereLike(Optional.ofNullable(this.buildVsphere()).orElse(item));
  }
  
  public OvirtNested<A> editOvirt() {
    return this.withNewOvirtLike(Optional.ofNullable(this.buildOvirt()).orElse(null));
  }
  
  public PowervsNested<A> editPowervs() {
    return this.withNewPowervsLike(Optional.ofNullable(this.buildPowervs()).orElse(null));
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
    PlatformSpecFluent that = (PlatformSpecFluent) o;
    if (!(Objects.equals(alibabaCloud, that.alibabaCloud))) {
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
    if (!(Objects.equals(equinixMetal, that.equinixMetal))) {
      return false;
    }
    if (!(Objects.equals(external, that.external))) {
      return false;
    }
    if (!(Objects.equals(gcp, that.gcp))) {
      return false;
    }
    if (!(Objects.equals(ibmcloud, that.ibmcloud))) {
      return false;
    }
    if (!(Objects.equals(kubevirt, that.kubevirt))) {
      return false;
    }
    if (!(Objects.equals(nutanix, that.nutanix))) {
      return false;
    }
    if (!(Objects.equals(openstack, that.openstack))) {
      return false;
    }
    if (!(Objects.equals(ovirt, that.ovirt))) {
      return false;
    }
    if (!(Objects.equals(powervs, that.powervs))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAlibabaCloud() {
    return this.alibabaCloud != null;
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
  
  public boolean hasEquinixMetal() {
    return this.equinixMetal != null;
  }
  
  public boolean hasExternal() {
    return this.external != null;
  }
  
  public boolean hasGcp() {
    return this.gcp != null;
  }
  
  public boolean hasIbmcloud() {
    return this.ibmcloud != null;
  }
  
  public boolean hasKubevirt() {
    return this.kubevirt != null;
  }
  
  public boolean hasNutanix() {
    return this.nutanix != null;
  }
  
  public boolean hasOpenstack() {
    return this.openstack != null;
  }
  
  public boolean hasOvirt() {
    return this.ovirt != null;
  }
  
  public boolean hasPowervs() {
    return this.powervs != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasVsphere() {
    return this.vsphere != null;
  }
  
  public int hashCode() {
    return Objects.hash(alibabaCloud, aws, azure, baremetal, equinixMetal, external, gcp, ibmcloud, kubevirt, nutanix, openstack, ovirt, powervs, type, vsphere, additionalProperties);
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
    if (!(alibabaCloud == null)) {
        sb.append("alibabaCloud:");
        sb.append(alibabaCloud);
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
    if (!(equinixMetal == null)) {
        sb.append("equinixMetal:");
        sb.append(equinixMetal);
        sb.append(",");
    }
    if (!(external == null)) {
        sb.append("external:");
        sb.append(external);
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
    if (!(kubevirt == null)) {
        sb.append("kubevirt:");
        sb.append(kubevirt);
        sb.append(",");
    }
    if (!(nutanix == null)) {
        sb.append("nutanix:");
        sb.append(nutanix);
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
    if (!(powervs == null)) {
        sb.append("powervs:");
        sb.append(powervs);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withAlibabaCloud(AlibabaCloudPlatformSpec alibabaCloud) {
    this._visitables.remove("alibabaCloud");
    if (alibabaCloud != null) {
        this.alibabaCloud = new AlibabaCloudPlatformSpecBuilder(alibabaCloud);
        this._visitables.get("alibabaCloud").add(this.alibabaCloud);
    } else {
        this.alibabaCloud = null;
        this._visitables.get("alibabaCloud").remove(this.alibabaCloud);
    }
    return (A) this;
  }
  
  public A withAws(AWSPlatformSpec aws) {
    this._visitables.remove("aws");
    if (aws != null) {
        this.aws = new AWSPlatformSpecBuilder(aws);
        this._visitables.get("aws").add(this.aws);
    } else {
        this.aws = null;
        this._visitables.get("aws").remove(this.aws);
    }
    return (A) this;
  }
  
  public A withAzure(AzurePlatformSpec azure) {
    this._visitables.remove("azure");
    if (azure != null) {
        this.azure = new AzurePlatformSpecBuilder(azure);
        this._visitables.get("azure").add(this.azure);
    } else {
        this.azure = null;
        this._visitables.get("azure").remove(this.azure);
    }
    return (A) this;
  }
  
  public A withBaremetal(BareMetalPlatformSpec baremetal) {
    this._visitables.remove("baremetal");
    if (baremetal != null) {
        this.baremetal = new BareMetalPlatformSpecBuilder(baremetal);
        this._visitables.get("baremetal").add(this.baremetal);
    } else {
        this.baremetal = null;
        this._visitables.get("baremetal").remove(this.baremetal);
    }
    return (A) this;
  }
  
  public A withEquinixMetal(EquinixMetalPlatformSpec equinixMetal) {
    this._visitables.remove("equinixMetal");
    if (equinixMetal != null) {
        this.equinixMetal = new EquinixMetalPlatformSpecBuilder(equinixMetal);
        this._visitables.get("equinixMetal").add(this.equinixMetal);
    } else {
        this.equinixMetal = null;
        this._visitables.get("equinixMetal").remove(this.equinixMetal);
    }
    return (A) this;
  }
  
  public A withExternal(ExternalPlatformSpec external) {
    this._visitables.remove("external");
    if (external != null) {
        this.external = new ExternalPlatformSpecBuilder(external);
        this._visitables.get("external").add(this.external);
    } else {
        this.external = null;
        this._visitables.get("external").remove(this.external);
    }
    return (A) this;
  }
  
  public A withGcp(GCPPlatformSpec gcp) {
    this._visitables.remove("gcp");
    if (gcp != null) {
        this.gcp = new GCPPlatformSpecBuilder(gcp);
        this._visitables.get("gcp").add(this.gcp);
    } else {
        this.gcp = null;
        this._visitables.get("gcp").remove(this.gcp);
    }
    return (A) this;
  }
  
  public A withIbmcloud(IBMCloudPlatformSpec ibmcloud) {
    this._visitables.remove("ibmcloud");
    if (ibmcloud != null) {
        this.ibmcloud = new IBMCloudPlatformSpecBuilder(ibmcloud);
        this._visitables.get("ibmcloud").add(this.ibmcloud);
    } else {
        this.ibmcloud = null;
        this._visitables.get("ibmcloud").remove(this.ibmcloud);
    }
    return (A) this;
  }
  
  public A withKubevirt(KubevirtPlatformSpec kubevirt) {
    this._visitables.remove("kubevirt");
    if (kubevirt != null) {
        this.kubevirt = new KubevirtPlatformSpecBuilder(kubevirt);
        this._visitables.get("kubevirt").add(this.kubevirt);
    } else {
        this.kubevirt = null;
        this._visitables.get("kubevirt").remove(this.kubevirt);
    }
    return (A) this;
  }
  
  public AlibabaCloudNested<A> withNewAlibabaCloud() {
    return new AlibabaCloudNested(null);
  }
  
  public AlibabaCloudNested<A> withNewAlibabaCloudLike(AlibabaCloudPlatformSpec item) {
    return new AlibabaCloudNested(item);
  }
  
  public AwsNested<A> withNewAws() {
    return new AwsNested(null);
  }
  
  public AwsNested<A> withNewAwsLike(AWSPlatformSpec item) {
    return new AwsNested(item);
  }
  
  public AzureNested<A> withNewAzure() {
    return new AzureNested(null);
  }
  
  public AzureNested<A> withNewAzureLike(AzurePlatformSpec item) {
    return new AzureNested(item);
  }
  
  public BaremetalNested<A> withNewBaremetal() {
    return new BaremetalNested(null);
  }
  
  public BaremetalNested<A> withNewBaremetalLike(BareMetalPlatformSpec item) {
    return new BaremetalNested(item);
  }
  
  public EquinixMetalNested<A> withNewEquinixMetal() {
    return new EquinixMetalNested(null);
  }
  
  public EquinixMetalNested<A> withNewEquinixMetalLike(EquinixMetalPlatformSpec item) {
    return new EquinixMetalNested(item);
  }
  
  public ExternalNested<A> withNewExternal() {
    return new ExternalNested(null);
  }
  
  public A withNewExternal(String platformName) {
    return (A) this.withExternal(new ExternalPlatformSpec(platformName));
  }
  
  public ExternalNested<A> withNewExternalLike(ExternalPlatformSpec item) {
    return new ExternalNested(item);
  }
  
  public GcpNested<A> withNewGcp() {
    return new GcpNested(null);
  }
  
  public GcpNested<A> withNewGcpLike(GCPPlatformSpec item) {
    return new GcpNested(item);
  }
  
  public IbmcloudNested<A> withNewIbmcloud() {
    return new IbmcloudNested(null);
  }
  
  public IbmcloudNested<A> withNewIbmcloudLike(IBMCloudPlatformSpec item) {
    return new IbmcloudNested(item);
  }
  
  public KubevirtNested<A> withNewKubevirt() {
    return new KubevirtNested(null);
  }
  
  public KubevirtNested<A> withNewKubevirtLike(KubevirtPlatformSpec item) {
    return new KubevirtNested(item);
  }
  
  public NutanixNested<A> withNewNutanix() {
    return new NutanixNested(null);
  }
  
  public NutanixNested<A> withNewNutanixLike(NutanixPlatformSpec item) {
    return new NutanixNested(item);
  }
  
  public OpenstackNested<A> withNewOpenstack() {
    return new OpenstackNested(null);
  }
  
  public OpenstackNested<A> withNewOpenstackLike(OpenStackPlatformSpec item) {
    return new OpenstackNested(item);
  }
  
  public OvirtNested<A> withNewOvirt() {
    return new OvirtNested(null);
  }
  
  public OvirtNested<A> withNewOvirtLike(OvirtPlatformSpec item) {
    return new OvirtNested(item);
  }
  
  public PowervsNested<A> withNewPowervs() {
    return new PowervsNested(null);
  }
  
  public PowervsNested<A> withNewPowervsLike(PowerVSPlatformSpec item) {
    return new PowervsNested(item);
  }
  
  public VsphereNested<A> withNewVsphere() {
    return new VsphereNested(null);
  }
  
  public VsphereNested<A> withNewVsphereLike(VSpherePlatformSpec item) {
    return new VsphereNested(item);
  }
  
  public A withNutanix(NutanixPlatformSpec nutanix) {
    this._visitables.remove("nutanix");
    if (nutanix != null) {
        this.nutanix = new NutanixPlatformSpecBuilder(nutanix);
        this._visitables.get("nutanix").add(this.nutanix);
    } else {
        this.nutanix = null;
        this._visitables.get("nutanix").remove(this.nutanix);
    }
    return (A) this;
  }
  
  public A withOpenstack(OpenStackPlatformSpec openstack) {
    this._visitables.remove("openstack");
    if (openstack != null) {
        this.openstack = new OpenStackPlatformSpecBuilder(openstack);
        this._visitables.get("openstack").add(this.openstack);
    } else {
        this.openstack = null;
        this._visitables.get("openstack").remove(this.openstack);
    }
    return (A) this;
  }
  
  public A withOvirt(OvirtPlatformSpec ovirt) {
    this._visitables.remove("ovirt");
    if (ovirt != null) {
        this.ovirt = new OvirtPlatformSpecBuilder(ovirt);
        this._visitables.get("ovirt").add(this.ovirt);
    } else {
        this.ovirt = null;
        this._visitables.get("ovirt").remove(this.ovirt);
    }
    return (A) this;
  }
  
  public A withPowervs(PowerVSPlatformSpec powervs) {
    this._visitables.remove("powervs");
    if (powervs != null) {
        this.powervs = new PowerVSPlatformSpecBuilder(powervs);
        this._visitables.get("powervs").add(this.powervs);
    } else {
        this.powervs = null;
        this._visitables.get("powervs").remove(this.powervs);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withVsphere(VSpherePlatformSpec vsphere) {
    this._visitables.remove("vsphere");
    if (vsphere != null) {
        this.vsphere = new VSpherePlatformSpecBuilder(vsphere);
        this._visitables.get("vsphere").add(this.vsphere);
    } else {
        this.vsphere = null;
        this._visitables.get("vsphere").remove(this.vsphere);
    }
    return (A) this;
  }
  public class AlibabaCloudNested<N> extends AlibabaCloudPlatformSpecFluent<AlibabaCloudNested<N>> implements Nested<N>{
  
    AlibabaCloudPlatformSpecBuilder builder;
  
    AlibabaCloudNested(AlibabaCloudPlatformSpec item) {
      this.builder = new AlibabaCloudPlatformSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformSpecFluent.this.withAlibabaCloud(builder.build());
    }
    
    public N endAlibabaCloud() {
      return and();
    }
    
  }
  public class AwsNested<N> extends AWSPlatformSpecFluent<AwsNested<N>> implements Nested<N>{
  
    AWSPlatformSpecBuilder builder;
  
    AwsNested(AWSPlatformSpec item) {
      this.builder = new AWSPlatformSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformSpecFluent.this.withAws(builder.build());
    }
    
    public N endAws() {
      return and();
    }
    
  }
  public class AzureNested<N> extends AzurePlatformSpecFluent<AzureNested<N>> implements Nested<N>{
  
    AzurePlatformSpecBuilder builder;
  
    AzureNested(AzurePlatformSpec item) {
      this.builder = new AzurePlatformSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformSpecFluent.this.withAzure(builder.build());
    }
    
    public N endAzure() {
      return and();
    }
    
  }
  public class BaremetalNested<N> extends BareMetalPlatformSpecFluent<BaremetalNested<N>> implements Nested<N>{
  
    BareMetalPlatformSpecBuilder builder;
  
    BaremetalNested(BareMetalPlatformSpec item) {
      this.builder = new BareMetalPlatformSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformSpecFluent.this.withBaremetal(builder.build());
    }
    
    public N endBaremetal() {
      return and();
    }
    
  }
  public class EquinixMetalNested<N> extends EquinixMetalPlatformSpecFluent<EquinixMetalNested<N>> implements Nested<N>{
  
    EquinixMetalPlatformSpecBuilder builder;
  
    EquinixMetalNested(EquinixMetalPlatformSpec item) {
      this.builder = new EquinixMetalPlatformSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformSpecFluent.this.withEquinixMetal(builder.build());
    }
    
    public N endEquinixMetal() {
      return and();
    }
    
  }
  public class ExternalNested<N> extends ExternalPlatformSpecFluent<ExternalNested<N>> implements Nested<N>{
  
    ExternalPlatformSpecBuilder builder;
  
    ExternalNested(ExternalPlatformSpec item) {
      this.builder = new ExternalPlatformSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformSpecFluent.this.withExternal(builder.build());
    }
    
    public N endExternal() {
      return and();
    }
    
  }
  public class GcpNested<N> extends GCPPlatformSpecFluent<GcpNested<N>> implements Nested<N>{
  
    GCPPlatformSpecBuilder builder;
  
    GcpNested(GCPPlatformSpec item) {
      this.builder = new GCPPlatformSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformSpecFluent.this.withGcp(builder.build());
    }
    
    public N endGcp() {
      return and();
    }
    
  }
  public class IbmcloudNested<N> extends IBMCloudPlatformSpecFluent<IbmcloudNested<N>> implements Nested<N>{
  
    IBMCloudPlatformSpecBuilder builder;
  
    IbmcloudNested(IBMCloudPlatformSpec item) {
      this.builder = new IBMCloudPlatformSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformSpecFluent.this.withIbmcloud(builder.build());
    }
    
    public N endIbmcloud() {
      return and();
    }
    
  }
  public class KubevirtNested<N> extends KubevirtPlatformSpecFluent<KubevirtNested<N>> implements Nested<N>{
  
    KubevirtPlatformSpecBuilder builder;
  
    KubevirtNested(KubevirtPlatformSpec item) {
      this.builder = new KubevirtPlatformSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformSpecFluent.this.withKubevirt(builder.build());
    }
    
    public N endKubevirt() {
      return and();
    }
    
  }
  public class NutanixNested<N> extends NutanixPlatformSpecFluent<NutanixNested<N>> implements Nested<N>{
  
    NutanixPlatformSpecBuilder builder;
  
    NutanixNested(NutanixPlatformSpec item) {
      this.builder = new NutanixPlatformSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformSpecFluent.this.withNutanix(builder.build());
    }
    
    public N endNutanix() {
      return and();
    }
    
  }
  public class OpenstackNested<N> extends OpenStackPlatformSpecFluent<OpenstackNested<N>> implements Nested<N>{
  
    OpenStackPlatformSpecBuilder builder;
  
    OpenstackNested(OpenStackPlatformSpec item) {
      this.builder = new OpenStackPlatformSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformSpecFluent.this.withOpenstack(builder.build());
    }
    
    public N endOpenstack() {
      return and();
    }
    
  }
  public class OvirtNested<N> extends OvirtPlatformSpecFluent<OvirtNested<N>> implements Nested<N>{
  
    OvirtPlatformSpecBuilder builder;
  
    OvirtNested(OvirtPlatformSpec item) {
      this.builder = new OvirtPlatformSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformSpecFluent.this.withOvirt(builder.build());
    }
    
    public N endOvirt() {
      return and();
    }
    
  }
  public class PowervsNested<N> extends PowerVSPlatformSpecFluent<PowervsNested<N>> implements Nested<N>{
  
    PowerVSPlatformSpecBuilder builder;
  
    PowervsNested(PowerVSPlatformSpec item) {
      this.builder = new PowerVSPlatformSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformSpecFluent.this.withPowervs(builder.build());
    }
    
    public N endPowervs() {
      return and();
    }
    
  }
  public class VsphereNested<N> extends VSpherePlatformSpecFluent<VsphereNested<N>> implements Nested<N>{
  
    VSpherePlatformSpecBuilder builder;
  
    VsphereNested(VSpherePlatformSpec item) {
      this.builder = new VSpherePlatformSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformSpecFluent.this.withVsphere(builder.build());
    }
    
    public N endVsphere() {
      return and();
    }
    
  }
}