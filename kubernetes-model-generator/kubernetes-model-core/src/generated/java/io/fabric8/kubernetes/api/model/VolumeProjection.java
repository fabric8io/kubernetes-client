
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "configMap",
    "downwardAPI",
    "secret",
    "serviceAccountToken"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class VolumeProjection implements KubernetesResource
{

    @JsonProperty("configMap")
    private ConfigMapProjection configMap;
    @JsonProperty("downwardAPI")
    private DownwardAPIProjection downwardAPI;
    @JsonProperty("secret")
    private SecretProjection secret;
    @JsonProperty("serviceAccountToken")
    private ServiceAccountTokenProjection serviceAccountToken;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VolumeProjection() {
    }

    public VolumeProjection(ConfigMapProjection configMap, DownwardAPIProjection downwardAPI, SecretProjection secret, ServiceAccountTokenProjection serviceAccountToken) {
        super();
        this.configMap = configMap;
        this.downwardAPI = downwardAPI;
        this.secret = secret;
        this.serviceAccountToken = serviceAccountToken;
    }

    @JsonProperty("configMap")
    public ConfigMapProjection getConfigMap() {
        return configMap;
    }

    @JsonProperty("configMap")
    public void setConfigMap(ConfigMapProjection configMap) {
        this.configMap = configMap;
    }

    @JsonProperty("downwardAPI")
    public DownwardAPIProjection getDownwardAPI() {
        return downwardAPI;
    }

    @JsonProperty("downwardAPI")
    public void setDownwardAPI(DownwardAPIProjection downwardAPI) {
        this.downwardAPI = downwardAPI;
    }

    @JsonProperty("secret")
    public SecretProjection getSecret() {
        return secret;
    }

    @JsonProperty("secret")
    public void setSecret(SecretProjection secret) {
        this.secret = secret;
    }

    @JsonProperty("serviceAccountToken")
    public ServiceAccountTokenProjection getServiceAccountToken() {
        return serviceAccountToken;
    }

    @JsonProperty("serviceAccountToken")
    public void setServiceAccountToken(ServiceAccountTokenProjection serviceAccountToken) {
        this.serviceAccountToken = serviceAccountToken;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
