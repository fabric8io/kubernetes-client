
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "protocol",
    "targetHost",
    "targetPort"
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
public class TrafficPolicyTunnelSettings implements Editable<TrafficPolicyTunnelSettingsBuilder>, KubernetesResource
{

    @JsonProperty("protocol")
    private String protocol;
    @JsonProperty("targetHost")
    private String targetHost;
    @JsonProperty("targetPort")
    private Long targetPort;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TrafficPolicyTunnelSettings() {
    }

    public TrafficPolicyTunnelSettings(String protocol, String targetHost, Long targetPort) {
        super();
        this.protocol = protocol;
        this.targetHost = targetHost;
        this.targetPort = targetPort;
    }

    /**
     * Specifies which protocol to use for tunneling the downstream connection. Supported protocols are:<br><p>   - CONNECT - uses HTTP CONNECT;<br><p>   - POST - uses HTTP POST.<br><p> <br><p> CONNECT is used by default if not specified.<br><p> <br><p> HTTP version for upstream requests is determined by the service protocol defined for the proxy.
     */
    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    /**
     * Specifies which protocol to use for tunneling the downstream connection. Supported protocols are:<br><p>   - CONNECT - uses HTTP CONNECT;<br><p>   - POST - uses HTTP POST.<br><p> <br><p> CONNECT is used by default if not specified.<br><p> <br><p> HTTP version for upstream requests is determined by the service protocol defined for the proxy.
     */
    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * Specifies a host to which the downstream connection is tunneled. Target host must be an FQDN or IP address.
     */
    @JsonProperty("targetHost")
    public String getTargetHost() {
        return targetHost;
    }

    /**
     * Specifies a host to which the downstream connection is tunneled. Target host must be an FQDN or IP address.
     */
    @JsonProperty("targetHost")
    public void setTargetHost(String targetHost) {
        this.targetHost = targetHost;
    }

    /**
     * Specifies a port to which the downstream connection is tunneled.
     */
    @JsonProperty("targetPort")
    public Long getTargetPort() {
        return targetPort;
    }

    /**
     * Specifies a port to which the downstream connection is tunneled.
     */
    @JsonProperty("targetPort")
    public void setTargetPort(Long targetPort) {
        this.targetPort = targetPort;
    }

    @JsonIgnore
    public TrafficPolicyTunnelSettingsBuilder edit() {
        return new TrafficPolicyTunnelSettingsBuilder(this);
    }

    @JsonIgnore
    public TrafficPolicyTunnelSettingsBuilder toBuilder() {
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
        if (!(o instanceof TrafficPolicyTunnelSettings)) {
            return false;
        }
        TrafficPolicyTunnelSettings other = (TrafficPolicyTunnelSettings) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$protocol = this.getProtocol();
        Object other$protocol = other.getProtocol();
        if (this$protocol == null ? other$protocol != null : !this$protocol.equals(other$protocol)) {
            return false;
        }
        Object this$targetHost = this.getTargetHost();
        Object other$targetHost = other.getTargetHost();
        if (this$targetHost == null ? other$targetHost != null : !this$targetHost.equals(other$targetHost)) {
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
        return other instanceof TrafficPolicyTunnelSettings;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $protocol = this.getProtocol();
        result = result * prime + ($protocol == null ? 43 : $protocol.hashCode());
        Object $targetHost = this.getTargetHost();
        result = result * prime + ($targetHost == null ? 43 : $targetHost.hashCode());
        Object $targetPort = this.getTargetPort();
        result = result * prime + ($targetPort == null ? 43 : $targetPort.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TrafficPolicyTunnelSettings(" + "protocol=" + this.getProtocol() + ", targetHost=" + this.getTargetHost() + ", targetPort=" + this.getTargetPort() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
