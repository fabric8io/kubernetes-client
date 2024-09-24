
package io.fabric8.openshift.api.model.monitoring.v1beta1;

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
import io.fabric8.kubernetes.api.builder.Editable;
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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clientId",
    "clientSecret",
    "endpointParams",
    "scopes",
    "tokenUrl"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class AlertmanagerConfigSpecRSCHCOauth2 implements Editable<AlertmanagerConfigSpecRSCHCOauth2Builder> , KubernetesResource
{

    @JsonProperty("clientId")
    private AlertmanagerConfigSpecRSCHCOClientId clientId;
    @JsonProperty("clientSecret")
    private AlertmanagerConfigSpecRSCHCOClientSecret clientSecret;
    @JsonProperty("endpointParams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> endpointParams = new LinkedHashMap<>();
    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> scopes = new ArrayList<>();
    @JsonProperty("tokenUrl")
    private String tokenUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlertmanagerConfigSpecRSCHCOauth2() {
    }

    public AlertmanagerConfigSpecRSCHCOauth2(AlertmanagerConfigSpecRSCHCOClientId clientId, AlertmanagerConfigSpecRSCHCOClientSecret clientSecret, Map<String, String> endpointParams, List<String> scopes, String tokenUrl) {
        super();
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.endpointParams = endpointParams;
        this.scopes = scopes;
        this.tokenUrl = tokenUrl;
    }

    @JsonProperty("clientId")
    public AlertmanagerConfigSpecRSCHCOClientId getClientId() {
        return clientId;
    }

    @JsonProperty("clientId")
    public void setClientId(AlertmanagerConfigSpecRSCHCOClientId clientId) {
        this.clientId = clientId;
    }

    @JsonProperty("clientSecret")
    public AlertmanagerConfigSpecRSCHCOClientSecret getClientSecret() {
        return clientSecret;
    }

    @JsonProperty("clientSecret")
    public void setClientSecret(AlertmanagerConfigSpecRSCHCOClientSecret clientSecret) {
        this.clientSecret = clientSecret;
    }

    @JsonProperty("endpointParams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getEndpointParams() {
        return endpointParams;
    }

    @JsonProperty("endpointParams")
    public void setEndpointParams(Map<String, String> endpointParams) {
        this.endpointParams = endpointParams;
    }

    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getScopes() {
        return scopes;
    }

    @JsonProperty("scopes")
    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    @JsonProperty("tokenUrl")
    public String getTokenUrl() {
        return tokenUrl;
    }

    @JsonProperty("tokenUrl")
    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    @JsonIgnore
    public AlertmanagerConfigSpecRSCHCOauth2Builder edit() {
        return new AlertmanagerConfigSpecRSCHCOauth2Builder(this);
    }

    @JsonIgnore
    public AlertmanagerConfigSpecRSCHCOauth2Builder toBuilder() {
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
