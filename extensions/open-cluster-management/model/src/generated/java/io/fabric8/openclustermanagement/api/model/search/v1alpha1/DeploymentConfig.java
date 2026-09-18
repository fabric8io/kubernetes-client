
package io.fabric8.openclustermanagement.api.model.search.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "arguments",
    "envVar",
    "imageOverride",
    "replicaCount",
    "resources"
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
public class DeploymentConfig implements Editable<DeploymentConfigBuilder>, KubernetesResource
{

    @JsonProperty("arguments")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> arguments = new ArrayList<>();
    @JsonProperty("envVar")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> envVar = new ArrayList<>();
    @JsonProperty("imageOverride")
    private String imageOverride;
    @JsonProperty("replicaCount")
    private Integer replicaCount;
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeploymentConfig() {
    }

    public DeploymentConfig(List<String> arguments, List<EnvVar> envVar, String imageOverride, Integer replicaCount, ResourceRequirements resources) {
        super();
        this.arguments = arguments;
        this.envVar = envVar;
        this.imageOverride = imageOverride;
        this.replicaCount = replicaCount;
        this.resources = resources;
    }

    /**
     * Container Arguments
     */
    @JsonProperty("arguments")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getArguments() {
        return arguments;
    }

    /**
     * Container Arguments
     */
    @JsonProperty("arguments")
    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    /**
     * Container Env variables
     */
    @JsonProperty("envVar")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EnvVar> getEnvVar() {
        return envVar;
    }

    /**
     * Container Env variables
     */
    @JsonProperty("envVar")
    public void setEnvVar(List<EnvVar> envVar) {
        this.envVar = envVar;
    }

    /**
     * Image_override
     */
    @JsonProperty("imageOverride")
    public String getImageOverride() {
        return imageOverride;
    }

    /**
     * Image_override
     */
    @JsonProperty("imageOverride")
    public void setImageOverride(String imageOverride) {
        this.imageOverride = imageOverride;
    }

    /**
     * Number of pod instances for the deployment.
     */
    @JsonProperty("replicaCount")
    public Integer getReplicaCount() {
        return replicaCount;
    }

    /**
     * Number of pod instances for the deployment.
     */
    @JsonProperty("replicaCount")
    public void setReplicaCount(Integer replicaCount) {
        this.replicaCount = replicaCount;
    }

    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    @JsonIgnore
    public DeploymentConfigBuilder edit() {
        return new DeploymentConfigBuilder(this);
    }

    @JsonIgnore
    public DeploymentConfigBuilder toBuilder() {
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
        if (!(o instanceof DeploymentConfig)) {
            return false;
        }
        DeploymentConfig other = (DeploymentConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$arguments = this.getArguments();
        Object other$arguments = other.getArguments();
        if (this$arguments == null ? other$arguments != null : !this$arguments.equals(other$arguments)) {
            return false;
        }
        Object this$envVar = this.getEnvVar();
        Object other$envVar = other.getEnvVar();
        if (this$envVar == null ? other$envVar != null : !this$envVar.equals(other$envVar)) {
            return false;
        }
        Object this$imageOverride = this.getImageOverride();
        Object other$imageOverride = other.getImageOverride();
        if (this$imageOverride == null ? other$imageOverride != null : !this$imageOverride.equals(other$imageOverride)) {
            return false;
        }
        Object this$replicaCount = this.getReplicaCount();
        Object other$replicaCount = other.getReplicaCount();
        if (this$replicaCount == null ? other$replicaCount != null : !this$replicaCount.equals(other$replicaCount)) {
            return false;
        }
        Object this$resources = this.getResources();
        Object other$resources = other.getResources();
        if (this$resources == null ? other$resources != null : !this$resources.equals(other$resources)) {
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
        return other instanceof DeploymentConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $arguments = this.getArguments();
        result = result * prime + ($arguments == null ? 43 : $arguments.hashCode());
        Object $envVar = this.getEnvVar();
        result = result * prime + ($envVar == null ? 43 : $envVar.hashCode());
        Object $imageOverride = this.getImageOverride();
        result = result * prime + ($imageOverride == null ? 43 : $imageOverride.hashCode());
        Object $replicaCount = this.getReplicaCount();
        result = result * prime + ($replicaCount == null ? 43 : $replicaCount.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DeploymentConfig(" + "arguments=" + this.getArguments() + ", envVar=" + this.getEnvVar() + ", imageOverride=" + this.getImageOverride() + ", replicaCount=" + this.getReplicaCount() + ", resources=" + this.getResources() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
