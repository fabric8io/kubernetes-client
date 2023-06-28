
package io.fabric8.chaosmesh.v1alpha1;

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
    "correlation",
    "device",
    "egress-port",
    "hostname",
    "ip-address",
    "ip-protocol",
    "jitter",
    "latency",
    "source-port"
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
public class NetworkDelaySpec implements KubernetesResource
{

    @JsonProperty("correlation")
    private String correlation;
    @JsonProperty("device")
    private String device;
    @JsonProperty("egress-port")
    private String egressPort;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("ip-address")
    private String ipAddress;
    @JsonProperty("ip-protocol")
    private String ipProtocol;
    @JsonProperty("jitter")
    private String jitter;
    @JsonProperty("latency")
    private String latency;
    @JsonProperty("source-port")
    private String sourcePort;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NetworkDelaySpec() {
    }

    public NetworkDelaySpec(String correlation, String device, String egressPort, String hostname, String ipAddress, String ipProtocol, String jitter, String latency, String sourcePort) {
        super();
        this.correlation = correlation;
        this.device = device;
        this.egressPort = egressPort;
        this.hostname = hostname;
        this.ipAddress = ipAddress;
        this.ipProtocol = ipProtocol;
        this.jitter = jitter;
        this.latency = latency;
        this.sourcePort = sourcePort;
    }

    @JsonProperty("correlation")
    public String getCorrelation() {
        return correlation;
    }

    @JsonProperty("correlation")
    public void setCorrelation(String correlation) {
        this.correlation = correlation;
    }

    @JsonProperty("device")
    public String getDevice() {
        return device;
    }

    @JsonProperty("device")
    public void setDevice(String device) {
        this.device = device;
    }

    @JsonProperty("egress-port")
    public String getEgressPort() {
        return egressPort;
    }

    @JsonProperty("egress-port")
    public void setEgressPort(String egressPort) {
        this.egressPort = egressPort;
    }

    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @JsonProperty("ip-address")
    public String getIpAddress() {
        return ipAddress;
    }

    @JsonProperty("ip-address")
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @JsonProperty("ip-protocol")
    public String getIpProtocol() {
        return ipProtocol;
    }

    @JsonProperty("ip-protocol")
    public void setIpProtocol(String ipProtocol) {
        this.ipProtocol = ipProtocol;
    }

    @JsonProperty("jitter")
    public String getJitter() {
        return jitter;
    }

    @JsonProperty("jitter")
    public void setJitter(String jitter) {
        this.jitter = jitter;
    }

    @JsonProperty("latency")
    public String getLatency() {
        return latency;
    }

    @JsonProperty("latency")
    public void setLatency(String latency) {
        this.latency = latency;
    }

    @JsonProperty("source-port")
    public String getSourcePort() {
        return sourcePort;
    }

    @JsonProperty("source-port")
    public void setSourcePort(String sourcePort) {
        this.sourcePort = sourcePort;
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
