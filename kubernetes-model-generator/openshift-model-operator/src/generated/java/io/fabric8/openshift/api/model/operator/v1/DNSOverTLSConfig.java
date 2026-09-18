
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
import io.fabric8.openshift.api.model.config.v1.ConfigMapNameReference;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * DNSOverTLSConfig describes optional DNSTransportConfig fields that should be captured.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "caBundle",
    "serverName"
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
public class DNSOverTLSConfig implements Editable<DNSOverTLSConfigBuilder>, KubernetesResource
{

    @JsonProperty("caBundle")
    private ConfigMapNameReference caBundle;
    @JsonProperty("serverName")
    private String serverName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DNSOverTLSConfig() {
    }

    public DNSOverTLSConfig(ConfigMapNameReference caBundle, String serverName) {
        super();
        this.caBundle = caBundle;
        this.serverName = serverName;
    }

    /**
     * DNSOverTLSConfig describes optional DNSTransportConfig fields that should be captured.
     */
    @JsonProperty("caBundle")
    public ConfigMapNameReference getCaBundle() {
        return caBundle;
    }

    /**
     * DNSOverTLSConfig describes optional DNSTransportConfig fields that should be captured.
     */
    @JsonProperty("caBundle")
    public void setCaBundle(ConfigMapNameReference caBundle) {
        this.caBundle = caBundle;
    }

    /**
     * serverName is the upstream server to connect to when forwarding DNS queries. This is required when Transport is set to "TLS". ServerName will be validated against the DNS naming conventions in RFC 1123 and should match the TLS certificate installed in the upstream resolver(s).
     */
    @JsonProperty("serverName")
    public String getServerName() {
        return serverName;
    }

    /**
     * serverName is the upstream server to connect to when forwarding DNS queries. This is required when Transport is set to "TLS". ServerName will be validated against the DNS naming conventions in RFC 1123 and should match the TLS certificate installed in the upstream resolver(s).
     */
    @JsonProperty("serverName")
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @JsonIgnore
    public DNSOverTLSConfigBuilder edit() {
        return new DNSOverTLSConfigBuilder(this);
    }

    @JsonIgnore
    public DNSOverTLSConfigBuilder toBuilder() {
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
        if (!(o instanceof DNSOverTLSConfig)) {
            return false;
        }
        DNSOverTLSConfig other = (DNSOverTLSConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$caBundle = this.getCaBundle();
        Object other$caBundle = other.getCaBundle();
        if (this$caBundle == null ? other$caBundle != null : !this$caBundle.equals(other$caBundle)) {
            return false;
        }
        Object this$serverName = this.getServerName();
        Object other$serverName = other.getServerName();
        if (this$serverName == null ? other$serverName != null : !this$serverName.equals(other$serverName)) {
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
        return other instanceof DNSOverTLSConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $caBundle = this.getCaBundle();
        result = result * prime + ($caBundle == null ? 43 : $caBundle.hashCode());
        Object $serverName = this.getServerName();
        result = result * prime + ($serverName == null ? 43 : $serverName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DNSOverTLSConfig(" + "caBundle=" + this.getCaBundle() + ", serverName=" + this.getServerName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
