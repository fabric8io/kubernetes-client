
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
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
    "clientId",
    "clientSecret",
    "endpointParams",
    "scopes",
    "tokenUrl"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class OAuth2 implements KubernetesResource
{

    @JsonProperty("clientId")
    private SecretOrConfigMap clientId;
    @JsonProperty("clientSecret")
    private SecretKeySelector clientSecret;
    @JsonProperty("endpointParams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> endpointParams = new LinkedHashMap<String, String>();
    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> scopes = new ArrayList<java.lang.String>();
    @JsonProperty("tokenUrl")
    private java.lang.String tokenUrl;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public OAuth2() {
    }

    public OAuth2(SecretOrConfigMap clientId, SecretKeySelector clientSecret, Map<String, String> endpointParams, List<java.lang.String> scopes, java.lang.String tokenUrl) {
        super();
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.endpointParams = endpointParams;
        this.scopes = scopes;
        this.tokenUrl = tokenUrl;
    }

    @JsonProperty("clientId")
    public SecretOrConfigMap getClientId() {
        return clientId;
    }

    @JsonProperty("clientId")
    public void setClientId(SecretOrConfigMap clientId) {
        this.clientId = clientId;
    }

    @JsonProperty("clientSecret")
    public SecretKeySelector getClientSecret() {
        return clientSecret;
    }

    @JsonProperty("clientSecret")
    public void setClientSecret(SecretKeySelector clientSecret) {
        this.clientSecret = clientSecret;
    }

    @JsonProperty("endpointParams")
    public Map<String, String> getEndpointParams() {
        return endpointParams;
    }

    @JsonProperty("endpointParams")
    public void setEndpointParams(Map<String, String> endpointParams) {
        this.endpointParams = endpointParams;
    }

    @JsonProperty("scopes")
    public List<java.lang.String> getScopes() {
        return scopes;
    }

    @JsonProperty("scopes")
    public void setScopes(List<java.lang.String> scopes) {
        this.scopes = scopes;
    }

    @JsonProperty("tokenUrl")
    public java.lang.String getTokenUrl() {
        return tokenUrl;
    }

    @JsonProperty("tokenUrl")
    public void setTokenUrl(java.lang.String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
