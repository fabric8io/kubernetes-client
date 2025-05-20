
package io.fabric8.openshift.api.model.config.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * RequestHeaderIdentityProvider provides identities for users authenticating using request header credentials
 */
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class RequestHeaderIdentityProvider implements Editable<RequestHeaderIdentityProviderBuilder>, KubernetesResource
{

    @JsonProperty("ca")
    private ConfigMapNameReference ca;
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
     */
    public RequestHeaderIdentityProvider() {
    }

    public RequestHeaderIdentityProvider(ConfigMapNameReference ca, String challengeURL, List<String> clientCommonNames, List<String> emailHeaders, List<String> headers, String loginURL, List<String> nameHeaders, List<String> preferredUsernameHeaders) {
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

    /**
     * RequestHeaderIdentityProvider provides identities for users authenticating using request header credentials
     */
    @JsonProperty("ca")
    public ConfigMapNameReference getCa() {
        return ca;
    }

    /**
     * RequestHeaderIdentityProvider provides identities for users authenticating using request header credentials
     */
    @JsonProperty("ca")
    public void setCa(ConfigMapNameReference ca) {
        this.ca = ca;
    }

    /**
     * challengeURL is a URL to redirect unauthenticated /authorize requests to Unauthenticated requests from OAuth clients which expect WWW-Authenticate challenges will be redirected here. ${url} is replaced with the current URL, escaped to be safe in a query parameter<br><p>   https://www.example.com/sso-login?then=${url}<br><p> ${query} is replaced with the current query string<br><p>   https://www.example.com/auth-proxy/oauth/authorize?${query}<br><p> Required when challenge is set to true.
     */
    @JsonProperty("challengeURL")
    public String getChallengeURL() {
        return challengeURL;
    }

    /**
     * challengeURL is a URL to redirect unauthenticated /authorize requests to Unauthenticated requests from OAuth clients which expect WWW-Authenticate challenges will be redirected here. ${url} is replaced with the current URL, escaped to be safe in a query parameter<br><p>   https://www.example.com/sso-login?then=${url}<br><p> ${query} is replaced with the current query string<br><p>   https://www.example.com/auth-proxy/oauth/authorize?${query}<br><p> Required when challenge is set to true.
     */
    @JsonProperty("challengeURL")
    public void setChallengeURL(String challengeURL) {
        this.challengeURL = challengeURL;
    }

    /**
     * clientCommonNames is an optional list of common names to require a match from. If empty, any client certificate validated against the clientCA bundle is considered authoritative.
     */
    @JsonProperty("clientCommonNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getClientCommonNames() {
        return clientCommonNames;
    }

    /**
     * clientCommonNames is an optional list of common names to require a match from. If empty, any client certificate validated against the clientCA bundle is considered authoritative.
     */
    @JsonProperty("clientCommonNames")
    public void setClientCommonNames(List<String> clientCommonNames) {
        this.clientCommonNames = clientCommonNames;
    }

    /**
     * emailHeaders is the set of headers to check for the email address
     */
    @JsonProperty("emailHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEmailHeaders() {
        return emailHeaders;
    }

    /**
     * emailHeaders is the set of headers to check for the email address
     */
    @JsonProperty("emailHeaders")
    public void setEmailHeaders(List<String> emailHeaders) {
        this.emailHeaders = emailHeaders;
    }

    /**
     * headers is the set of headers to check for identity information
     */
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getHeaders() {
        return headers;
    }

    /**
     * headers is the set of headers to check for identity information
     */
    @JsonProperty("headers")
    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    /**
     * loginURL is a URL to redirect unauthenticated /authorize requests to Unauthenticated requests from OAuth clients which expect interactive logins will be redirected here ${url} is replaced with the current URL, escaped to be safe in a query parameter<br><p>   https://www.example.com/sso-login?then=${url}<br><p> ${query} is replaced with the current query string<br><p>   https://www.example.com/auth-proxy/oauth/authorize?${query}<br><p> Required when login is set to true.
     */
    @JsonProperty("loginURL")
    public String getLoginURL() {
        return loginURL;
    }

    /**
     * loginURL is a URL to redirect unauthenticated /authorize requests to Unauthenticated requests from OAuth clients which expect interactive logins will be redirected here ${url} is replaced with the current URL, escaped to be safe in a query parameter<br><p>   https://www.example.com/sso-login?then=${url}<br><p> ${query} is replaced with the current query string<br><p>   https://www.example.com/auth-proxy/oauth/authorize?${query}<br><p> Required when login is set to true.
     */
    @JsonProperty("loginURL")
    public void setLoginURL(String loginURL) {
        this.loginURL = loginURL;
    }

    /**
     * nameHeaders is the set of headers to check for the display name
     */
    @JsonProperty("nameHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNameHeaders() {
        return nameHeaders;
    }

    /**
     * nameHeaders is the set of headers to check for the display name
     */
    @JsonProperty("nameHeaders")
    public void setNameHeaders(List<String> nameHeaders) {
        this.nameHeaders = nameHeaders;
    }

    /**
     * preferredUsernameHeaders is the set of headers to check for the preferred username
     */
    @JsonProperty("preferredUsernameHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPreferredUsernameHeaders() {
        return preferredUsernameHeaders;
    }

    /**
     * preferredUsernameHeaders is the set of headers to check for the preferred username
     */
    @JsonProperty("preferredUsernameHeaders")
    public void setPreferredUsernameHeaders(List<String> preferredUsernameHeaders) {
        this.preferredUsernameHeaders = preferredUsernameHeaders;
    }

    @JsonIgnore
    public RequestHeaderIdentityProviderBuilder edit() {
        return new RequestHeaderIdentityProviderBuilder(this);
    }

    @JsonIgnore
    public RequestHeaderIdentityProviderBuilder toBuilder() {
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
