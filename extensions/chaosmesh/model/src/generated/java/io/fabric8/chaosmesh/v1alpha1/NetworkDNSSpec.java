
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
    "dns-domain-name",
    "dns-ip",
    "dns-server"
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
public class NetworkDNSSpec implements Editable<NetworkDNSSpecBuilder>, KubernetesResource
{

    @JsonProperty("dns-domain-name")
    private String dnsDomainName;
    @JsonProperty("dns-ip")
    private String dnsIp;
    @JsonProperty("dns-server")
    private String dnsServer;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkDNSSpec() {
    }

    public NetworkDNSSpec(String dnsDomainName, String dnsIp, String dnsServer) {
        super();
        this.dnsDomainName = dnsDomainName;
        this.dnsIp = dnsIp;
        this.dnsServer = dnsServer;
    }

    /**
     * map this host to specified IP
     */
    @JsonProperty("dns-domain-name")
    public String getDnsDomainName() {
        return dnsDomainName;
    }

    /**
     * map this host to specified IP
     */
    @JsonProperty("dns-domain-name")
    public void setDnsDomainName(String dnsDomainName) {
        this.dnsDomainName = dnsDomainName;
    }

    /**
     * map specified host to this IP address
     */
    @JsonProperty("dns-ip")
    public String getDnsIp() {
        return dnsIp;
    }

    /**
     * map specified host to this IP address
     */
    @JsonProperty("dns-ip")
    public void setDnsIp(String dnsIp) {
        this.dnsIp = dnsIp;
    }

    /**
     * update the DNS server in /etc/resolv.conf with this value
     */
    @JsonProperty("dns-server")
    public String getDnsServer() {
        return dnsServer;
    }

    /**
     * update the DNS server in /etc/resolv.conf with this value
     */
    @JsonProperty("dns-server")
    public void setDnsServer(String dnsServer) {
        this.dnsServer = dnsServer;
    }

    @JsonIgnore
    public NetworkDNSSpecBuilder edit() {
        return new NetworkDNSSpecBuilder(this);
    }

    @JsonIgnore
    public NetworkDNSSpecBuilder toBuilder() {
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
        if (!(o instanceof NetworkDNSSpec)) {
            return false;
        }
        NetworkDNSSpec other = (NetworkDNSSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$dnsDomainName = this.getDnsDomainName();
        Object other$dnsDomainName = other.getDnsDomainName();
        if (this$dnsDomainName == null ? other$dnsDomainName != null : !this$dnsDomainName.equals(other$dnsDomainName)) {
            return false;
        }
        Object this$dnsIp = this.getDnsIp();
        Object other$dnsIp = other.getDnsIp();
        if (this$dnsIp == null ? other$dnsIp != null : !this$dnsIp.equals(other$dnsIp)) {
            return false;
        }
        Object this$dnsServer = this.getDnsServer();
        Object other$dnsServer = other.getDnsServer();
        if (this$dnsServer == null ? other$dnsServer != null : !this$dnsServer.equals(other$dnsServer)) {
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
        return other instanceof NetworkDNSSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $dnsDomainName = this.getDnsDomainName();
        result = result * prime + ($dnsDomainName == null ? 43 : $dnsDomainName.hashCode());
        Object $dnsIp = this.getDnsIp();
        result = result * prime + ($dnsIp == null ? 43 : $dnsIp.hashCode());
        Object $dnsServer = this.getDnsServer();
        result = result * prime + ($dnsServer == null ? 43 : $dnsServer.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkDNSSpec(" + "dnsDomainName=" + this.getDnsDomainName() + ", dnsIp=" + this.getDnsIp() + ", dnsServer=" + this.getDnsServer() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
