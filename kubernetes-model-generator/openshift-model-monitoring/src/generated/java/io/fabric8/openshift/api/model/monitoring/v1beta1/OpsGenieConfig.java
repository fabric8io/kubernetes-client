
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
     * actions defines a comma separated list of actions that will be available for the alert. These appear as action buttons in the OpsGenie interface.
     */
    @JsonProperty("actions")
    public String getActions() {
        return actions;
    }

    /**
     * actions defines a comma separated list of actions that will be available for the alert. These appear as action buttons in the OpsGenie interface.
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
     * apiURL defines the URL to send OpsGenie API requests to. When not specified, defaults to the standard OpsGenie API endpoint.
     */
    @JsonProperty("apiURL")
    public String getApiURL() {
        return apiURL;
    }

    /**
     * apiURL defines the URL to send OpsGenie API requests to. When not specified, defaults to the standard OpsGenie API endpoint.
     */
    @JsonProperty("apiURL")
    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    /**
     * description defines the detailed description of the incident. This provides additional context beyond the message field.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * description defines the detailed description of the incident. This provides additional context beyond the message field.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * details defines a set of arbitrary key/value pairs that provide further detail about the incident. These appear as additional fields in the OpsGenie alert.
     */
    @JsonProperty("details")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<KeyValue> getDetails() {
        return details;
    }

    /**
     * details defines a set of arbitrary key/value pairs that provide further detail about the incident. These appear as additional fields in the OpsGenie alert.
     */
    @JsonProperty("details")
    public void setDetails(List<KeyValue> details) {
        this.details = details;
    }

    /**
     * entity defines an optional field that can be used to specify which domain alert is related to. This helps group related alerts together in OpsGenie.
     */
    @JsonProperty("entity")
    public String getEntity() {
        return entity;
    }

    /**
     * entity defines an optional field that can be used to specify which domain alert is related to. This helps group related alerts together in OpsGenie.
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
     * message defines the alert text limited to 130 characters. This appears as the main alert title in OpsGenie.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * message defines the alert text limited to 130 characters. This appears as the main alert title in OpsGenie.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * note defines an additional alert note. This provides supplementary information about the alert.
     */
    @JsonProperty("note")
    public String getNote() {
        return note;
    }

    /**
     * note defines an additional alert note. This provides supplementary information about the alert.
     */
    @JsonProperty("note")
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * priority defines the priority level of alert. Possible values are P1, P2, P3, P4, and P5, where P1 is highest priority.
     */
    @JsonProperty("priority")
    public String getPriority() {
        return priority;
    }

    /**
     * priority defines the priority level of alert. Possible values are P1, P2, P3, P4, and P5, where P1 is highest priority.
     */
    @JsonProperty("priority")
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * responders defines the list of responders responsible for notifications. These determine who gets notified when the alert is created.
     */
    @JsonProperty("responders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OpsGenieConfigResponder> getResponders() {
        return responders;
    }

    /**
     * responders defines the list of responders responsible for notifications. These determine who gets notified when the alert is created.
     */
    @JsonProperty("responders")
    public void setResponders(List<OpsGenieConfigResponder> responders) {
        this.responders = responders;
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
     * source defines the backlink to the sender of the notification. This helps identify where the alert originated from.
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * source defines the backlink to the sender of the notification. This helps identify where the alert originated from.
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * tags defines a comma separated list of tags attached to the notifications. These help categorize and filter alerts within OpsGenie.
     */
    @JsonProperty("tags")
    public String getTags() {
        return tags;
    }

    /**
     * tags defines a comma separated list of tags attached to the notifications. These help categorize and filter alerts within OpsGenie.
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof OpsGenieConfig)) {
            return false;
        }
        OpsGenieConfig other = (OpsGenieConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$actions = this.getActions();
        Object other$actions = other.getActions();
        if (this$actions == null ? other$actions != null : !this$actions.equals(other$actions)) {
            return false;
        }
        Object this$apiKey = this.getApiKey();
        Object other$apiKey = other.getApiKey();
        if (this$apiKey == null ? other$apiKey != null : !this$apiKey.equals(other$apiKey)) {
            return false;
        }
        Object this$apiURL = this.getApiURL();
        Object other$apiURL = other.getApiURL();
        if (this$apiURL == null ? other$apiURL != null : !this$apiURL.equals(other$apiURL)) {
            return false;
        }
        Object this$description = this.getDescription();
        Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        Object this$details = this.getDetails();
        Object other$details = other.getDetails();
        if (this$details == null ? other$details != null : !this$details.equals(other$details)) {
            return false;
        }
        Object this$entity = this.getEntity();
        Object other$entity = other.getEntity();
        if (this$entity == null ? other$entity != null : !this$entity.equals(other$entity)) {
            return false;
        }
        Object this$httpConfig = this.getHttpConfig();
        Object other$httpConfig = other.getHttpConfig();
        if (this$httpConfig == null ? other$httpConfig != null : !this$httpConfig.equals(other$httpConfig)) {
            return false;
        }
        Object this$message = this.getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {
            return false;
        }
        Object this$note = this.getNote();
        Object other$note = other.getNote();
        if (this$note == null ? other$note != null : !this$note.equals(other$note)) {
            return false;
        }
        Object this$priority = this.getPriority();
        Object other$priority = other.getPriority();
        if (this$priority == null ? other$priority != null : !this$priority.equals(other$priority)) {
            return false;
        }
        Object this$responders = this.getResponders();
        Object other$responders = other.getResponders();
        if (this$responders == null ? other$responders != null : !this$responders.equals(other$responders)) {
            return false;
        }
        Object this$sendResolved = this.getSendResolved();
        Object other$sendResolved = other.getSendResolved();
        if (this$sendResolved == null ? other$sendResolved != null : !this$sendResolved.equals(other$sendResolved)) {
            return false;
        }
        Object this$source = this.getSource();
        Object other$source = other.getSource();
        if (this$source == null ? other$source != null : !this$source.equals(other$source)) {
            return false;
        }
        Object this$tags = this.getTags();
        Object other$tags = other.getTags();
        if (this$tags == null ? other$tags != null : !this$tags.equals(other$tags)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof OpsGenieConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $actions = this.getActions();
        result = result * prime + ($actions == null ? 43 : $actions.hashCode());
        Object $apiKey = this.getApiKey();
        result = result * prime + ($apiKey == null ? 43 : $apiKey.hashCode());
        Object $apiURL = this.getApiURL();
        result = result * prime + ($apiURL == null ? 43 : $apiURL.hashCode());
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $details = this.getDetails();
        result = result * prime + ($details == null ? 43 : $details.hashCode());
        Object $entity = this.getEntity();
        result = result * prime + ($entity == null ? 43 : $entity.hashCode());
        Object $httpConfig = this.getHttpConfig();
        result = result * prime + ($httpConfig == null ? 43 : $httpConfig.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $note = this.getNote();
        result = result * prime + ($note == null ? 43 : $note.hashCode());
        Object $priority = this.getPriority();
        result = result * prime + ($priority == null ? 43 : $priority.hashCode());
        Object $responders = this.getResponders();
        result = result * prime + ($responders == null ? 43 : $responders.hashCode());
        Object $sendResolved = this.getSendResolved();
        result = result * prime + ($sendResolved == null ? 43 : $sendResolved.hashCode());
        Object $source = this.getSource();
        result = result * prime + ($source == null ? 43 : $source.hashCode());
        Object $tags = this.getTags();
        result = result * prime + ($tags == null ? 43 : $tags.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OpsGenieConfig(" + "actions=" + this.getActions() + ", apiKey=" + this.getApiKey() + ", apiURL=" + this.getApiURL() + ", description=" + this.getDescription() + ", details=" + this.getDetails() + ", entity=" + this.getEntity() + ", httpConfig=" + this.getHttpConfig() + ", message=" + this.getMessage() + ", note=" + this.getNote() + ", priority=" + this.getPriority() + ", responders=" + this.getResponders() + ", sendResolved=" + this.getSendResolved() + ", source=" + this.getSource() + ", tags=" + this.getTags() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
