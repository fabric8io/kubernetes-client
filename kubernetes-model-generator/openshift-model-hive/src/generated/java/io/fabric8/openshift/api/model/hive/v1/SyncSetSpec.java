
package io.fabric8.openshift.api.model.hive.v1;

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
 * SyncSetSpec defines the SyncSetCommonSpec resources and patches to sync along with ClusterDeploymentRefs indicating which clusters the SyncSet applies to in the SyncSet's namespace.
 */
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

    /**
     * ApplyBehavior indicates how resources in this syncset will be applied to the target cluster. The default value of "Apply" indicates that resources should be applied using the 'oc apply' command. If no value is set, "Apply" is assumed. A value of "CreateOnly" indicates that the resource will only be created if it does not already exist in the target cluster. Otherwise, it will be left alone. A value of "CreateOrUpdate" indicates that the resource will be created/updated without the use of the 'oc apply' command, allowing larger resources to be synced, but losing some functionality of the 'oc apply' command such as the ability to remove annotations, labels, and other map entries in general.
     */
    @JsonProperty("applyBehavior")
    public String getApplyBehavior() {
        return applyBehavior;
    }

    /**
     * ApplyBehavior indicates how resources in this syncset will be applied to the target cluster. The default value of "Apply" indicates that resources should be applied using the 'oc apply' command. If no value is set, "Apply" is assumed. A value of "CreateOnly" indicates that the resource will only be created if it does not already exist in the target cluster. Otherwise, it will be left alone. A value of "CreateOrUpdate" indicates that the resource will be created/updated without the use of the 'oc apply' command, allowing larger resources to be synced, but losing some functionality of the 'oc apply' command such as the ability to remove annotations, labels, and other map entries in general.
     */
    @JsonProperty("applyBehavior")
    public void setApplyBehavior(String applyBehavior) {
        this.applyBehavior = applyBehavior;
    }

    /**
     * ClusterDeploymentRefs is the list of LocalObjectReference indicating which clusters the SyncSet applies to in the SyncSet's namespace.
     */
    @JsonProperty("clusterDeploymentRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LocalObjectReference> getClusterDeploymentRefs() {
        return clusterDeploymentRefs;
    }

    /**
     * ClusterDeploymentRefs is the list of LocalObjectReference indicating which clusters the SyncSet applies to in the SyncSet's namespace.
     */
    @JsonProperty("clusterDeploymentRefs")
    public void setClusterDeploymentRefs(List<LocalObjectReference> clusterDeploymentRefs) {
        this.clusterDeploymentRefs = clusterDeploymentRefs;
    }

    /**
     * EnableResourceTemplates, if True, causes hive to honor golang text/templates in Resources. While the standard syntax is supported, it won't do you a whole lot of good as the parser does not pass a data object (i.e. there is no "dot" for you to use). This currently exists to expose a single function: {{ fromCDLabel "some.label/key" }} will be substituted with the string value of ClusterDeployment.Labels["some.label/key"]. The empty string is interpolated if there are no labels, or if the indicated key does not exist. Note that this only works in values (not e.g. map keys) that are of type string.
     */
    @JsonProperty("enableResourceTemplates")
    public Boolean getEnableResourceTemplates() {
        return enableResourceTemplates;
    }

    /**
     * EnableResourceTemplates, if True, causes hive to honor golang text/templates in Resources. While the standard syntax is supported, it won't do you a whole lot of good as the parser does not pass a data object (i.e. there is no "dot" for you to use). This currently exists to expose a single function: {{ fromCDLabel "some.label/key" }} will be substituted with the string value of ClusterDeployment.Labels["some.label/key"]. The empty string is interpolated if there are no labels, or if the indicated key does not exist. Note that this only works in values (not e.g. map keys) that are of type string.
     */
    @JsonProperty("enableResourceTemplates")
    public void setEnableResourceTemplates(Boolean enableResourceTemplates) {
        this.enableResourceTemplates = enableResourceTemplates;
    }

    /**
     * Patches is the list of patches to apply.
     */
    @JsonProperty("patches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SyncObjectPatch> getPatches() {
        return patches;
    }

    /**
     * Patches is the list of patches to apply.
     */
    @JsonProperty("patches")
    public void setPatches(List<SyncObjectPatch> patches) {
        this.patches = patches;
    }

    /**
     * ResourceApplyMode indicates if the Resource apply mode is "Upsert" (default) or "Sync". ApplyMode "Upsert" indicates create and update. ApplyMode "Sync" indicates create, update and delete.
     */
    @JsonProperty("resourceApplyMode")
    public String getResourceApplyMode() {
        return resourceApplyMode;
    }

    /**
     * ResourceApplyMode indicates if the Resource apply mode is "Upsert" (default) or "Sync". ApplyMode "Upsert" indicates create and update. ApplyMode "Sync" indicates create, update and delete.
     */
    @JsonProperty("resourceApplyMode")
    public void setResourceApplyMode(String resourceApplyMode) {
        this.resourceApplyMode = resourceApplyMode;
    }

    /**
     * Resources is the list of objects to sync from RawExtension definitions.
     */
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Object> getResources() {
        return resources;
    }

    /**
     * Resources is the list of objects to sync from RawExtension definitions.
     */
    @JsonProperty("resources")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForList.class)
    public void setResources(List<Object> resources) {
        this.resources = resources;
    }

    /**
     * Secrets is the list of secrets to sync along with their respective destinations.
     */
    @JsonProperty("secretMappings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SecretMapping> getSecretMappings() {
        return secretMappings;
    }

    /**
     * Secrets is the list of secrets to sync along with their respective destinations.
     */
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
