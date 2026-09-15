
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * OAuthRemoteConnectionInfo holds information necessary for establishing a remote connection
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ca",
    "tlsClientCert",
    "tlsClientKey",
    "url"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class OAuthRemoteConnectionInfo implements Editable<OAuthRemoteConnectionInfoBuilder>, KubernetesResource
{

    @JsonProperty("ca")
    private ConfigMapNameReference ca;
    @JsonProperty("tlsClientCert")
    private SecretNameReference tlsClientCert;
    @JsonProperty("tlsClientKey")
    private SecretNameReference tlsClientKey;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OAuthRemoteConnectionInfo() {
    }

    public OAuthRemoteConnectionInfo(ConfigMapNameReference ca, SecretNameReference tlsClientCert, SecretNameReference tlsClientKey, String url) {
        super();
        this.ca = ca;
        this.tlsClientCert = tlsClientCert;
        this.tlsClientKey = tlsClientKey;
        this.url = url;
    }

    /**
     * OAuthRemoteConnectionInfo holds information necessary for establishing a remote connection
     */
    @JsonProperty("ca")
    public ConfigMapNameReference getCa() {
        return ca;
    }

    /**
     * OAuthRemoteConnectionInfo holds information necessary for establishing a remote connection
     */
    @JsonProperty("ca")
    public void setCa(ConfigMapNameReference ca) {
        this.ca = ca;
    }

    /**
     * OAuthRemoteConnectionInfo holds information necessary for establishing a remote connection
     */
    @JsonProperty("tlsClientCert")
    public SecretNameReference getTlsClientCert() {
        return tlsClientCert;
    }

    /**
     * OAuthRemoteConnectionInfo holds information necessary for establishing a remote connection
     */
    @JsonProperty("tlsClientCert")
    public void setTlsClientCert(SecretNameReference tlsClientCert) {
        this.tlsClientCert = tlsClientCert;
    }

    /**
     * OAuthRemoteConnectionInfo holds information necessary for establishing a remote connection
     */
    @JsonProperty("tlsClientKey")
    public SecretNameReference getTlsClientKey() {
        return tlsClientKey;
    }

    /**
     * OAuthRemoteConnectionInfo holds information necessary for establishing a remote connection
     */
    @JsonProperty("tlsClientKey")
    public void setTlsClientKey(SecretNameReference tlsClientKey) {
        this.tlsClientKey = tlsClientKey;
    }

    /**
     * url is the remote URL to connect to
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * url is the remote URL to connect to
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public OAuthRemoteConnectionInfoBuilder edit() {
        return new OAuthRemoteConnectionInfoBuilder(this);
    }

    @JsonIgnore
    public OAuthRemoteConnectionInfoBuilder toBuilder() {
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
        if (!(o instanceof OAuthRemoteConnectionInfo)) {
            return false;
        }
        OAuthRemoteConnectionInfo other = (OAuthRemoteConnectionInfo) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ca = this.getCa();
        Object other$ca = other.getCa();
        if (this$ca == null ? other$ca != null : !this$ca.equals(other$ca)) {
            return false;
        }
        Object this$tlsClientCert = this.getTlsClientCert();
        Object other$tlsClientCert = other.getTlsClientCert();
        if (this$tlsClientCert == null ? other$tlsClientCert != null : !this$tlsClientCert.equals(other$tlsClientCert)) {
            return false;
        }
        Object this$tlsClientKey = this.getTlsClientKey();
        Object other$tlsClientKey = other.getTlsClientKey();
        if (this$tlsClientKey == null ? other$tlsClientKey != null : !this$tlsClientKey.equals(other$tlsClientKey)) {
            return false;
        }
        Object this$url = this.getUrl();
        Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) {
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
        return other instanceof OAuthRemoteConnectionInfo;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ca = this.getCa();
        result = result * prime + ($ca == null ? 43 : $ca.hashCode());
        Object $tlsClientCert = this.getTlsClientCert();
        result = result * prime + ($tlsClientCert == null ? 43 : $tlsClientCert.hashCode());
        Object $tlsClientKey = this.getTlsClientKey();
        result = result * prime + ($tlsClientKey == null ? 43 : $tlsClientKey.hashCode());
        Object $url = this.getUrl();
        result = result * prime + ($url == null ? 43 : $url.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OAuthRemoteConnectionInfo(" + "ca=" + this.getCa() + ", tlsClientCert=" + this.getTlsClientCert() + ", tlsClientKey=" + this.getTlsClientKey() + ", url=" + this.getUrl() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
