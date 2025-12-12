
package io.fabric8.kubernetes.api.model.clusterapi.metal3.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import io.fabric8.kubernetes.api.model.Condition;
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

/**
 * PreprovisioningImageStatus defines the observed state of PreprovisioningImage.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "architecture",
    "conditions",
    "extraKernelParams",
    "format",
    "imageUrl",
    "kernelUrl",
    "networkData"
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
public class PreprovisioningImageStatus implements Editable<PreprovisioningImageStatusBuilder>, KubernetesResource
{

    @JsonProperty("architecture")
    private String architecture;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("extraKernelParams")
    private String extraKernelParams;
    @JsonProperty("format")
    private String format;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("kernelUrl")
    private String kernelUrl;
    @JsonProperty("networkData")
    private SecretStatus networkData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PreprovisioningImageStatus() {
    }

    public PreprovisioningImageStatus(String architecture, List<Condition> conditions, String extraKernelParams, String format, String imageUrl, String kernelUrl, SecretStatus networkData) {
        super();
        this.architecture = architecture;
        this.conditions = conditions;
        this.extraKernelParams = extraKernelParams;
        this.format = format;
        this.imageUrl = imageUrl;
        this.kernelUrl = kernelUrl;
        this.networkData = networkData;
    }

    /**
     * architecture is the processor architecture for which the image is built
     */
    @JsonProperty("architecture")
    public String getArchitecture() {
        return architecture;
    }

    /**
     * architecture is the processor architecture for which the image is built
     */
    @JsonProperty("architecture")
    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    /**
     * conditions describe the state of the built image
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions describe the state of the built image
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * extraKernelParams is a string with extra parameters to pass to the kernel when booting the image over network. Only makes sense for initrd images.
     */
    @JsonProperty("extraKernelParams")
    public String getExtraKernelParams() {
        return extraKernelParams;
    }

    /**
     * extraKernelParams is a string with extra parameters to pass to the kernel when booting the image over network. Only makes sense for initrd images.
     */
    @JsonProperty("extraKernelParams")
    public void setExtraKernelParams(String extraKernelParams) {
        this.extraKernelParams = extraKernelParams;
    }

    /**
     * format is the type of image that is available at the download url: either iso or initrd.
     */
    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    /**
     * format is the type of image that is available at the download url: either iso or initrd.
     */
    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * imageUrl is the URL from which the built image can be downloaded.
     */
    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * imageUrl is the URL from which the built image can be downloaded.
     */
    @JsonProperty("imageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * kernelUrl is the URL from which the kernel of the image can be downloaded. Only makes sense for initrd images.
     */
    @JsonProperty("kernelUrl")
    public String getKernelUrl() {
        return kernelUrl;
    }

    /**
     * kernelUrl is the URL from which the kernel of the image can be downloaded. Only makes sense for initrd images.
     */
    @JsonProperty("kernelUrl")
    public void setKernelUrl(String kernelUrl) {
        this.kernelUrl = kernelUrl;
    }

    /**
     * PreprovisioningImageStatus defines the observed state of PreprovisioningImage.
     */
    @JsonProperty("networkData")
    public SecretStatus getNetworkData() {
        return networkData;
    }

    /**
     * PreprovisioningImageStatus defines the observed state of PreprovisioningImage.
     */
    @JsonProperty("networkData")
    public void setNetworkData(SecretStatus networkData) {
        this.networkData = networkData;
    }

    @JsonIgnore
    public PreprovisioningImageStatusBuilder edit() {
        return new PreprovisioningImageStatusBuilder(this);
    }

    @JsonIgnore
    public PreprovisioningImageStatusBuilder toBuilder() {
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
