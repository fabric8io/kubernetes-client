
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
    "duration",
    "ip-address",
    "parallel",
    "port",
    "rate"
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
public class NetworkFloodSpec implements Editable<NetworkFloodSpecBuilder>, KubernetesResource
{

    @JsonProperty("duration")
    private String duration;
    @JsonProperty("ip-address")
    private String ipAddress;
    @JsonProperty("parallel")
    private Integer parallel;
    @JsonProperty("port")
    private String port;
    @JsonProperty("rate")
    private String rate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkFloodSpec() {
    }

    public NetworkFloodSpec(String duration, String ipAddress, Integer parallel, String port, String rate) {
        super();
        this.duration = duration;
        this.ipAddress = ipAddress;
        this.parallel = parallel;
        this.port = port;
        this.rate = rate;
    }

    /**
     * The number of seconds to run the iperf test
     */
    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    /**
     * The number of seconds to run the iperf test
     */
    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Generate traffic to this IP address
     */
    @JsonProperty("ip-address")
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * Generate traffic to this IP address
     */
    @JsonProperty("ip-address")
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * The number of iperf parallel client threads to run
     */
    @JsonProperty("parallel")
    public Integer getParallel() {
        return parallel;
    }

    /**
     * The number of iperf parallel client threads to run
     */
    @JsonProperty("parallel")
    public void setParallel(Integer parallel) {
        this.parallel = parallel;
    }

    /**
     * Generate traffic to this port on the IP address
     */
    @JsonProperty("port")
    public String getPort() {
        return port;
    }

    /**
     * Generate traffic to this port on the IP address
     */
    @JsonProperty("port")
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * The speed of network traffic, allows bps, kbps, mbps, gbps, tbps unit. bps means bytes per second
     */
    @JsonProperty("rate")
    public String getRate() {
        return rate;
    }

    /**
     * The speed of network traffic, allows bps, kbps, mbps, gbps, tbps unit. bps means bytes per second
     */
    @JsonProperty("rate")
    public void setRate(String rate) {
        this.rate = rate;
    }

    @JsonIgnore
    public NetworkFloodSpecBuilder edit() {
        return new NetworkFloodSpecBuilder(this);
    }

    @JsonIgnore
    public NetworkFloodSpecBuilder toBuilder() {
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
        if (!(o instanceof NetworkFloodSpec)) {
            return false;
        }
        NetworkFloodSpec other = (NetworkFloodSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$duration = this.getDuration();
        Object other$duration = other.getDuration();
        if (this$duration == null ? other$duration != null : !this$duration.equals(other$duration)) {
            return false;
        }
        Object this$ipAddress = this.getIpAddress();
        Object other$ipAddress = other.getIpAddress();
        if (this$ipAddress == null ? other$ipAddress != null : !this$ipAddress.equals(other$ipAddress)) {
            return false;
        }
        Object this$parallel = this.getParallel();
        Object other$parallel = other.getParallel();
        if (this$parallel == null ? other$parallel != null : !this$parallel.equals(other$parallel)) {
            return false;
        }
        Object this$port = this.getPort();
        Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
            return false;
        }
        Object this$rate = this.getRate();
        Object other$rate = other.getRate();
        if (this$rate == null ? other$rate != null : !this$rate.equals(other$rate)) {
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
        return other instanceof NetworkFloodSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $duration = this.getDuration();
        result = result * prime + ($duration == null ? 43 : $duration.hashCode());
        Object $ipAddress = this.getIpAddress();
        result = result * prime + ($ipAddress == null ? 43 : $ipAddress.hashCode());
        Object $parallel = this.getParallel();
        result = result * prime + ($parallel == null ? 43 : $parallel.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $rate = this.getRate();
        result = result * prime + ($rate == null ? 43 : $rate.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkFloodSpec(" + "duration=" + this.getDuration() + ", ipAddress=" + this.getIpAddress() + ", parallel=" + this.getParallel() + ", port=" + this.getPort() + ", rate=" + this.getRate() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
