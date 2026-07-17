package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openshift.api.model.installer.aws.v1.Platform;
import io.fabric8.openshift.api.model.installer.aws.v1.PlatformBuilder;
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
public class PlatformFluent<A extends io.fabric8.openshift.api.model.installer.v1.PlatformFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private PlatformBuilder aws;
  private Object azure;
  private io.fabric8.openshift.api.model.installer.baremetal.v1.PlatformBuilder baremetal;
  private io.fabric8.openshift.api.model.installer.external.v1.PlatformBuilder external;
  private io.fabric8.openshift.api.model.installer.gcp.v1.PlatformBuilder gcp;
  private io.fabric8.openshift.api.model.installer.ibmcloud.v1.PlatformBuilder ibmcloud;
  private io.fabric8.openshift.api.model.installer.none.v1.PlatformBuilder none;
  private io.fabric8.openshift.api.model.installer.nutanix.v1.PlatformBuilder nutanix;
  private io.fabric8.openshift.api.model.installer.openstack.v1.PlatformBuilder openstack;
  private io.fabric8.openshift.api.model.installer.ovirt.v1.PlatformBuilder ovirt;
  private io.fabric8.openshift.api.model.installer.powervc.v1.PlatformBuilder powervc;
  private io.fabric8.openshift.api.model.installer.powervs.v1.PlatformBuilder powervs;
  private io.fabric8.openshift.api.model.installer.vsphere.v1.PlatformBuilder vsphere;

  public PlatformFluent() {
  }
  
  public PlatformFluent(io.fabric8.openshift.api.model.installer.v1.Platform instance) {
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
  
  public Platform buildAws() {
    return this.aws != null ? this.aws.build() : null;
  }
  
  public io.fabric8.openshift.api.model.installer.baremetal.v1.Platform buildBaremetal() {
    return this.baremetal != null ? this.baremetal.build() : null;
  }
  
  public io.fabric8.openshift.api.model.installer.external.v1.Platform buildExternal() {
    return this.external != null ? this.external.build() : null;
  }
  
  public io.fabric8.openshift.api.model.installer.gcp.v1.Platform buildGcp() {
    return this.gcp != null ? this.gcp.build() : null;
  }
  
  public io.fabric8.openshift.api.model.installer.ibmcloud.v1.Platform buildIbmcloud() {
    return this.ibmcloud != null ? this.ibmcloud.build() : null;
  }
  
  public io.fabric8.openshift.api.model.installer.none.v1.Platform buildNone() {
    return this.none != null ? this.none.build() : null;
  }
  
  public io.fabric8.openshift.api.model.installer.nutanix.v1.Platform buildNutanix() {
    return this.nutanix != null ? this.nutanix.build() : null;
  }
  
  public io.fabric8.openshift.api.model.installer.openstack.v1.Platform buildOpenstack() {
    return this.openstack != null ? this.openstack.build() : null;
  }
  
  public io.fabric8.openshift.api.model.installer.ovirt.v1.Platform buildOvirt() {
    return this.ovirt != null ? this.ovirt.build() : null;
  }
  
  public io.fabric8.openshift.api.model.installer.powervc.v1.Platform buildPowervc() {
    return this.powervc != null ? this.powervc.build() : null;
  }
  
  public io.fabric8.openshift.api.model.installer.powervs.v1.Platform buildPowervs() {
    return this.powervs != null ? this.powervs.build() : null;
  }
  
  public io.fabric8.openshift.api.model.installer.vsphere.v1.Platform buildVsphere() {
    return this.vsphere != null ? this.vsphere.build() : null;
  }
  
  protected void copyInstance(io.fabric8.openshift.api.model.installer.v1.Platform instance) {
    instance = instance != null ? instance : new io.fabric8.openshift.api.model.installer.v1.Platform();
    if (instance != null) {
        this.withAws(instance.getAws());
        this.withAzure(instance.getAzure());
        this.withBaremetal(instance.getBaremetal());
        this.withExternal(instance.getExternal());
        this.withGcp(instance.getGcp());
        this.withIbmcloud(instance.getIbmcloud());
        this.withNone(instance.getNone());
        this.withNutanix(instance.getNutanix());
        this.withOpenstack(instance.getOpenstack());
        this.withOvirt(instance.getOvirt());
        this.withPowervc(instance.getPowervc());
        this.withPowervs(instance.getPowervs());
        this.withVsphere(instance.getVsphere());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AwsNested<A> editAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(null));
  }
  
  public BaremetalNested<A> editBaremetal() {
    return this.withNewBaremetalLike(Optional.ofNullable(this.buildBaremetal()).orElse(null));
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
  
  public NoneNested<A> editNone() {
    return this.withNewNoneLike(Optional.ofNullable(this.buildNone()).orElse(null));
  }
  
  public NutanixNested<A> editNutanix() {
    return this.withNewNutanixLike(Optional.ofNullable(this.buildNutanix()).orElse(null));
  }
  
  public OpenstackNested<A> editOpenstack() {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(null));
  }
  
  public AwsNested<A> editOrNewAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(new PlatformBuilder().build()));
  }
  
  public AwsNested<A> editOrNewAwsLike(Platform item) {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(item));
  }
  
  public BaremetalNested<A> editOrNewBaremetal() {
    return this.withNewBaremetalLike(Optional.ofNullable(this.buildBaremetal()).orElse(new io.fabric8.openshift.api.model.installer.baremetal.v1.PlatformBuilder().build()));
  }
  
  public BaremetalNested<A> editOrNewBaremetalLike(io.fabric8.openshift.api.model.installer.baremetal.v1.Platform item) {
    return this.withNewBaremetalLike(Optional.ofNullable(this.buildBaremetal()).orElse(item));
  }
  
  public ExternalNested<A> editOrNewExternal() {
    return this.withNewExternalLike(Optional.ofNullable(this.buildExternal()).orElse(new io.fabric8.openshift.api.model.installer.external.v1.PlatformBuilder().build()));
  }
  
  public ExternalNested<A> editOrNewExternalLike(io.fabric8.openshift.api.model.installer.external.v1.Platform item) {
    return this.withNewExternalLike(Optional.ofNullable(this.buildExternal()).orElse(item));
  }
  
  public GcpNested<A> editOrNewGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(new io.fabric8.openshift.api.model.installer.gcp.v1.PlatformBuilder().build()));
  }
  
  public GcpNested<A> editOrNewGcpLike(io.fabric8.openshift.api.model.installer.gcp.v1.Platform item) {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(item));
  }
  
  public IbmcloudNested<A> editOrNewIbmcloud() {
    return this.withNewIbmcloudLike(Optional.ofNullable(this.buildIbmcloud()).orElse(new io.fabric8.openshift.api.model.installer.ibmcloud.v1.PlatformBuilder().build()));
  }
  
  public IbmcloudNested<A> editOrNewIbmcloudLike(io.fabric8.openshift.api.model.installer.ibmcloud.v1.Platform item) {
    return this.withNewIbmcloudLike(Optional.ofNullable(this.buildIbmcloud()).orElse(item));
  }
  
  public NoneNested<A> editOrNewNone() {
    return this.withNewNoneLike(Optional.ofNullable(this.buildNone()).orElse(new io.fabric8.openshift.api.model.installer.none.v1.PlatformBuilder().build()));
  }
  
  public NoneNested<A> editOrNewNoneLike(io.fabric8.openshift.api.model.installer.none.v1.Platform item) {
    return this.withNewNoneLike(Optional.ofNullable(this.buildNone()).orElse(item));
  }
  
  public NutanixNested<A> editOrNewNutanix() {
    return this.withNewNutanixLike(Optional.ofNullable(this.buildNutanix()).orElse(new io.fabric8.openshift.api.model.installer.nutanix.v1.PlatformBuilder().build()));
  }
  
  public NutanixNested<A> editOrNewNutanixLike(io.fabric8.openshift.api.model.installer.nutanix.v1.Platform item) {
    return this.withNewNutanixLike(Optional.ofNullable(this.buildNutanix()).orElse(item));
  }
  
  public OpenstackNested<A> editOrNewOpenstack() {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(new io.fabric8.openshift.api.model.installer.openstack.v1.PlatformBuilder().build()));
  }
  
  public OpenstackNested<A> editOrNewOpenstackLike(io.fabric8.openshift.api.model.installer.openstack.v1.Platform item) {
    return this.withNewOpenstackLike(Optional.ofNullable(this.buildOpenstack()).orElse(item));
  }
  
  public OvirtNested<A> editOrNewOvirt() {
    return this.withNewOvirtLike(Optional.ofNullable(this.buildOvirt()).orElse(new io.fabric8.openshift.api.model.installer.ovirt.v1.PlatformBuilder().build()));
  }
  
  public OvirtNested<A> editOrNewOvirtLike(io.fabric8.openshift.api.model.installer.ovirt.v1.Platform item) {
    return this.withNewOvirtLike(Optional.ofNullable(this.buildOvirt()).orElse(item));
  }
  
  public PowervcNested<A> editOrNewPowervc() {
    return this.withNewPowervcLike(Optional.ofNullable(this.buildPowervc()).orElse(new io.fabric8.openshift.api.model.installer.powervc.v1.PlatformBuilder().build()));
  }
  
  public PowervcNested<A> editOrNewPowervcLike(io.fabric8.openshift.api.model.installer.powervc.v1.Platform item) {
    return this.withNewPowervcLike(Optional.ofNullable(this.buildPowervc()).orElse(item));
  }
  
  public PowervsNested<A> editOrNewPowervs() {
    return this.withNewPowervsLike(Optional.ofNullable(this.buildPowervs()).orElse(new io.fabric8.openshift.api.model.installer.powervs.v1.PlatformBuilder().build()));
  }
  
  public PowervsNested<A> editOrNewPowervsLike(io.fabric8.openshift.api.model.installer.powervs.v1.Platform item) {
    return this.withNewPowervsLike(Optional.ofNullable(this.buildPowervs()).orElse(item));
  }
  
  public VsphereNested<A> editOrNewVsphere() {
    return this.withNewVsphereLike(Optional.ofNullable(this.buildVsphere()).orElse(new io.fabric8.openshift.api.model.installer.vsphere.v1.PlatformBuilder().build()));
  }
  
  public VsphereNested<A> editOrNewVsphereLike(io.fabric8.openshift.api.model.installer.vsphere.v1.Platform item) {
    return this.withNewVsphereLike(Optional.ofNullable(this.buildVsphere()).orElse(item));
  }
  
  public OvirtNested<A> editOvirt() {
    return this.withNewOvirtLike(Optional.ofNullable(this.buildOvirt()).orElse(null));
  }
  
  public PowervcNested<A> editPowervc() {
    return this.withNewPowervcLike(Optional.ofNullable(this.buildPowervc()).orElse(null));
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
    PlatformFluent that = (PlatformFluent) o;
    if (!(Objects.equals(aws, that.aws))) {
      return false;
    }
    if (!(Objects.equals(azure, that.azure))) {
      return false;
    }
    if (!(Objects.equals(baremetal, that.baremetal))) {
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
    if (!(Objects.equals(none, that.none))) {
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
    if (!(Objects.equals(powervc, that.powervc))) {
      return false;
    }
    if (!(Objects.equals(powervs, that.powervs))) {
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
  
  public Object getAzure() {
    return this.azure;
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
  
  public boolean hasBaremetal() {
    return this.baremetal != null;
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
  
  public boolean hasNone() {
    return this.none != null;
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
  
  public boolean hasPowervc() {
    return this.powervc != null;
  }
  
  public boolean hasPowervs() {
    return this.powervs != null;
  }
  
  public boolean hasVsphere() {
    return this.vsphere != null;
  }
  
  public int hashCode() {
    return Objects.hash(aws, azure, baremetal, external, gcp, ibmcloud, none, nutanix, openstack, ovirt, powervc, powervs, vsphere, additionalProperties);
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
    if (!(baremetal == null)) {
        sb.append("baremetal:");
        sb.append(baremetal);
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
    if (!(none == null)) {
        sb.append("none:");
        sb.append(none);
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
    if (!(powervc == null)) {
        sb.append("powervc:");
        sb.append(powervc);
        sb.append(",");
    }
    if (!(powervs == null)) {
        sb.append("powervs:");
        sb.append(powervs);
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
  
  public A withAzure(Object azure) {
    this.azure = azure;
    return (A) this;
  }
  
  public A withBaremetal(io.fabric8.openshift.api.model.installer.baremetal.v1.Platform baremetal) {
    this._visitables.remove("baremetal");
    if (baremetal != null) {
        this.baremetal = new io.fabric8.openshift.api.model.installer.baremetal.v1.PlatformBuilder(baremetal);
        this._visitables.get("baremetal").add(this.baremetal);
    } else {
        this.baremetal = null;
        this._visitables.get("baremetal").remove(this.baremetal);
    }
    return (A) this;
  }
  
  public A withExternal(io.fabric8.openshift.api.model.installer.external.v1.Platform external) {
    this._visitables.remove("external");
    if (external != null) {
        this.external = new io.fabric8.openshift.api.model.installer.external.v1.PlatformBuilder(external);
        this._visitables.get("external").add(this.external);
    } else {
        this.external = null;
        this._visitables.get("external").remove(this.external);
    }
    return (A) this;
  }
  
  public A withGcp(io.fabric8.openshift.api.model.installer.gcp.v1.Platform gcp) {
    this._visitables.remove("gcp");
    if (gcp != null) {
        this.gcp = new io.fabric8.openshift.api.model.installer.gcp.v1.PlatformBuilder(gcp);
        this._visitables.get("gcp").add(this.gcp);
    } else {
        this.gcp = null;
        this._visitables.get("gcp").remove(this.gcp);
    }
    return (A) this;
  }
  
  public A withIbmcloud(io.fabric8.openshift.api.model.installer.ibmcloud.v1.Platform ibmcloud) {
    this._visitables.remove("ibmcloud");
    if (ibmcloud != null) {
        this.ibmcloud = new io.fabric8.openshift.api.model.installer.ibmcloud.v1.PlatformBuilder(ibmcloud);
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
  
  public AwsNested<A> withNewAwsLike(Platform item) {
    return new AwsNested(item);
  }
  
  public BaremetalNested<A> withNewBaremetal() {
    return new BaremetalNested(null);
  }
  
  public BaremetalNested<A> withNewBaremetalLike(io.fabric8.openshift.api.model.installer.baremetal.v1.Platform item) {
    return new BaremetalNested(item);
  }
  
  public ExternalNested<A> withNewExternal() {
    return new ExternalNested(null);
  }
  
  public A withNewExternal(String cloudControllerManager,String platformName) {
    return (A) this.withExternal(new io.fabric8.openshift.api.model.installer.external.v1.Platform(cloudControllerManager, platformName));
  }
  
  public ExternalNested<A> withNewExternalLike(io.fabric8.openshift.api.model.installer.external.v1.Platform item) {
    return new ExternalNested(item);
  }
  
  public GcpNested<A> withNewGcp() {
    return new GcpNested(null);
  }
  
  public GcpNested<A> withNewGcpLike(io.fabric8.openshift.api.model.installer.gcp.v1.Platform item) {
    return new GcpNested(item);
  }
  
  public IbmcloudNested<A> withNewIbmcloud() {
    return new IbmcloudNested(null);
  }
  
  public IbmcloudNested<A> withNewIbmcloudLike(io.fabric8.openshift.api.model.installer.ibmcloud.v1.Platform item) {
    return new IbmcloudNested(item);
  }
  
  public NoneNested<A> withNewNone() {
    return new NoneNested(null);
  }
  
  public NoneNested<A> withNewNoneLike(io.fabric8.openshift.api.model.installer.none.v1.Platform item) {
    return new NoneNested(item);
  }
  
  public NutanixNested<A> withNewNutanix() {
    return new NutanixNested(null);
  }
  
  public NutanixNested<A> withNewNutanixLike(io.fabric8.openshift.api.model.installer.nutanix.v1.Platform item) {
    return new NutanixNested(item);
  }
  
  public OpenstackNested<A> withNewOpenstack() {
    return new OpenstackNested(null);
  }
  
  public OpenstackNested<A> withNewOpenstackLike(io.fabric8.openshift.api.model.installer.openstack.v1.Platform item) {
    return new OpenstackNested(item);
  }
  
  public OvirtNested<A> withNewOvirt() {
    return new OvirtNested(null);
  }
  
  public OvirtNested<A> withNewOvirtLike(io.fabric8.openshift.api.model.installer.ovirt.v1.Platform item) {
    return new OvirtNested(item);
  }
  
  public PowervcNested<A> withNewPowervc() {
    return new PowervcNested(null);
  }
  
  public PowervcNested<A> withNewPowervcLike(io.fabric8.openshift.api.model.installer.powervc.v1.Platform item) {
    return new PowervcNested(item);
  }
  
  public PowervsNested<A> withNewPowervs() {
    return new PowervsNested(null);
  }
  
  public PowervsNested<A> withNewPowervsLike(io.fabric8.openshift.api.model.installer.powervs.v1.Platform item) {
    return new PowervsNested(item);
  }
  
  public VsphereNested<A> withNewVsphere() {
    return new VsphereNested(null);
  }
  
  public VsphereNested<A> withNewVsphereLike(io.fabric8.openshift.api.model.installer.vsphere.v1.Platform item) {
    return new VsphereNested(item);
  }
  
  public A withNone(io.fabric8.openshift.api.model.installer.none.v1.Platform none) {
    this._visitables.remove("none");
    if (none != null) {
        this.none = new io.fabric8.openshift.api.model.installer.none.v1.PlatformBuilder(none);
        this._visitables.get("none").add(this.none);
    } else {
        this.none = null;
        this._visitables.get("none").remove(this.none);
    }
    return (A) this;
  }
  
  public A withNutanix(io.fabric8.openshift.api.model.installer.nutanix.v1.Platform nutanix) {
    this._visitables.remove("nutanix");
    if (nutanix != null) {
        this.nutanix = new io.fabric8.openshift.api.model.installer.nutanix.v1.PlatformBuilder(nutanix);
        this._visitables.get("nutanix").add(this.nutanix);
    } else {
        this.nutanix = null;
        this._visitables.get("nutanix").remove(this.nutanix);
    }
    return (A) this;
  }
  
  public A withOpenstack(io.fabric8.openshift.api.model.installer.openstack.v1.Platform openstack) {
    this._visitables.remove("openstack");
    if (openstack != null) {
        this.openstack = new io.fabric8.openshift.api.model.installer.openstack.v1.PlatformBuilder(openstack);
        this._visitables.get("openstack").add(this.openstack);
    } else {
        this.openstack = null;
        this._visitables.get("openstack").remove(this.openstack);
    }
    return (A) this;
  }
  
  public A withOvirt(io.fabric8.openshift.api.model.installer.ovirt.v1.Platform ovirt) {
    this._visitables.remove("ovirt");
    if (ovirt != null) {
        this.ovirt = new io.fabric8.openshift.api.model.installer.ovirt.v1.PlatformBuilder(ovirt);
        this._visitables.get("ovirt").add(this.ovirt);
    } else {
        this.ovirt = null;
        this._visitables.get("ovirt").remove(this.ovirt);
    }
    return (A) this;
  }
  
  public A withPowervc(io.fabric8.openshift.api.model.installer.powervc.v1.Platform powervc) {
    this._visitables.remove("powervc");
    if (powervc != null) {
        this.powervc = new io.fabric8.openshift.api.model.installer.powervc.v1.PlatformBuilder(powervc);
        this._visitables.get("powervc").add(this.powervc);
    } else {
        this.powervc = null;
        this._visitables.get("powervc").remove(this.powervc);
    }
    return (A) this;
  }
  
  public A withPowervs(io.fabric8.openshift.api.model.installer.powervs.v1.Platform powervs) {
    this._visitables.remove("powervs");
    if (powervs != null) {
        this.powervs = new io.fabric8.openshift.api.model.installer.powervs.v1.PlatformBuilder(powervs);
        this._visitables.get("powervs").add(this.powervs);
    } else {
        this.powervs = null;
        this._visitables.get("powervs").remove(this.powervs);
    }
    return (A) this;
  }
  
  public A withVsphere(io.fabric8.openshift.api.model.installer.vsphere.v1.Platform vsphere) {
    this._visitables.remove("vsphere");
    if (vsphere != null) {
        this.vsphere = new io.fabric8.openshift.api.model.installer.vsphere.v1.PlatformBuilder(vsphere);
        this._visitables.get("vsphere").add(this.vsphere);
    } else {
        this.vsphere = null;
        this._visitables.get("vsphere").remove(this.vsphere);
    }
    return (A) this;
  }
  public class AwsNested<N> extends io.fabric8.openshift.api.model.installer.aws.v1.PlatformFluent<AwsNested<N>> implements Nested<N>{
  
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
  public class BaremetalNested<N> extends io.fabric8.openshift.api.model.installer.baremetal.v1.PlatformFluent<BaremetalNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.installer.baremetal.v1.PlatformBuilder builder;
  
    BaremetalNested(io.fabric8.openshift.api.model.installer.baremetal.v1.Platform item) {
      this.builder = new io.fabric8.openshift.api.model.installer.baremetal.v1.PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withBaremetal(builder.build());
    }
    
    public N endBaremetal() {
      return and();
    }
    
  }
  public class ExternalNested<N> extends io.fabric8.openshift.api.model.installer.external.v1.PlatformFluent<ExternalNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.installer.external.v1.PlatformBuilder builder;
  
    ExternalNested(io.fabric8.openshift.api.model.installer.external.v1.Platform item) {
      this.builder = new io.fabric8.openshift.api.model.installer.external.v1.PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withExternal(builder.build());
    }
    
    public N endExternal() {
      return and();
    }
    
  }
  public class GcpNested<N> extends io.fabric8.openshift.api.model.installer.gcp.v1.PlatformFluent<GcpNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.installer.gcp.v1.PlatformBuilder builder;
  
    GcpNested(io.fabric8.openshift.api.model.installer.gcp.v1.Platform item) {
      this.builder = new io.fabric8.openshift.api.model.installer.gcp.v1.PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withGcp(builder.build());
    }
    
    public N endGcp() {
      return and();
    }
    
  }
  public class IbmcloudNested<N> extends io.fabric8.openshift.api.model.installer.ibmcloud.v1.PlatformFluent<IbmcloudNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.installer.ibmcloud.v1.PlatformBuilder builder;
  
    IbmcloudNested(io.fabric8.openshift.api.model.installer.ibmcloud.v1.Platform item) {
      this.builder = new io.fabric8.openshift.api.model.installer.ibmcloud.v1.PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withIbmcloud(builder.build());
    }
    
    public N endIbmcloud() {
      return and();
    }
    
  }
  public class NoneNested<N> extends io.fabric8.openshift.api.model.installer.none.v1.PlatformFluent<NoneNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.installer.none.v1.PlatformBuilder builder;
  
    NoneNested(io.fabric8.openshift.api.model.installer.none.v1.Platform item) {
      this.builder = new io.fabric8.openshift.api.model.installer.none.v1.PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withNone(builder.build());
    }
    
    public N endNone() {
      return and();
    }
    
  }
  public class NutanixNested<N> extends io.fabric8.openshift.api.model.installer.nutanix.v1.PlatformFluent<NutanixNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.installer.nutanix.v1.PlatformBuilder builder;
  
    NutanixNested(io.fabric8.openshift.api.model.installer.nutanix.v1.Platform item) {
      this.builder = new io.fabric8.openshift.api.model.installer.nutanix.v1.PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withNutanix(builder.build());
    }
    
    public N endNutanix() {
      return and();
    }
    
  }
  public class OpenstackNested<N> extends io.fabric8.openshift.api.model.installer.openstack.v1.PlatformFluent<OpenstackNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.installer.openstack.v1.PlatformBuilder builder;
  
    OpenstackNested(io.fabric8.openshift.api.model.installer.openstack.v1.Platform item) {
      this.builder = new io.fabric8.openshift.api.model.installer.openstack.v1.PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withOpenstack(builder.build());
    }
    
    public N endOpenstack() {
      return and();
    }
    
  }
  public class OvirtNested<N> extends io.fabric8.openshift.api.model.installer.ovirt.v1.PlatformFluent<OvirtNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.installer.ovirt.v1.PlatformBuilder builder;
  
    OvirtNested(io.fabric8.openshift.api.model.installer.ovirt.v1.Platform item) {
      this.builder = new io.fabric8.openshift.api.model.installer.ovirt.v1.PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withOvirt(builder.build());
    }
    
    public N endOvirt() {
      return and();
    }
    
  }
  public class PowervcNested<N> extends io.fabric8.openshift.api.model.installer.powervc.v1.PlatformFluent<PowervcNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.installer.powervc.v1.PlatformBuilder builder;
  
    PowervcNested(io.fabric8.openshift.api.model.installer.powervc.v1.Platform item) {
      this.builder = new io.fabric8.openshift.api.model.installer.powervc.v1.PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withPowervc(builder.build());
    }
    
    public N endPowervc() {
      return and();
    }
    
  }
  public class PowervsNested<N> extends io.fabric8.openshift.api.model.installer.powervs.v1.PlatformFluent<PowervsNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.installer.powervs.v1.PlatformBuilder builder;
  
    PowervsNested(io.fabric8.openshift.api.model.installer.powervs.v1.Platform item) {
      this.builder = new io.fabric8.openshift.api.model.installer.powervs.v1.PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withPowervs(builder.build());
    }
    
    public N endPowervs() {
      return and();
    }
    
  }
  public class VsphereNested<N> extends io.fabric8.openshift.api.model.installer.vsphere.v1.PlatformFluent<VsphereNested<N>> implements Nested<N>{
  
    io.fabric8.openshift.api.model.installer.vsphere.v1.PlatformBuilder builder;
  
    VsphereNested(io.fabric8.openshift.api.model.installer.vsphere.v1.Platform item) {
      this.builder = new io.fabric8.openshift.api.model.installer.vsphere.v1.PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withVsphere(builder.build());
    }
    
    public N endVsphere() {
      return and();
    }
    
  }
}