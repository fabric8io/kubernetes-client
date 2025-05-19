
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.EmptyDirVolumeSource;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.EphemeralVolumeSource;
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
 * StorageSpec defines the configured storage for a group Prometheus servers. If no storage option is specified, then by default an [EmptyDir](https://kubernetes.io/docs/concepts/storage/volumes/#emptydir) will be used.<br><p> <br><p> If multiple storage options are specified, priority will be given as follows:<br><p>  1. emptyDir<br><p>  2. ephemeral<br><p>  3. volumeClaimTemplate
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "disableMountSubPath",
    "emptyDir",
    "ephemeral",
    "volumeClaimTemplate"
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
public class StorageSpec implements Editable<StorageSpecBuilder>, KubernetesResource
{

    @JsonProperty("disableMountSubPath")
    private Boolean disableMountSubPath;
    @JsonProperty("emptyDir")
    private EmptyDirVolumeSource emptyDir;
    @JsonProperty("ephemeral")
    private EphemeralVolumeSource ephemeral;
    @JsonProperty("volumeClaimTemplate")
    private EmbeddedPersistentVolumeClaim volumeClaimTemplate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StorageSpec() {
    }

    public StorageSpec(Boolean disableMountSubPath, EmptyDirVolumeSource emptyDir, EphemeralVolumeSource ephemeral, EmbeddedPersistentVolumeClaim volumeClaimTemplate) {
        super();
        this.disableMountSubPath = disableMountSubPath;
        this.emptyDir = emptyDir;
        this.ephemeral = ephemeral;
        this.volumeClaimTemplate = volumeClaimTemplate;
    }

    /**
     * Deprecated: subPath usage will be removed in a future release.
     */
    @JsonProperty("disableMountSubPath")
    public Boolean getDisableMountSubPath() {
        return disableMountSubPath;
    }

    /**
     * Deprecated: subPath usage will be removed in a future release.
     */
    @JsonProperty("disableMountSubPath")
    public void setDisableMountSubPath(Boolean disableMountSubPath) {
        this.disableMountSubPath = disableMountSubPath;
    }

    /**
     * StorageSpec defines the configured storage for a group Prometheus servers. If no storage option is specified, then by default an [EmptyDir](https://kubernetes.io/docs/concepts/storage/volumes/#emptydir) will be used.<br><p> <br><p> If multiple storage options are specified, priority will be given as follows:<br><p>  1. emptyDir<br><p>  2. ephemeral<br><p>  3. volumeClaimTemplate
     */
    @JsonProperty("emptyDir")
    public EmptyDirVolumeSource getEmptyDir() {
        return emptyDir;
    }

    /**
     * StorageSpec defines the configured storage for a group Prometheus servers. If no storage option is specified, then by default an [EmptyDir](https://kubernetes.io/docs/concepts/storage/volumes/#emptydir) will be used.<br><p> <br><p> If multiple storage options are specified, priority will be given as follows:<br><p>  1. emptyDir<br><p>  2. ephemeral<br><p>  3. volumeClaimTemplate
     */
    @JsonProperty("emptyDir")
    public void setEmptyDir(EmptyDirVolumeSource emptyDir) {
        this.emptyDir = emptyDir;
    }

    /**
     * StorageSpec defines the configured storage for a group Prometheus servers. If no storage option is specified, then by default an [EmptyDir](https://kubernetes.io/docs/concepts/storage/volumes/#emptydir) will be used.<br><p> <br><p> If multiple storage options are specified, priority will be given as follows:<br><p>  1. emptyDir<br><p>  2. ephemeral<br><p>  3. volumeClaimTemplate
     */
    @JsonProperty("ephemeral")
    public EphemeralVolumeSource getEphemeral() {
        return ephemeral;
    }

    /**
     * StorageSpec defines the configured storage for a group Prometheus servers. If no storage option is specified, then by default an [EmptyDir](https://kubernetes.io/docs/concepts/storage/volumes/#emptydir) will be used.<br><p> <br><p> If multiple storage options are specified, priority will be given as follows:<br><p>  1. emptyDir<br><p>  2. ephemeral<br><p>  3. volumeClaimTemplate
     */
    @JsonProperty("ephemeral")
    public void setEphemeral(EphemeralVolumeSource ephemeral) {
        this.ephemeral = ephemeral;
    }

    /**
     * StorageSpec defines the configured storage for a group Prometheus servers. If no storage option is specified, then by default an [EmptyDir](https://kubernetes.io/docs/concepts/storage/volumes/#emptydir) will be used.<br><p> <br><p> If multiple storage options are specified, priority will be given as follows:<br><p>  1. emptyDir<br><p>  2. ephemeral<br><p>  3. volumeClaimTemplate
     */
    @JsonProperty("volumeClaimTemplate")
    public EmbeddedPersistentVolumeClaim getVolumeClaimTemplate() {
        return volumeClaimTemplate;
    }

    /**
     * StorageSpec defines the configured storage for a group Prometheus servers. If no storage option is specified, then by default an [EmptyDir](https://kubernetes.io/docs/concepts/storage/volumes/#emptydir) will be used.<br><p> <br><p> If multiple storage options are specified, priority will be given as follows:<br><p>  1. emptyDir<br><p>  2. ephemeral<br><p>  3. volumeClaimTemplate
     */
    @JsonProperty("volumeClaimTemplate")
    public void setVolumeClaimTemplate(EmbeddedPersistentVolumeClaim volumeClaimTemplate) {
        this.volumeClaimTemplate = volumeClaimTemplate;
    }

    @JsonIgnore
    public StorageSpecBuilder edit() {
        return new StorageSpecBuilder(this);
    }

    @JsonIgnore
    public StorageSpecBuilder toBuilder() {
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
