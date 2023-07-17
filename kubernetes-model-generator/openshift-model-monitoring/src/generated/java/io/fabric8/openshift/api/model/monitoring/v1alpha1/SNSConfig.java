
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
import io.fabric8.openshift.api.model.monitoring.v1.Sigv4;
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
    "apiURL",
    "attributes",
    "httpConfig",
    "message",
    "phoneNumber",
    "sendResolved",
    "sigv4",
    "subject",
    "targetARN",
    "topicARN"
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
public class SNSConfig implements KubernetesResource
{

    @JsonProperty("apiURL")
    private java.lang.String apiURL;
    @JsonProperty("attributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> attributes = new LinkedHashMap<String, String>();
    @JsonProperty("httpConfig")
    private HTTPConfig httpConfig;
    @JsonProperty("message")
    private java.lang.String message;
    @JsonProperty("phoneNumber")
    private java.lang.String phoneNumber;
    @JsonProperty("sendResolved")
    private Boolean sendResolved;
    @JsonProperty("sigv4")
    private Sigv4 sigv4;
    @JsonProperty("subject")
    private java.lang.String subject;
    @JsonProperty("targetARN")
    private java.lang.String targetARN;
    @JsonProperty("topicARN")
    private java.lang.String topicARN;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SNSConfig() {
    }

    public SNSConfig(java.lang.String apiURL, Map<String, String> attributes, HTTPConfig httpConfig, java.lang.String message, java.lang.String phoneNumber, Boolean sendResolved, Sigv4 sigv4, java.lang.String subject, java.lang.String targetARN, java.lang.String topicARN) {
        super();
        this.apiURL = apiURL;
        this.attributes = attributes;
        this.httpConfig = httpConfig;
        this.message = message;
        this.phoneNumber = phoneNumber;
        this.sendResolved = sendResolved;
        this.sigv4 = sigv4;
        this.subject = subject;
        this.targetARN = targetARN;
        this.topicARN = topicARN;
    }

    @JsonProperty("apiURL")
    public java.lang.String getApiURL() {
        return apiURL;
    }

    @JsonProperty("apiURL")
    public void setApiURL(java.lang.String apiURL) {
        this.apiURL = apiURL;
    }

    @JsonProperty("attributes")
    public Map<String, String> getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
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
    public java.lang.String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(java.lang.String message) {
        this.message = message;
    }

    @JsonProperty("phoneNumber")
    public java.lang.String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(java.lang.String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("sendResolved")
    public Boolean getSendResolved() {
        return sendResolved;
    }

    @JsonProperty("sendResolved")
    public void setSendResolved(Boolean sendResolved) {
        this.sendResolved = sendResolved;
    }

    @JsonProperty("sigv4")
    public Sigv4 getSigv4() {
        return sigv4;
    }

    @JsonProperty("sigv4")
    public void setSigv4(Sigv4 sigv4) {
        this.sigv4 = sigv4;
    }

    @JsonProperty("subject")
    public java.lang.String getSubject() {
        return subject;
    }

    @JsonProperty("subject")
    public void setSubject(java.lang.String subject) {
        this.subject = subject;
    }

    @JsonProperty("targetARN")
    public java.lang.String getTargetARN() {
        return targetARN;
    }

    @JsonProperty("targetARN")
    public void setTargetARN(java.lang.String targetARN) {
        this.targetARN = targetARN;
    }

    @JsonProperty("topicARN")
    public java.lang.String getTopicARN() {
        return topicARN;
    }

    @JsonProperty("topicARN")
    public void setTopicARN(java.lang.String topicARN) {
        this.topicARN = topicARN;
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
