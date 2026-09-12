
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
    "buffer",
    "device",
    "hostname",
    "ip-address",
    "limit",
    "minburst",
    "peakrate",
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
public class NetworkBandwidthSpec implements Editable<NetworkBandwidthSpecBuilder>, KubernetesResource
{

    @JsonProperty("buffer")
    private Long buffer;
    @JsonProperty("device")
    private String device;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("ip-address")
    private String ipAddress;
    @JsonProperty("limit")
    private Long limit;
    @JsonProperty("minburst")
    private Long minburst;
    @JsonProperty("peakrate")
    private Long peakrate;
    @JsonProperty("rate")
    private String rate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkBandwidthSpec() {
    }

    public NetworkBandwidthSpec(Long buffer, String device, String hostname, String ipAddress, Long limit, Long minburst, Long peakrate, String rate) {
        super();
        this.buffer = buffer;
        this.device = device;
        this.hostname = hostname;
        this.ipAddress = ipAddress;
        this.limit = limit;
        this.minburst = minburst;
        this.peakrate = peakrate;
        this.rate = rate;
    }

    @JsonProperty("buffer")
    public Long getBuffer() {
        return buffer;
    }

    @JsonProperty("buffer")
    public void setBuffer(Long buffer) {
        this.buffer = buffer;
    }

    @JsonProperty("device")
    public String getDevice() {
        return device;
    }

    @JsonProperty("device")
    public void setDevice(String device) {
        this.device = device;
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

    @JsonProperty("limit")
    public Long getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(Long limit) {
        this.limit = limit;
    }

    @JsonProperty("minburst")
    public Long getMinburst() {
        return minburst;
    }

    @JsonProperty("minburst")
    public void setMinburst(Long minburst) {
        this.minburst = minburst;
    }

    @JsonProperty("peakrate")
    public Long getPeakrate() {
        return peakrate;
    }

    @JsonProperty("peakrate")
    public void setPeakrate(Long peakrate) {
        this.peakrate = peakrate;
    }

    @JsonProperty("rate")
    public String getRate() {
        return rate;
    }

    @JsonProperty("rate")
    public void setRate(String rate) {
        this.rate = rate;
    }

    @JsonIgnore
    public NetworkBandwidthSpecBuilder edit() {
        return new NetworkBandwidthSpecBuilder(this);
    }

    @JsonIgnore
    public NetworkBandwidthSpecBuilder toBuilder() {
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
        if (!(o instanceof NetworkBandwidthSpec)) {
            return false;
        }
        NetworkBandwidthSpec other = (NetworkBandwidthSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$buffer = this.getBuffer();
        Object other$buffer = other.getBuffer();
        if (this$buffer == null ? other$buffer != null : !this$buffer.equals(other$buffer)) {
            return false;
        }
        Object this$device = this.getDevice();
        Object other$device = other.getDevice();
        if (this$device == null ? other$device != null : !this$device.equals(other$device)) {
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
        Object this$limit = this.getLimit();
        Object other$limit = other.getLimit();
        if (this$limit == null ? other$limit != null : !this$limit.equals(other$limit)) {
            return false;
        }
        Object this$minburst = this.getMinburst();
        Object other$minburst = other.getMinburst();
        if (this$minburst == null ? other$minburst != null : !this$minburst.equals(other$minburst)) {
            return false;
        }
        Object this$peakrate = this.getPeakrate();
        Object other$peakrate = other.getPeakrate();
        if (this$peakrate == null ? other$peakrate != null : !this$peakrate.equals(other$peakrate)) {
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
        return other instanceof NetworkBandwidthSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $buffer = this.getBuffer();
        result = result * prime + ($buffer == null ? 43 : $buffer.hashCode());
        Object $device = this.getDevice();
        result = result * prime + ($device == null ? 43 : $device.hashCode());
        Object $hostname = this.getHostname();
        result = result * prime + ($hostname == null ? 43 : $hostname.hashCode());
        Object $ipAddress = this.getIpAddress();
        result = result * prime + ($ipAddress == null ? 43 : $ipAddress.hashCode());
        Object $limit = this.getLimit();
        result = result * prime + ($limit == null ? 43 : $limit.hashCode());
        Object $minburst = this.getMinburst();
        result = result * prime + ($minburst == null ? 43 : $minburst.hashCode());
        Object $peakrate = this.getPeakrate();
        result = result * prime + ($peakrate == null ? 43 : $peakrate.hashCode());
        Object $rate = this.getRate();
        result = result * prime + ($rate == null ? 43 : $rate.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkBandwidthSpec(" + "buffer=" + this.getBuffer() + ", device=" + this.getDevice() + ", hostname=" + this.getHostname() + ", ipAddress=" + this.getIpAddress() + ", limit=" + this.getLimit() + ", minburst=" + this.getMinburst() + ", peakrate=" + this.getPeakrate() + ", rate=" + this.getRate() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
