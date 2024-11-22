
package io.fabric8.openshift.api.model.machine.v1beta1;

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
    "autoDelete",
    "boot",
    "encryptionKey",
    "image",
    "labels",
    "sizeGb",
    "type"
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
public class GCPDisk implements Editable<GCPDiskBuilder> , KubernetesResource
{

    @JsonProperty("autoDelete")
    private Boolean autoDelete;
    @JsonProperty("boot")
    private Boolean boot;
    @JsonProperty("encryptionKey")
    private GCPEncryptionKeyReference encryptionKey;
    @JsonProperty("image")
    private String image;
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<>();
    @JsonProperty("sizeGb")
    private Long sizeGb;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GCPDisk() {
    }

    public GCPDisk(Boolean autoDelete, Boolean boot, GCPEncryptionKeyReference encryptionKey, String image, Map<String, String> labels, Long sizeGb, String type) {
        super();
        this.autoDelete = autoDelete;
        this.boot = boot;
        this.encryptionKey = encryptionKey;
        this.image = image;
        this.labels = labels;
        this.sizeGb = sizeGb;
        this.type = type;
    }

    @JsonProperty("autoDelete")
    public Boolean getAutoDelete() {
        return autoDelete;
    }

    @JsonProperty("autoDelete")
    public void setAutoDelete(Boolean autoDelete) {
        this.autoDelete = autoDelete;
    }

    @JsonProperty("boot")
    public Boolean getBoot() {
        return boot;
    }

    @JsonProperty("boot")
    public void setBoot(Boolean boot) {
        this.boot = boot;
    }

    @JsonProperty("encryptionKey")
    public GCPEncryptionKeyReference getEncryptionKey() {
        return encryptionKey;
    }

    @JsonProperty("encryptionKey")
    public void setEncryptionKey(GCPEncryptionKeyReference encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    @JsonProperty("sizeGb")
    public Long getSizeGb() {
        return sizeGb;
    }

    @JsonProperty("sizeGb")
    public void setSizeGb(Long sizeGb) {
        this.sizeGb = sizeGb;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public GCPDiskBuilder edit() {
        return new GCPDiskBuilder(this);
    }

    @JsonIgnore
    public GCPDiskBuilder toBuilder() {
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
