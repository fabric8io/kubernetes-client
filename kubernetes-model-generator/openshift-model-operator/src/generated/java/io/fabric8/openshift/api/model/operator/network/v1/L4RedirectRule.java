
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
     * Port is the port number to which clients should send traffic to be redirected.
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * Port is the port number to which clients should send traffic to be redirected.
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * Protocol can be TCP, SCTP or UDP.
     */
    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    /**
     * Protocol can be TCP, SCTP or UDP.
     */
    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * TargetPort allows specifying the port number on the remote destination to which the traffic gets redirected to. If unspecified, the value from "Port" is used.
     */
    @JsonProperty("targetPort")
    public Integer getTargetPort() {
        return targetPort;
    }

    /**
     * TargetPort allows specifying the port number on the remote destination to which the traffic gets redirected to. If unspecified, the value from "Port" is used.
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

}
