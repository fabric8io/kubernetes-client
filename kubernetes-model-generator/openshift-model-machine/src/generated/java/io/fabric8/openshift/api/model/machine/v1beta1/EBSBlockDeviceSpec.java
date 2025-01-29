
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
    "deleteOnTermination",
    "encrypted",
    "iops",
    "kmsKey",
    "volumeSize",
    "volumeType"
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
public class EBSBlockDeviceSpec implements Editable<EBSBlockDeviceSpecBuilder>, KubernetesResource
{

    @JsonProperty("deleteOnTermination")
    private Boolean deleteOnTermination;
    @JsonProperty("encrypted")
    private Boolean encrypted;
    @JsonProperty("iops")
    private Long iops;
    @JsonProperty("kmsKey")
    private AWSResourceReference kmsKey;
    @JsonProperty("volumeSize")
    private Long volumeSize;
    @JsonProperty("volumeType")
    private String volumeType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EBSBlockDeviceSpec() {
    }

    public EBSBlockDeviceSpec(Boolean deleteOnTermination, Boolean encrypted, Long iops, AWSResourceReference kmsKey, Long volumeSize, String volumeType) {
        super();
        this.deleteOnTermination = deleteOnTermination;
        this.encrypted = encrypted;
        this.iops = iops;
        this.kmsKey = kmsKey;
        this.volumeSize = volumeSize;
        this.volumeType = volumeType;
    }

    @JsonProperty("deleteOnTermination")
    public Boolean getDeleteOnTermination() {
        return deleteOnTermination;
    }

    @JsonProperty("deleteOnTermination")
    public void setDeleteOnTermination(Boolean deleteOnTermination) {
        this.deleteOnTermination = deleteOnTermination;
    }

    @JsonProperty("encrypted")
    public Boolean getEncrypted() {
        return encrypted;
    }

    @JsonProperty("encrypted")
    public void setEncrypted(Boolean encrypted) {
        this.encrypted = encrypted;
    }

    @JsonProperty("iops")
    public Long getIops() {
        return iops;
    }

    @JsonProperty("iops")
    public void setIops(Long iops) {
        this.iops = iops;
    }

    @JsonProperty("kmsKey")
    public AWSResourceReference getKmsKey() {
        return kmsKey;
    }

    @JsonProperty("kmsKey")
    public void setKmsKey(AWSResourceReference kmsKey) {
        this.kmsKey = kmsKey;
    }

    @JsonProperty("volumeSize")
    public Long getVolumeSize() {
        return volumeSize;
    }

    @JsonProperty("volumeSize")
    public void setVolumeSize(Long volumeSize) {
        this.volumeSize = volumeSize;
    }

    @JsonProperty("volumeType")
    public String getVolumeType() {
        return volumeType;
    }

    @JsonProperty("volumeType")
    public void setVolumeType(String volumeType) {
        this.volumeType = volumeType;
    }

    @JsonIgnore
    public EBSBlockDeviceSpecBuilder edit() {
        return new EBSBlockDeviceSpecBuilder(this);
    }

    @JsonIgnore
    public EBSBlockDeviceSpecBuilder toBuilder() {
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
