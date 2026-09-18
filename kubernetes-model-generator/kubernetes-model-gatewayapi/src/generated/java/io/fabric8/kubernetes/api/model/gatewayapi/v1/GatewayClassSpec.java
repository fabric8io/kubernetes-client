
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * GatewayClassSpec reflects the configuration of a class of Gateways.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "controllerName",
    "description",
    "parametersRef"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class GatewayClassSpec implements Editable<GatewayClassSpecBuilder>, KubernetesResource
{

    @JsonProperty("controllerName")
    private String controllerName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("parametersRef")
    private ParametersReference parametersRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GatewayClassSpec() {
    }

    public GatewayClassSpec(String controllerName, String description, ParametersReference parametersRef) {
        super();
        this.controllerName = controllerName;
        this.description = description;
        this.parametersRef = parametersRef;
    }

    /**
     * ControllerName is the name of the controller that is managing Gateways of this class. The value of this field MUST be a domain prefixed path.<br><p> <br><p> Example: "example.net/gateway-controller".<br><p> <br><p> This field is not mutable and cannot be empty.<br><p> <br><p> Support: Core
     */
    @JsonProperty("controllerName")
    public String getControllerName() {
        return controllerName;
    }

    /**
     * ControllerName is the name of the controller that is managing Gateways of this class. The value of this field MUST be a domain prefixed path.<br><p> <br><p> Example: "example.net/gateway-controller".<br><p> <br><p> This field is not mutable and cannot be empty.<br><p> <br><p> Support: Core
     */
    @JsonProperty("controllerName")
    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    /**
     * Description helps describe a GatewayClass with more details.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Description helps describe a GatewayClass with more details.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * GatewayClassSpec reflects the configuration of a class of Gateways.
     */
    @JsonProperty("parametersRef")
    public ParametersReference getParametersRef() {
        return parametersRef;
    }

    /**
     * GatewayClassSpec reflects the configuration of a class of Gateways.
     */
    @JsonProperty("parametersRef")
    public void setParametersRef(ParametersReference parametersRef) {
        this.parametersRef = parametersRef;
    }

    @JsonIgnore
    public GatewayClassSpecBuilder edit() {
        return new GatewayClassSpecBuilder(this);
    }

    @JsonIgnore
    public GatewayClassSpecBuilder toBuilder() {
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
        if (!(o instanceof GatewayClassSpec)) {
            return false;
        }
        GatewayClassSpec other = (GatewayClassSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$controllerName = this.getControllerName();
        Object other$controllerName = other.getControllerName();
        if (this$controllerName == null ? other$controllerName != null : !this$controllerName.equals(other$controllerName)) {
            return false;
        }
        Object this$description = this.getDescription();
        Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        Object this$parametersRef = this.getParametersRef();
        Object other$parametersRef = other.getParametersRef();
        if (this$parametersRef == null ? other$parametersRef != null : !this$parametersRef.equals(other$parametersRef)) {
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
        return other instanceof GatewayClassSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $controllerName = this.getControllerName();
        result = result * prime + ($controllerName == null ? 43 : $controllerName.hashCode());
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $parametersRef = this.getParametersRef();
        result = result * prime + ($parametersRef == null ? 43 : $parametersRef.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GatewayClassSpec(" + "controllerName=" + this.getControllerName() + ", description=" + this.getDescription() + ", parametersRef=" + this.getParametersRef() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
