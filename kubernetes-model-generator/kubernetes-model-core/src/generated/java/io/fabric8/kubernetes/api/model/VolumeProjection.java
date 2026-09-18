
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * Projection that may be projected along with other supported volume types. Exactly one of these fields must be set.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterTrustBundle",
    "configMap",
    "downwardAPI",
    "podCertificate",
    "secret",
    "serviceAccountToken"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class VolumeProjection implements Editable<VolumeProjectionBuilder>, KubernetesResource
{

    @JsonProperty("clusterTrustBundle")
    private ClusterTrustBundleProjection clusterTrustBundle;
    @JsonProperty("configMap")
    private ConfigMapProjection configMap;
    @JsonProperty("downwardAPI")
    private DownwardAPIProjection downwardAPI;
    @JsonProperty("podCertificate")
    private PodCertificateProjection podCertificate;
    @JsonProperty("secret")
    private SecretProjection secret;
    @JsonProperty("serviceAccountToken")
    private ServiceAccountTokenProjection serviceAccountToken;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VolumeProjection() {
    }

    public VolumeProjection(ClusterTrustBundleProjection clusterTrustBundle, ConfigMapProjection configMap, DownwardAPIProjection downwardAPI, PodCertificateProjection podCertificate, SecretProjection secret, ServiceAccountTokenProjection serviceAccountToken) {
        super();
        this.clusterTrustBundle = clusterTrustBundle;
        this.configMap = configMap;
        this.downwardAPI = downwardAPI;
        this.podCertificate = podCertificate;
        this.secret = secret;
        this.serviceAccountToken = serviceAccountToken;
    }

    /**
     * Projection that may be projected along with other supported volume types. Exactly one of these fields must be set.
     */
    @JsonProperty("clusterTrustBundle")
    public ClusterTrustBundleProjection getClusterTrustBundle() {
        return clusterTrustBundle;
    }

    /**
     * Projection that may be projected along with other supported volume types. Exactly one of these fields must be set.
     */
    @JsonProperty("clusterTrustBundle")
    public void setClusterTrustBundle(ClusterTrustBundleProjection clusterTrustBundle) {
        this.clusterTrustBundle = clusterTrustBundle;
    }

    /**
     * Projection that may be projected along with other supported volume types. Exactly one of these fields must be set.
     */
    @JsonProperty("configMap")
    public ConfigMapProjection getConfigMap() {
        return configMap;
    }

    /**
     * Projection that may be projected along with other supported volume types. Exactly one of these fields must be set.
     */
    @JsonProperty("configMap")
    public void setConfigMap(ConfigMapProjection configMap) {
        this.configMap = configMap;
    }

    /**
     * Projection that may be projected along with other supported volume types. Exactly one of these fields must be set.
     */
    @JsonProperty("downwardAPI")
    public DownwardAPIProjection getDownwardAPI() {
        return downwardAPI;
    }

    /**
     * Projection that may be projected along with other supported volume types. Exactly one of these fields must be set.
     */
    @JsonProperty("downwardAPI")
    public void setDownwardAPI(DownwardAPIProjection downwardAPI) {
        this.downwardAPI = downwardAPI;
    }

    /**
     * Projection that may be projected along with other supported volume types. Exactly one of these fields must be set.
     */
    @JsonProperty("podCertificate")
    public PodCertificateProjection getPodCertificate() {
        return podCertificate;
    }

    /**
     * Projection that may be projected along with other supported volume types. Exactly one of these fields must be set.
     */
    @JsonProperty("podCertificate")
    public void setPodCertificate(PodCertificateProjection podCertificate) {
        this.podCertificate = podCertificate;
    }

    /**
     * Projection that may be projected along with other supported volume types. Exactly one of these fields must be set.
     */
    @JsonProperty("secret")
    public SecretProjection getSecret() {
        return secret;
    }

    /**
     * Projection that may be projected along with other supported volume types. Exactly one of these fields must be set.
     */
    @JsonProperty("secret")
    public void setSecret(SecretProjection secret) {
        this.secret = secret;
    }

    /**
     * Projection that may be projected along with other supported volume types. Exactly one of these fields must be set.
     */
    @JsonProperty("serviceAccountToken")
    public ServiceAccountTokenProjection getServiceAccountToken() {
        return serviceAccountToken;
    }

    /**
     * Projection that may be projected along with other supported volume types. Exactly one of these fields must be set.
     */
    @JsonProperty("serviceAccountToken")
    public void setServiceAccountToken(ServiceAccountTokenProjection serviceAccountToken) {
        this.serviceAccountToken = serviceAccountToken;
    }

    @JsonIgnore
    public VolumeProjectionBuilder edit() {
        return new VolumeProjectionBuilder(this);
    }

    @JsonIgnore
    public VolumeProjectionBuilder toBuilder() {
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
        if (!(o instanceof VolumeProjection)) {
            return false;
        }
        VolumeProjection other = (VolumeProjection) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clusterTrustBundle = this.getClusterTrustBundle();
        Object other$clusterTrustBundle = other.getClusterTrustBundle();
        if (this$clusterTrustBundle == null ? other$clusterTrustBundle != null : !this$clusterTrustBundle.equals(other$clusterTrustBundle)) {
            return false;
        }
        Object this$configMap = this.getConfigMap();
        Object other$configMap = other.getConfigMap();
        if (this$configMap == null ? other$configMap != null : !this$configMap.equals(other$configMap)) {
            return false;
        }
        Object this$downwardAPI = this.getDownwardAPI();
        Object other$downwardAPI = other.getDownwardAPI();
        if (this$downwardAPI == null ? other$downwardAPI != null : !this$downwardAPI.equals(other$downwardAPI)) {
            return false;
        }
        Object this$podCertificate = this.getPodCertificate();
        Object other$podCertificate = other.getPodCertificate();
        if (this$podCertificate == null ? other$podCertificate != null : !this$podCertificate.equals(other$podCertificate)) {
            return false;
        }
        Object this$secret = this.getSecret();
        Object other$secret = other.getSecret();
        if (this$secret == null ? other$secret != null : !this$secret.equals(other$secret)) {
            return false;
        }
        Object this$serviceAccountToken = this.getServiceAccountToken();
        Object other$serviceAccountToken = other.getServiceAccountToken();
        if (this$serviceAccountToken == null ? other$serviceAccountToken != null : !this$serviceAccountToken.equals(other$serviceAccountToken)) {
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
        return other instanceof VolumeProjection;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clusterTrustBundle = this.getClusterTrustBundle();
        result = result * prime + ($clusterTrustBundle == null ? 43 : $clusterTrustBundle.hashCode());
        Object $configMap = this.getConfigMap();
        result = result * prime + ($configMap == null ? 43 : $configMap.hashCode());
        Object $downwardAPI = this.getDownwardAPI();
        result = result * prime + ($downwardAPI == null ? 43 : $downwardAPI.hashCode());
        Object $podCertificate = this.getPodCertificate();
        result = result * prime + ($podCertificate == null ? 43 : $podCertificate.hashCode());
        Object $secret = this.getSecret();
        result = result * prime + ($secret == null ? 43 : $secret.hashCode());
        Object $serviceAccountToken = this.getServiceAccountToken();
        result = result * prime + ($serviceAccountToken == null ? 43 : $serviceAccountToken.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VolumeProjection(" + "clusterTrustBundle=" + this.getClusterTrustBundle() + ", configMap=" + this.getConfigMap() + ", downwardAPI=" + this.getDownwardAPI() + ", podCertificate=" + this.getPodCertificate() + ", secret=" + this.getSecret() + ", serviceAccountToken=" + this.getServiceAccountToken() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
