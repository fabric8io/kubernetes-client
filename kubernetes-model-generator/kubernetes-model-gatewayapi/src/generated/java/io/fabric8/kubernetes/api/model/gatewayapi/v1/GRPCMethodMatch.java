
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
 * GRPCMethodMatch describes how to select a gRPC route by matching the gRPC request service and/or method.<br><p> <br><p> At least one of Service and Method MUST be a non-empty string.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "method",
    "service",
    "type"
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
public class GRPCMethodMatch implements Editable<GRPCMethodMatchBuilder>, KubernetesResource
{

    @JsonProperty("method")
    private String method;
    @JsonProperty("service")
    private String service;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GRPCMethodMatch() {
    }

    public GRPCMethodMatch(String method, String service, String type) {
        super();
        this.method = method;
        this.service = service;
        this.type = type;
    }

    /**
     * Value of the method to match against. If left empty or omitted, will match all services.<br><p> <br><p> At least one of Service and Method MUST be a non-empty string.
     */
    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    /**
     * Value of the method to match against. If left empty or omitted, will match all services.<br><p> <br><p> At least one of Service and Method MUST be a non-empty string.
     */
    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Value of the service to match against. If left empty or omitted, will match any service.<br><p> <br><p> At least one of Service and Method MUST be a non-empty string.
     */
    @JsonProperty("service")
    public String getService() {
        return service;
    }

    /**
     * Value of the service to match against. If left empty or omitted, will match any service.<br><p> <br><p> At least one of Service and Method MUST be a non-empty string.
     */
    @JsonProperty("service")
    public void setService(String service) {
        this.service = service;
    }

    /**
     * Type specifies how to match against the service and/or method. Support: Core (Exact with service and method specified)<br><p> <br><p> Support: Implementation-specific (Exact with method specified but no service specified)<br><p> <br><p> Support: Implementation-specific (RegularExpression)
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type specifies how to match against the service and/or method. Support: Core (Exact with service and method specified)<br><p> <br><p> Support: Implementation-specific (Exact with method specified but no service specified)<br><p> <br><p> Support: Implementation-specific (RegularExpression)
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public GRPCMethodMatchBuilder edit() {
        return new GRPCMethodMatchBuilder(this);
    }

    @JsonIgnore
    public GRPCMethodMatchBuilder toBuilder() {
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
        if (!(o instanceof GRPCMethodMatch)) {
            return false;
        }
        GRPCMethodMatch other = (GRPCMethodMatch) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$method = this.getMethod();
        Object other$method = other.getMethod();
        if (this$method == null ? other$method != null : !this$method.equals(other$method)) {
            return false;
        }
        Object this$service = this.getService();
        Object other$service = other.getService();
        if (this$service == null ? other$service != null : !this$service.equals(other$service)) {
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
        return other instanceof GRPCMethodMatch;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $method = this.getMethod();
        result = result * prime + ($method == null ? 43 : $method.hashCode());
        Object $service = this.getService();
        result = result * prime + ($service == null ? 43 : $service.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GRPCMethodMatch(" + "method=" + this.getMethod() + ", service=" + this.getService() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
