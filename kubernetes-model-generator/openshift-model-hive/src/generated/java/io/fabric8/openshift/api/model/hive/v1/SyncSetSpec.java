
package io.fabric8.openshift.api.model.hive.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    "applyBehavior",
    "clusterDeploymentRefs",
    "enableResourceTemplates",
    "patches",
    "resourceApplyMode",
    "resources",
    "secretMappings"
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
public class SyncSetSpec implements Editable<SyncSetSpecBuilder>, KubernetesResource
{

    @JsonProperty("applyBehavior")
    private String applyBehavior;
    @JsonProperty("clusterDeploymentRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LocalObjectReference> clusterDeploymentRefs = new ArrayList<>();
    @JsonProperty("enableResourceTemplates")
    private Boolean enableResourceTemplates;
    @JsonProperty("patches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SyncObjectPatch> patches = new ArrayList<>();
    @JsonProperty("resourceApplyMode")
    private String resourceApplyMode;
    @JsonProperty("resources")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForList.class)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Object> resources = new ArrayList<>();
    @JsonProperty("secretMappings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SecretMapping> secretMappings = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SyncSetSpec() {
    }

    public SyncSetSpec(String applyBehavior, List<LocalObjectReference> clusterDeploymentRefs, Boolean enableResourceTemplates, List<SyncObjectPatch> patches, String resourceApplyMode, List<Object> resources, List<SecretMapping> secretMappings) {
        super();
        this.applyBehavior = applyBehavior;
        this.clusterDeploymentRefs = clusterDeploymentRefs;
        this.enableResourceTemplates = enableResourceTemplates;
        this.patches = patches;
        this.resourceApplyMode = resourceApplyMode;
        this.resources = resources;
        this.secretMappings = secretMappings;
    }

    @JsonProperty("applyBehavior")
    public String getApplyBehavior() {
        return applyBehavior;
    }

    @JsonProperty("applyBehavior")
    public void setApplyBehavior(String applyBehavior) {
        this.applyBehavior = applyBehavior;
    }

    @JsonProperty("clusterDeploymentRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LocalObjectReference> getClusterDeploymentRefs() {
        return clusterDeploymentRefs;
    }

    @JsonProperty("clusterDeploymentRefs")
    public void setClusterDeploymentRefs(List<LocalObjectReference> clusterDeploymentRefs) {
        this.clusterDeploymentRefs = clusterDeploymentRefs;
    }

    @JsonProperty("enableResourceTemplates")
    public Boolean getEnableResourceTemplates() {
        return enableResourceTemplates;
    }

    @JsonProperty("enableResourceTemplates")
    public void setEnableResourceTemplates(Boolean enableResourceTemplates) {
        this.enableResourceTemplates = enableResourceTemplates;
    }

    @JsonProperty("patches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SyncObjectPatch> getPatches() {
        return patches;
    }

    @JsonProperty("patches")
    public void setPatches(List<SyncObjectPatch> patches) {
        this.patches = patches;
    }

    @JsonProperty("resourceApplyMode")
    public String getResourceApplyMode() {
        return resourceApplyMode;
    }

    @JsonProperty("resourceApplyMode")
    public void setResourceApplyMode(String resourceApplyMode) {
        this.resourceApplyMode = resourceApplyMode;
    }

    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Object> getResources() {
        return resources;
    }

    @JsonProperty("resources")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForList.class)
    public void setResources(List<Object> resources) {
        this.resources = resources;
    }

    @JsonProperty("secretMappings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SecretMapping> getSecretMappings() {
        return secretMappings;
    }

    @JsonProperty("secretMappings")
    public void setSecretMappings(List<SecretMapping> secretMappings) {
        this.secretMappings = secretMappings;
    }

    @JsonIgnore
    public SyncSetSpecBuilder edit() {
        return new SyncSetSpecBuilder(this);
    }

    @JsonIgnore
    public SyncSetSpecBuilder toBuilder() {
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
