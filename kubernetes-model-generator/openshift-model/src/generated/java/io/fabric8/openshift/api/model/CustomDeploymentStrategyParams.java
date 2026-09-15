
package io.fabric8.openshift.api.model;

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
 * CustomDeploymentStrategyParams are the input to the Custom deployment strategy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "command",
    "environment",
    "image"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class CustomDeploymentStrategyParams implements Editable<CustomDeploymentStrategyParamsBuilder>, KubernetesResource
{

    @JsonProperty("command")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> command = new ArrayList<>();
    @JsonProperty("environment")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> environment = new ArrayList<>();
    @JsonProperty("image")
    private String image;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CustomDeploymentStrategyParams() {
    }

    public CustomDeploymentStrategyParams(List<String> command, List<EnvVar> environment, String image) {
        super();
        this.command = command;
        this.environment = environment;
        this.image = image;
    }

    /**
     * command is optional and overrides CMD in the container Image.
     */
    @JsonProperty("command")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCommand() {
        return command;
    }

    /**
     * command is optional and overrides CMD in the container Image.
     */
    @JsonProperty("command")
    public void setCommand(List<String> command) {
        this.command = command;
    }

    /**
     * environment holds the environment which will be given to the container for Image.
     */
    @JsonProperty("environment")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EnvVar> getEnvironment() {
        return environment;
    }

    /**
     * environment holds the environment which will be given to the container for Image.
     */
    @JsonProperty("environment")
    public void setEnvironment(List<EnvVar> environment) {
        this.environment = environment;
    }

    /**
     * image specifies a container image which can carry out a deployment.
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * image specifies a container image which can carry out a deployment.
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonIgnore
    public CustomDeploymentStrategyParamsBuilder edit() {
        return new CustomDeploymentStrategyParamsBuilder(this);
    }

    @JsonIgnore
    public CustomDeploymentStrategyParamsBuilder toBuilder() {
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
        if (!(o instanceof CustomDeploymentStrategyParams)) {
            return false;
        }
        CustomDeploymentStrategyParams other = (CustomDeploymentStrategyParams) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$command = this.getCommand();
        Object other$command = other.getCommand();
        if (this$command == null ? other$command != null : !this$command.equals(other$command)) {
            return false;
        }
        Object this$environment = this.getEnvironment();
        Object other$environment = other.getEnvironment();
        if (this$environment == null ? other$environment != null : !this$environment.equals(other$environment)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
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
        return other instanceof CustomDeploymentStrategyParams;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $command = this.getCommand();
        result = result * prime + ($command == null ? 43 : $command.hashCode());
        Object $environment = this.getEnvironment();
        result = result * prime + ($environment == null ? 43 : $environment.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CustomDeploymentStrategyParams(" + "command=" + this.getCommand() + ", environment=" + this.getEnvironment() + ", image=" + this.getImage() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
