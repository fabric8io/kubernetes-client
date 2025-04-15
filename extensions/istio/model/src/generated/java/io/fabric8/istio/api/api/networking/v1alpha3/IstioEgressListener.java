
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * `IstioEgressListener` specifies the properties of an outbound traffic listener on the sidecar proxy attached to a workload instance.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bind",
    "captureMode",
    "hosts",
    "port"
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
public class IstioEgressListener implements Editable<IstioEgressListenerBuilder>, KubernetesResource
{

    @JsonProperty("bind")
    private String bind;
    @JsonProperty("captureMode")
    private CaptureMode captureMode;
    @JsonProperty("hosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> hosts = new ArrayList<>();
    @JsonProperty("port")
    private SidecarPort port;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IstioEgressListener() {
    }

    public IstioEgressListener(String bind, CaptureMode captureMode, List<String> hosts, SidecarPort port) {
        super();
        this.bind = bind;
        this.captureMode = captureMode;
        this.hosts = hosts;
        this.port = port;
    }

    /**
     * The IP(IPv4 or IPv6) or the Unix domain socket to which the listener should be bound to. Port MUST be specified if bind is not empty. Format: IPv4 or IPv6 address formats or `unix:///path/to/uds` or `unix://@foobar` (Linux abstract namespace). If omitted, Istio will automatically configure the defaults based on imported services, the workload instances to which this configuration is applied to and the captureMode. If captureMode is `NONE`, bind will default to 127.0.0.1.
     */
    @JsonProperty("bind")
    public String getBind() {
        return bind;
    }

    /**
     * The IP(IPv4 or IPv6) or the Unix domain socket to which the listener should be bound to. Port MUST be specified if bind is not empty. Format: IPv4 or IPv6 address formats or `unix:///path/to/uds` or `unix://@foobar` (Linux abstract namespace). If omitted, Istio will automatically configure the defaults based on imported services, the workload instances to which this configuration is applied to and the captureMode. If captureMode is `NONE`, bind will default to 127.0.0.1.
     */
    @JsonProperty("bind")
    public void setBind(String bind) {
        this.bind = bind;
    }

    /**
     * `IstioEgressListener` specifies the properties of an outbound traffic listener on the sidecar proxy attached to a workload instance.
     */
    @JsonProperty("captureMode")
    public CaptureMode getCaptureMode() {
        return captureMode;
    }

    /**
     * `IstioEgressListener` specifies the properties of an outbound traffic listener on the sidecar proxy attached to a workload instance.
     */
    @JsonProperty("captureMode")
    public void setCaptureMode(CaptureMode captureMode) {
        this.captureMode = captureMode;
    }

    /**
     * One or more service hosts exposed by the listener in `namespace/dnsName` format. Services in the specified namespace matching `dnsName` will be exposed. The corresponding service can be a service in the service registry (e.g., a Kubernetes or cloud foundry service) or a service specified using a `ServiceEntry` or `VirtualService` configuration. Any associated `DestinationRule` in the same namespace will also be used.<br><p> <br><p> The `dnsName` should be specified using FQDN format, optionally including a wildcard character in the left-most component (e.g., `prod/&#42;.example.com`). Set the `dnsName` to `&#42;` to select all services from the specified namespace (e.g., `prod/&#42;`).<br><p> <br><p> The `namespace` can be set to `&#42;`, `.`, or `~`, representing any, the current, or no namespace, respectively. For example, `&#42;/foo.example.com` selects the service from any available namespace while `./foo.example.com` only selects the service from the namespace of the sidecar. If a host is set to `&#42;/&#42;`, Istio will configure the sidecar to be able to reach every service in the mesh that is exported to the sidecar's namespace. The value `~/&#42;` can be used to completely trim the configuration for sidecars that simply receive traffic and respond, but make no outbound connections of their own.<br><p> <br><p> NOTE: Only services and configuration artifacts exported to the sidecar's namespace (e.g., `exportTo` value of `&#42;`) can be referenced. Private configurations (e.g., `exportTo` set to `.`) will not be available. Refer to the `exportTo` setting in `VirtualService`, `DestinationRule`, and `ServiceEntry` configurations for details.
     */
    @JsonProperty("hosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getHosts() {
        return hosts;
    }

    /**
     * One or more service hosts exposed by the listener in `namespace/dnsName` format. Services in the specified namespace matching `dnsName` will be exposed. The corresponding service can be a service in the service registry (e.g., a Kubernetes or cloud foundry service) or a service specified using a `ServiceEntry` or `VirtualService` configuration. Any associated `DestinationRule` in the same namespace will also be used.<br><p> <br><p> The `dnsName` should be specified using FQDN format, optionally including a wildcard character in the left-most component (e.g., `prod/&#42;.example.com`). Set the `dnsName` to `&#42;` to select all services from the specified namespace (e.g., `prod/&#42;`).<br><p> <br><p> The `namespace` can be set to `&#42;`, `.`, or `~`, representing any, the current, or no namespace, respectively. For example, `&#42;/foo.example.com` selects the service from any available namespace while `./foo.example.com` only selects the service from the namespace of the sidecar. If a host is set to `&#42;/&#42;`, Istio will configure the sidecar to be able to reach every service in the mesh that is exported to the sidecar's namespace. The value `~/&#42;` can be used to completely trim the configuration for sidecars that simply receive traffic and respond, but make no outbound connections of their own.<br><p> <br><p> NOTE: Only services and configuration artifacts exported to the sidecar's namespace (e.g., `exportTo` value of `&#42;`) can be referenced. Private configurations (e.g., `exportTo` set to `.`) will not be available. Refer to the `exportTo` setting in `VirtualService`, `DestinationRule`, and `ServiceEntry` configurations for details.
     */
    @JsonProperty("hosts")
    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    /**
     * `IstioEgressListener` specifies the properties of an outbound traffic listener on the sidecar proxy attached to a workload instance.
     */
    @JsonProperty("port")
    public SidecarPort getPort() {
        return port;
    }

    /**
     * `IstioEgressListener` specifies the properties of an outbound traffic listener on the sidecar proxy attached to a workload instance.
     */
    @JsonProperty("port")
    public void setPort(SidecarPort port) {
        this.port = port;
    }

    @JsonIgnore
    public IstioEgressListenerBuilder edit() {
        return new IstioEgressListenerBuilder(this);
    }

    @JsonIgnore
    public IstioEgressListenerBuilder toBuilder() {
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

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
