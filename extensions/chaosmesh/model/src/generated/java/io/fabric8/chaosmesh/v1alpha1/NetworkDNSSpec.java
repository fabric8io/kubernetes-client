
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dns-domain-name",
    "dns-ip",
    "dns-server"
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
