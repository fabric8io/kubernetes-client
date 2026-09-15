
package io.fabric8.openshift.api.model.config.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalTrustedCA",
    "buildDefaults",
    "buildOverrides"
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
public class BuildSpec implements Editable<BuildSpecBuilder>, KubernetesResource
{

    @JsonProperty("additionalTrustedCA")
    private ConfigMapNameReference additionalTrustedCA;
    @JsonProperty("buildDefaults")
    private BuildDefaults buildDefaults;
    @JsonProperty("buildOverrides")
    private BuildOverrides buildOverrides;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BuildSpec() {
    }

    public BuildSpec(ConfigMapNameReference additionalTrustedCA, BuildDefaults buildDefaults, BuildOverrides buildOverrides) {
        super();
        this.additionalTrustedCA = additionalTrustedCA;
        this.buildDefaults = buildDefaults;
        this.buildOverrides = buildOverrides;
    }

    @JsonProperty("additionalTrustedCA")
    public ConfigMapNameReference getAdditionalTrustedCA() {
        return additionalTrustedCA;
    }

    @JsonProperty("additionalTrustedCA")
    public void setAdditionalTrustedCA(ConfigMapNameReference additionalTrustedCA) {
        this.additionalTrustedCA = additionalTrustedCA;
    }

    @JsonProperty("buildDefaults")
    public BuildDefaults getBuildDefaults() {
        return buildDefaults;
    }

    @JsonProperty("buildDefaults")
    public void setBuildDefaults(BuildDefaults buildDefaults) {
        this.buildDefaults = buildDefaults;
    }

    @JsonProperty("buildOverrides")
    public BuildOverrides getBuildOverrides() {
        return buildOverrides;
    }

    @JsonProperty("buildOverrides")
    public void setBuildOverrides(BuildOverrides buildOverrides) {
        this.buildOverrides = buildOverrides;
    }

    @JsonIgnore
    public BuildSpecBuilder edit() {
        return new BuildSpecBuilder(this);
    }

    @JsonIgnore
    public BuildSpecBuilder toBuilder() {
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
        if (!(o instanceof BuildSpec)) {
            return false;
        }
        BuildSpec other = (BuildSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$additionalTrustedCA = this.getAdditionalTrustedCA();
        Object other$additionalTrustedCA = other.getAdditionalTrustedCA();
        if (this$additionalTrustedCA == null ? other$additionalTrustedCA != null : !this$additionalTrustedCA.equals(other$additionalTrustedCA)) {
            return false;
        }
        Object this$buildDefaults = this.getBuildDefaults();
        Object other$buildDefaults = other.getBuildDefaults();
        if (this$buildDefaults == null ? other$buildDefaults != null : !this$buildDefaults.equals(other$buildDefaults)) {
            return false;
        }
        Object this$buildOverrides = this.getBuildOverrides();
        Object other$buildOverrides = other.getBuildOverrides();
        if (this$buildOverrides == null ? other$buildOverrides != null : !this$buildOverrides.equals(other$buildOverrides)) {
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
        return other instanceof BuildSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $additionalTrustedCA = this.getAdditionalTrustedCA();
        result = result * prime + ($additionalTrustedCA == null ? 43 : $additionalTrustedCA.hashCode());
        Object $buildDefaults = this.getBuildDefaults();
        result = result * prime + ($buildDefaults == null ? 43 : $buildDefaults.hashCode());
        Object $buildOverrides = this.getBuildOverrides();
        result = result * prime + ($buildOverrides == null ? 43 : $buildOverrides.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BuildSpec(" + "additionalTrustedCA=" + this.getAdditionalTrustedCA() + ", buildDefaults=" + this.getBuildDefaults() + ", buildOverrides=" + this.getBuildOverrides() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
