
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

/**
 * InfrastructureSpec contains settings that apply to the cluster infrastructure.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cloudConfig",
    "platformSpec"
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
public class InfrastructureSpec implements Editable<InfrastructureSpecBuilder>, KubernetesResource
{

    @JsonProperty("cloudConfig")
    private ConfigMapFileReference cloudConfig;
    @JsonProperty("platformSpec")
    private PlatformSpec platformSpec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public InfrastructureSpec() {
    }

    public InfrastructureSpec(ConfigMapFileReference cloudConfig, PlatformSpec platformSpec) {
        super();
        this.cloudConfig = cloudConfig;
        this.platformSpec = platformSpec;
    }

    /**
     * InfrastructureSpec contains settings that apply to the cluster infrastructure.
     */
    @JsonProperty("cloudConfig")
    public ConfigMapFileReference getCloudConfig() {
        return cloudConfig;
    }

    /**
     * InfrastructureSpec contains settings that apply to the cluster infrastructure.
     */
    @JsonProperty("cloudConfig")
    public void setCloudConfig(ConfigMapFileReference cloudConfig) {
        this.cloudConfig = cloudConfig;
    }

    /**
     * InfrastructureSpec contains settings that apply to the cluster infrastructure.
     */
    @JsonProperty("platformSpec")
    public PlatformSpec getPlatformSpec() {
        return platformSpec;
    }

    /**
     * InfrastructureSpec contains settings that apply to the cluster infrastructure.
     */
    @JsonProperty("platformSpec")
    public void setPlatformSpec(PlatformSpec platformSpec) {
        this.platformSpec = platformSpec;
    }

    @JsonIgnore
    public InfrastructureSpecBuilder edit() {
        return new InfrastructureSpecBuilder(this);
    }

    @JsonIgnore
    public InfrastructureSpecBuilder toBuilder() {
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
        if (!(o instanceof InfrastructureSpec)) {
            return false;
        }
        InfrastructureSpec other = (InfrastructureSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cloudConfig = this.getCloudConfig();
        Object other$cloudConfig = other.getCloudConfig();
        if (this$cloudConfig == null ? other$cloudConfig != null : !this$cloudConfig.equals(other$cloudConfig)) {
            return false;
        }
        Object this$platformSpec = this.getPlatformSpec();
        Object other$platformSpec = other.getPlatformSpec();
        if (this$platformSpec == null ? other$platformSpec != null : !this$platformSpec.equals(other$platformSpec)) {
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
        return other instanceof InfrastructureSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cloudConfig = this.getCloudConfig();
        result = result * prime + ($cloudConfig == null ? 43 : $cloudConfig.hashCode());
        Object $platformSpec = this.getPlatformSpec();
        result = result * prime + ($platformSpec == null ? 43 : $platformSpec.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "InfrastructureSpec(" + "cloudConfig=" + this.getCloudConfig() + ", platformSpec=" + this.getPlatformSpec() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
