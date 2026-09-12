
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
 * ServicePort contains information on service's port.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "appProtocol",
    "name",
    "nodePort",
    "port",
    "protocol",
    "targetPort"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ServicePort implements Editable<ServicePortBuilder>, KubernetesResource
{

    @JsonProperty("appProtocol")
    private String appProtocol;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nodePort")
    private Integer nodePort;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("protocol")
    private String protocol;
    @JsonProperty("targetPort")
    private IntOrString targetPort;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ServicePort() {
    }

    public ServicePort(String appProtocol, String name, Integer nodePort, Integer port, String protocol, IntOrString targetPort) {
        super();
        this.appProtocol = appProtocol;
        this.name = name;
        this.nodePort = nodePort;
        this.port = port;
        this.protocol = protocol;
        this.targetPort = targetPort;
    }

    /**
     * The application protocol for this port. This is used as a hint for implementations to offer richer behavior for protocols that they understand. This field follows standard Kubernetes label syntax. Valid values are either:<br><p> <br><p> &#42; Un-prefixed protocol names - reserved for IANA standard service names (as per RFC-6335 and https://www.iana.org/assignments/service-names).<br><p> <br><p> &#42; Kubernetes-defined prefixed names:<br><p>   &#42; 'kubernetes.io/h2c' - HTTP/2 prior knowledge over cleartext as described in https://www.rfc-editor.org/rfc/rfc9113.html#name-starting-http-2-with-prior-<br><p>   &#42; 'kubernetes.io/ws'  - WebSocket over cleartext as described in https://www.rfc-editor.org/rfc/rfc6455<br><p>   &#42; 'kubernetes.io/wss' - WebSocket over TLS as described in https://www.rfc-editor.org/rfc/rfc6455<br><p> <br><p> &#42; Other protocols should use implementation-defined prefixed names such as mycompany.com/my-custom-protocol.
     */
    @JsonProperty("appProtocol")
    public String getAppProtocol() {
        return appProtocol;
    }

    /**
     * The application protocol for this port. This is used as a hint for implementations to offer richer behavior for protocols that they understand. This field follows standard Kubernetes label syntax. Valid values are either:<br><p> <br><p> &#42; Un-prefixed protocol names - reserved for IANA standard service names (as per RFC-6335 and https://www.iana.org/assignments/service-names).<br><p> <br><p> &#42; Kubernetes-defined prefixed names:<br><p>   &#42; 'kubernetes.io/h2c' - HTTP/2 prior knowledge over cleartext as described in https://www.rfc-editor.org/rfc/rfc9113.html#name-starting-http-2-with-prior-<br><p>   &#42; 'kubernetes.io/ws'  - WebSocket over cleartext as described in https://www.rfc-editor.org/rfc/rfc6455<br><p>   &#42; 'kubernetes.io/wss' - WebSocket over TLS as described in https://www.rfc-editor.org/rfc/rfc6455<br><p> <br><p> &#42; Other protocols should use implementation-defined prefixed names such as mycompany.com/my-custom-protocol.
     */
    @JsonProperty("appProtocol")
    public void setAppProtocol(String appProtocol) {
        this.appProtocol = appProtocol;
    }

    /**
     * The name of this port within the service. This must be a DNS_LABEL. All ports within a ServiceSpec must have unique names. When considering the endpoints for a Service, this must match the 'name' field in the EndpointPort. Optional if only one ServicePort is defined on this service.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The name of this port within the service. This must be a DNS_LABEL. All ports within a ServiceSpec must have unique names. When considering the endpoints for a Service, this must match the 'name' field in the EndpointPort. Optional if only one ServicePort is defined on this service.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The port on each node on which this service is exposed when type is NodePort or LoadBalancer.  Usually assigned by the system. If a value is specified, in-range, and not in use it will be used, otherwise the operation will fail.  If not specified, a port will be allocated if this Service requires one.  If this field is specified when creating a Service which does not need it, creation will fail. This field will be wiped when updating a Service to no longer need it (e.g. changing type from NodePort to ClusterIP). More info: https://kubernetes.io/docs/concepts/services-networking/service/#type-nodeport
     */
    @JsonProperty("nodePort")
    public Integer getNodePort() {
        return nodePort;
    }

    /**
     * The port on each node on which this service is exposed when type is NodePort or LoadBalancer.  Usually assigned by the system. If a value is specified, in-range, and not in use it will be used, otherwise the operation will fail.  If not specified, a port will be allocated if this Service requires one.  If this field is specified when creating a Service which does not need it, creation will fail. This field will be wiped when updating a Service to no longer need it (e.g. changing type from NodePort to ClusterIP). More info: https://kubernetes.io/docs/concepts/services-networking/service/#type-nodeport
     */
    @JsonProperty("nodePort")
    public void setNodePort(Integer nodePort) {
        this.nodePort = nodePort;
    }

    /**
     * The port that will be exposed by this service.
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * The port that will be exposed by this service.
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * The IP protocol for this port. Supports "TCP", "UDP", and "SCTP". Default is TCP.
     */
    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    /**
     * The IP protocol for this port. Supports "TCP", "UDP", and "SCTP". Default is TCP.
     */
    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * ServicePort contains information on service's port.
     */
    @JsonProperty("targetPort")
    public IntOrString getTargetPort() {
        return targetPort;
    }

    /**
     * ServicePort contains information on service's port.
     */
    @JsonProperty("targetPort")
    public void setTargetPort(IntOrString targetPort) {
        this.targetPort = targetPort;
    }

    @JsonIgnore
    public ServicePortBuilder edit() {
        return new ServicePortBuilder(this);
    }

    @JsonIgnore
    public ServicePortBuilder toBuilder() {
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
        if (!(o instanceof ServicePort)) {
            return false;
        }
        ServicePort other = (ServicePort) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$appProtocol = this.getAppProtocol();
        Object other$appProtocol = other.getAppProtocol();
        if (this$appProtocol == null ? other$appProtocol != null : !this$appProtocol.equals(other$appProtocol)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$nodePort = this.getNodePort();
        Object other$nodePort = other.getNodePort();
        if (this$nodePort == null ? other$nodePort != null : !this$nodePort.equals(other$nodePort)) {
            return false;
        }
        Object this$port = this.getPort();
        Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
            return false;
        }
        Object this$protocol = this.getProtocol();
        Object other$protocol = other.getProtocol();
        if (this$protocol == null ? other$protocol != null : !this$protocol.equals(other$protocol)) {
            return false;
        }
        Object this$targetPort = this.getTargetPort();
        Object other$targetPort = other.getTargetPort();
        if (this$targetPort == null ? other$targetPort != null : !this$targetPort.equals(other$targetPort)) {
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
        return other instanceof ServicePort;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $appProtocol = this.getAppProtocol();
        result = result * prime + ($appProtocol == null ? 43 : $appProtocol.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $nodePort = this.getNodePort();
        result = result * prime + ($nodePort == null ? 43 : $nodePort.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $protocol = this.getProtocol();
        result = result * prime + ($protocol == null ? 43 : $protocol.hashCode());
        Object $targetPort = this.getTargetPort();
        result = result * prime + ($targetPort == null ? 43 : $targetPort.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ServicePort(" + "appProtocol=" + this.getAppProtocol() + ", name=" + this.getName() + ", nodePort=" + this.getNodePort() + ", port=" + this.getPort() + ", protocol=" + this.getProtocol() + ", targetPort=" + this.getTargetPort() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
