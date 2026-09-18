
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * GRPCAction specifies an action involving a GRPC service.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mode",
    "port",
    "service"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class GRPCAction implements Editable<GRPCActionBuilder>, KubernetesResource
{

    @JsonProperty("mode")
    private String mode;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("service")
    private String service;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GRPCAction() {
    }

    public GRPCAction(String mode, Integer port, String service) {
        super();
        this.mode = mode;
        this.port = port;
        this.service = service;
    }

    /**
     * mode specifies the connection mode for the gRPC health probe. Set to "TLS" to use TLS without certificate verification. Set to "Plaintext" to use a plaintext (insecure) connection explicitly. If not specified, the probe uses a plaintext (insecure) connection.
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * mode specifies the connection mode for the gRPC health probe. Set to "TLS" to use TLS without certificate verification. Set to "Plaintext" to use a plaintext (insecure) connection explicitly. If not specified, the probe uses a plaintext (insecure) connection.
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * Port number of the gRPC service. Number must be in the range 1 to 65535.
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * Port number of the gRPC service. Number must be in the range 1 to 65535.
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * Service is the name of the service to place in the gRPC HealthCheckRequest (see https://github.com/grpc/grpc/blob/master/doc/health-checking.md).<br><p> <br><p> If this is not specified, the default behavior is defined by gRPC.
     */
    @JsonProperty("service")
    public String getService() {
        return service;
    }

    /**
     * Service is the name of the service to place in the gRPC HealthCheckRequest (see https://github.com/grpc/grpc/blob/master/doc/health-checking.md).<br><p> <br><p> If this is not specified, the default behavior is defined by gRPC.
     */
    @JsonProperty("service")
    public void setService(String service) {
        this.service = service;
    }

    @JsonIgnore
    public GRPCActionBuilder edit() {
        return new GRPCActionBuilder(this);
    }

    @JsonIgnore
    public GRPCActionBuilder toBuilder() {
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
        if (!(o instanceof GRPCAction)) {
            return false;
        }
        GRPCAction other = (GRPCAction) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$mode = this.getMode();
        Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) {
            return false;
        }
        Object this$port = this.getPort();
        Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
            return false;
        }
        Object this$service = this.getService();
        Object other$service = other.getService();
        if (this$service == null ? other$service != null : !this$service.equals(other$service)) {
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
        return other instanceof GRPCAction;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $mode = this.getMode();
        result = result * prime + ($mode == null ? 43 : $mode.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $service = this.getService();
        result = result * prime + ($service == null ? 43 : $service.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GRPCAction(" + "mode=" + this.getMode() + ", port=" + this.getPort() + ", service=" + this.getService() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
