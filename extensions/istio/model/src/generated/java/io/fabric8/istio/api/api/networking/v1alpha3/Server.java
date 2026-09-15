
package io.fabric8.istio.api.api.networking.v1alpha3;

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
 * `Server` describes the properties of the proxy on a given load balancer port. For example,<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: Gateway metadata:<br><p> <br><p> 	name: my-ingress<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  app: my-ingressgateway<br><p> 	servers:<br><p> 	- port:<br><p> 	    number: 80<br><p> 	    name: http2<br><p> 	    protocol: HTTP2<br><p> 	  hosts:<br><p> 	  - "&#42;"<br><p> <br><p> ```<br><p> <br><p> # Another example<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: Gateway metadata:<br><p> <br><p> 	name: my-tcp-ingress<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  app: my-tcp-ingressgateway<br><p> 	servers:<br><p> 	- port:<br><p> 	    number: 27018<br><p> 	    name: mongo<br><p> 	    protocol: MONGO<br><p> 	  hosts:<br><p> 	  - "&#42;"<br><p> <br><p> ```<br><p> <br><p> # The following is an example of TLS configuration for port 443<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: Gateway metadata:<br><p> <br><p> 	name: my-tls-ingress<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  app: my-tls-ingressgateway<br><p> 	servers:<br><p> 	- port:<br><p> 	    number: 443<br><p> 	    name: https<br><p> 	    protocol: HTTPS<br><p> 	  hosts:<br><p> 	  - "&#42;"<br><p> 	  tls:<br><p> 	    mode: SIMPLE<br><p> 	    credentialName: tls-cert<br><p> <br><p> ```
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bind",
    "defaultEndpoint",
    "hosts",
    "name",
    "port",
    "tls"
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
public class Server implements Editable<ServerBuilder>, KubernetesResource
{

    @JsonProperty("bind")
    private String bind;
    @JsonProperty("defaultEndpoint")
    private String defaultEndpoint;
    @JsonProperty("hosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> hosts = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("port")
    private Port port;
    @JsonProperty("tls")
    private ServerTLSSettings tls;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Server() {
    }

    public Server(String bind, String defaultEndpoint, List<String> hosts, String name, Port port, ServerTLSSettings tls) {
        super();
        this.bind = bind;
        this.defaultEndpoint = defaultEndpoint;
        this.hosts = hosts;
        this.name = name;
        this.port = port;
        this.tls = tls;
    }

    /**
     * The ip or the Unix domain socket to which the listener should be bound to. Format: `x.x.x.x` or `unix:///path/to/uds` or `unix://@foobar` (Linux abstract namespace). When using Unix domain sockets, the port number should be 0. This can be used to restrict the reachability of this server to be gateway internal only. This is typically used when a gateway needs to communicate to another mesh service e.g. publishing metrics. In such case, the server created with the specified bind will not be available to external gateway clients.
     */
    @JsonProperty("bind")
    public String getBind() {
        return bind;
    }

    /**
     * The ip or the Unix domain socket to which the listener should be bound to. Format: `x.x.x.x` or `unix:///path/to/uds` or `unix://@foobar` (Linux abstract namespace). When using Unix domain sockets, the port number should be 0. This can be used to restrict the reachability of this server to be gateway internal only. This is typically used when a gateway needs to communicate to another mesh service e.g. publishing metrics. In such case, the server created with the specified bind will not be available to external gateway clients.
     */
    @JsonProperty("bind")
    public void setBind(String bind) {
        this.bind = bind;
    }

    /**
     * The loopback IP endpoint or Unix domain socket to which traffic should be forwarded to by default. Format should be `127.0.0.1:PORT` or `unix:///path/to/socket` or `unix://@foobar` (Linux abstract namespace). NOT IMPLEMENTED. $hide_from_docs
     */
    @JsonProperty("defaultEndpoint")
    public String getDefaultEndpoint() {
        return defaultEndpoint;
    }

    /**
     * The loopback IP endpoint or Unix domain socket to which traffic should be forwarded to by default. Format should be `127.0.0.1:PORT` or `unix:///path/to/socket` or `unix://@foobar` (Linux abstract namespace). NOT IMPLEMENTED. $hide_from_docs
     */
    @JsonProperty("defaultEndpoint")
    public void setDefaultEndpoint(String defaultEndpoint) {
        this.defaultEndpoint = defaultEndpoint;
    }

    /**
     * One or more hosts exposed by this gateway. While typically applicable to HTTP services, it can also be used for TCP services using TLS with SNI. A host is specified as a `dnsName` with an optional `namespace/` prefix. The `dnsName` should be specified using FQDN format, optionally including a wildcard character in the left-most component (e.g., `prod/&#42;.example.com`). Set the `dnsName` to `&#42;` to select all `VirtualService` hosts from the specified namespace (e.g.,`prod/&#42;`).<br><p> <br><p> The `namespace` can be set to `&#42;` or `.`, representing any or the current namespace, respectively. For example, `&#42;/foo.example.com` selects the service from any available namespace while `./foo.example.com` only selects the service from the namespace of the sidecar. The default, if no `namespace/` is specified, is `&#42;/`, that is, select services from any namespace. Any associated `DestinationRule` in the selected namespace will also be used.<br><p> <br><p> A `VirtualService` must be bound to the gateway and must have one or more hosts that match the hosts specified in a server. The match could be an exact match or a suffix match with the server's hosts. For example, if the server's hosts specifies `&#42;.example.com`, a `VirtualService` with hosts `dev.example.com` or `prod.example.com` will match. However, a `VirtualService` with host `example.com` or `newexample.com` will not match.<br><p> <br><p> NOTE: Only virtual services exported to the gateway's namespace (e.g., `exportTo` value of `&#42;`) can be referenced. Private configurations (e.g., `exportTo` set to `.`) will not be available. Refer to the `exportTo` setting in `VirtualService`, `DestinationRule`, and `ServiceEntry` configurations for details.
     */
    @JsonProperty("hosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getHosts() {
        return hosts;
    }

    /**
     * One or more hosts exposed by this gateway. While typically applicable to HTTP services, it can also be used for TCP services using TLS with SNI. A host is specified as a `dnsName` with an optional `namespace/` prefix. The `dnsName` should be specified using FQDN format, optionally including a wildcard character in the left-most component (e.g., `prod/&#42;.example.com`). Set the `dnsName` to `&#42;` to select all `VirtualService` hosts from the specified namespace (e.g.,`prod/&#42;`).<br><p> <br><p> The `namespace` can be set to `&#42;` or `.`, representing any or the current namespace, respectively. For example, `&#42;/foo.example.com` selects the service from any available namespace while `./foo.example.com` only selects the service from the namespace of the sidecar. The default, if no `namespace/` is specified, is `&#42;/`, that is, select services from any namespace. Any associated `DestinationRule` in the selected namespace will also be used.<br><p> <br><p> A `VirtualService` must be bound to the gateway and must have one or more hosts that match the hosts specified in a server. The match could be an exact match or a suffix match with the server's hosts. For example, if the server's hosts specifies `&#42;.example.com`, a `VirtualService` with hosts `dev.example.com` or `prod.example.com` will match. However, a `VirtualService` with host `example.com` or `newexample.com` will not match.<br><p> <br><p> NOTE: Only virtual services exported to the gateway's namespace (e.g., `exportTo` value of `&#42;`) can be referenced. Private configurations (e.g., `exportTo` set to `.`) will not be available. Refer to the `exportTo` setting in `VirtualService`, `DestinationRule`, and `ServiceEntry` configurations for details.
     */
    @JsonProperty("hosts")
    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    /**
     * An optional name of the server, when set must be unique across all servers. This will be used for variety of purposes like prefixing stats generated with this name etc.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * An optional name of the server, when set must be unique across all servers. This will be used for variety of purposes like prefixing stats generated with this name etc.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * `Server` describes the properties of the proxy on a given load balancer port. For example,<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: Gateway metadata:<br><p> <br><p> 	name: my-ingress<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  app: my-ingressgateway<br><p> 	servers:<br><p> 	- port:<br><p> 	    number: 80<br><p> 	    name: http2<br><p> 	    protocol: HTTP2<br><p> 	  hosts:<br><p> 	  - "&#42;"<br><p> <br><p> ```<br><p> <br><p> # Another example<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: Gateway metadata:<br><p> <br><p> 	name: my-tcp-ingress<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  app: my-tcp-ingressgateway<br><p> 	servers:<br><p> 	- port:<br><p> 	    number: 27018<br><p> 	    name: mongo<br><p> 	    protocol: MONGO<br><p> 	  hosts:<br><p> 	  - "&#42;"<br><p> <br><p> ```<br><p> <br><p> # The following is an example of TLS configuration for port 443<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: Gateway metadata:<br><p> <br><p> 	name: my-tls-ingress<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  app: my-tls-ingressgateway<br><p> 	servers:<br><p> 	- port:<br><p> 	    number: 443<br><p> 	    name: https<br><p> 	    protocol: HTTPS<br><p> 	  hosts:<br><p> 	  - "&#42;"<br><p> 	  tls:<br><p> 	    mode: SIMPLE<br><p> 	    credentialName: tls-cert<br><p> <br><p> ```
     */
    @JsonProperty("port")
    public Port getPort() {
        return port;
    }

    /**
     * `Server` describes the properties of the proxy on a given load balancer port. For example,<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: Gateway metadata:<br><p> <br><p> 	name: my-ingress<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  app: my-ingressgateway<br><p> 	servers:<br><p> 	- port:<br><p> 	    number: 80<br><p> 	    name: http2<br><p> 	    protocol: HTTP2<br><p> 	  hosts:<br><p> 	  - "&#42;"<br><p> <br><p> ```<br><p> <br><p> # Another example<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: Gateway metadata:<br><p> <br><p> 	name: my-tcp-ingress<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  app: my-tcp-ingressgateway<br><p> 	servers:<br><p> 	- port:<br><p> 	    number: 27018<br><p> 	    name: mongo<br><p> 	    protocol: MONGO<br><p> 	  hosts:<br><p> 	  - "&#42;"<br><p> <br><p> ```<br><p> <br><p> # The following is an example of TLS configuration for port 443<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: Gateway metadata:<br><p> <br><p> 	name: my-tls-ingress<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  app: my-tls-ingressgateway<br><p> 	servers:<br><p> 	- port:<br><p> 	    number: 443<br><p> 	    name: https<br><p> 	    protocol: HTTPS<br><p> 	  hosts:<br><p> 	  - "&#42;"<br><p> 	  tls:<br><p> 	    mode: SIMPLE<br><p> 	    credentialName: tls-cert<br><p> <br><p> ```
     */
    @JsonProperty("port")
    public void setPort(Port port) {
        this.port = port;
    }

    /**
     * `Server` describes the properties of the proxy on a given load balancer port. For example,<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: Gateway metadata:<br><p> <br><p> 	name: my-ingress<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  app: my-ingressgateway<br><p> 	servers:<br><p> 	- port:<br><p> 	    number: 80<br><p> 	    name: http2<br><p> 	    protocol: HTTP2<br><p> 	  hosts:<br><p> 	  - "&#42;"<br><p> <br><p> ```<br><p> <br><p> # Another example<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: Gateway metadata:<br><p> <br><p> 	name: my-tcp-ingress<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  app: my-tcp-ingressgateway<br><p> 	servers:<br><p> 	- port:<br><p> 	    number: 27018<br><p> 	    name: mongo<br><p> 	    protocol: MONGO<br><p> 	  hosts:<br><p> 	  - "&#42;"<br><p> <br><p> ```<br><p> <br><p> # The following is an example of TLS configuration for port 443<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: Gateway metadata:<br><p> <br><p> 	name: my-tls-ingress<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  app: my-tls-ingressgateway<br><p> 	servers:<br><p> 	- port:<br><p> 	    number: 443<br><p> 	    name: https<br><p> 	    protocol: HTTPS<br><p> 	  hosts:<br><p> 	  - "&#42;"<br><p> 	  tls:<br><p> 	    mode: SIMPLE<br><p> 	    credentialName: tls-cert<br><p> <br><p> ```
     */
    @JsonProperty("tls")
    public ServerTLSSettings getTls() {
        return tls;
    }

    /**
     * `Server` describes the properties of the proxy on a given load balancer port. For example,<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: Gateway metadata:<br><p> <br><p> 	name: my-ingress<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  app: my-ingressgateway<br><p> 	servers:<br><p> 	- port:<br><p> 	    number: 80<br><p> 	    name: http2<br><p> 	    protocol: HTTP2<br><p> 	  hosts:<br><p> 	  - "&#42;"<br><p> <br><p> ```<br><p> <br><p> # Another example<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: Gateway metadata:<br><p> <br><p> 	name: my-tcp-ingress<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  app: my-tcp-ingressgateway<br><p> 	servers:<br><p> 	- port:<br><p> 	    number: 27018<br><p> 	    name: mongo<br><p> 	    protocol: MONGO<br><p> 	  hosts:<br><p> 	  - "&#42;"<br><p> <br><p> ```<br><p> <br><p> # The following is an example of TLS configuration for port 443<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: Gateway metadata:<br><p> <br><p> 	name: my-tls-ingress<br><p> <br><p> spec:<br><p> <br><p> 	selector:<br><p> 	  app: my-tls-ingressgateway<br><p> 	servers:<br><p> 	- port:<br><p> 	    number: 443<br><p> 	    name: https<br><p> 	    protocol: HTTPS<br><p> 	  hosts:<br><p> 	  - "&#42;"<br><p> 	  tls:<br><p> 	    mode: SIMPLE<br><p> 	    credentialName: tls-cert<br><p> <br><p> ```
     */
    @JsonProperty("tls")
    public void setTls(ServerTLSSettings tls) {
        this.tls = tls;
    }

    @JsonIgnore
    public ServerBuilder edit() {
        return new ServerBuilder(this);
    }

    @JsonIgnore
    public ServerBuilder toBuilder() {
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
        if (!(o instanceof Server)) {
            return false;
        }
        Server other = (Server) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bind = this.getBind();
        Object other$bind = other.getBind();
        if (this$bind == null ? other$bind != null : !this$bind.equals(other$bind)) {
            return false;
        }
        Object this$defaultEndpoint = this.getDefaultEndpoint();
        Object other$defaultEndpoint = other.getDefaultEndpoint();
        if (this$defaultEndpoint == null ? other$defaultEndpoint != null : !this$defaultEndpoint.equals(other$defaultEndpoint)) {
            return false;
        }
        Object this$hosts = this.getHosts();
        Object other$hosts = other.getHosts();
        if (this$hosts == null ? other$hosts != null : !this$hosts.equals(other$hosts)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$port = this.getPort();
        Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
            return false;
        }
        Object this$tls = this.getTls();
        Object other$tls = other.getTls();
        if (this$tls == null ? other$tls != null : !this$tls.equals(other$tls)) {
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
        return other instanceof Server;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bind = this.getBind();
        result = result * prime + ($bind == null ? 43 : $bind.hashCode());
        Object $defaultEndpoint = this.getDefaultEndpoint();
        result = result * prime + ($defaultEndpoint == null ? 43 : $defaultEndpoint.hashCode());
        Object $hosts = this.getHosts();
        result = result * prime + ($hosts == null ? 43 : $hosts.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $tls = this.getTls();
        result = result * prime + ($tls == null ? 43 : $tls.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Server(" + "bind=" + this.getBind() + ", defaultEndpoint=" + this.getDefaultEndpoint() + ", hosts=" + this.getHosts() + ", name=" + this.getName() + ", port=" + this.getPort() + ", tls=" + this.getTls() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
