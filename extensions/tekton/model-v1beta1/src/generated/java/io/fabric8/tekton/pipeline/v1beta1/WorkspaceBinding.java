
package io.fabric8.tekton.pipeline.v1beta1;

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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
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
@Setter
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
    @BuildableReference(io.fabric8.kubernetes.api.model.PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("jsonschema2pojo")
public class WorkspaceBinding implements KubernetesResource
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
    private io.fabric8.kubernetes.api.model.PersistentVolumeClaim volumeClaimTemplate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WorkspaceBinding() {
    }

    public WorkspaceBinding(ConfigMapVolumeSource configMap, CSIVolumeSource csi, EmptyDirVolumeSource emptyDir, String name, PersistentVolumeClaimVolumeSource persistentVolumeClaim, ProjectedVolumeSource projected, SecretVolumeSource secret, String subPath, io.fabric8.kubernetes.api.model.PersistentVolumeClaim volumeClaimTemplate) {
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

    @JsonProperty("configMap")
    public ConfigMapVolumeSource getConfigMap() {
        return configMap;
    }

    @JsonProperty("configMap")
    public void setConfigMap(ConfigMapVolumeSource configMap) {
        this.configMap = configMap;
    }

    @JsonProperty("csi")
    public CSIVolumeSource getCsi() {
        return csi;
    }

    @JsonProperty("csi")
    public void setCsi(CSIVolumeSource csi) {
        this.csi = csi;
    }

    @JsonProperty("emptyDir")
    public EmptyDirVolumeSource getEmptyDir() {
        return emptyDir;
    }

    @JsonProperty("emptyDir")
    public void setEmptyDir(EmptyDirVolumeSource emptyDir) {
        this.emptyDir = emptyDir;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("persistentVolumeClaim")
    public PersistentVolumeClaimVolumeSource getPersistentVolumeClaim() {
        return persistentVolumeClaim;
    }

    @JsonProperty("persistentVolumeClaim")
    public void setPersistentVolumeClaim(PersistentVolumeClaimVolumeSource persistentVolumeClaim) {
        this.persistentVolumeClaim = persistentVolumeClaim;
    }

    @JsonProperty("projected")
    public ProjectedVolumeSource getProjected() {
        return projected;
    }

    @JsonProperty("projected")
    public void setProjected(ProjectedVolumeSource projected) {
        this.projected = projected;
    }

    @JsonProperty("secret")
    public SecretVolumeSource getSecret() {
        return secret;
    }

    @JsonProperty("secret")
    public void setSecret(SecretVolumeSource secret) {
        this.secret = secret;
    }

    @JsonProperty("subPath")
    public String getSubPath() {
        return subPath;
    }

    @JsonProperty("subPath")
    public void setSubPath(String subPath) {
        this.subPath = subPath;
    }

    @JsonProperty("volumeClaimTemplate")
    public io.fabric8.kubernetes.api.model.PersistentVolumeClaim getVolumeClaimTemplate() {
        return volumeClaimTemplate;
    }

    @JsonProperty("volumeClaimTemplate")
    public void setVolumeClaimTemplate(io.fabric8.kubernetes.api.model.PersistentVolumeClaim volumeClaimTemplate) {
        this.volumeClaimTemplate = volumeClaimTemplate;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
