package io.fabric8.openshift.api.model.operator.v1;

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
public class CSIDriverConfigSpecFluent<A extends io.fabric8.openshift.api.model.operator.v1.CSIDriverConfigSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AWSCSIDriverConfigSpecBuilder aws;
  private AzureCSIDriverConfigSpecBuilder azure;
  private String driverType;
  private GCPCSIDriverConfigSpecBuilder gcp;
  private IBMCloudCSIDriverConfigSpecBuilder ibmcloud;
  private VSphereCSIDriverConfigSpecBuilder vSphere;

  public CSIDriverConfigSpecFluent() {
  }
  
  public CSIDriverConfigSpecFluent(CSIDriverConfigSpec instance) {
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
  
  public AWSCSIDriverConfigSpec buildAws() {
    return this.aws != null ? this.aws.build() : null;
  }
  
  public AzureCSIDriverConfigSpec buildAzure() {
    return this.azure != null ? this.azure.build() : null;
  }
  
  public GCPCSIDriverConfigSpec buildGcp() {
    return this.gcp != null ? this.gcp.build() : null;
  }
  
  public IBMCloudCSIDriverConfigSpec buildIbmcloud() {
    return this.ibmcloud != null ? this.ibmcloud.build() : null;
  }
  
  public VSphereCSIDriverConfigSpec buildVSphere() {
    return this.vSphere != null ? this.vSphere.build() : null;
  }
  
  protected void copyInstance(CSIDriverConfigSpec instance) {
    instance = instance != null ? instance : new CSIDriverConfigSpec();
    if (instance != null) {
        this.withAws(instance.getAws());
        this.withAzure(instance.getAzure());
        this.withDriverType(instance.getDriverType());
        this.withGcp(instance.getGcp());
        this.withIbmcloud(instance.getIbmcloud());
        this.withVSphere(instance.getVSphere());
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
  
  public AwsNested<A> editOrNewAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(new AWSCSIDriverConfigSpecBuilder().build()));
  }
  
  public AwsNested<A> editOrNewAwsLike(AWSCSIDriverConfigSpec item) {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(item));
  }
  
  public AzureNested<A> editOrNewAzure() {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(new AzureCSIDriverConfigSpecBuilder().build()));
  }
  
  public AzureNested<A> editOrNewAzureLike(AzureCSIDriverConfigSpec item) {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(item));
  }
  
  public GcpNested<A> editOrNewGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(new GCPCSIDriverConfigSpecBuilder().build()));
  }
  
  public GcpNested<A> editOrNewGcpLike(GCPCSIDriverConfigSpec item) {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(item));
  }
  
  public IbmcloudNested<A> editOrNewIbmcloud() {
    return this.withNewIbmcloudLike(Optional.ofNullable(this.buildIbmcloud()).orElse(new IBMCloudCSIDriverConfigSpecBuilder().build()));
  }
  
  public IbmcloudNested<A> editOrNewIbmcloudLike(IBMCloudCSIDriverConfigSpec item) {
    return this.withNewIbmcloudLike(Optional.ofNullable(this.buildIbmcloud()).orElse(item));
  }
  
  public VSphereNested<A> editOrNewVSphere() {
    return this.withNewVSphereLike(Optional.ofNullable(this.buildVSphere()).orElse(new VSphereCSIDriverConfigSpecBuilder().build()));
  }
  
  public VSphereNested<A> editOrNewVSphereLike(VSphereCSIDriverConfigSpec item) {
    return this.withNewVSphereLike(Optional.ofNullable(this.buildVSphere()).orElse(item));
  }
  
  public VSphereNested<A> editVSphere() {
    return this.withNewVSphereLike(Optional.ofNullable(this.buildVSphere()).orElse(null));
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
    CSIDriverConfigSpecFluent that = (CSIDriverConfigSpecFluent) o;
    if (!(Objects.equals(aws, that.aws))) {
      return false;
    }
    if (!(Objects.equals(azure, that.azure))) {
      return false;
    }
    if (!(Objects.equals(driverType, that.driverType))) {
      return false;
    }
    if (!(Objects.equals(gcp, that.gcp))) {
      return false;
    }
    if (!(Objects.equals(ibmcloud, that.ibmcloud))) {
      return false;
    }
    if (!(Objects.equals(vSphere, that.vSphere))) {
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
  
  public String getDriverType() {
    return this.driverType;
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
  
  public boolean hasDriverType() {
    return this.driverType != null;
  }
  
  public boolean hasGcp() {
    return this.gcp != null;
  }
  
  public boolean hasIbmcloud() {
    return this.ibmcloud != null;
  }
  
  public boolean hasVSphere() {
    return this.vSphere != null;
  }
  
  public int hashCode() {
    return Objects.hash(aws, azure, driverType, gcp, ibmcloud, vSphere, additionalProperties);
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
    if (!(driverType == null)) {
        sb.append("driverType:");
        sb.append(driverType);
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
    if (!(vSphere == null)) {
        sb.append("vSphere:");
        sb.append(vSphere);
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
  
  public A withAws(AWSCSIDriverConfigSpec aws) {
    this._visitables.remove("aws");
    if (aws != null) {
        this.aws = new AWSCSIDriverConfigSpecBuilder(aws);
        this._visitables.get("aws").add(this.aws);
    } else {
        this.aws = null;
        this._visitables.get("aws").remove(this.aws);
    }
    return (A) this;
  }
  
  public A withAzure(AzureCSIDriverConfigSpec azure) {
    this._visitables.remove("azure");
    if (azure != null) {
        this.azure = new AzureCSIDriverConfigSpecBuilder(azure);
        this._visitables.get("azure").add(this.azure);
    } else {
        this.azure = null;
        this._visitables.get("azure").remove(this.azure);
    }
    return (A) this;
  }
  
  public A withDriverType(String driverType) {
    this.driverType = driverType;
    return (A) this;
  }
  
  public A withGcp(GCPCSIDriverConfigSpec gcp) {
    this._visitables.remove("gcp");
    if (gcp != null) {
        this.gcp = new GCPCSIDriverConfigSpecBuilder(gcp);
        this._visitables.get("gcp").add(this.gcp);
    } else {
        this.gcp = null;
        this._visitables.get("gcp").remove(this.gcp);
    }
    return (A) this;
  }
  
  public A withIbmcloud(IBMCloudCSIDriverConfigSpec ibmcloud) {
    this._visitables.remove("ibmcloud");
    if (ibmcloud != null) {
        this.ibmcloud = new IBMCloudCSIDriverConfigSpecBuilder(ibmcloud);
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
  
  public AwsNested<A> withNewAwsLike(AWSCSIDriverConfigSpec item) {
    return new AwsNested(item);
  }
  
  public AzureNested<A> withNewAzure() {
    return new AzureNested(null);
  }
  
  public AzureNested<A> withNewAzureLike(AzureCSIDriverConfigSpec item) {
    return new AzureNested(item);
  }
  
  public GcpNested<A> withNewGcp() {
    return new GcpNested(null);
  }
  
  public GcpNested<A> withNewGcpLike(GCPCSIDriverConfigSpec item) {
    return new GcpNested(item);
  }
  
  public IbmcloudNested<A> withNewIbmcloud() {
    return new IbmcloudNested(null);
  }
  
  public A withNewIbmcloud(String encryptionKeyCRN) {
    return (A) this.withIbmcloud(new IBMCloudCSIDriverConfigSpec(encryptionKeyCRN));
  }
  
  public IbmcloudNested<A> withNewIbmcloudLike(IBMCloudCSIDriverConfigSpec item) {
    return new IbmcloudNested(item);
  }
  
  public VSphereNested<A> withNewVSphere() {
    return new VSphereNested(null);
  }
  
  public VSphereNested<A> withNewVSphereLike(VSphereCSIDriverConfigSpec item) {
    return new VSphereNested(item);
  }
  
  public A withVSphere(VSphereCSIDriverConfigSpec vSphere) {
    this._visitables.remove("vSphere");
    if (vSphere != null) {
        this.vSphere = new VSphereCSIDriverConfigSpecBuilder(vSphere);
        this._visitables.get("vSphere").add(this.vSphere);
    } else {
        this.vSphere = null;
        this._visitables.get("vSphere").remove(this.vSphere);
    }
    return (A) this;
  }
  public class AwsNested<N> extends AWSCSIDriverConfigSpecFluent<AwsNested<N>> implements Nested<N>{
  
    AWSCSIDriverConfigSpecBuilder builder;
  
    AwsNested(AWSCSIDriverConfigSpec item) {
      this.builder = new AWSCSIDriverConfigSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) CSIDriverConfigSpecFluent.this.withAws(builder.build());
    }
    
    public N endAws() {
      return and();
    }
    
  }
  public class AzureNested<N> extends AzureCSIDriverConfigSpecFluent<AzureNested<N>> implements Nested<N>{
  
    AzureCSIDriverConfigSpecBuilder builder;
  
    AzureNested(AzureCSIDriverConfigSpec item) {
      this.builder = new AzureCSIDriverConfigSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) CSIDriverConfigSpecFluent.this.withAzure(builder.build());
    }
    
    public N endAzure() {
      return and();
    }
    
  }
  public class GcpNested<N> extends GCPCSIDriverConfigSpecFluent<GcpNested<N>> implements Nested<N>{
  
    GCPCSIDriverConfigSpecBuilder builder;
  
    GcpNested(GCPCSIDriverConfigSpec item) {
      this.builder = new GCPCSIDriverConfigSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) CSIDriverConfigSpecFluent.this.withGcp(builder.build());
    }
    
    public N endGcp() {
      return and();
    }
    
  }
  public class IbmcloudNested<N> extends IBMCloudCSIDriverConfigSpecFluent<IbmcloudNested<N>> implements Nested<N>{
  
    IBMCloudCSIDriverConfigSpecBuilder builder;
  
    IbmcloudNested(IBMCloudCSIDriverConfigSpec item) {
      this.builder = new IBMCloudCSIDriverConfigSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) CSIDriverConfigSpecFluent.this.withIbmcloud(builder.build());
    }
    
    public N endIbmcloud() {
      return and();
    }
    
  }
  public class VSphereNested<N> extends VSphereCSIDriverConfigSpecFluent<VSphereNested<N>> implements Nested<N>{
  
    VSphereCSIDriverConfigSpecBuilder builder;
  
    VSphereNested(VSphereCSIDriverConfigSpec item) {
      this.builder = new VSphereCSIDriverConfigSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) CSIDriverConfigSpecFluent.this.withVSphere(builder.build());
    }
    
    public N endVSphere() {
      return and();
    }
    
  }
}