
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
 * HTTPExternalAuthFilter defines a filter that modifies requests by sending request details to an external authorization server.<br><p> <br><p> Support: Extended Feature Name: HTTPRouteExternalAuth
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "backendRef",
    "forwardBody",
    "grpc",
    "http",
    "protocol"
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
public class HTTPExternalAuthFilter implements Editable<HTTPExternalAuthFilterBuilder>, KubernetesResource
{

    @JsonProperty("backendRef")
    private BackendObjectReference backendRef;
    @JsonProperty("forwardBody")
    private ForwardBodyConfig forwardBody;
    @JsonProperty("grpc")
    private GRPCAuthConfig grpc;
    @JsonProperty("http")
    private HTTPAuthConfig http;
    @JsonProperty("protocol")
    private String protocol;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPExternalAuthFilter() {
    }

    public HTTPExternalAuthFilter(BackendObjectReference backendRef, ForwardBodyConfig forwardBody, GRPCAuthConfig grpc, HTTPAuthConfig http, String protocol) {
        super();
        this.backendRef = backendRef;
        this.forwardBody = forwardBody;
        this.grpc = grpc;
        this.http = http;
        this.protocol = protocol;
    }

    /**
     * HTTPExternalAuthFilter defines a filter that modifies requests by sending request details to an external authorization server.<br><p> <br><p> Support: Extended Feature Name: HTTPRouteExternalAuth
     */
    @JsonProperty("backendRef")
    public BackendObjectReference getBackendRef() {
        return backendRef;
    }

    /**
     * HTTPExternalAuthFilter defines a filter that modifies requests by sending request details to an external authorization server.<br><p> <br><p> Support: Extended Feature Name: HTTPRouteExternalAuth
     */
    @JsonProperty("backendRef")
    public void setBackendRef(BackendObjectReference backendRef) {
        this.backendRef = backendRef;
    }

    /**
     * HTTPExternalAuthFilter defines a filter that modifies requests by sending request details to an external authorization server.<br><p> <br><p> Support: Extended Feature Name: HTTPRouteExternalAuth
     */
    @JsonProperty("forwardBody")
    public ForwardBodyConfig getForwardBody() {
        return forwardBody;
    }

    /**
     * HTTPExternalAuthFilter defines a filter that modifies requests by sending request details to an external authorization server.<br><p> <br><p> Support: Extended Feature Name: HTTPRouteExternalAuth
     */
    @JsonProperty("forwardBody")
    public void setForwardBody(ForwardBodyConfig forwardBody) {
        this.forwardBody = forwardBody;
    }

    /**
     * HTTPExternalAuthFilter defines a filter that modifies requests by sending request details to an external authorization server.<br><p> <br><p> Support: Extended Feature Name: HTTPRouteExternalAuth
     */
    @JsonProperty("grpc")
    public GRPCAuthConfig getGrpc() {
        return grpc;
    }

    /**
     * HTTPExternalAuthFilter defines a filter that modifies requests by sending request details to an external authorization server.<br><p> <br><p> Support: Extended Feature Name: HTTPRouteExternalAuth
     */
    @JsonProperty("grpc")
    public void setGrpc(GRPCAuthConfig grpc) {
        this.grpc = grpc;
    }

    /**
     * HTTPExternalAuthFilter defines a filter that modifies requests by sending request details to an external authorization server.<br><p> <br><p> Support: Extended Feature Name: HTTPRouteExternalAuth
     */
    @JsonProperty("http")
    public HTTPAuthConfig getHttp() {
        return http;
    }

    /**
     * HTTPExternalAuthFilter defines a filter that modifies requests by sending request details to an external authorization server.<br><p> <br><p> Support: Extended Feature Name: HTTPRouteExternalAuth
     */
    @JsonProperty("http")
    public void setHttp(HTTPAuthConfig http) {
        this.http = http;
    }

    /**
     * ExternalAuthProtocol describes which protocol to use when communicating with an ext_authz authorization server.<br><p> <br><p> When this is set to GRPC, each backend must use the Envoy ext_authz protocol on the port specified in `backendRefs`. Requests and responses are defined in the protobufs explained at: https://www.envoyproxy.io/docs/envoy/latest/api-v3/service/auth/v3/external_auth.proto<br><p> <br><p> When this is set to HTTP, each backend must respond with a `200` status code in on a successful authorization. Any other code is considered an authorization failure.<br><p> <br><p> Feature Names: GRPC Support - HTTPRouteExternalAuthGRPC HTTP Support - HTTPRouteExternalAuthHTTP
     */
    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    /**
     * ExternalAuthProtocol describes which protocol to use when communicating with an ext_authz authorization server.<br><p> <br><p> When this is set to GRPC, each backend must use the Envoy ext_authz protocol on the port specified in `backendRefs`. Requests and responses are defined in the protobufs explained at: https://www.envoyproxy.io/docs/envoy/latest/api-v3/service/auth/v3/external_auth.proto<br><p> <br><p> When this is set to HTTP, each backend must respond with a `200` status code in on a successful authorization. Any other code is considered an authorization failure.<br><p> <br><p> Feature Names: GRPC Support - HTTPRouteExternalAuthGRPC HTTP Support - HTTPRouteExternalAuthHTTP
     */
    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @JsonIgnore
    public HTTPExternalAuthFilterBuilder edit() {
        return new HTTPExternalAuthFilterBuilder(this);
    }

    @JsonIgnore
    public HTTPExternalAuthFilterBuilder toBuilder() {
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
        if (!(o instanceof HTTPExternalAuthFilter)) {
            return false;
        }
        HTTPExternalAuthFilter other = (HTTPExternalAuthFilter) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$backendRef = this.getBackendRef();
        Object other$backendRef = other.getBackendRef();
        if (this$backendRef == null ? other$backendRef != null : !this$backendRef.equals(other$backendRef)) {
            return false;
        }
        Object this$forwardBody = this.getForwardBody();
        Object other$forwardBody = other.getForwardBody();
        if (this$forwardBody == null ? other$forwardBody != null : !this$forwardBody.equals(other$forwardBody)) {
            return false;
        }
        Object this$grpc = this.getGrpc();
        Object other$grpc = other.getGrpc();
        if (this$grpc == null ? other$grpc != null : !this$grpc.equals(other$grpc)) {
            return false;
        }
        Object this$http = this.getHttp();
        Object other$http = other.getHttp();
        if (this$http == null ? other$http != null : !this$http.equals(other$http)) {
            return false;
        }
        Object this$protocol = this.getProtocol();
        Object other$protocol = other.getProtocol();
        if (this$protocol == null ? other$protocol != null : !this$protocol.equals(other$protocol)) {
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
        return other instanceof HTTPExternalAuthFilter;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $backendRef = this.getBackendRef();
        result = result * prime + ($backendRef == null ? 43 : $backendRef.hashCode());
        Object $forwardBody = this.getForwardBody();
        result = result * prime + ($forwardBody == null ? 43 : $forwardBody.hashCode());
        Object $grpc = this.getGrpc();
        result = result * prime + ($grpc == null ? 43 : $grpc.hashCode());
        Object $http = this.getHttp();
        result = result * prime + ($http == null ? 43 : $http.hashCode());
        Object $protocol = this.getProtocol();
        result = result * prime + ($protocol == null ? 43 : $protocol.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HTTPExternalAuthFilter(" + "backendRef=" + this.getBackendRef() + ", forwardBody=" + this.getForwardBody() + ", grpc=" + this.getGrpc() + ", http=" + this.getHttp() + ", protocol=" + this.getProtocol() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
