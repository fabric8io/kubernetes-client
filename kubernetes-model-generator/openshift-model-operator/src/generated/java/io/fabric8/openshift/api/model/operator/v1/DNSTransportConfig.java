
package io.fabric8.openshift.api.model.operator.v1;

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
 * DNSTransportConfig groups related configuration parameters used for configuring forwarding to upstream resolvers that support DNS-over-TLS.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "tls",
    "transport"
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
public class DNSTransportConfig implements Editable<DNSTransportConfigBuilder>, KubernetesResource
{

    @JsonProperty("tls")
    private DNSOverTLSConfig tls;
    @JsonProperty("transport")
    private String transport;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DNSTransportConfig() {
    }

    public DNSTransportConfig(DNSOverTLSConfig tls, String transport) {
        super();
        this.tls = tls;
        this.transport = transport;
    }

    /**
     * DNSTransportConfig groups related configuration parameters used for configuring forwarding to upstream resolvers that support DNS-over-TLS.
     */
    @JsonProperty("tls")
    public DNSOverTLSConfig getTls() {
        return tls;
    }

    /**
     * DNSTransportConfig groups related configuration parameters used for configuring forwarding to upstream resolvers that support DNS-over-TLS.
     */
    @JsonProperty("tls")
    public void setTls(DNSOverTLSConfig tls) {
        this.tls = tls;
    }

    /**
     * transport allows cluster administrators to opt-in to using a DNS-over-TLS connection between cluster DNS and an upstream resolver(s). Configuring TLS as the transport at this level without configuring a CABundle will result in the system certificates being used to verify the serving certificate of the upstream resolver(s).<br><p> <br><p> Possible values: "" (empty) - This means no explicit choice has been made and the platform chooses the default which is subject to change over time. The current default is "Cleartext". "Cleartext" - Cluster admin specified cleartext option. This results in the same functionality as an empty value but may be useful when a cluster admin wants to be more explicit about the transport, or wants to switch from "TLS" to "Cleartext" explicitly. "TLS" - This indicates that DNS queries should be sent over a TLS connection. If Transport is set to TLS, you MUST also set ServerName. If a port is not included with the upstream IP, port 853 will be tried by default per RFC 7858 section 3.1; https://datatracker.ietf.org/doc/html/rfc7858#section-3.1.
     */
    @JsonProperty("transport")
    public String getTransport() {
        return transport;
    }

    /**
     * transport allows cluster administrators to opt-in to using a DNS-over-TLS connection between cluster DNS and an upstream resolver(s). Configuring TLS as the transport at this level without configuring a CABundle will result in the system certificates being used to verify the serving certificate of the upstream resolver(s).<br><p> <br><p> Possible values: "" (empty) - This means no explicit choice has been made and the platform chooses the default which is subject to change over time. The current default is "Cleartext". "Cleartext" - Cluster admin specified cleartext option. This results in the same functionality as an empty value but may be useful when a cluster admin wants to be more explicit about the transport, or wants to switch from "TLS" to "Cleartext" explicitly. "TLS" - This indicates that DNS queries should be sent over a TLS connection. If Transport is set to TLS, you MUST also set ServerName. If a port is not included with the upstream IP, port 853 will be tried by default per RFC 7858 section 3.1; https://datatracker.ietf.org/doc/html/rfc7858#section-3.1.
     */
    @JsonProperty("transport")
    public void setTransport(String transport) {
        this.transport = transport;
    }

    @JsonIgnore
    public DNSTransportConfigBuilder edit() {
        return new DNSTransportConfigBuilder(this);
    }

    @JsonIgnore
    public DNSTransportConfigBuilder toBuilder() {
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
        if (!(o instanceof DNSTransportConfig)) {
            return false;
        }
        DNSTransportConfig other = (DNSTransportConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$tls = this.getTls();
        Object other$tls = other.getTls();
        if (this$tls == null ? other$tls != null : !this$tls.equals(other$tls)) {
            return false;
        }
        Object this$transport = this.getTransport();
        Object other$transport = other.getTransport();
        if (this$transport == null ? other$transport != null : !this$transport.equals(other$transport)) {
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
        return other instanceof DNSTransportConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $tls = this.getTls();
        result = result * prime + ($tls == null ? 43 : $tls.hashCode());
        Object $transport = this.getTransport();
        result = result * prime + ($transport == null ? 43 : $transport.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DNSTransportConfig(" + "tls=" + this.getTls() + ", transport=" + this.getTransport() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
