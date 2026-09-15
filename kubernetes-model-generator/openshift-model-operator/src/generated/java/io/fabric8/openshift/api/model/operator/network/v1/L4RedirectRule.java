
package io.fabric8.openshift.api.model.operator.network.v1;

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
 * L4RedirectRule defines a DNAT redirection from a given port to a destination IP and port.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "destinationIP",
    "port",
    "protocol",
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
public class L4RedirectRule implements Editable<L4RedirectRuleBuilder>, KubernetesResource
{

    @JsonProperty("destinationIP")
    private String destinationIP;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("protocol")
    private String protocol;
    @JsonProperty("targetPort")
    private Integer targetPort;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public L4RedirectRule() {
    }

    public L4RedirectRule(String destinationIP, Integer port, String protocol, Integer targetPort) {
        super();
        this.destinationIP = destinationIP;
        this.port = port;
        this.protocol = protocol;
        this.targetPort = targetPort;
    }

    /**
     * IP specifies the remote destination's IP address. Can be IPv4 or IPv6.
     */
    @JsonProperty("destinationIP")
    public String getDestinationIP() {
        return destinationIP;
    }

    /**
     * IP specifies the remote destination's IP address. Can be IPv4 or IPv6.
     */
    @JsonProperty("destinationIP")
    public void setDestinationIP(String destinationIP) {
        this.destinationIP = destinationIP;
    }

    /**
     * port is the port number to which clients should send traffic to be redirected.
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * port is the port number to which clients should send traffic to be redirected.
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * protocol can be TCP, SCTP or UDP.
     */
    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    /**
     * protocol can be TCP, SCTP or UDP.
     */
    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * targetPort allows specifying the port number on the remote destination to which the traffic gets redirected to. If unspecified, the value from "Port" is used.
     */
    @JsonProperty("targetPort")
    public Integer getTargetPort() {
        return targetPort;
    }

    /**
     * targetPort allows specifying the port number on the remote destination to which the traffic gets redirected to. If unspecified, the value from "Port" is used.
     */
    @JsonProperty("targetPort")
    public void setTargetPort(Integer targetPort) {
        this.targetPort = targetPort;
    }

    @JsonIgnore
    public L4RedirectRuleBuilder edit() {
        return new L4RedirectRuleBuilder(this);
    }

    @JsonIgnore
    public L4RedirectRuleBuilder toBuilder() {
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
        if (!(o instanceof L4RedirectRule)) {
            return false;
        }
        L4RedirectRule other = (L4RedirectRule) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$destinationIP = this.getDestinationIP();
        Object other$destinationIP = other.getDestinationIP();
        if (this$destinationIP == null ? other$destinationIP != null : !this$destinationIP.equals(other$destinationIP)) {
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
        return other instanceof L4RedirectRule;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $destinationIP = this.getDestinationIP();
        result = result * prime + ($destinationIP == null ? 43 : $destinationIP.hashCode());
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
        return "L4RedirectRule(" + "destinationIP=" + this.getDestinationIP() + ", port=" + this.getPort() + ", protocol=" + this.getProtocol() + ", targetPort=" + this.getTargetPort() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
