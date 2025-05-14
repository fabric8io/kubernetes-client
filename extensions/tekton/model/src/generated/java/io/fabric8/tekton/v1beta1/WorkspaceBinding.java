
package io.fabric8.tekton.v1beta1;

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
import io.fabric8.kubernetes.api.model.CSIVolumeSource;
import io.fabric8.kubernetes.api.model.ConfigMapVolumeSource;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EmptyDirVolumeSource;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimVolumeSource;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ProjectedVolumeSource;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretVolumeSource;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * WorkspaceBinding maps a Task's declared workspace to a Volume.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configMap",
    "csi",
    "emptyDir",
    "name",
    "persistentVolumeClaim",
    "projected",
    "secret",
    "subPath",
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class WorkspaceBinding implements Editable<WorkspaceBindingBuilder>, KubernetesResource
{

    @JsonProperty("configMap")
    private ConfigMapVolumeSource configMap;
    @JsonProperty("csi")
    private CSIVolumeSource csi;
    @JsonProperty("emptyDir")
    private EmptyDirVolumeSource emptyDir;
    @JsonProperty("name")
    private String name;
    @JsonProperty("persistentVolumeClaim")
    private PersistentVolumeClaimVolumeSource persistentVolumeClaim;
    @JsonProperty("projected")
    private ProjectedVolumeSource projected;
    @JsonProperty("secret")
    private SecretVolumeSource secret;
    @JsonProperty("subPath")
    private String subPath;
    @JsonProperty("volumeClaimTemplate")
    private PersistentVolumeClaim volumeClaimTemplate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WorkspaceBinding() {
    }

    public WorkspaceBinding(ConfigMapVolumeSource configMap, CSIVolumeSource csi, EmptyDirVolumeSource emptyDir, String name, PersistentVolumeClaimVolumeSource persistentVolumeClaim, ProjectedVolumeSource projected, SecretVolumeSource secret, String subPath, PersistentVolumeClaim volumeClaimTemplate) {
        super();
        this.configMap = configMap;
        this.csi = csi;
        this.emptyDir = emptyDir;
        this.name = name;
        this.persistentVolumeClaim = persistentVolumeClaim;
        this.projected = projected;
        this.secret = secret;
        this.subPath = subPath;
        this.volumeClaimTemplate = volumeClaimTemplate;
    }

    /**
     * WorkspaceBinding maps a Task's declared workspace to a Volume.
     */
    @JsonProperty("configMap")
    public ConfigMapVolumeSource getConfigMap() {
        return configMap;
    }

    /**
     * WorkspaceBinding maps a Task's declared workspace to a Volume.
     */
    @JsonProperty("configMap")
    public void setConfigMap(ConfigMapVolumeSource configMap) {
        this.configMap = configMap;
    }

    /**
     * WorkspaceBinding maps a Task's declared workspace to a Volume.
     */
    @JsonProperty("csi")
    public CSIVolumeSource getCsi() {
        return csi;
    }

    /**
     * WorkspaceBinding maps a Task's declared workspace to a Volume.
     */
    @JsonProperty("csi")
    public void setCsi(CSIVolumeSource csi) {
        this.csi = csi;
    }

    /**
     * WorkspaceBinding maps a Task's declared workspace to a Volume.
     */
    @JsonProperty("emptyDir")
    public EmptyDirVolumeSource getEmptyDir() {
        return emptyDir;
    }

    /**
     * WorkspaceBinding maps a Task's declared workspace to a Volume.
     */
    @JsonProperty("emptyDir")
    public void setEmptyDir(EmptyDirVolumeSource emptyDir) {
        this.emptyDir = emptyDir;
    }

    /**
     * Name is the name of the workspace populated by the volume.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the workspace populated by the volume.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * WorkspaceBinding maps a Task's declared workspace to a Volume.
     */
    @JsonProperty("persistentVolumeClaim")
    public PersistentVolumeClaimVolumeSource getPersistentVolumeClaim() {
        return persistentVolumeClaim;
    }

    /**
     * WorkspaceBinding maps a Task's declared workspace to a Volume.
     */
    @JsonProperty("persistentVolumeClaim")
    public void setPersistentVolumeClaim(PersistentVolumeClaimVolumeSource persistentVolumeClaim) {
        this.persistentVolumeClaim = persistentVolumeClaim;
    }

    /**
     * WorkspaceBinding maps a Task's declared workspace to a Volume.
     */
    @JsonProperty("projected")
    public ProjectedVolumeSource getProjected() {
        return projected;
    }

    /**
     * WorkspaceBinding maps a Task's declared workspace to a Volume.
     */
    @JsonProperty("projected")
    public void setProjected(ProjectedVolumeSource projected) {
        this.projected = projected;
    }

    /**
     * WorkspaceBinding maps a Task's declared workspace to a Volume.
     */
    @JsonProperty("secret")
    public SecretVolumeSource getSecret() {
        return secret;
    }

    /**
     * WorkspaceBinding maps a Task's declared workspace to a Volume.
     */
    @JsonProperty("secret")
    public void setSecret(SecretVolumeSource secret) {
        this.secret = secret;
    }

    /**
     * SubPath is optionally a directory on the volume which should be used for this binding (i.e. the volume will be mounted at this sub directory).
     */
    @JsonProperty("subPath")
    public String getSubPath() {
        return subPath;
    }

    /**
     * SubPath is optionally a directory on the volume which should be used for this binding (i.e. the volume will be mounted at this sub directory).
     */
    @JsonProperty("subPath")
    public void setSubPath(String subPath) {
        this.subPath = subPath;
    }

    /**
     * WorkspaceBinding maps a Task's declared workspace to a Volume.
     */
    @JsonProperty("volumeClaimTemplate")
    public PersistentVolumeClaim getVolumeClaimTemplate() {
        return volumeClaimTemplate;
    }

    /**
     * WorkspaceBinding maps a Task's declared workspace to a Volume.
     */
    @JsonProperty("volumeClaimTemplate")
    public void setVolumeClaimTemplate(PersistentVolumeClaim volumeClaimTemplate) {
        this.volumeClaimTemplate = volumeClaimTemplate;
    }

    @JsonIgnore
    public WorkspaceBindingBuilder edit() {
        return new WorkspaceBindingBuilder(this);
    }

    @JsonIgnore
    public WorkspaceBindingBuilder toBuilder() {
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
