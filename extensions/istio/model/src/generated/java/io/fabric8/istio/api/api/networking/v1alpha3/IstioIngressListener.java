
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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

}
