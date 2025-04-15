
package io.fabric8.openshift.api.model.monitoring.v1beta1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
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
 * OpsGenieConfig configures notifications via OpsGenie. See https://prometheus.io/docs/alerting/latest/configuration/#opsgenie_config
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "actions",
    "apiKey",
    "apiURL",
    "description",
    "details",
    "entity",
    "httpConfig",
    "message",
    "note",
    "priority",
    "responders",
    "sendResolved",
    "source",
    "tags"
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
public class OpsGenieConfig implements Editable<OpsGenieConfigBuilder>, KubernetesResource
{

    @JsonProperty("actions")
    private String actions;
    @JsonProperty("apiKey")
    private SecretKeySelector apiKey;
    @JsonProperty("apiURL")
    private String apiURL;
    @JsonProperty("description")
    private String description;
    @JsonProperty("details")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<KeyValue> details = new ArrayList<>();
    @JsonProperty("entity")
    private String entity;
    @JsonProperty("httpConfig")
    private HTTPConfig httpConfig;
    @JsonProperty("message")
    private String message;
    @JsonProperty("note")
    private String note;
    @JsonProperty("priority")
    private String priority;
    @JsonProperty("responders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OpsGenieConfigResponder> responders = new ArrayList<>();
    @JsonProperty("sendResolved")
    private Boolean sendResolved;
    @JsonProperty("source")
    private String source;
    @JsonProperty("tags")
    private String tags;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OpsGenieConfig() {
    }

    public OpsGenieConfig(String actions, SecretKeySelector apiKey, String apiURL, String description, List<KeyValue> details, String entity, HTTPConfig httpConfig, String message, String note, String priority, List<OpsGenieConfigResponder> responders, Boolean sendResolved, String source, String tags) {
        super();
        this.actions = actions;
        this.apiKey = apiKey;
        this.apiURL = apiURL;
        this.description = description;
        this.details = details;
        this.entity = entity;
        this.httpConfig = httpConfig;
        this.message = message;
        this.note = note;
        this.priority = priority;
        this.responders = responders;
        this.sendResolved = sendResolved;
        this.source = source;
        this.tags = tags;
    }

    /**
     * Comma separated list of actions that will be available for the alert.
     */
    @JsonProperty("actions")
    public String getActions() {
        return actions;
    }

    /**
     * Comma separated list of actions that will be available for the alert.
     */
    @JsonProperty("actions")
    public void setActions(String actions) {
        this.actions = actions;
    }

    /**
     * OpsGenieConfig configures notifications via OpsGenie. See https://prometheus.io/docs/alerting/latest/configuration/#opsgenie_config
     */
    @JsonProperty("apiKey")
    public SecretKeySelector getApiKey() {
        return apiKey;
    }

    /**
     * OpsGenieConfig configures notifications via OpsGenie. See https://prometheus.io/docs/alerting/latest/configuration/#opsgenie_config
     */
    @JsonProperty("apiKey")
    public void setApiKey(SecretKeySelector apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * The URL to send OpsGenie API requests to.
     */
    @JsonProperty("apiURL")
    public String getApiURL() {
        return apiURL;
    }

    /**
     * The URL to send OpsGenie API requests to.
     */
    @JsonProperty("apiURL")
    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    /**
     * Description of the incident.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Description of the incident.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * A set of arbitrary key/value pairs that provide further detail about the incident.
     */
    @JsonProperty("details")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<KeyValue> getDetails() {
        return details;
    }

    /**
     * A set of arbitrary key/value pairs that provide further detail about the incident.
     */
    @JsonProperty("details")
    public void setDetails(List<KeyValue> details) {
        this.details = details;
    }

    /**
     * Optional field that can be used to specify which domain alert is related to.
     */
    @JsonProperty("entity")
    public String getEntity() {
        return entity;
    }

    /**
     * Optional field that can be used to specify which domain alert is related to.
     */
    @JsonProperty("entity")
    public void setEntity(String entity) {
        this.entity = entity;
    }

    /**
     * OpsGenieConfig configures notifications via OpsGenie. See https://prometheus.io/docs/alerting/latest/configuration/#opsgenie_config
     */
    @JsonProperty("httpConfig")
    public HTTPConfig getHttpConfig() {
        return httpConfig;
    }

    /**
     * OpsGenieConfig configures notifications via OpsGenie. See https://prometheus.io/docs/alerting/latest/configuration/#opsgenie_config
     */
    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    /**
     * Alert text limited to 130 characters.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * Alert text limited to 130 characters.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Additional alert note.
     */
    @JsonProperty("note")
    public String getNote() {
        return note;
    }

    /**
     * Additional alert note.
     */
    @JsonProperty("note")
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Priority level of alert. Possible values are P1, P2, P3, P4, and P5.
     */
    @JsonProperty("priority")
    public String getPriority() {
        return priority;
    }

    /**
     * Priority level of alert. Possible values are P1, P2, P3, P4, and P5.
     */
    @JsonProperty("priority")
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * List of responders responsible for notifications.
     */
    @JsonProperty("responders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OpsGenieConfigResponder> getResponders() {
        return responders;
    }

    /**
     * List of responders responsible for notifications.
     */
    @JsonProperty("responders")
    public void setResponders(List<OpsGenieConfigResponder> responders) {
        this.responders = responders;
    }

    /**
     * Whether or not to notify about resolved alerts.
     */
    @JsonProperty("sendResolved")
    public Boolean getSendResolved() {
        return sendResolved;
    }

    /**
     * Whether or not to notify about resolved alerts.
     */
    @JsonProperty("sendResolved")
    public void setSendResolved(Boolean sendResolved) {
        this.sendResolved = sendResolved;
    }

    /**
     * Backlink to the sender of the notification.
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * Backlink to the sender of the notification.
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Comma separated list of tags attached to the notifications.
     */
    @JsonProperty("tags")
    public String getTags() {
        return tags;
    }

    /**
     * Comma separated list of tags attached to the notifications.
     */
    @JsonProperty("tags")
    public void setTags(String tags) {
        this.tags = tags;
    }

    @JsonIgnore
    public OpsGenieConfigBuilder edit() {
        return new OpsGenieConfigBuilder(this);
    }

    @JsonIgnore
    public OpsGenieConfigBuilder toBuilder() {
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
