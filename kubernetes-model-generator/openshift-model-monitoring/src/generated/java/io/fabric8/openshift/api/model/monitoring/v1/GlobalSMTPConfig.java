
package io.fabric8.openshift.api.model.monitoring.v1;

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
    "authIdentity",
    "authPassword",
    "authSecret",
    "authUsername",
    "from",
    "hello",
    "requireTLS",
    "smartHost"
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
public class GlobalSMTPConfig implements Editable<GlobalSMTPConfigBuilder> , KubernetesResource
{

    @JsonProperty("authIdentity")
    private String authIdentity;
    @JsonProperty("authPassword")
    private SecretKeySelector authPassword;
    @JsonProperty("authSecret")
    private SecretKeySelector authSecret;
    @JsonProperty("authUsername")
    private String authUsername;
    @JsonProperty("from")
    private String from;
    @JsonProperty("hello")
    private String hello;
    @JsonProperty("requireTLS")
    private Boolean requireTLS;
    @JsonProperty("smartHost")
    private HostPort smartHost;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GlobalSMTPConfig() {
    }

    public GlobalSMTPConfig(String authIdentity, SecretKeySelector authPassword, SecretKeySelector authSecret, String authUsername, String from, String hello, Boolean requireTLS, HostPort smartHost) {
        super();
        this.authIdentity = authIdentity;
        this.authPassword = authPassword;
        this.authSecret = authSecret;
        this.authUsername = authUsername;
        this.from = from;
        this.hello = hello;
        this.requireTLS = requireTLS;
        this.smartHost = smartHost;
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
    public SecretKeySelector getAuthPassword() {
        return authPassword;
    }

    @JsonProperty("authPassword")
    public void setAuthPassword(SecretKeySelector authPassword) {
        this.authPassword = authPassword;
    }

    @JsonProperty("authSecret")
    public SecretKeySelector getAuthSecret() {
        return authSecret;
    }

    @JsonProperty("authSecret")
    public void setAuthSecret(SecretKeySelector authSecret) {
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

    @JsonProperty("hello")
    public String getHello() {
        return hello;
    }

    @JsonProperty("hello")
    public void setHello(String hello) {
        this.hello = hello;
    }

    @JsonProperty("requireTLS")
    public Boolean getRequireTLS() {
        return requireTLS;
    }

    @JsonProperty("requireTLS")
    public void setRequireTLS(Boolean requireTLS) {
        this.requireTLS = requireTLS;
    }

    @JsonProperty("smartHost")
    public HostPort getSmartHost() {
        return smartHost;
    }

    @JsonProperty("smartHost")
    public void setSmartHost(HostPort smartHost) {
        this.smartHost = smartHost;
    }

    @JsonIgnore
    public GlobalSMTPConfigBuilder edit() {
        return new GlobalSMTPConfigBuilder(this);
    }

    @JsonIgnore
    public GlobalSMTPConfigBuilder toBuilder() {
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

}
