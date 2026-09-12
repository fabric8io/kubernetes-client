
package io.fabric8.chaosmesh.v1alpha1;

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
    "accept-tcp-flags",
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
public class NetworkDelaySpec implements Editable<NetworkDelaySpecBuilder>, KubernetesResource
{

    @JsonProperty("accept-tcp-flags")
    private String acceptTcpFlags;
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
     */
    public NetworkDelaySpec() {
    }

    public NetworkDelaySpec(String acceptTcpFlags, String correlation, String device, String egressPort, String hostname, String ipAddress, String ipProtocol, String jitter, String latency, String sourcePort) {
        super();
        this.acceptTcpFlags = acceptTcpFlags;
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

    /**
     * only the packet which match the tcp flag can be accepted, others will be dropped. only set when the IPProtocol is tcp, used for partition.
     */
    @JsonProperty("accept-tcp-flags")
    public String getAcceptTcpFlags() {
        return acceptTcpFlags;
    }

    /**
     * only the packet which match the tcp flag can be accepted, others will be dropped. only set when the IPProtocol is tcp, used for partition.
     */
    @JsonProperty("accept-tcp-flags")
    public void setAcceptTcpFlags(String acceptTcpFlags) {
        this.acceptTcpFlags = acceptTcpFlags;
    }

    /**
     * correlation is percentage (10 is 10%)
     */
    @JsonProperty("correlation")
    public String getCorrelation() {
        return correlation;
    }

    /**
     * correlation is percentage (10 is 10%)
     */
    @JsonProperty("correlation")
    public void setCorrelation(String correlation) {
        this.correlation = correlation;
    }

    /**
     * the network interface to impact
     */
    @JsonProperty("device")
    public String getDevice() {
        return device;
    }

    /**
     * the network interface to impact
     */
    @JsonProperty("device")
    public void setDevice(String device) {
        this.device = device;
    }

    /**
     * only impact egress traffic to these destination ports, use a ',' to separate or to indicate the range, such as 80, 8001:8010. it can only be used in conjunction with -p tcp or -p udp
     */
    @JsonProperty("egress-port")
    public String getEgressPort() {
        return egressPort;
    }

    /**
     * only impact egress traffic to these destination ports, use a ',' to separate or to indicate the range, such as 80, 8001:8010. it can only be used in conjunction with -p tcp or -p udp
     */
    @JsonProperty("egress-port")
    public void setEgressPort(String egressPort) {
        this.egressPort = egressPort;
    }

    /**
     * only impact traffic to these hostnames
     */
    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    /**
     * only impact traffic to these hostnames
     */
    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * only impact egress traffic to these IP addresses
     */
    @JsonProperty("ip-address")
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * only impact egress traffic to these IP addresses
     */
    @JsonProperty("ip-address")
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * only impact traffic using this IP protocol, supported: tcp, udp, icmp, all
     */
    @JsonProperty("ip-protocol")
    public String getIpProtocol() {
        return ipProtocol;
    }

    /**
     * only impact traffic using this IP protocol, supported: tcp, udp, icmp, all
     */
    @JsonProperty("ip-protocol")
    public void setIpProtocol(String ipProtocol) {
        this.ipProtocol = ipProtocol;
    }

    /**
     * jitter time, time units: ns, us (or µs), ms, s, m, h.
     */
    @JsonProperty("jitter")
    public String getJitter() {
        return jitter;
    }

    /**
     * jitter time, time units: ns, us (or µs), ms, s, m, h.
     */
    @JsonProperty("jitter")
    public void setJitter(String jitter) {
        this.jitter = jitter;
    }

    /**
     * delay egress time, time units: ns, us (or µs), ms, s, m, h.
     */
    @JsonProperty("latency")
    public String getLatency() {
        return latency;
    }

    /**
     * delay egress time, time units: ns, us (or µs), ms, s, m, h.
     */
    @JsonProperty("latency")
    public void setLatency(String latency) {
        this.latency = latency;
    }

    /**
     * only impact egress traffic from these source ports, use a ',' to separate or to indicate the range, such as 80, 8001:8010. it can only be used in conjunction with -p tcp or -p udp
     */
    @JsonProperty("source-port")
    public String getSourcePort() {
        return sourcePort;
    }

    /**
     * only impact egress traffic from these source ports, use a ',' to separate or to indicate the range, such as 80, 8001:8010. it can only be used in conjunction with -p tcp or -p udp
     */
    @JsonProperty("source-port")
    public void setSourcePort(String sourcePort) {
        this.sourcePort = sourcePort;
    }

    @JsonIgnore
    public NetworkDelaySpecBuilder edit() {
        return new NetworkDelaySpecBuilder(this);
    }

    @JsonIgnore
    public NetworkDelaySpecBuilder toBuilder() {
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
        if (!(o instanceof NetworkDelaySpec)) {
            return false;
        }
        NetworkDelaySpec other = (NetworkDelaySpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$acceptTcpFlags = this.getAcceptTcpFlags();
        Object other$acceptTcpFlags = other.getAcceptTcpFlags();
        if (this$acceptTcpFlags == null ? other$acceptTcpFlags != null : !this$acceptTcpFlags.equals(other$acceptTcpFlags)) {
            return false;
        }
        Object this$correlation = this.getCorrelation();
        Object other$correlation = other.getCorrelation();
        if (this$correlation == null ? other$correlation != null : !this$correlation.equals(other$correlation)) {
            return false;
        }
        Object this$device = this.getDevice();
        Object other$device = other.getDevice();
        if (this$device == null ? other$device != null : !this$device.equals(other$device)) {
            return false;
        }
        Object this$egressPort = this.getEgressPort();
        Object other$egressPort = other.getEgressPort();
        if (this$egressPort == null ? other$egressPort != null : !this$egressPort.equals(other$egressPort)) {
            return false;
        }
        Object this$hostname = this.getHostname();
        Object other$hostname = other.getHostname();
        if (this$hostname == null ? other$hostname != null : !this$hostname.equals(other$hostname)) {
            return false;
        }
        Object this$ipAddress = this.getIpAddress();
        Object other$ipAddress = other.getIpAddress();
        if (this$ipAddress == null ? other$ipAddress != null : !this$ipAddress.equals(other$ipAddress)) {
            return false;
        }
        Object this$ipProtocol = this.getIpProtocol();
        Object other$ipProtocol = other.getIpProtocol();
        if (this$ipProtocol == null ? other$ipProtocol != null : !this$ipProtocol.equals(other$ipProtocol)) {
            return false;
        }
        Object this$jitter = this.getJitter();
        Object other$jitter = other.getJitter();
        if (this$jitter == null ? other$jitter != null : !this$jitter.equals(other$jitter)) {
            return false;
        }
        Object this$latency = this.getLatency();
        Object other$latency = other.getLatency();
        if (this$latency == null ? other$latency != null : !this$latency.equals(other$latency)) {
            return false;
        }
        Object this$sourcePort = this.getSourcePort();
        Object other$sourcePort = other.getSourcePort();
        if (this$sourcePort == null ? other$sourcePort != null : !this$sourcePort.equals(other$sourcePort)) {
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
        return other instanceof NetworkDelaySpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $acceptTcpFlags = this.getAcceptTcpFlags();
        result = result * prime + ($acceptTcpFlags == null ? 43 : $acceptTcpFlags.hashCode());
        Object $correlation = this.getCorrelation();
        result = result * prime + ($correlation == null ? 43 : $correlation.hashCode());
        Object $device = this.getDevice();
        result = result * prime + ($device == null ? 43 : $device.hashCode());
        Object $egressPort = this.getEgressPort();
        result = result * prime + ($egressPort == null ? 43 : $egressPort.hashCode());
        Object $hostname = this.getHostname();
        result = result * prime + ($hostname == null ? 43 : $hostname.hashCode());
        Object $ipAddress = this.getIpAddress();
        result = result * prime + ($ipAddress == null ? 43 : $ipAddress.hashCode());
        Object $ipProtocol = this.getIpProtocol();
        result = result * prime + ($ipProtocol == null ? 43 : $ipProtocol.hashCode());
        Object $jitter = this.getJitter();
        result = result * prime + ($jitter == null ? 43 : $jitter.hashCode());
        Object $latency = this.getLatency();
        result = result * prime + ($latency == null ? 43 : $latency.hashCode());
        Object $sourcePort = this.getSourcePort();
        result = result * prime + ($sourcePort == null ? 43 : $sourcePort.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkDelaySpec(" + "acceptTcpFlags=" + this.getAcceptTcpFlags() + ", correlation=" + this.getCorrelation() + ", device=" + this.getDevice() + ", egressPort=" + this.getEgressPort() + ", hostname=" + this.getHostname() + ", ipAddress=" + this.getIpAddress() + ", ipProtocol=" + this.getIpProtocol() + ", jitter=" + this.getJitter() + ", latency=" + this.getLatency() + ", sourcePort=" + this.getSourcePort() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
