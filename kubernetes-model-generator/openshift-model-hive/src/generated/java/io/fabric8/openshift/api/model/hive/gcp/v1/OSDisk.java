
package io.fabric8.openshift.api.model.hive.gcp.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * OSDisk defines the disk for machines on GCP.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "diskSizeGB",
    "diskType",
    "encryptionKey"
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
public class OSDisk implements Editable<OSDiskBuilder>, KubernetesResource
{

    @JsonProperty("diskSizeGB")
    private Long diskSizeGB;
    @JsonProperty("diskType")
    private String diskType;
    @JsonProperty("encryptionKey")
    private EncryptionKeyReference encryptionKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OSDisk() {
    }

    public OSDisk(Long diskSizeGB, String diskType, EncryptionKeyReference encryptionKey) {
        super();
        this.diskSizeGB = diskSizeGB;
        this.diskType = diskType;
        this.encryptionKey = encryptionKey;
    }

    /**
     * DiskSizeGB defines the size of disk in GB. Defaulted internally to 128.
     */
    @JsonProperty("diskSizeGB")
    public Long getDiskSizeGB() {
        return diskSizeGB;
    }

    /**
     * DiskSizeGB defines the size of disk in GB. Defaulted internally to 128.
     */
    @JsonProperty("diskSizeGB")
    public void setDiskSizeGB(Long diskSizeGB) {
        this.diskSizeGB = diskSizeGB;
    }

    /**
     * DiskType defines the type of disk. The valid values are pd-standard and pd-ssd. Defaulted internally to pd-ssd.
     */
    @JsonProperty("diskType")
    public String getDiskType() {
        return diskType;
    }

    /**
     * DiskType defines the type of disk. The valid values are pd-standard and pd-ssd. Defaulted internally to pd-ssd.
     */
    @JsonProperty("diskType")
    public void setDiskType(String diskType) {
        this.diskType = diskType;
    }

    /**
     * OSDisk defines the disk for machines on GCP.
     */
    @JsonProperty("encryptionKey")
    public EncryptionKeyReference getEncryptionKey() {
        return encryptionKey;
    }

    /**
     * OSDisk defines the disk for machines on GCP.
     */
    @JsonProperty("encryptionKey")
    public void setEncryptionKey(EncryptionKeyReference encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    @JsonIgnore
    public OSDiskBuilder edit() {
        return new OSDiskBuilder(this);
    }

    @JsonIgnore
    public OSDiskBuilder toBuilder() {
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
