
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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

}
