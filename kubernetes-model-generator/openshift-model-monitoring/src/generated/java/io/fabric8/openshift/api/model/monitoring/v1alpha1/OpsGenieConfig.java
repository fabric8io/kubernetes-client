
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "apiKey",
    "apiURL",
    "description",
    "details",
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
public class OpsGenieConfig implements KubernetesResource
{

    @JsonProperty("apiKey")
    private SecretKeySelector apiKey;
    @JsonProperty("apiURL")
    private String apiURL;
    @JsonProperty("description")
    private String description;
    @JsonProperty("details")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<KeyValue> details = new ArrayList<KeyValue>();
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
    private List<OpsGenieConfigResponder> responders = new ArrayList<OpsGenieConfigResponder>();
    @JsonProperty("sendResolved")
    private Boolean sendResolved;
    @JsonProperty("source")
    private String source;
    @JsonProperty("tags")
    private String tags;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpsGenieConfig() {
    }

    /**
     * 
     * @param note
     * @param sendResolved
     * @param apiKey
     * @param apiURL
     * @param httpConfig
     * @param description
     * @param details
     * @param source
     * @param message
     * @param priority
     * @param responders
     * @param tags
     */
    public OpsGenieConfig(SecretKeySelector apiKey, String apiURL, String description, List<KeyValue> details, HTTPConfig httpConfig, String message, String note, String priority, List<OpsGenieConfigResponder> responders, Boolean sendResolved, String source, String tags) {
        super();
        this.apiKey = apiKey;
        this.apiURL = apiURL;
        this.description = description;
        this.details = details;
        this.httpConfig = httpConfig;
        this.message = message;
        this.note = note;
        this.priority = priority;
        this.responders = responders;
        this.sendResolved = sendResolved;
        this.source = source;
        this.tags = tags;
    }

    @JsonProperty("apiKey")
    public SecretKeySelector getApiKey() {
        return apiKey;
    }

    @JsonProperty("apiKey")
    public void setApiKey(SecretKeySelector apiKey) {
        this.apiKey = apiKey;
    }

    @JsonProperty("apiURL")
    public String getApiURL() {
        return apiURL;
    }

    @JsonProperty("apiURL")
    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("details")
    public List<KeyValue> getDetails() {
        return details;
    }

    @JsonProperty("details")
    public void setDetails(List<KeyValue> details) {
        this.details = details;
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

    @JsonProperty("note")
    public String getNote() {
        return note;
    }

    @JsonProperty("note")
    public void setNote(String note) {
        this.note = note;
    }

    @JsonProperty("priority")
    public String getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(String priority) {
        this.priority = priority;
    }

    @JsonProperty("responders")
    public List<OpsGenieConfigResponder> getResponders() {
        return responders;
    }

    @JsonProperty("responders")
    public void setResponders(List<OpsGenieConfigResponder> responders) {
        this.responders = responders;
    }

    @JsonProperty("sendResolved")
    public Boolean getSendResolved() {
        return sendResolved;
    }

    @JsonProperty("sendResolved")
    public void setSendResolved(Boolean sendResolved) {
        this.sendResolved = sendResolved;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("tags")
    public String getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(String tags) {
        this.tags = tags;
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
