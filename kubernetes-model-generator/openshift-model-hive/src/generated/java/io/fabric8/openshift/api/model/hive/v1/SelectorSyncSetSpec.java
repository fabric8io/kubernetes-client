
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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "applyBehavior",
    "clusterDeploymentSelector",
    "patches",
    "resourceApplyMode",
    "resources",
    "secretMappings"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class SelectorSyncSetSpec implements KubernetesResource
{

    @JsonProperty("applyBehavior")
    private java.lang.String applyBehavior;
    @JsonProperty("clusterDeploymentSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector clusterDeploymentSelector;
    @JsonProperty("patches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SyncObjectPatch> patches = new ArrayList<SyncObjectPatch>();
    @JsonProperty("resourceApplyMode")
    private java.lang.String resourceApplyMode;
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Map<String, Object>> resources = new ArrayList<Map<String, Object>>();
    @JsonProperty("secretMappings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SecretMapping> secretMappings = new ArrayList<SecretMapping>();
    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new LinkedHashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SelectorSyncSetSpec() {
    }

    public SelectorSyncSetSpec(java.lang.String applyBehavior, io.fabric8.kubernetes.api.model.LabelSelector clusterDeploymentSelector, List<SyncObjectPatch> patches, java.lang.String resourceApplyMode, List<Map<String, Object>> resources, List<SecretMapping> secretMappings) {
        super();
        this.applyBehavior = applyBehavior;
        this.clusterDeploymentSelector = clusterDeploymentSelector;
        this.patches = patches;
        this.resourceApplyMode = resourceApplyMode;
        this.resources = resources;
        this.secretMappings = secretMappings;
    }

    @JsonProperty("applyBehavior")
    public java.lang.String getApplyBehavior() {
        return applyBehavior;
    }

    @JsonProperty("applyBehavior")
    public void setApplyBehavior(java.lang.String applyBehavior) {
        this.applyBehavior = applyBehavior;
    }

    @JsonProperty("clusterDeploymentSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getClusterDeploymentSelector() {
        return clusterDeploymentSelector;
    }

    @JsonProperty("clusterDeploymentSelector")
    public void setClusterDeploymentSelector(io.fabric8.kubernetes.api.model.LabelSelector clusterDeploymentSelector) {
        this.clusterDeploymentSelector = clusterDeploymentSelector;
    }

    @JsonProperty("patches")
    public List<SyncObjectPatch> getPatches() {
        return patches;
    }

    @JsonProperty("patches")
    public void setPatches(List<SyncObjectPatch> patches) {
        this.patches = patches;
    }

    @JsonProperty("resourceApplyMode")
    public java.lang.String getResourceApplyMode() {
        return resourceApplyMode;
    }

    @JsonProperty("resourceApplyMode")
    public void setResourceApplyMode(java.lang.String resourceApplyMode) {
        this.resourceApplyMode = resourceApplyMode;
    }

    @JsonProperty("resources")
    public List<Map<String, Object>> getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(List<Map<String, Object>> resources) {
        this.resources = resources;
    }

    @JsonProperty("secretMappings")
    public List<SecretMapping> getSecretMappings() {
        return secretMappings;
    }

    @JsonProperty("secretMappings")
    public void setSecretMappings(List<SecretMapping> secretMappings) {
        this.secretMappings = secretMappings;
    }

    @JsonAnyGetter
    public Map<java.lang.String, java.lang.Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, java.lang.Object value) {
        this.additionalProperties.put(name, value);
    }

}
