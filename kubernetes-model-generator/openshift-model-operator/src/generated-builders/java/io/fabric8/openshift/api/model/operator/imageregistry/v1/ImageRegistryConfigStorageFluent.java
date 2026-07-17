package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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
public class ImageRegistryConfigStorageFluent<A extends io.fabric8.openshift.api.model.operator.imageregistry.v1.ImageRegistryConfigStorageFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ImageRegistryConfigStorageAzureBuilder azure;
  private ImageRegistryConfigStorageEmptyDirBuilder emptyDir;
  private ImageRegistryConfigStorageGCSBuilder gcs;
  private ImageRegistryConfigStorageIBMCOSBuilder ibmcos;
  private String managementState;
  private ImageRegistryConfigStorageAlibabaOSSBuilder oss;
  private ImageRegistryConfigStoragePVCBuilder pvc;
  private ImageRegistryConfigStorageS3Builder s3;
  private ImageRegistryConfigStorageSwiftBuilder swift;

  public ImageRegistryConfigStorageFluent() {
  }
  
  public ImageRegistryConfigStorageFluent(ImageRegistryConfigStorage instance) {
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
  
  public ImageRegistryConfigStorageAzure buildAzure() {
    return this.azure != null ? this.azure.build() : null;
  }
  
  public ImageRegistryConfigStorageEmptyDir buildEmptyDir() {
    return this.emptyDir != null ? this.emptyDir.build() : null;
  }
  
  public ImageRegistryConfigStorageGCS buildGcs() {
    return this.gcs != null ? this.gcs.build() : null;
  }
  
  public ImageRegistryConfigStorageIBMCOS buildIbmcos() {
    return this.ibmcos != null ? this.ibmcos.build() : null;
  }
  
  public ImageRegistryConfigStorageAlibabaOSS buildOss() {
    return this.oss != null ? this.oss.build() : null;
  }
  
  public ImageRegistryConfigStoragePVC buildPvc() {
    return this.pvc != null ? this.pvc.build() : null;
  }
  
  public ImageRegistryConfigStorageS3 buildS3() {
    return this.s3 != null ? this.s3.build() : null;
  }
  
  public ImageRegistryConfigStorageSwift buildSwift() {
    return this.swift != null ? this.swift.build() : null;
  }
  
  protected void copyInstance(ImageRegistryConfigStorage instance) {
    instance = instance != null ? instance : new ImageRegistryConfigStorage();
    if (instance != null) {
        this.withAzure(instance.getAzure());
        this.withEmptyDir(instance.getEmptyDir());
        this.withGcs(instance.getGcs());
        this.withIbmcos(instance.getIbmcos());
        this.withManagementState(instance.getManagementState());
        this.withOss(instance.getOss());
        this.withPvc(instance.getPvc());
        this.withS3(instance.getS3());
        this.withSwift(instance.getSwift());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AzureNested<A> editAzure() {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(null));
  }
  
  public EmptyDirNested<A> editEmptyDir() {
    return this.withNewEmptyDirLike(Optional.ofNullable(this.buildEmptyDir()).orElse(null));
  }
  
  public GcsNested<A> editGcs() {
    return this.withNewGcsLike(Optional.ofNullable(this.buildGcs()).orElse(null));
  }
  
  public IbmcosNested<A> editIbmcos() {
    return this.withNewIbmcosLike(Optional.ofNullable(this.buildIbmcos()).orElse(null));
  }
  
  public AzureNested<A> editOrNewAzure() {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(new ImageRegistryConfigStorageAzureBuilder().build()));
  }
  
  public AzureNested<A> editOrNewAzureLike(ImageRegistryConfigStorageAzure item) {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(item));
  }
  
  public EmptyDirNested<A> editOrNewEmptyDir() {
    return this.withNewEmptyDirLike(Optional.ofNullable(this.buildEmptyDir()).orElse(new ImageRegistryConfigStorageEmptyDirBuilder().build()));
  }
  
  public EmptyDirNested<A> editOrNewEmptyDirLike(ImageRegistryConfigStorageEmptyDir item) {
    return this.withNewEmptyDirLike(Optional.ofNullable(this.buildEmptyDir()).orElse(item));
  }
  
  public GcsNested<A> editOrNewGcs() {
    return this.withNewGcsLike(Optional.ofNullable(this.buildGcs()).orElse(new ImageRegistryConfigStorageGCSBuilder().build()));
  }
  
  public GcsNested<A> editOrNewGcsLike(ImageRegistryConfigStorageGCS item) {
    return this.withNewGcsLike(Optional.ofNullable(this.buildGcs()).orElse(item));
  }
  
  public IbmcosNested<A> editOrNewIbmcos() {
    return this.withNewIbmcosLike(Optional.ofNullable(this.buildIbmcos()).orElse(new ImageRegistryConfigStorageIBMCOSBuilder().build()));
  }
  
  public IbmcosNested<A> editOrNewIbmcosLike(ImageRegistryConfigStorageIBMCOS item) {
    return this.withNewIbmcosLike(Optional.ofNullable(this.buildIbmcos()).orElse(item));
  }
  
  public OssNested<A> editOrNewOss() {
    return this.withNewOssLike(Optional.ofNullable(this.buildOss()).orElse(new ImageRegistryConfigStorageAlibabaOSSBuilder().build()));
  }
  
  public OssNested<A> editOrNewOssLike(ImageRegistryConfigStorageAlibabaOSS item) {
    return this.withNewOssLike(Optional.ofNullable(this.buildOss()).orElse(item));
  }
  
  public PvcNested<A> editOrNewPvc() {
    return this.withNewPvcLike(Optional.ofNullable(this.buildPvc()).orElse(new ImageRegistryConfigStoragePVCBuilder().build()));
  }
  
  public PvcNested<A> editOrNewPvcLike(ImageRegistryConfigStoragePVC item) {
    return this.withNewPvcLike(Optional.ofNullable(this.buildPvc()).orElse(item));
  }
  
  public S3Nested<A> editOrNewS3() {
    return this.withNewS3Like(Optional.ofNullable(this.buildS3()).orElse(new ImageRegistryConfigStorageS3Builder().build()));
  }
  
  public S3Nested<A> editOrNewS3Like(ImageRegistryConfigStorageS3 item) {
    return this.withNewS3Like(Optional.ofNullable(this.buildS3()).orElse(item));
  }
  
  public SwiftNested<A> editOrNewSwift() {
    return this.withNewSwiftLike(Optional.ofNullable(this.buildSwift()).orElse(new ImageRegistryConfigStorageSwiftBuilder().build()));
  }
  
  public SwiftNested<A> editOrNewSwiftLike(ImageRegistryConfigStorageSwift item) {
    return this.withNewSwiftLike(Optional.ofNullable(this.buildSwift()).orElse(item));
  }
  
  public OssNested<A> editOss() {
    return this.withNewOssLike(Optional.ofNullable(this.buildOss()).orElse(null));
  }
  
  public PvcNested<A> editPvc() {
    return this.withNewPvcLike(Optional.ofNullable(this.buildPvc()).orElse(null));
  }
  
  public S3Nested<A> editS3() {
    return this.withNewS3Like(Optional.ofNullable(this.buildS3()).orElse(null));
  }
  
  public SwiftNested<A> editSwift() {
    return this.withNewSwiftLike(Optional.ofNullable(this.buildSwift()).orElse(null));
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
    ImageRegistryConfigStorageFluent that = (ImageRegistryConfigStorageFluent) o;
    if (!(Objects.equals(azure, that.azure))) {
      return false;
    }
    if (!(Objects.equals(emptyDir, that.emptyDir))) {
      return false;
    }
    if (!(Objects.equals(gcs, that.gcs))) {
      return false;
    }
    if (!(Objects.equals(ibmcos, that.ibmcos))) {
      return false;
    }
    if (!(Objects.equals(managementState, that.managementState))) {
      return false;
    }
    if (!(Objects.equals(oss, that.oss))) {
      return false;
    }
    if (!(Objects.equals(pvc, that.pvc))) {
      return false;
    }
    if (!(Objects.equals(s3, that.s3))) {
      return false;
    }
    if (!(Objects.equals(swift, that.swift))) {
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
  
  public String getManagementState() {
    return this.managementState;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAzure() {
    return this.azure != null;
  }
  
  public boolean hasEmptyDir() {
    return this.emptyDir != null;
  }
  
  public boolean hasGcs() {
    return this.gcs != null;
  }
  
  public boolean hasIbmcos() {
    return this.ibmcos != null;
  }
  
  public boolean hasManagementState() {
    return this.managementState != null;
  }
  
  public boolean hasOss() {
    return this.oss != null;
  }
  
  public boolean hasPvc() {
    return this.pvc != null;
  }
  
  public boolean hasS3() {
    return this.s3 != null;
  }
  
  public boolean hasSwift() {
    return this.swift != null;
  }
  
  public int hashCode() {
    return Objects.hash(azure, emptyDir, gcs, ibmcos, managementState, oss, pvc, s3, swift, additionalProperties);
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
    if (!(azure == null)) {
        sb.append("azure:");
        sb.append(azure);
        sb.append(",");
    }
    if (!(emptyDir == null)) {
        sb.append("emptyDir:");
        sb.append(emptyDir);
        sb.append(",");
    }
    if (!(gcs == null)) {
        sb.append("gcs:");
        sb.append(gcs);
        sb.append(",");
    }
    if (!(ibmcos == null)) {
        sb.append("ibmcos:");
        sb.append(ibmcos);
        sb.append(",");
    }
    if (!(managementState == null)) {
        sb.append("managementState:");
        sb.append(managementState);
        sb.append(",");
    }
    if (!(oss == null)) {
        sb.append("oss:");
        sb.append(oss);
        sb.append(",");
    }
    if (!(pvc == null)) {
        sb.append("pvc:");
        sb.append(pvc);
        sb.append(",");
    }
    if (!(s3 == null)) {
        sb.append("s3:");
        sb.append(s3);
        sb.append(",");
    }
    if (!(swift == null)) {
        sb.append("swift:");
        sb.append(swift);
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
  
  public A withAzure(ImageRegistryConfigStorageAzure azure) {
    this._visitables.remove("azure");
    if (azure != null) {
        this.azure = new ImageRegistryConfigStorageAzureBuilder(azure);
        this._visitables.get("azure").add(this.azure);
    } else {
        this.azure = null;
        this._visitables.get("azure").remove(this.azure);
    }
    return (A) this;
  }
  
  public A withEmptyDir(ImageRegistryConfigStorageEmptyDir emptyDir) {
    this._visitables.remove("emptyDir");
    if (emptyDir != null) {
        this.emptyDir = new ImageRegistryConfigStorageEmptyDirBuilder(emptyDir);
        this._visitables.get("emptyDir").add(this.emptyDir);
    } else {
        this.emptyDir = null;
        this._visitables.get("emptyDir").remove(this.emptyDir);
    }
    return (A) this;
  }
  
  public A withGcs(ImageRegistryConfigStorageGCS gcs) {
    this._visitables.remove("gcs");
    if (gcs != null) {
        this.gcs = new ImageRegistryConfigStorageGCSBuilder(gcs);
        this._visitables.get("gcs").add(this.gcs);
    } else {
        this.gcs = null;
        this._visitables.get("gcs").remove(this.gcs);
    }
    return (A) this;
  }
  
  public A withIbmcos(ImageRegistryConfigStorageIBMCOS ibmcos) {
    this._visitables.remove("ibmcos");
    if (ibmcos != null) {
        this.ibmcos = new ImageRegistryConfigStorageIBMCOSBuilder(ibmcos);
        this._visitables.get("ibmcos").add(this.ibmcos);
    } else {
        this.ibmcos = null;
        this._visitables.get("ibmcos").remove(this.ibmcos);
    }
    return (A) this;
  }
  
  public A withManagementState(String managementState) {
    this.managementState = managementState;
    return (A) this;
  }
  
  public AzureNested<A> withNewAzure() {
    return new AzureNested(null);
  }
  
  public AzureNested<A> withNewAzureLike(ImageRegistryConfigStorageAzure item) {
    return new AzureNested(item);
  }
  
  public EmptyDirNested<A> withNewEmptyDir() {
    return new EmptyDirNested(null);
  }
  
  public EmptyDirNested<A> withNewEmptyDirLike(ImageRegistryConfigStorageEmptyDir item) {
    return new EmptyDirNested(item);
  }
  
  public GcsNested<A> withNewGcs() {
    return new GcsNested(null);
  }
  
  public A withNewGcs(String bucket,String keyID,String projectID,String region) {
    return (A) this.withGcs(new ImageRegistryConfigStorageGCS(bucket, keyID, projectID, region));
  }
  
  public GcsNested<A> withNewGcsLike(ImageRegistryConfigStorageGCS item) {
    return new GcsNested(item);
  }
  
  public IbmcosNested<A> withNewIbmcos() {
    return new IbmcosNested(null);
  }
  
  public A withNewIbmcos(String bucket,String location,String resourceGroupName,String resourceKeyCRN,String serviceInstanceCRN) {
    return (A) this.withIbmcos(new ImageRegistryConfigStorageIBMCOS(bucket, location, resourceGroupName, resourceKeyCRN, serviceInstanceCRN));
  }
  
  public IbmcosNested<A> withNewIbmcosLike(ImageRegistryConfigStorageIBMCOS item) {
    return new IbmcosNested(item);
  }
  
  public OssNested<A> withNewOss() {
    return new OssNested(null);
  }
  
  public OssNested<A> withNewOssLike(ImageRegistryConfigStorageAlibabaOSS item) {
    return new OssNested(item);
  }
  
  public PvcNested<A> withNewPvc() {
    return new PvcNested(null);
  }
  
  public A withNewPvc(String claim) {
    return (A) this.withPvc(new ImageRegistryConfigStoragePVC(claim));
  }
  
  public PvcNested<A> withNewPvcLike(ImageRegistryConfigStoragePVC item) {
    return new PvcNested(item);
  }
  
  public S3Nested<A> withNewS3() {
    return new S3Nested(null);
  }
  
  public S3Nested<A> withNewS3Like(ImageRegistryConfigStorageS3 item) {
    return new S3Nested(item);
  }
  
  public SwiftNested<A> withNewSwift() {
    return new SwiftNested(null);
  }
  
  public SwiftNested<A> withNewSwiftLike(ImageRegistryConfigStorageSwift item) {
    return new SwiftNested(item);
  }
  
  public A withOss(ImageRegistryConfigStorageAlibabaOSS oss) {
    this._visitables.remove("oss");
    if (oss != null) {
        this.oss = new ImageRegistryConfigStorageAlibabaOSSBuilder(oss);
        this._visitables.get("oss").add(this.oss);
    } else {
        this.oss = null;
        this._visitables.get("oss").remove(this.oss);
    }
    return (A) this;
  }
  
  public A withPvc(ImageRegistryConfigStoragePVC pvc) {
    this._visitables.remove("pvc");
    if (pvc != null) {
        this.pvc = new ImageRegistryConfigStoragePVCBuilder(pvc);
        this._visitables.get("pvc").add(this.pvc);
    } else {
        this.pvc = null;
        this._visitables.get("pvc").remove(this.pvc);
    }
    return (A) this;
  }
  
  public A withS3(ImageRegistryConfigStorageS3 s3) {
    this._visitables.remove("s3");
    if (s3 != null) {
        this.s3 = new ImageRegistryConfigStorageS3Builder(s3);
        this._visitables.get("s3").add(this.s3);
    } else {
        this.s3 = null;
        this._visitables.get("s3").remove(this.s3);
    }
    return (A) this;
  }
  
  public A withSwift(ImageRegistryConfigStorageSwift swift) {
    this._visitables.remove("swift");
    if (swift != null) {
        this.swift = new ImageRegistryConfigStorageSwiftBuilder(swift);
        this._visitables.get("swift").add(this.swift);
    } else {
        this.swift = null;
        this._visitables.get("swift").remove(this.swift);
    }
    return (A) this;
  }
  public class AzureNested<N> extends ImageRegistryConfigStorageAzureFluent<AzureNested<N>> implements Nested<N>{
  
    ImageRegistryConfigStorageAzureBuilder builder;
  
    AzureNested(ImageRegistryConfigStorageAzure item) {
      this.builder = new ImageRegistryConfigStorageAzureBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageRegistryConfigStorageFluent.this.withAzure(builder.build());
    }
    
    public N endAzure() {
      return and();
    }
    
  }
  public class EmptyDirNested<N> extends ImageRegistryConfigStorageEmptyDirFluent<EmptyDirNested<N>> implements Nested<N>{
  
    ImageRegistryConfigStorageEmptyDirBuilder builder;
  
    EmptyDirNested(ImageRegistryConfigStorageEmptyDir item) {
      this.builder = new ImageRegistryConfigStorageEmptyDirBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageRegistryConfigStorageFluent.this.withEmptyDir(builder.build());
    }
    
    public N endEmptyDir() {
      return and();
    }
    
  }
  public class GcsNested<N> extends ImageRegistryConfigStorageGCSFluent<GcsNested<N>> implements Nested<N>{
  
    ImageRegistryConfigStorageGCSBuilder builder;
  
    GcsNested(ImageRegistryConfigStorageGCS item) {
      this.builder = new ImageRegistryConfigStorageGCSBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageRegistryConfigStorageFluent.this.withGcs(builder.build());
    }
    
    public N endGcs() {
      return and();
    }
    
  }
  public class IbmcosNested<N> extends ImageRegistryConfigStorageIBMCOSFluent<IbmcosNested<N>> implements Nested<N>{
  
    ImageRegistryConfigStorageIBMCOSBuilder builder;
  
    IbmcosNested(ImageRegistryConfigStorageIBMCOS item) {
      this.builder = new ImageRegistryConfigStorageIBMCOSBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageRegistryConfigStorageFluent.this.withIbmcos(builder.build());
    }
    
    public N endIbmcos() {
      return and();
    }
    
  }
  public class OssNested<N> extends ImageRegistryConfigStorageAlibabaOSSFluent<OssNested<N>> implements Nested<N>{
  
    ImageRegistryConfigStorageAlibabaOSSBuilder builder;
  
    OssNested(ImageRegistryConfigStorageAlibabaOSS item) {
      this.builder = new ImageRegistryConfigStorageAlibabaOSSBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageRegistryConfigStorageFluent.this.withOss(builder.build());
    }
    
    public N endOss() {
      return and();
    }
    
  }
  public class PvcNested<N> extends ImageRegistryConfigStoragePVCFluent<PvcNested<N>> implements Nested<N>{
  
    ImageRegistryConfigStoragePVCBuilder builder;
  
    PvcNested(ImageRegistryConfigStoragePVC item) {
      this.builder = new ImageRegistryConfigStoragePVCBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageRegistryConfigStorageFluent.this.withPvc(builder.build());
    }
    
    public N endPvc() {
      return and();
    }
    
  }
  public class S3Nested<N> extends ImageRegistryConfigStorageS3Fluent<S3Nested<N>> implements Nested<N>{
  
    ImageRegistryConfigStorageS3Builder builder;
  
    S3Nested(ImageRegistryConfigStorageS3 item) {
      this.builder = new ImageRegistryConfigStorageS3Builder(this, item);
    }
  
    public N and() {
      return (N) ImageRegistryConfigStorageFluent.this.withS3(builder.build());
    }
    
    public N endS3() {
      return and();
    }
    
  }
  public class SwiftNested<N> extends ImageRegistryConfigStorageSwiftFluent<SwiftNested<N>> implements Nested<N>{
  
    ImageRegistryConfigStorageSwiftBuilder builder;
  
    SwiftNested(ImageRegistryConfigStorageSwift item) {
      this.builder = new ImageRegistryConfigStorageSwiftBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageRegistryConfigStorageFluent.this.withSwift(builder.build());
    }
    
    public N endSwift() {
      return and();
    }
    
  }
}