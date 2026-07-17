package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Integer;
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
public class ImageRegistryConfigStorageS3Fluent<A extends io.fabric8.openshift.api.model.operator.imageregistry.v1.ImageRegistryConfigStorageS3Fluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String bucket;
  private Integer chunkSizeMiB;
  private ImageRegistryConfigStorageS3CloudFrontBuilder cloudFront;
  private Boolean encrypt;
  private String keyID;
  private String region;
  private String regionEndpoint;
  private S3TrustedCASourceBuilder trustedCA;
  private Boolean virtualHostedStyle;

  public ImageRegistryConfigStorageS3Fluent() {
  }
  
  public ImageRegistryConfigStorageS3Fluent(ImageRegistryConfigStorageS3 instance) {
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
  
  public ImageRegistryConfigStorageS3CloudFront buildCloudFront() {
    return this.cloudFront != null ? this.cloudFront.build() : null;
  }
  
  public S3TrustedCASource buildTrustedCA() {
    return this.trustedCA != null ? this.trustedCA.build() : null;
  }
  
  protected void copyInstance(ImageRegistryConfigStorageS3 instance) {
    instance = instance != null ? instance : new ImageRegistryConfigStorageS3();
    if (instance != null) {
        this.withBucket(instance.getBucket());
        this.withChunkSizeMiB(instance.getChunkSizeMiB());
        this.withCloudFront(instance.getCloudFront());
        this.withEncrypt(instance.getEncrypt());
        this.withKeyID(instance.getKeyID());
        this.withRegion(instance.getRegion());
        this.withRegionEndpoint(instance.getRegionEndpoint());
        this.withTrustedCA(instance.getTrustedCA());
        this.withVirtualHostedStyle(instance.getVirtualHostedStyle());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CloudFrontNested<A> editCloudFront() {
    return this.withNewCloudFrontLike(Optional.ofNullable(this.buildCloudFront()).orElse(null));
  }
  
  public CloudFrontNested<A> editOrNewCloudFront() {
    return this.withNewCloudFrontLike(Optional.ofNullable(this.buildCloudFront()).orElse(new ImageRegistryConfigStorageS3CloudFrontBuilder().build()));
  }
  
  public CloudFrontNested<A> editOrNewCloudFrontLike(ImageRegistryConfigStorageS3CloudFront item) {
    return this.withNewCloudFrontLike(Optional.ofNullable(this.buildCloudFront()).orElse(item));
  }
  
  public TrustedCANested<A> editOrNewTrustedCA() {
    return this.withNewTrustedCALike(Optional.ofNullable(this.buildTrustedCA()).orElse(new S3TrustedCASourceBuilder().build()));
  }
  
  public TrustedCANested<A> editOrNewTrustedCALike(S3TrustedCASource item) {
    return this.withNewTrustedCALike(Optional.ofNullable(this.buildTrustedCA()).orElse(item));
  }
  
  public TrustedCANested<A> editTrustedCA() {
    return this.withNewTrustedCALike(Optional.ofNullable(this.buildTrustedCA()).orElse(null));
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
    ImageRegistryConfigStorageS3Fluent that = (ImageRegistryConfigStorageS3Fluent) o;
    if (!(Objects.equals(bucket, that.bucket))) {
      return false;
    }
    if (!(Objects.equals(chunkSizeMiB, that.chunkSizeMiB))) {
      return false;
    }
    if (!(Objects.equals(cloudFront, that.cloudFront))) {
      return false;
    }
    if (!(Objects.equals(encrypt, that.encrypt))) {
      return false;
    }
    if (!(Objects.equals(keyID, that.keyID))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(regionEndpoint, that.regionEndpoint))) {
      return false;
    }
    if (!(Objects.equals(trustedCA, that.trustedCA))) {
      return false;
    }
    if (!(Objects.equals(virtualHostedStyle, that.virtualHostedStyle))) {
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
  
  public String getBucket() {
    return this.bucket;
  }
  
  public Integer getChunkSizeMiB() {
    return this.chunkSizeMiB;
  }
  
  public Boolean getEncrypt() {
    return this.encrypt;
  }
  
  public String getKeyID() {
    return this.keyID;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public String getRegionEndpoint() {
    return this.regionEndpoint;
  }
  
  public Boolean getVirtualHostedStyle() {
    return this.virtualHostedStyle;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBucket() {
    return this.bucket != null;
  }
  
  public boolean hasChunkSizeMiB() {
    return this.chunkSizeMiB != null;
  }
  
  public boolean hasCloudFront() {
    return this.cloudFront != null;
  }
  
  public boolean hasEncrypt() {
    return this.encrypt != null;
  }
  
  public boolean hasKeyID() {
    return this.keyID != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasRegionEndpoint() {
    return this.regionEndpoint != null;
  }
  
  public boolean hasTrustedCA() {
    return this.trustedCA != null;
  }
  
  public boolean hasVirtualHostedStyle() {
    return this.virtualHostedStyle != null;
  }
  
  public int hashCode() {
    return Objects.hash(bucket, chunkSizeMiB, cloudFront, encrypt, keyID, region, regionEndpoint, trustedCA, virtualHostedStyle, additionalProperties);
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
    if (!(bucket == null)) {
        sb.append("bucket:");
        sb.append(bucket);
        sb.append(",");
    }
    if (!(chunkSizeMiB == null)) {
        sb.append("chunkSizeMiB:");
        sb.append(chunkSizeMiB);
        sb.append(",");
    }
    if (!(cloudFront == null)) {
        sb.append("cloudFront:");
        sb.append(cloudFront);
        sb.append(",");
    }
    if (!(encrypt == null)) {
        sb.append("encrypt:");
        sb.append(encrypt);
        sb.append(",");
    }
    if (!(keyID == null)) {
        sb.append("keyID:");
        sb.append(keyID);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
        sb.append(",");
    }
    if (!(regionEndpoint == null)) {
        sb.append("regionEndpoint:");
        sb.append(regionEndpoint);
        sb.append(",");
    }
    if (!(trustedCA == null)) {
        sb.append("trustedCA:");
        sb.append(trustedCA);
        sb.append(",");
    }
    if (!(virtualHostedStyle == null)) {
        sb.append("virtualHostedStyle:");
        sb.append(virtualHostedStyle);
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
  
  public A withBucket(String bucket) {
    this.bucket = bucket;
    return (A) this;
  }
  
  public A withChunkSizeMiB(Integer chunkSizeMiB) {
    this.chunkSizeMiB = chunkSizeMiB;
    return (A) this;
  }
  
  public A withCloudFront(ImageRegistryConfigStorageS3CloudFront cloudFront) {
    this._visitables.remove("cloudFront");
    if (cloudFront != null) {
        this.cloudFront = new ImageRegistryConfigStorageS3CloudFrontBuilder(cloudFront);
        this._visitables.get("cloudFront").add(this.cloudFront);
    } else {
        this.cloudFront = null;
        this._visitables.get("cloudFront").remove(this.cloudFront);
    }
    return (A) this;
  }
  
  public A withEncrypt() {
    return withEncrypt(true);
  }
  
  public A withEncrypt(Boolean encrypt) {
    this.encrypt = encrypt;
    return (A) this;
  }
  
  public A withKeyID(String keyID) {
    this.keyID = keyID;
    return (A) this;
  }
  
  public CloudFrontNested<A> withNewCloudFront() {
    return new CloudFrontNested(null);
  }
  
  public CloudFrontNested<A> withNewCloudFrontLike(ImageRegistryConfigStorageS3CloudFront item) {
    return new CloudFrontNested(item);
  }
  
  public TrustedCANested<A> withNewTrustedCA() {
    return new TrustedCANested(null);
  }
  
  public A withNewTrustedCA(String name) {
    return (A) this.withTrustedCA(new S3TrustedCASource(name));
  }
  
  public TrustedCANested<A> withNewTrustedCALike(S3TrustedCASource item) {
    return new TrustedCANested(item);
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withRegionEndpoint(String regionEndpoint) {
    this.regionEndpoint = regionEndpoint;
    return (A) this;
  }
  
  public A withTrustedCA(S3TrustedCASource trustedCA) {
    this._visitables.remove("trustedCA");
    if (trustedCA != null) {
        this.trustedCA = new S3TrustedCASourceBuilder(trustedCA);
        this._visitables.get("trustedCA").add(this.trustedCA);
    } else {
        this.trustedCA = null;
        this._visitables.get("trustedCA").remove(this.trustedCA);
    }
    return (A) this;
  }
  
  public A withVirtualHostedStyle() {
    return withVirtualHostedStyle(true);
  }
  
  public A withVirtualHostedStyle(Boolean virtualHostedStyle) {
    this.virtualHostedStyle = virtualHostedStyle;
    return (A) this;
  }
  public class CloudFrontNested<N> extends ImageRegistryConfigStorageS3CloudFrontFluent<CloudFrontNested<N>> implements Nested<N>{
  
    ImageRegistryConfigStorageS3CloudFrontBuilder builder;
  
    CloudFrontNested(ImageRegistryConfigStorageS3CloudFront item) {
      this.builder = new ImageRegistryConfigStorageS3CloudFrontBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageRegistryConfigStorageS3Fluent.this.withCloudFront(builder.build());
    }
    
    public N endCloudFront() {
      return and();
    }
    
  }
  public class TrustedCANested<N> extends S3TrustedCASourceFluent<TrustedCANested<N>> implements Nested<N>{
  
    S3TrustedCASourceBuilder builder;
  
    TrustedCANested(S3TrustedCASource item) {
      this.builder = new S3TrustedCASourceBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageRegistryConfigStorageS3Fluent.this.withTrustedCA(builder.build());
    }
    
    public N endTrustedCA() {
      return and();
    }
    
  }
}