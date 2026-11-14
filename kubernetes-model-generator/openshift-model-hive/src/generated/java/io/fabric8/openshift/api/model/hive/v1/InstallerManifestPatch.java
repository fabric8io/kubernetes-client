
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
import tools.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "manifestSelector",
    "patches"
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
public class InstallerManifestPatch implements Editable<InstallerManifestPatchBuilder>, KubernetesResource
{

    @JsonProperty("manifestSelector")
    private ManifestSelector manifestSelector;
    @JsonProperty("patches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PatchEntity> patches = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public InstallerManifestPatch() {
    }

    public InstallerManifestPatch(ManifestSelector manifestSelector, List<PatchEntity> patches) {
        super();
        this.manifestSelector = manifestSelector;
        this.patches = patches;
    }

    @JsonProperty("manifestSelector")
    public ManifestSelector getManifestSelector() {
        return manifestSelector;
    }

    @JsonProperty("manifestSelector")
    public void setManifestSelector(ManifestSelector manifestSelector) {
        this.manifestSelector = manifestSelector;
    }

    /**
     * Patches is a list of RFC6902 patches to apply to manifests identified by manifestSelector.
     */
    @JsonProperty("patches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PatchEntity> getPatches() {
        return patches;
    }

    /**
     * Patches is a list of RFC6902 patches to apply to manifests identified by manifestSelector.
     */
    @JsonProperty("patches")
    public void setPatches(List<PatchEntity> patches) {
        this.patches = patches;
    }

    @JsonIgnore
    public InstallerManifestPatchBuilder edit() {
        return new InstallerManifestPatchBuilder(this);
    }

    @JsonIgnore
    public InstallerManifestPatchBuilder toBuilder() {
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
        if (!(o instanceof InstallerManifestPatch)) {
            return false;
        }
        InstallerManifestPatch other = (InstallerManifestPatch) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$manifestSelector = this.getManifestSelector();
        Object other$manifestSelector = other.getManifestSelector();
        if (this$manifestSelector == null ? other$manifestSelector != null : !this$manifestSelector.equals(other$manifestSelector)) {
            return false;
        }
        Object this$patches = this.getPatches();
        Object other$patches = other.getPatches();
        if (this$patches == null ? other$patches != null : !this$patches.equals(other$patches)) {
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
        return other instanceof InstallerManifestPatch;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $manifestSelector = this.getManifestSelector();
        result = result * prime + ($manifestSelector == null ? 43 : $manifestSelector.hashCode());
        Object $patches = this.getPatches();
        result = result * prime + ($patches == null ? 43 : $patches.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "InstallerManifestPatch(" + "manifestSelector=" + this.getManifestSelector() + ", patches=" + this.getPatches() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
