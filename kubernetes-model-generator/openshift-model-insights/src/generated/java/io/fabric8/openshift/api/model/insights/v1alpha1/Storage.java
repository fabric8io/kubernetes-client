
package io.fabric8.openshift.api.model.insights.v1alpha1;

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
 * storage provides persistent storage configuration options for gathering jobs. If the type is set to PersistentVolume, then the PersistentVolume must be defined. If the type is set to Ephemeral, then the PersistentVolume must not be defined.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "persistentVolume",
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Storage implements Editable<StorageBuilder>, KubernetesResource
{

    @JsonProperty("persistentVolume")
    private PersistentVolumeConfig persistentVolume;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Storage() {
    }

    public Storage(PersistentVolumeConfig persistentVolume, String type) {
        super();
        this.persistentVolume = persistentVolume;
        this.type = type;
    }

    /**
     * storage provides persistent storage configuration options for gathering jobs. If the type is set to PersistentVolume, then the PersistentVolume must be defined. If the type is set to Ephemeral, then the PersistentVolume must not be defined.
     */
    @JsonProperty("persistentVolume")
    public PersistentVolumeConfig getPersistentVolume() {
        return persistentVolume;
    }

    /**
     * storage provides persistent storage configuration options for gathering jobs. If the type is set to PersistentVolume, then the PersistentVolume must be defined. If the type is set to Ephemeral, then the PersistentVolume must not be defined.
     */
    @JsonProperty("persistentVolume")
    public void setPersistentVolume(PersistentVolumeConfig persistentVolume) {
        this.persistentVolume = persistentVolume;
    }

    /**
     * type is a required field that specifies the type of storage that will be used to store the Insights data archive. Valid values are "PersistentVolume" and "Ephemeral". When set to Ephemeral, the Insights data archive is stored in the ephemeral storage of the gathering job. When set to PersistentVolume, the Insights data archive is stored in the PersistentVolume that is defined by the PersistentVolume field.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is a required field that specifies the type of storage that will be used to store the Insights data archive. Valid values are "PersistentVolume" and "Ephemeral". When set to Ephemeral, the Insights data archive is stored in the ephemeral storage of the gathering job. When set to PersistentVolume, the Insights data archive is stored in the PersistentVolume that is defined by the PersistentVolume field.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public StorageBuilder edit() {
        return new StorageBuilder(this);
    }

    @JsonIgnore
    public StorageBuilder toBuilder() {
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
