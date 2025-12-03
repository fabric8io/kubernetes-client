
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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

}
