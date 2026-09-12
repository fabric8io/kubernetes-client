
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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

/**
 * NetworkDataServicev4 represents a service object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dns",
    "dnsFromIPPool"
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
public class NetworkDataServicev4 implements Editable<NetworkDataServicev4Builder>, KubernetesResource
{

    @JsonProperty("dns")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> dns = new ArrayList<>();
    @JsonProperty("dnsFromIPPool")
    private String dnsFromIPPool;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkDataServicev4() {
    }

    public NetworkDataServicev4(List<String> dns, String dnsFromIPPool) {
        super();
        this.dns = dns;
        this.dnsFromIPPool = dnsFromIPPool;
    }

    /**
     * DNS is a list of IPv4 DNS services
     */
    @JsonProperty("dns")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDns() {
        return dns;
    }

    /**
     * DNS is a list of IPv4 DNS services
     */
    @JsonProperty("dns")
    public void setDns(List<String> dns) {
        this.dns = dns;
    }

    /**
     * DNSFromIPPool is the name of the IPPool from which to get the DNS servers
     */
    @JsonProperty("dnsFromIPPool")
    public String getDnsFromIPPool() {
        return dnsFromIPPool;
    }

    /**
     * DNSFromIPPool is the name of the IPPool from which to get the DNS servers
     */
    @JsonProperty("dnsFromIPPool")
    public void setDnsFromIPPool(String dnsFromIPPool) {
        this.dnsFromIPPool = dnsFromIPPool;
    }

    @JsonIgnore
    public NetworkDataServicev4Builder edit() {
        return new NetworkDataServicev4Builder(this);
    }

    @JsonIgnore
    public NetworkDataServicev4Builder toBuilder() {
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
        if (!(o instanceof NetworkDataServicev4)) {
            return false;
        }
        NetworkDataServicev4 other = (NetworkDataServicev4) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$dns = this.getDns();
        Object other$dns = other.getDns();
        if (this$dns == null ? other$dns != null : !this$dns.equals(other$dns)) {
            return false;
        }
        Object this$dnsFromIPPool = this.getDnsFromIPPool();
        Object other$dnsFromIPPool = other.getDnsFromIPPool();
        if (this$dnsFromIPPool == null ? other$dnsFromIPPool != null : !this$dnsFromIPPool.equals(other$dnsFromIPPool)) {
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
        return other instanceof NetworkDataServicev4;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $dns = this.getDns();
        result = result * prime + ($dns == null ? 43 : $dns.hashCode());
        Object $dnsFromIPPool = this.getDnsFromIPPool();
        result = result * prime + ($dnsFromIPPool == null ? 43 : $dnsFromIPPool.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkDataServicev4(" + "dns=" + this.getDns() + ", dnsFromIPPool=" + this.getDnsFromIPPool() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
