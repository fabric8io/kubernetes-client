
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
    "authIdentity",
    "authPassword",
    "authSecret",
    "authUsername",
    "from",
    "headers",
    "hello",
    "html",
    "requireTLS",
    "sendResolved",
    "smarthost",
    "text",
    "tlsConfig",
    "to"
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
public class AlertmanagerConfigSpecREmailConfigs implements Editable<AlertmanagerConfigSpecREmailConfigsBuilder> , KubernetesResource
{

    @JsonProperty("authIdentity")
    private String authIdentity;
    @JsonProperty("authPassword")
    private AlertmanagerConfigSpecRECAuthPassword authPassword;
    @JsonProperty("authSecret")
    private AlertmanagerConfigSpecRECAuthSecret authSecret;
    @JsonProperty("authUsername")
    private String authUsername;
    @JsonProperty("from")
    private String from;
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerConfigSpecRECHeaders> headers = new ArrayList<>();
    @JsonProperty("hello")
    private String hello;
    @JsonProperty("html")
    private String html;
    @JsonProperty("requireTLS")
    private Boolean requireTLS;
    @JsonProperty("sendResolved")
    private Boolean sendResolved;
    @JsonProperty("smarthost")
    private String smarthost;
    @JsonProperty("text")
    private String text;
    @JsonProperty("tlsConfig")
    private AlertmanagerConfigSpecRECTlsConfig tlsConfig;
    @JsonProperty("to")
    private String to;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlertmanagerConfigSpecREmailConfigs() {
    }

    public AlertmanagerConfigSpecREmailConfigs(String authIdentity, AlertmanagerConfigSpecRECAuthPassword authPassword, AlertmanagerConfigSpecRECAuthSecret authSecret, String authUsername, String from, List<AlertmanagerConfigSpecRECHeaders> headers, String hello, String html, Boolean requireTLS, Boolean sendResolved, String smarthost, String text, AlertmanagerConfigSpecRECTlsConfig tlsConfig, String to) {
        super();
        this.authIdentity = authIdentity;
        this.authPassword = authPassword;
        this.authSecret = authSecret;
        this.authUsername = authUsername;
        this.from = from;
        this.headers = headers;
        this.hello = hello;
        this.html = html;
        this.requireTLS = requireTLS;
        this.sendResolved = sendResolved;
        this.smarthost = smarthost;
        this.text = text;
        this.tlsConfig = tlsConfig;
        this.to = to;
    }

    @JsonProperty("authIdentity")
    public String getAuthIdentity() {
        return authIdentity;
    }

    @JsonProperty("authIdentity")
    public void setAuthIdentity(String authIdentity) {
        this.authIdentity = authIdentity;
    }

    @JsonProperty("authPassword")
    public AlertmanagerConfigSpecRECAuthPassword getAuthPassword() {
        return authPassword;
    }

    @JsonProperty("authPassword")
    public void setAuthPassword(AlertmanagerConfigSpecRECAuthPassword authPassword) {
        this.authPassword = authPassword;
    }

    @JsonProperty("authSecret")
    public AlertmanagerConfigSpecRECAuthSecret getAuthSecret() {
        return authSecret;
    }

    @JsonProperty("authSecret")
    public void setAuthSecret(AlertmanagerConfigSpecRECAuthSecret authSecret) {
        this.authSecret = authSecret;
    }

    @JsonProperty("authUsername")
    public String getAuthUsername() {
        return authUsername;
    }

    @JsonProperty("authUsername")
    public void setAuthUsername(String authUsername) {
        this.authUsername = authUsername;
    }

    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(String from) {
        this.from = from;
    }

    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerConfigSpecRECHeaders> getHeaders() {
        return headers;
    }

    @JsonProperty("headers")
    public void setHeaders(List<AlertmanagerConfigSpecRECHeaders> headers) {
        this.headers = headers;
    }

    @JsonProperty("hello")
    public String getHello() {
        return hello;
    }

    @JsonProperty("hello")
    public void setHello(String hello) {
        this.hello = hello;
    }

    @JsonProperty("html")
    public String getHtml() {
        return html;
    }

    @JsonProperty("html")
    public void setHtml(String html) {
        this.html = html;
    }

    @JsonProperty("requireTLS")
    public Boolean getRequireTLS() {
        return requireTLS;
    }

    @JsonProperty("requireTLS")
    public void setRequireTLS(Boolean requireTLS) {
        this.requireTLS = requireTLS;
    }

    @JsonProperty("sendResolved")
    public Boolean getSendResolved() {
        return sendResolved;
    }

    @JsonProperty("sendResolved")
    public void setSendResolved(Boolean sendResolved) {
        this.sendResolved = sendResolved;
    }

    @JsonProperty("smarthost")
    public String getSmarthost() {
        return smarthost;
    }

    @JsonProperty("smarthost")
    public void setSmarthost(String smarthost) {
        this.smarthost = smarthost;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("tlsConfig")
    public AlertmanagerConfigSpecRECTlsConfig getTlsConfig() {
        return tlsConfig;
    }

    @JsonProperty("tlsConfig")
    public void setTlsConfig(AlertmanagerConfigSpecRECTlsConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonProperty("to")
    public String getTo() {
        return to;
    }

    @JsonProperty("to")
    public void setTo(String to) {
        this.to = to;
    }

    @JsonIgnore
    public AlertmanagerConfigSpecREmailConfigsBuilder edit() {
        return new AlertmanagerConfigSpecREmailConfigsBuilder(this);
    }

    @JsonIgnore
    public AlertmanagerConfigSpecREmailConfigsBuilder toBuilder() {
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
