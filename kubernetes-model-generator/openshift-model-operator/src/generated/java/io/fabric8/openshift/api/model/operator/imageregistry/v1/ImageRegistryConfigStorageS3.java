
package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
public class ImageRegistryConfigStorageS3 implements Editable<ImageRegistryConfigStorageS3Builder> , KubernetesResource
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
     * 
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

    @JsonProperty("bucket")
    public String getBucket() {
        return bucket;
    }

    @JsonProperty("bucket")
    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    @JsonProperty("chunkSizeMiB")
    public Integer getChunkSizeMiB() {
        return chunkSizeMiB;
    }

    @JsonProperty("chunkSizeMiB")
    public void setChunkSizeMiB(Integer chunkSizeMiB) {
        this.chunkSizeMiB = chunkSizeMiB;
    }

    @JsonProperty("cloudFront")
    public ImageRegistryConfigStorageS3CloudFront getCloudFront() {
        return cloudFront;
    }

    @JsonProperty("cloudFront")
    public void setCloudFront(ImageRegistryConfigStorageS3CloudFront cloudFront) {
        this.cloudFront = cloudFront;
    }

    @JsonProperty("encrypt")
    public Boolean getEncrypt() {
        return encrypt;
    }

    @JsonProperty("encrypt")
    public void setEncrypt(Boolean encrypt) {
        this.encrypt = encrypt;
    }

    @JsonProperty("keyID")
    public String getKeyID() {
        return keyID;
    }

    @JsonProperty("keyID")
    public void setKeyID(String keyID) {
        this.keyID = keyID;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("regionEndpoint")
    public String getRegionEndpoint() {
        return regionEndpoint;
    }

    @JsonProperty("regionEndpoint")
    public void setRegionEndpoint(String regionEndpoint) {
        this.regionEndpoint = regionEndpoint;
    }

    @JsonProperty("trustedCA")
    public S3TrustedCASource getTrustedCA() {
        return trustedCA;
    }

    @JsonProperty("trustedCA")
    public void setTrustedCA(S3TrustedCASource trustedCA) {
        this.trustedCA = trustedCA;
    }

    @JsonProperty("virtualHostedStyle")
    public Boolean getVirtualHostedStyle() {
        return virtualHostedStyle;
    }

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

}
