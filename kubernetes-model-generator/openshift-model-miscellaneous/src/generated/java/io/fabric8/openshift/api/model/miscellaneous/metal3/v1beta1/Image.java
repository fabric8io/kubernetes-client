
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
 * Image holds the details of an image to use during provisioning.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "checksum",
    "checksumType",
    "format",
    "url"
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
public class Image implements Editable<ImageBuilder>, KubernetesResource
{

    @JsonProperty("checksum")
    private String checksum;
    @JsonProperty("checksumType")
    private String checksumType;
    @JsonProperty("format")
    private String format;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Image() {
    }

    public Image(String checksum, String checksumType, String format, String url) {
        super();
        this.checksum = checksum;
        this.checksumType = checksumType;
        this.format = format;
        this.url = url;
    }

    /**
     * Checksum is a md5sum, sha256sum or sha512sum value or a URL to retrieve one.
     */
    @JsonProperty("checksum")
    public String getChecksum() {
        return checksum;
    }

    /**
     * Checksum is a md5sum, sha256sum or sha512sum value or a URL to retrieve one.
     */
    @JsonProperty("checksum")
    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    /**
     * ChecksumType is the checksum algorithm for the image. e.g md5, sha256, sha512
     */
    @JsonProperty("checksumType")
    public String getChecksumType() {
        return checksumType;
    }

    /**
     * ChecksumType is the checksum algorithm for the image. e.g md5, sha256, sha512
     */
    @JsonProperty("checksumType")
    public void setChecksumType(String checksumType) {
        this.checksumType = checksumType;
    }

    /**
     * DiskFormat contains the image disk format.
     */
    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    /**
     * DiskFormat contains the image disk format.
     */
    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * URL is a location of an image to deploy.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * URL is a location of an image to deploy.
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public ImageBuilder edit() {
        return new ImageBuilder(this);
    }

    @JsonIgnore
    public ImageBuilder toBuilder() {
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
        if (!(o instanceof Image)) {
            return false;
        }
        Image other = (Image) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$checksum = this.getChecksum();
        Object other$checksum = other.getChecksum();
        if (this$checksum == null ? other$checksum != null : !this$checksum.equals(other$checksum)) {
            return false;
        }
        Object this$checksumType = this.getChecksumType();
        Object other$checksumType = other.getChecksumType();
        if (this$checksumType == null ? other$checksumType != null : !this$checksumType.equals(other$checksumType)) {
            return false;
        }
        Object this$format = this.getFormat();
        Object other$format = other.getFormat();
        if (this$format == null ? other$format != null : !this$format.equals(other$format)) {
            return false;
        }
        Object this$url = this.getUrl();
        Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) {
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
        return other instanceof Image;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $checksum = this.getChecksum();
        result = result * prime + ($checksum == null ? 43 : $checksum.hashCode());
        Object $checksumType = this.getChecksumType();
        result = result * prime + ($checksumType == null ? 43 : $checksumType.hashCode());
        Object $format = this.getFormat();
        result = result * prime + ($format == null ? 43 : $format.hashCode());
        Object $url = this.getUrl();
        result = result * prime + ($url == null ? 43 : $url.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Image(" + "checksum=" + this.getChecksum() + ", checksumType=" + this.getChecksumType() + ", format=" + this.getFormat() + ", url=" + this.getUrl() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
