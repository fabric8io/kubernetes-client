
package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ImageRegistryConfigStorageS3 holds the information to configure the registry to use the AWS S3 service for backend storage https://docs.docker.com/registry/storage-drivers/s3/
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bucket",
    "chunkSizeMiB",
    "cloudFront",
    "encrypt",
    "keyID",
    "region",
    "regionEndpoint",
    "trustedCA",
    "virtualHostedStyle"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ImageRegistryConfigStorageS3 implements Editable<ImageRegistryConfigStorageS3Builder>, KubernetesResource
{

    @JsonProperty("bucket")
    private String bucket;
    @JsonProperty("chunkSizeMiB")
    private Integer chunkSizeMiB;
    @JsonProperty("cloudFront")
    private ImageRegistryConfigStorageS3CloudFront cloudFront;
    @JsonProperty("encrypt")
    private Boolean encrypt;
    @JsonProperty("keyID")
    private String keyID;
    @JsonProperty("region")
    private String region;
    @JsonProperty("regionEndpoint")
    private String regionEndpoint;
    @JsonProperty("trustedCA")
    private S3TrustedCASource trustedCA;
    @JsonProperty("virtualHostedStyle")
    private Boolean virtualHostedStyle;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageRegistryConfigStorageS3() {
    }

    public ImageRegistryConfigStorageS3(String bucket, Integer chunkSizeMiB, ImageRegistryConfigStorageS3CloudFront cloudFront, Boolean encrypt, String keyID, String region, String regionEndpoint, S3TrustedCASource trustedCA, Boolean virtualHostedStyle) {
        super();
        this.bucket = bucket;
        this.chunkSizeMiB = chunkSizeMiB;
        this.cloudFront = cloudFront;
        this.encrypt = encrypt;
        this.keyID = keyID;
        this.region = region;
        this.regionEndpoint = regionEndpoint;
        this.trustedCA = trustedCA;
        this.virtualHostedStyle = virtualHostedStyle;
    }

    /**
     * bucket is the bucket name in which you want to store the registry's data. Optional, will be generated if not provided.
     */
    @JsonProperty("bucket")
    public String getBucket() {
        return bucket;
    }

    /**
     * bucket is the bucket name in which you want to store the registry's data. Optional, will be generated if not provided.
     */
    @JsonProperty("bucket")
    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    /**
     * chunkSizeMiB defines the size of the multipart upload chunks of the S3 API. The S3 API requires multipart upload chunks to be at least 5MiB. When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default value is 10 MiB. The value is an integer number of MiB. The minimum value is 5 and the maximum value is 5120 (5 GiB).
     */
    @JsonProperty("chunkSizeMiB")
    public Integer getChunkSizeMiB() {
        return chunkSizeMiB;
    }

    /**
     * chunkSizeMiB defines the size of the multipart upload chunks of the S3 API. The S3 API requires multipart upload chunks to be at least 5MiB. When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default value is 10 MiB. The value is an integer number of MiB. The minimum value is 5 and the maximum value is 5120 (5 GiB).
     */
    @JsonProperty("chunkSizeMiB")
    public void setChunkSizeMiB(Integer chunkSizeMiB) {
        this.chunkSizeMiB = chunkSizeMiB;
    }

    /**
     * ImageRegistryConfigStorageS3 holds the information to configure the registry to use the AWS S3 service for backend storage https://docs.docker.com/registry/storage-drivers/s3/
     */
    @JsonProperty("cloudFront")
    public ImageRegistryConfigStorageS3CloudFront getCloudFront() {
        return cloudFront;
    }

    /**
     * ImageRegistryConfigStorageS3 holds the information to configure the registry to use the AWS S3 service for backend storage https://docs.docker.com/registry/storage-drivers/s3/
     */
    @JsonProperty("cloudFront")
    public void setCloudFront(ImageRegistryConfigStorageS3CloudFront cloudFront) {
        this.cloudFront = cloudFront;
    }

    /**
     * encrypt specifies whether the registry stores the image in encrypted format or not. Optional, defaults to false.
     */
    @JsonProperty("encrypt")
    public Boolean getEncrypt() {
        return encrypt;
    }

    /**
     * encrypt specifies whether the registry stores the image in encrypted format or not. Optional, defaults to false.
     */
    @JsonProperty("encrypt")
    public void setEncrypt(Boolean encrypt) {
        this.encrypt = encrypt;
    }

    /**
     * keyID is the KMS key ID to use for encryption. Optional, Encrypt must be true, or this parameter is ignored.
     */
    @JsonProperty("keyID")
    public String getKeyID() {
        return keyID;
    }

    /**
     * keyID is the KMS key ID to use for encryption. Optional, Encrypt must be true, or this parameter is ignored.
     */
    @JsonProperty("keyID")
    public void setKeyID(String keyID) {
        this.keyID = keyID;
    }

    /**
     * region is the AWS region in which your bucket exists. Optional, will be set based on the installed AWS Region.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * region is the AWS region in which your bucket exists. Optional, will be set based on the installed AWS Region.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * regionEndpoint is the endpoint for S3 compatible storage services. It should be a valid URL with scheme, e.g. https://s3.example.com. Optional, defaults based on the Region that is provided.
     */
    @JsonProperty("regionEndpoint")
    public String getRegionEndpoint() {
        return regionEndpoint;
    }

    /**
     * regionEndpoint is the endpoint for S3 compatible storage services. It should be a valid URL with scheme, e.g. https://s3.example.com. Optional, defaults based on the Region that is provided.
     */
    @JsonProperty("regionEndpoint")
    public void setRegionEndpoint(String regionEndpoint) {
        this.regionEndpoint = regionEndpoint;
    }

    /**
     * ImageRegistryConfigStorageS3 holds the information to configure the registry to use the AWS S3 service for backend storage https://docs.docker.com/registry/storage-drivers/s3/
     */
    @JsonProperty("trustedCA")
    public S3TrustedCASource getTrustedCA() {
        return trustedCA;
    }

    /**
     * ImageRegistryConfigStorageS3 holds the information to configure the registry to use the AWS S3 service for backend storage https://docs.docker.com/registry/storage-drivers/s3/
     */
    @JsonProperty("trustedCA")
    public void setTrustedCA(S3TrustedCASource trustedCA) {
        this.trustedCA = trustedCA;
    }

    /**
     * virtualHostedStyle enables using S3 virtual hosted style bucket paths with a custom RegionEndpoint Optional, defaults to false.
     */
    @JsonProperty("virtualHostedStyle")
    public Boolean getVirtualHostedStyle() {
        return virtualHostedStyle;
    }

    /**
     * virtualHostedStyle enables using S3 virtual hosted style bucket paths with a custom RegionEndpoint Optional, defaults to false.
     */
    @JsonProperty("virtualHostedStyle")
    public void setVirtualHostedStyle(Boolean virtualHostedStyle) {
        this.virtualHostedStyle = virtualHostedStyle;
    }

    @JsonIgnore
    public ImageRegistryConfigStorageS3Builder edit() {
        return new ImageRegistryConfigStorageS3Builder(this);
    }

    @JsonIgnore
    public ImageRegistryConfigStorageS3Builder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ImageRegistryConfigStorageS3)) {
            return false;
        }
        ImageRegistryConfigStorageS3 other = (ImageRegistryConfigStorageS3) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bucket = this.getBucket();
        Object other$bucket = other.getBucket();
        if (this$bucket == null ? other$bucket != null : !this$bucket.equals(other$bucket)) {
            return false;
        }
        Object this$chunkSizeMiB = this.getChunkSizeMiB();
        Object other$chunkSizeMiB = other.getChunkSizeMiB();
        if (this$chunkSizeMiB == null ? other$chunkSizeMiB != null : !this$chunkSizeMiB.equals(other$chunkSizeMiB)) {
            return false;
        }
        Object this$cloudFront = this.getCloudFront();
        Object other$cloudFront = other.getCloudFront();
        if (this$cloudFront == null ? other$cloudFront != null : !this$cloudFront.equals(other$cloudFront)) {
            return false;
        }
        Object this$encrypt = this.getEncrypt();
        Object other$encrypt = other.getEncrypt();
        if (this$encrypt == null ? other$encrypt != null : !this$encrypt.equals(other$encrypt)) {
            return false;
        }
        Object this$keyID = this.getKeyID();
        Object other$keyID = other.getKeyID();
        if (this$keyID == null ? other$keyID != null : !this$keyID.equals(other$keyID)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        Object this$regionEndpoint = this.getRegionEndpoint();
        Object other$regionEndpoint = other.getRegionEndpoint();
        if (this$regionEndpoint == null ? other$regionEndpoint != null : !this$regionEndpoint.equals(other$regionEndpoint)) {
            return false;
        }
        Object this$trustedCA = this.getTrustedCA();
        Object other$trustedCA = other.getTrustedCA();
        if (this$trustedCA == null ? other$trustedCA != null : !this$trustedCA.equals(other$trustedCA)) {
            return false;
        }
        Object this$virtualHostedStyle = this.getVirtualHostedStyle();
        Object other$virtualHostedStyle = other.getVirtualHostedStyle();
        if (this$virtualHostedStyle == null ? other$virtualHostedStyle != null : !this$virtualHostedStyle.equals(other$virtualHostedStyle)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ImageRegistryConfigStorageS3;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bucket = this.getBucket();
        result = result * prime + ($bucket == null ? 43 : $bucket.hashCode());
        Object $chunkSizeMiB = this.getChunkSizeMiB();
        result = result * prime + ($chunkSizeMiB == null ? 43 : $chunkSizeMiB.hashCode());
        Object $cloudFront = this.getCloudFront();
        result = result * prime + ($cloudFront == null ? 43 : $cloudFront.hashCode());
        Object $encrypt = this.getEncrypt();
        result = result * prime + ($encrypt == null ? 43 : $encrypt.hashCode());
        Object $keyID = this.getKeyID();
        result = result * prime + ($keyID == null ? 43 : $keyID.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $regionEndpoint = this.getRegionEndpoint();
        result = result * prime + ($regionEndpoint == null ? 43 : $regionEndpoint.hashCode());
        Object $trustedCA = this.getTrustedCA();
        result = result * prime + ($trustedCA == null ? 43 : $trustedCA.hashCode());
        Object $virtualHostedStyle = this.getVirtualHostedStyle();
        result = result * prime + ($virtualHostedStyle == null ? 43 : $virtualHostedStyle.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ImageRegistryConfigStorageS3(" + "bucket=" + this.getBucket() + ", chunkSizeMiB=" + this.getChunkSizeMiB() + ", cloudFront=" + this.getCloudFront() + ", encrypt=" + this.getEncrypt() + ", keyID=" + this.getKeyID() + ", region=" + this.getRegion() + ", regionEndpoint=" + this.getRegionEndpoint() + ", trustedCA=" + this.getTrustedCA() + ", virtualHostedStyle=" + this.getVirtualHostedStyle() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
