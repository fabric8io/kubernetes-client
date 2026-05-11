
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.openshift.api.model.monitoring.v1.Sigv4;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * SNSConfig configures notifications via AWS SNS. See https://prometheus.io/docs/alerting/latest/configuration/#sns_configs
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SNSConfig implements Editable<SNSConfigBuilder>, KubernetesResource
{

    @JsonProperty("apiURL")
    private String apiURL;
    @JsonProperty("attributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> attributes = new LinkedHashMap<>();
    @JsonProperty("httpConfig")
    private HTTPConfig httpConfig;
    @JsonProperty("message")
    private String message;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("sendResolved")
    private Boolean sendResolved;
    @JsonProperty("sigv4")
    private Sigv4 sigv4;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("targetARN")
    private String targetARN;
    @JsonProperty("topicARN")
    private String topicARN;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SNSConfig() {
    }

    public SNSConfig(String apiURL, Map<String, String> attributes, HTTPConfig httpConfig, String message, String phoneNumber, Boolean sendResolved, Sigv4 sigv4, String subject, String targetARN, String topicARN) {
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

    /**
     * apiURL defines the SNS API URL, e.g. https://sns.us-east-2.amazonaws.com. If not specified, the SNS API URL from the SNS SDK will be used.
     */
    @JsonProperty("apiURL")
    public String getApiURL() {
        return apiURL;
    }

    /**
     * apiURL defines the SNS API URL, e.g. https://sns.us-east-2.amazonaws.com. If not specified, the SNS API URL from the SNS SDK will be used.
     */
    @JsonProperty("apiURL")
    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    /**
     * attributes defines SNS message attributes as key-value pairs. These provide additional metadata that can be used for message filtering and routing.
     */
    @JsonProperty("attributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAttributes() {
        return attributes;
    }

    /**
     * attributes defines SNS message attributes as key-value pairs. These provide additional metadata that can be used for message filtering and routing.
     */
    @JsonProperty("attributes")
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    /**
     * SNSConfig configures notifications via AWS SNS. See https://prometheus.io/docs/alerting/latest/configuration/#sns_configs
     */
    @JsonProperty("httpConfig")
    public HTTPConfig getHttpConfig() {
        return httpConfig;
    }

    /**
     * SNSConfig configures notifications via AWS SNS. See https://prometheus.io/docs/alerting/latest/configuration/#sns_configs
     */
    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    /**
     * message defines the message content of the SNS notification. This is the actual notification text that will be sent to subscribers.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * message defines the message content of the SNS notification. This is the actual notification text that will be sent to subscribers.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * phoneNumber defines the phone number if message is delivered via SMS in E.164 format. If you don't specify this value, you must specify a value for the TopicARN or TargetARN.
     */
    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * phoneNumber defines the phone number if message is delivered via SMS in E.164 format. If you don't specify this value, you must specify a value for the TopicARN or TargetARN.
     */
    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * sendResolved defines whether or not to notify about resolved alerts.
     */
    @JsonProperty("sendResolved")
    public Boolean getSendResolved() {
        return sendResolved;
    }

    /**
     * sendResolved defines whether or not to notify about resolved alerts.
     */
    @JsonProperty("sendResolved")
    public void setSendResolved(Boolean sendResolved) {
        this.sendResolved = sendResolved;
    }

    /**
     * SNSConfig configures notifications via AWS SNS. See https://prometheus.io/docs/alerting/latest/configuration/#sns_configs
     */
    @JsonProperty("sigv4")
    public Sigv4 getSigv4() {
        return sigv4;
    }

    /**
     * SNSConfig configures notifications via AWS SNS. See https://prometheus.io/docs/alerting/latest/configuration/#sns_configs
     */
    @JsonProperty("sigv4")
    public void setSigv4(Sigv4 sigv4) {
        this.sigv4 = sigv4;
    }

    /**
     * subject defines the subject line when the message is delivered to email endpoints. This field is only used when sending to email subscribers of an SNS topic.
     */
    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    /**
     * subject defines the subject line when the message is delivered to email endpoints. This field is only used when sending to email subscribers of an SNS topic.
     */
    @JsonProperty("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * targetARN defines the mobile platform endpoint ARN if message is delivered via mobile notifications. If you don't specify this value, you must specify a value for the TopicARN or PhoneNumber.
     */
    @JsonProperty("targetARN")
    public String getTargetARN() {
        return targetARN;
    }

    /**
     * targetARN defines the mobile platform endpoint ARN if message is delivered via mobile notifications. If you don't specify this value, you must specify a value for the TopicARN or PhoneNumber.
     */
    @JsonProperty("targetARN")
    public void setTargetARN(String targetARN) {
        this.targetARN = targetARN;
    }

    /**
     * topicARN defines the SNS topic ARN, e.g. arn:aws:sns:us-east-2:698519295917:My-Topic. If you don't specify this value, you must specify a value for the PhoneNumber or TargetARN.
     */
    @JsonProperty("topicARN")
    public String getTopicARN() {
        return topicARN;
    }

    /**
     * topicARN defines the SNS topic ARN, e.g. arn:aws:sns:us-east-2:698519295917:My-Topic. If you don't specify this value, you must specify a value for the PhoneNumber or TargetARN.
     */
    @JsonProperty("topicARN")
    public void setTopicARN(String topicARN) {
        this.topicARN = topicARN;
    }

    @JsonIgnore
    public SNSConfigBuilder edit() {
        return new SNSConfigBuilder(this);
    }

    @JsonIgnore
    public SNSConfigBuilder toBuilder() {
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
