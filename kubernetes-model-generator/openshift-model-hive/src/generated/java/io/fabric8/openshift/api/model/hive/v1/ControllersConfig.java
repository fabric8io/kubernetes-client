
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
 * ControllersConfig contains default as well as controller specific configurations
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "controllers",
    "default"
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
public class ControllersConfig implements Editable<ControllersConfigBuilder>, KubernetesResource
{

    @JsonProperty("controllers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SpecificControllerConfig> controllers = new ArrayList<>();
    @JsonProperty("default")
    private ControllerConfig _default;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ControllersConfig() {
    }

    public ControllersConfig(List<SpecificControllerConfig> controllers, ControllerConfig _default) {
        super();
        this.controllers = controllers;
        this._default = _default;
    }

    /**
     * Controllers contains a list of configurations for different controllers
     */
    @JsonProperty("controllers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SpecificControllerConfig> getControllers() {
        return controllers;
    }

    /**
     * Controllers contains a list of configurations for different controllers
     */
    @JsonProperty("controllers")
    public void setControllers(List<SpecificControllerConfig> controllers) {
        this.controllers = controllers;
    }

    /**
     * ControllersConfig contains default as well as controller specific configurations
     */
    @JsonProperty("default")
    public ControllerConfig getDefault() {
        return _default;
    }

    /**
     * ControllersConfig contains default as well as controller specific configurations
     */
    @JsonProperty("default")
    public void setDefault(ControllerConfig _default) {
        this._default = _default;
    }

    @JsonIgnore
    public ControllersConfigBuilder edit() {
        return new ControllersConfigBuilder(this);
    }

    @JsonIgnore
    public ControllersConfigBuilder toBuilder() {
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
        if (!(o instanceof ControllersConfig)) {
            return false;
        }
        ControllersConfig other = (ControllersConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$controllers = this.getControllers();
        Object other$controllers = other.getControllers();
        if (this$controllers == null ? other$controllers != null : !this$controllers.equals(other$controllers)) {
            return false;
        }
        Object this$_default = this.getDefault();
        Object other$_default = other.getDefault();
        if (this$_default == null ? other$_default != null : !this$_default.equals(other$_default)) {
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
        return other instanceof ControllersConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $controllers = this.getControllers();
        result = result * prime + ($controllers == null ? 43 : $controllers.hashCode());
        Object $_default = this.getDefault();
        result = result * prime + ($_default == null ? 43 : $_default.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ControllersConfig(" + "controllers=" + this.getControllers() + ", _default=" + this.getDefault() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
