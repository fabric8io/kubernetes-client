
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
    "expire",
    "html",
    "httpConfig",
    "message",
    "priority",
    "retry",
    "sendResolved",
    "sound",
    "title",
    "token",
    "url",
    "urlTitle",
    "userKey"
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
public class PushoverConfig implements KubernetesResource
{

    @JsonProperty("expire")
    private String expire;
    @JsonProperty("html")
    private Boolean html;
    @JsonProperty("httpConfig")
    private HTTPConfig httpConfig;
    @JsonProperty("message")
    private String message;
    @JsonProperty("priority")
    private String priority;
    @JsonProperty("retry")
    private String retry;
    @JsonProperty("sendResolved")
    private Boolean sendResolved;
    @JsonProperty("sound")
    private String sound;
    @JsonProperty("title")
    private String title;
    @JsonProperty("token")
    private SecretKeySelector token;
    @JsonProperty("url")
    private String url;
    @JsonProperty("urlTitle")
    private String urlTitle;
    @JsonProperty("userKey")
    private SecretKeySelector userKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PushoverConfig() {
    }

    public PushoverConfig(String expire, Boolean html, HTTPConfig httpConfig, String message, String priority, String retry, Boolean sendResolved, String sound, String title, SecretKeySelector token, String url, String urlTitle, SecretKeySelector userKey) {
        super();
        this.expire = expire;
        this.html = html;
        this.httpConfig = httpConfig;
        this.message = message;
        this.priority = priority;
        this.retry = retry;
        this.sendResolved = sendResolved;
        this.sound = sound;
        this.title = title;
        this.token = token;
        this.url = url;
        this.urlTitle = urlTitle;
        this.userKey = userKey;
    }

    @JsonProperty("expire")
    public String getExpire() {
        return expire;
    }

    @JsonProperty("expire")
    public void setExpire(String expire) {
        this.expire = expire;
    }

    @JsonProperty("html")
    public Boolean getHtml() {
        return html;
    }

    @JsonProperty("html")
    public void setHtml(Boolean html) {
        this.html = html;
    }

    @JsonProperty("httpConfig")
    public HTTPConfig getHttpConfig() {
        return httpConfig;
    }

    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("priority")
    public String getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(String priority) {
        this.priority = priority;
    }

    @JsonProperty("retry")
    public String getRetry() {
        return retry;
    }

    @JsonProperty("retry")
    public void setRetry(String retry) {
        this.retry = retry;
    }

    @JsonProperty("sendResolved")
    public Boolean getSendResolved() {
        return sendResolved;
    }

    @JsonProperty("sendResolved")
    public void setSendResolved(Boolean sendResolved) {
        this.sendResolved = sendResolved;
    }

    @JsonProperty("sound")
    public String getSound() {
        return sound;
    }

    @JsonProperty("sound")
    public void setSound(String sound) {
        this.sound = sound;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("token")
    public SecretKeySelector getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(SecretKeySelector token) {
        this.token = token;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("urlTitle")
    public String getUrlTitle() {
        return urlTitle;
    }

    @JsonProperty("urlTitle")
    public void setUrlTitle(String urlTitle) {
        this.urlTitle = urlTitle;
    }

    @JsonProperty("userKey")
    public SecretKeySelector getUserKey() {
        return userKey;
    }

    @JsonProperty("userKey")
    public void setUserKey(SecretKeySelector userKey) {
        this.userKey = userKey;
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
