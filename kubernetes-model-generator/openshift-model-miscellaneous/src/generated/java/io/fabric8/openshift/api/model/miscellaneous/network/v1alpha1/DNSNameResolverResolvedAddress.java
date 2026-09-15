
package io.fabric8.openshift.api.model.miscellaneous.network.v1alpha1;

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
 * DNSNameResolverResolvedAddress describes the details of an IP address for a resolved DNS name.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ip",
    "lastLookupTime",
    "ttlSeconds"
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
public class DNSNameResolverResolvedAddress implements Editable<DNSNameResolverResolvedAddressBuilder>, KubernetesResource
{

    @JsonProperty("ip")
    private String ip;
    @JsonProperty("lastLookupTime")
    private String lastLookupTime;
    @JsonProperty("ttlSeconds")
    private Integer ttlSeconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DNSNameResolverResolvedAddress() {
    }

    public DNSNameResolverResolvedAddress(String ip, String lastLookupTime, Integer ttlSeconds) {
        super();
        this.ip = ip;
        this.lastLookupTime = lastLookupTime;
        this.ttlSeconds = ttlSeconds;
    }

    /**
     * ip is an IP address associated with the dnsName. The validity of the IP address expires after lastLookupTime + ttlSeconds. To refresh the information, a DNS lookup will be performed upon the expiration of the IP address's validity. If the information is not refreshed then it will be removed with a grace period after the expiration of the IP address's validity.
     */
    @JsonProperty("ip")
    public String getIp() {
        return ip;
    }

    /**
     * ip is an IP address associated with the dnsName. The validity of the IP address expires after lastLookupTime + ttlSeconds. To refresh the information, a DNS lookup will be performed upon the expiration of the IP address's validity. If the information is not refreshed then it will be removed with a grace period after the expiration of the IP address's validity.
     */
    @JsonProperty("ip")
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * DNSNameResolverResolvedAddress describes the details of an IP address for a resolved DNS name.
     */
    @JsonProperty("lastLookupTime")
    public String getLastLookupTime() {
        return lastLookupTime;
    }

    /**
     * DNSNameResolverResolvedAddress describes the details of an IP address for a resolved DNS name.
     */
    @JsonProperty("lastLookupTime")
    public void setLastLookupTime(String lastLookupTime) {
        this.lastLookupTime = lastLookupTime;
    }

    /**
     * ttlSeconds is the time-to-live value of the IP address. The validity of the IP address expires after lastLookupTime + ttlSeconds. On a successful DNS lookup the value of this field will be updated with the current time-to-live value. If the information is not refreshed then it will be removed with a grace period after the expiration of the IP address's validity.
     */
    @JsonProperty("ttlSeconds")
    public Integer getTtlSeconds() {
        return ttlSeconds;
    }

    /**
     * ttlSeconds is the time-to-live value of the IP address. The validity of the IP address expires after lastLookupTime + ttlSeconds. On a successful DNS lookup the value of this field will be updated with the current time-to-live value. If the information is not refreshed then it will be removed with a grace period after the expiration of the IP address's validity.
     */
    @JsonProperty("ttlSeconds")
    public void setTtlSeconds(Integer ttlSeconds) {
        this.ttlSeconds = ttlSeconds;
    }

    @JsonIgnore
    public DNSNameResolverResolvedAddressBuilder edit() {
        return new DNSNameResolverResolvedAddressBuilder(this);
    }

    @JsonIgnore
    public DNSNameResolverResolvedAddressBuilder toBuilder() {
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
        if (!(o instanceof DNSNameResolverResolvedAddress)) {
            return false;
        }
        DNSNameResolverResolvedAddress other = (DNSNameResolverResolvedAddress) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ip = this.getIp();
        Object other$ip = other.getIp();
        if (this$ip == null ? other$ip != null : !this$ip.equals(other$ip)) {
            return false;
        }
        Object this$lastLookupTime = this.getLastLookupTime();
        Object other$lastLookupTime = other.getLastLookupTime();
        if (this$lastLookupTime == null ? other$lastLookupTime != null : !this$lastLookupTime.equals(other$lastLookupTime)) {
            return false;
        }
        Object this$ttlSeconds = this.getTtlSeconds();
        Object other$ttlSeconds = other.getTtlSeconds();
        if (this$ttlSeconds == null ? other$ttlSeconds != null : !this$ttlSeconds.equals(other$ttlSeconds)) {
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
        return other instanceof DNSNameResolverResolvedAddress;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ip = this.getIp();
        result = result * prime + ($ip == null ? 43 : $ip.hashCode());
        Object $lastLookupTime = this.getLastLookupTime();
        result = result * prime + ($lastLookupTime == null ? 43 : $lastLookupTime.hashCode());
        Object $ttlSeconds = this.getTtlSeconds();
        result = result * prime + ($ttlSeconds == null ? 43 : $ttlSeconds.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DNSNameResolverResolvedAddress(" + "ip=" + this.getIp() + ", lastLookupTime=" + this.getLastLookupTime() + ", ttlSeconds=" + this.getTtlSeconds() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
