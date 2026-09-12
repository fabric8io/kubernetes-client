
package io.fabric8.openclustermanagement.api.model.operator.v1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
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
    "localSecretsConfig",
    "type"
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
public class BootstrapKubeConfigs implements Editable<BootstrapKubeConfigsBuilder>, KubernetesResource
{

    @JsonProperty("localSecretsConfig")
    private LocalSecretsConfig localSecretsConfig;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BootstrapKubeConfigs() {
    }

    public BootstrapKubeConfigs(LocalSecretsConfig localSecretsConfig, String type) {
        super();
        this.localSecretsConfig = localSecretsConfig;
        this.type = type;
    }

    @JsonProperty("localSecretsConfig")
    public LocalSecretsConfig getLocalSecretsConfig() {
        return localSecretsConfig;
    }

    @JsonProperty("localSecretsConfig")
    public void setLocalSecretsConfig(LocalSecretsConfig localSecretsConfig) {
        this.localSecretsConfig = localSecretsConfig;
    }

    /**
     * Type specifies the type of priority bootstrap kubeconfigs. By default, it is set to None, representing no priority bootstrap kubeconfigs are set.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type specifies the type of priority bootstrap kubeconfigs. By default, it is set to None, representing no priority bootstrap kubeconfigs are set.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public BootstrapKubeConfigsBuilder edit() {
        return new BootstrapKubeConfigsBuilder(this);
    }

    @JsonIgnore
    public BootstrapKubeConfigsBuilder toBuilder() {
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
        if (!(o instanceof BootstrapKubeConfigs)) {
            return false;
        }
        BootstrapKubeConfigs other = (BootstrapKubeConfigs) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$localSecretsConfig = this.getLocalSecretsConfig();
        Object other$localSecretsConfig = other.getLocalSecretsConfig();
        if (this$localSecretsConfig == null ? other$localSecretsConfig != null : !this$localSecretsConfig.equals(other$localSecretsConfig)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof BootstrapKubeConfigs;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $localSecretsConfig = this.getLocalSecretsConfig();
        result = result * prime + ($localSecretsConfig == null ? 43 : $localSecretsConfig.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BootstrapKubeConfigs(" + "localSecretsConfig=" + this.getLocalSecretsConfig() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
