
package io.fabric8.istio.api.api.networking.v1alpha3;

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

/**
 * `IstioIngressListener` specifies the properties of an inbound traffic listener on the sidecar proxy attached to a workload instance.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bind",
    "captureMode",
    "connectionPool",
    "defaultEndpoint",
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
public class IstioIngressListener implements Editable<IstioIngressListenerBuilder>, KubernetesResource
{

    @JsonProperty("bind")
    private String bind;
    @JsonProperty("captureMode")
    private CaptureMode captureMode;
    @JsonProperty("connectionPool")
    private ConnectionPoolSettings connectionPool;
    @JsonProperty("defaultEndpoint")
    private String defaultEndpoint;
    @JsonProperty("port")
    private SidecarPort port;
    @JsonProperty("tls")
    private ServerTLSSettings tls;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IstioIngressListener() {
    }

    public IstioIngressListener(String bind, CaptureMode captureMode, ConnectionPoolSettings connectionPool, String defaultEndpoint, SidecarPort port, ServerTLSSettings tls) {
        super();
        this.bind = bind;
        this.captureMode = captureMode;
        this.connectionPool = connectionPool;
        this.defaultEndpoint = defaultEndpoint;
        this.port = port;
        this.tls = tls;
    }

    /**
     * The IP(IPv4 or IPv6) to which the listener should be bound. Unix domain socket addresses are not allowed in the bind field for ingress listeners. If omitted, Istio will automatically configure the defaults based on imported services and the workload instances to which this configuration is applied to.
     */
    @JsonProperty("bind")
    public String getBind() {
        return bind;
    }

    /**
     * The IP(IPv4 or IPv6) to which the listener should be bound. Unix domain socket addresses are not allowed in the bind field for ingress listeners. If omitted, Istio will automatically configure the defaults based on imported services and the workload instances to which this configuration is applied to.
     */
    @JsonProperty("bind")
    public void setBind(String bind) {
        this.bind = bind;
    }

    /**
     * `IstioIngressListener` specifies the properties of an inbound traffic listener on the sidecar proxy attached to a workload instance.
     */
    @JsonProperty("captureMode")
    public CaptureMode getCaptureMode() {
        return captureMode;
    }

    /**
     * `IstioIngressListener` specifies the properties of an inbound traffic listener on the sidecar proxy attached to a workload instance.
     */
    @JsonProperty("captureMode")
    public void setCaptureMode(CaptureMode captureMode) {
        this.captureMode = captureMode;
    }

    /**
     * `IstioIngressListener` specifies the properties of an inbound traffic listener on the sidecar proxy attached to a workload instance.
     */
    @JsonProperty("connectionPool")
    public ConnectionPoolSettings getConnectionPool() {
        return connectionPool;
    }

    /**
     * `IstioIngressListener` specifies the properties of an inbound traffic listener on the sidecar proxy attached to a workload instance.
     */
    @JsonProperty("connectionPool")
    public void setConnectionPool(ConnectionPoolSettings connectionPool) {
        this.connectionPool = connectionPool;
    }

    /**
     * The IP endpoint or Unix domain socket to which traffic should be forwarded to. This configuration can be used to redirect traffic arriving at the bind `IP:Port` on the sidecar to a `localhost:port` or Unix domain socket where the application workload instance is listening for connections. Arbitrary IPs are not supported. Format should be one of `127.0.0.1:PORT`, `[::1]:PORT` (forward to localhost), `0.0.0.0:PORT`, `[::]:PORT` (forward to the instance IP), or `unix:///path/to/socket` (forward to Unix domain socket).
     */
    @JsonProperty("defaultEndpoint")
    public String getDefaultEndpoint() {
        return defaultEndpoint;
    }

    /**
     * The IP endpoint or Unix domain socket to which traffic should be forwarded to. This configuration can be used to redirect traffic arriving at the bind `IP:Port` on the sidecar to a `localhost:port` or Unix domain socket where the application workload instance is listening for connections. Arbitrary IPs are not supported. Format should be one of `127.0.0.1:PORT`, `[::1]:PORT` (forward to localhost), `0.0.0.0:PORT`, `[::]:PORT` (forward to the instance IP), or `unix:///path/to/socket` (forward to Unix domain socket).
     */
    @JsonProperty("defaultEndpoint")
    public void setDefaultEndpoint(String defaultEndpoint) {
        this.defaultEndpoint = defaultEndpoint;
    }

    /**
     * `IstioIngressListener` specifies the properties of an inbound traffic listener on the sidecar proxy attached to a workload instance.
     */
    @JsonProperty("port")
    public SidecarPort getPort() {
        return port;
    }

    /**
     * `IstioIngressListener` specifies the properties of an inbound traffic listener on the sidecar proxy attached to a workload instance.
     */
    @JsonProperty("port")
    public void setPort(SidecarPort port) {
        this.port = port;
    }

    /**
     * `IstioIngressListener` specifies the properties of an inbound traffic listener on the sidecar proxy attached to a workload instance.
     */
    @JsonProperty("tls")
    public ServerTLSSettings getTls() {
        return tls;
    }

    /**
     * `IstioIngressListener` specifies the properties of an inbound traffic listener on the sidecar proxy attached to a workload instance.
     */
    @JsonProperty("tls")
    public void setTls(ServerTLSSettings tls) {
        this.tls = tls;
    }

    @JsonIgnore
    public IstioIngressListenerBuilder edit() {
        return new IstioIngressListenerBuilder(this);
    }

    @JsonIgnore
    public IstioIngressListenerBuilder toBuilder() {
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
        if (!(o instanceof IstioIngressListener)) {
            return false;
        }
        IstioIngressListener other = (IstioIngressListener) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bind = this.getBind();
        Object other$bind = other.getBind();
        if (this$bind == null ? other$bind != null : !this$bind.equals(other$bind)) {
            return false;
        }
        Object this$captureMode = this.getCaptureMode();
        Object other$captureMode = other.getCaptureMode();
        if (this$captureMode == null ? other$captureMode != null : !this$captureMode.equals(other$captureMode)) {
            return false;
        }
        Object this$connectionPool = this.getConnectionPool();
        Object other$connectionPool = other.getConnectionPool();
        if (this$connectionPool == null ? other$connectionPool != null : !this$connectionPool.equals(other$connectionPool)) {
            return false;
        }
        Object this$defaultEndpoint = this.getDefaultEndpoint();
        Object other$defaultEndpoint = other.getDefaultEndpoint();
        if (this$defaultEndpoint == null ? other$defaultEndpoint != null : !this$defaultEndpoint.equals(other$defaultEndpoint)) {
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
        return other instanceof IstioIngressListener;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bind = this.getBind();
        result = result * prime + ($bind == null ? 43 : $bind.hashCode());
        Object $captureMode = this.getCaptureMode();
        result = result * prime + ($captureMode == null ? 43 : $captureMode.hashCode());
        Object $connectionPool = this.getConnectionPool();
        result = result * prime + ($connectionPool == null ? 43 : $connectionPool.hashCode());
        Object $defaultEndpoint = this.getDefaultEndpoint();
        result = result * prime + ($defaultEndpoint == null ? 43 : $defaultEndpoint.hashCode());
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
        return "IstioIngressListener(" + "bind=" + this.getBind() + ", captureMode=" + this.getCaptureMode() + ", connectionPool=" + this.getConnectionPool() + ", defaultEndpoint=" + this.getDefaultEndpoint() + ", port=" + this.getPort() + ", tls=" + this.getTls() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
