
package io.fabric8.openshift.api.model.config.v1;

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
    "ca",
    "challengeURL",
    "clientCommonNames",
    "emailHeaders",
    "headers",
    "loginURL",
    "nameHeaders",
    "preferredUsernameHeaders"
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
public class OAuthSpecIPRequestHeader implements Editable<OAuthSpecIPRequestHeaderBuilder> , KubernetesResource
{

    @JsonProperty("ca")
    private OAuthSpecIPRHCa ca;
    @JsonProperty("challengeURL")
    private String challengeURL;
    @JsonProperty("clientCommonNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> clientCommonNames = new ArrayList<>();
    @JsonProperty("emailHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> emailHeaders = new ArrayList<>();
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> headers = new ArrayList<>();
    @JsonProperty("loginURL")
    private String loginURL;
    @JsonProperty("nameHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> nameHeaders = new ArrayList<>();
    @JsonProperty("preferredUsernameHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> preferredUsernameHeaders = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public OAuthSpecIPRequestHeader() {
    }

    public OAuthSpecIPRequestHeader(OAuthSpecIPRHCa ca, String challengeURL, List<String> clientCommonNames, List<String> emailHeaders, List<String> headers, String loginURL, List<String> nameHeaders, List<String> preferredUsernameHeaders) {
        super();
        this.ca = ca;
        this.challengeURL = challengeURL;
        this.clientCommonNames = clientCommonNames;
        this.emailHeaders = emailHeaders;
        this.headers = headers;
        this.loginURL = loginURL;
        this.nameHeaders = nameHeaders;
        this.preferredUsernameHeaders = preferredUsernameHeaders;
    }

    @JsonProperty("ca")
    public OAuthSpecIPRHCa getCa() {
        return ca;
    }

    @JsonProperty("ca")
    public void setCa(OAuthSpecIPRHCa ca) {
        this.ca = ca;
    }

    @JsonProperty("challengeURL")
    public String getChallengeURL() {
        return challengeURL;
    }

    @JsonProperty("challengeURL")
    public void setChallengeURL(String challengeURL) {
        this.challengeURL = challengeURL;
    }

    @JsonProperty("clientCommonNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getClientCommonNames() {
        return clientCommonNames;
    }

    @JsonProperty("clientCommonNames")
    public void setClientCommonNames(List<String> clientCommonNames) {
        this.clientCommonNames = clientCommonNames;
    }

    @JsonProperty("emailHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEmailHeaders() {
        return emailHeaders;
    }

    @JsonProperty("emailHeaders")
    public void setEmailHeaders(List<String> emailHeaders) {
        this.emailHeaders = emailHeaders;
    }

    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getHeaders() {
        return headers;
    }

    @JsonProperty("headers")
    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    @JsonProperty("loginURL")
    public String getLoginURL() {
        return loginURL;
    }

    @JsonProperty("loginURL")
    public void setLoginURL(String loginURL) {
        this.loginURL = loginURL;
    }

    @JsonProperty("nameHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNameHeaders() {
        return nameHeaders;
    }

    @JsonProperty("nameHeaders")
    public void setNameHeaders(List<String> nameHeaders) {
        this.nameHeaders = nameHeaders;
    }

    @JsonProperty("preferredUsernameHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPreferredUsernameHeaders() {
        return preferredUsernameHeaders;
    }

    @JsonProperty("preferredUsernameHeaders")
    public void setPreferredUsernameHeaders(List<String> preferredUsernameHeaders) {
        this.preferredUsernameHeaders = preferredUsernameHeaders;
    }

    @JsonIgnore
    public OAuthSpecIPRequestHeaderBuilder edit() {
        return new OAuthSpecIPRequestHeaderBuilder(this);
    }

    @JsonIgnore
    public OAuthSpecIPRequestHeaderBuilder toBuilder() {
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
