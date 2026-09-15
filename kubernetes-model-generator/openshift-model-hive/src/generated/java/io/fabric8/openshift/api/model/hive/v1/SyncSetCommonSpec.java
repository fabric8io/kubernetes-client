
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

/**
 * SyncSetCommonSpec defines the resources and patches to sync
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "applyBehavior",
    "enableResourceTemplates",
    "patches",
    "resourceApplyMode",
    "resources",
    "secretMappings"
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
public class SyncSetCommonSpec implements Editable<SyncSetCommonSpecBuilder>, KubernetesResource
{

    @JsonProperty("applyBehavior")
    private String applyBehavior;
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
    public SyncSetCommonSpec() {
    }

    public SyncSetCommonSpec(String applyBehavior, Boolean enableResourceTemplates, List<SyncObjectPatch> patches, String resourceApplyMode, List<Object> resources, List<SecretMapping> secretMappings) {
        super();
        this.applyBehavior = applyBehavior;
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
    public SyncSetCommonSpecBuilder edit() {
        return new SyncSetCommonSpecBuilder(this);
    }

    @JsonIgnore
    public SyncSetCommonSpecBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SyncSetCommonSpec)) {
            return false;
        }
        SyncSetCommonSpec other = (SyncSetCommonSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$applyBehavior = this.getApplyBehavior();
        Object other$applyBehavior = other.getApplyBehavior();
        if (this$applyBehavior == null ? other$applyBehavior != null : !this$applyBehavior.equals(other$applyBehavior)) {
            return false;
        }
        Object this$enableResourceTemplates = this.getEnableResourceTemplates();
        Object other$enableResourceTemplates = other.getEnableResourceTemplates();
        if (this$enableResourceTemplates == null ? other$enableResourceTemplates != null : !this$enableResourceTemplates.equals(other$enableResourceTemplates)) {
            return false;
        }
        Object this$patches = this.getPatches();
        Object other$patches = other.getPatches();
        if (this$patches == null ? other$patches != null : !this$patches.equals(other$patches)) {
            return false;
        }
        Object this$resourceApplyMode = this.getResourceApplyMode();
        Object other$resourceApplyMode = other.getResourceApplyMode();
        if (this$resourceApplyMode == null ? other$resourceApplyMode != null : !this$resourceApplyMode.equals(other$resourceApplyMode)) {
            return false;
        }
        Object this$resources = this.getResources();
        Object other$resources = other.getResources();
        if (this$resources == null ? other$resources != null : !this$resources.equals(other$resources)) {
            return false;
        }
        Object this$secretMappings = this.getSecretMappings();
        Object other$secretMappings = other.getSecretMappings();
        if (this$secretMappings == null ? other$secretMappings != null : !this$secretMappings.equals(other$secretMappings)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof SyncSetCommonSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $applyBehavior = this.getApplyBehavior();
        result = result * prime + ($applyBehavior == null ? 43 : $applyBehavior.hashCode());
        Object $enableResourceTemplates = this.getEnableResourceTemplates();
        result = result * prime + ($enableResourceTemplates == null ? 43 : $enableResourceTemplates.hashCode());
        Object $patches = this.getPatches();
        result = result * prime + ($patches == null ? 43 : $patches.hashCode());
        Object $resourceApplyMode = this.getResourceApplyMode();
        result = result * prime + ($resourceApplyMode == null ? 43 : $resourceApplyMode.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $secretMappings = this.getSecretMappings();
        result = result * prime + ($secretMappings == null ? 43 : $secretMappings.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SyncSetCommonSpec(" + "applyBehavior=" + this.getApplyBehavior() + ", enableResourceTemplates=" + this.getEnableResourceTemplates() + ", patches=" + this.getPatches() + ", resourceApplyMode=" + this.getResourceApplyMode() + ", resources=" + this.getResources() + ", secretMappings=" + this.getSecretMappings() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
