
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "bind",
    "captureMode",
    "connectionPool",
    "defaultEndpoint",
    "port",
    "tls"
})
@ToString
@EqualsAndHashCode
@Setter
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
@Generated("jsonschema2pojo")
public class IstioIngressListener implements Editable<IstioIngressListenerBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("bind")
    public String getBind() {
        return bind;
    }

    @JsonProperty("bind")
    public void setBind(String bind) {
        this.bind = bind;
    }

    @JsonProperty("captureMode")
    public CaptureMode getCaptureMode() {
        return captureMode;
    }

    @JsonProperty("captureMode")
    public void setCaptureMode(CaptureMode captureMode) {
        this.captureMode = captureMode;
    }

    @JsonProperty("connectionPool")
    public ConnectionPoolSettings getConnectionPool() {
        return connectionPool;
    }

    @JsonProperty("connectionPool")
    public void setConnectionPool(ConnectionPoolSettings connectionPool) {
        this.connectionPool = connectionPool;
    }

    @JsonProperty("defaultEndpoint")
    public String getDefaultEndpoint() {
        return defaultEndpoint;
    }

    @JsonProperty("defaultEndpoint")
    public void setDefaultEndpoint(String defaultEndpoint) {
        this.defaultEndpoint = defaultEndpoint;
    }

    @JsonProperty("port")
    public SidecarPort getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(SidecarPort port) {
        this.port = port;
    }

    @JsonProperty("tls")
    public ServerTLSSettings getTls() {
        return tls;
    }

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
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
