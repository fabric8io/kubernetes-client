
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
 * VictorOpsConfig configures notifications via VictorOps. See https://prometheus.io/docs/alerting/latest/configuration/#victorops_config
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiKey",
    "apiUrl",
    "customFields",
    "entityDisplayName",
    "httpConfig",
    "messageType",
    "monitoringTool",
    "routingKey",
    "sendResolved",
    "stateMessage"
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
public class VictorOpsConfig implements Editable<VictorOpsConfigBuilder>, KubernetesResource
{

    @JsonProperty("apiKey")
    private SecretKeySelector apiKey;
    @JsonProperty("apiUrl")
    private String apiUrl;
    @JsonProperty("customFields")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<KeyValue> customFields = new ArrayList<>();
    @JsonProperty("entityDisplayName")
    private String entityDisplayName;
    @JsonProperty("httpConfig")
    private HTTPConfig httpConfig;
    @JsonProperty("messageType")
    private String messageType;
    @JsonProperty("monitoringTool")
    private String monitoringTool;
    @JsonProperty("routingKey")
    private String routingKey;
    @JsonProperty("sendResolved")
    private Boolean sendResolved;
    @JsonProperty("stateMessage")
    private String stateMessage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VictorOpsConfig() {
    }

    public VictorOpsConfig(SecretKeySelector apiKey, String apiUrl, List<KeyValue> customFields, String entityDisplayName, HTTPConfig httpConfig, String messageType, String monitoringTool, String routingKey, Boolean sendResolved, String stateMessage) {
        super();
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
        this.customFields = customFields;
        this.entityDisplayName = entityDisplayName;
        this.httpConfig = httpConfig;
        this.messageType = messageType;
        this.monitoringTool = monitoringTool;
        this.routingKey = routingKey;
        this.sendResolved = sendResolved;
        this.stateMessage = stateMessage;
    }

    /**
     * VictorOpsConfig configures notifications via VictorOps. See https://prometheus.io/docs/alerting/latest/configuration/#victorops_config
     */
    @JsonProperty("apiKey")
    public SecretKeySelector getApiKey() {
        return apiKey;
    }

    /**
     * VictorOpsConfig configures notifications via VictorOps. See https://prometheus.io/docs/alerting/latest/configuration/#victorops_config
     */
    @JsonProperty("apiKey")
    public void setApiKey(SecretKeySelector apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * apiUrl defines the VictorOps API URL. When not specified, defaults to the standard VictorOps API endpoint.
     */
    @JsonProperty("apiUrl")
    public String getApiUrl() {
        return apiUrl;
    }

    /**
     * apiUrl defines the VictorOps API URL. When not specified, defaults to the standard VictorOps API endpoint.
     */
    @JsonProperty("apiUrl")
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    /**
     * customFields defines additional custom fields for notification. These provide extra metadata that will be included with the VictorOps incident.
     */
    @JsonProperty("customFields")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<KeyValue> getCustomFields() {
        return customFields;
    }

    /**
     * customFields defines additional custom fields for notification. These provide extra metadata that will be included with the VictorOps incident.
     */
    @JsonProperty("customFields")
    public void setCustomFields(List<KeyValue> customFields) {
        this.customFields = customFields;
    }

    /**
     * entityDisplayName contains a summary of the alerted problem. This appears as the main title or identifier for the incident.
     */
    @JsonProperty("entityDisplayName")
    public String getEntityDisplayName() {
        return entityDisplayName;
    }

    /**
     * entityDisplayName contains a summary of the alerted problem. This appears as the main title or identifier for the incident.
     */
    @JsonProperty("entityDisplayName")
    public void setEntityDisplayName(String entityDisplayName) {
        this.entityDisplayName = entityDisplayName;
    }

    /**
     * VictorOpsConfig configures notifications via VictorOps. See https://prometheus.io/docs/alerting/latest/configuration/#victorops_config
     */
    @JsonProperty("httpConfig")
    public HTTPConfig getHttpConfig() {
        return httpConfig;
    }

    /**
     * VictorOpsConfig configures notifications via VictorOps. See https://prometheus.io/docs/alerting/latest/configuration/#victorops_config
     */
    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    /**
     * messageType describes the behavior of the alert. Valid values are "CRITICAL", "WARNING", and "INFO".
     */
    @JsonProperty("messageType")
    public String getMessageType() {
        return messageType;
    }

    /**
     * messageType describes the behavior of the alert. Valid values are "CRITICAL", "WARNING", and "INFO".
     */
    @JsonProperty("messageType")
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    /**
     * monitoringTool defines the monitoring tool the state message is from. This helps identify the source system that generated the alert.
     */
    @JsonProperty("monitoringTool")
    public String getMonitoringTool() {
        return monitoringTool;
    }

    /**
     * monitoringTool defines the monitoring tool the state message is from. This helps identify the source system that generated the alert.
     */
    @JsonProperty("monitoringTool")
    public void setMonitoringTool(String monitoringTool) {
        this.monitoringTool = monitoringTool;
    }

    /**
     * routingKey defines a key used to map the alert to a team. This determines which VictorOps team will receive the alert notification.
     */
    @JsonProperty("routingKey")
    public String getRoutingKey() {
        return routingKey;
    }

    /**
     * routingKey defines a key used to map the alert to a team. This determines which VictorOps team will receive the alert notification.
     */
    @JsonProperty("routingKey")
    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
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
     * stateMessage contains a long explanation of the alerted problem. This provides detailed context about the incident.
     */
    @JsonProperty("stateMessage")
    public String getStateMessage() {
        return stateMessage;
    }

    /**
     * stateMessage contains a long explanation of the alerted problem. This provides detailed context about the incident.
     */
    @JsonProperty("stateMessage")
    public void setStateMessage(String stateMessage) {
        this.stateMessage = stateMessage;
    }

    @JsonIgnore
    public VictorOpsConfigBuilder edit() {
        return new VictorOpsConfigBuilder(this);
    }

    @JsonIgnore
    public VictorOpsConfigBuilder toBuilder() {
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
        if (!(o instanceof VictorOpsConfig)) {
            return false;
        }
        VictorOpsConfig other = (VictorOpsConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiKey = this.getApiKey();
        Object other$apiKey = other.getApiKey();
        if (this$apiKey == null ? other$apiKey != null : !this$apiKey.equals(other$apiKey)) {
            return false;
        }
        Object this$apiUrl = this.getApiUrl();
        Object other$apiUrl = other.getApiUrl();
        if (this$apiUrl == null ? other$apiUrl != null : !this$apiUrl.equals(other$apiUrl)) {
            return false;
        }
        Object this$customFields = this.getCustomFields();
        Object other$customFields = other.getCustomFields();
        if (this$customFields == null ? other$customFields != null : !this$customFields.equals(other$customFields)) {
            return false;
        }
        Object this$entityDisplayName = this.getEntityDisplayName();
        Object other$entityDisplayName = other.getEntityDisplayName();
        if (this$entityDisplayName == null ? other$entityDisplayName != null : !this$entityDisplayName.equals(other$entityDisplayName)) {
            return false;
        }
        Object this$httpConfig = this.getHttpConfig();
        Object other$httpConfig = other.getHttpConfig();
        if (this$httpConfig == null ? other$httpConfig != null : !this$httpConfig.equals(other$httpConfig)) {
            return false;
        }
        Object this$messageType = this.getMessageType();
        Object other$messageType = other.getMessageType();
        if (this$messageType == null ? other$messageType != null : !this$messageType.equals(other$messageType)) {
            return false;
        }
        Object this$monitoringTool = this.getMonitoringTool();
        Object other$monitoringTool = other.getMonitoringTool();
        if (this$monitoringTool == null ? other$monitoringTool != null : !this$monitoringTool.equals(other$monitoringTool)) {
            return false;
        }
        Object this$routingKey = this.getRoutingKey();
        Object other$routingKey = other.getRoutingKey();
        if (this$routingKey == null ? other$routingKey != null : !this$routingKey.equals(other$routingKey)) {
            return false;
        }
        Object this$sendResolved = this.getSendResolved();
        Object other$sendResolved = other.getSendResolved();
        if (this$sendResolved == null ? other$sendResolved != null : !this$sendResolved.equals(other$sendResolved)) {
            return false;
        }
        Object this$stateMessage = this.getStateMessage();
        Object other$stateMessage = other.getStateMessage();
        if (this$stateMessage == null ? other$stateMessage != null : !this$stateMessage.equals(other$stateMessage)) {
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
        return other instanceof VictorOpsConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiKey = this.getApiKey();
        result = result * prime + ($apiKey == null ? 43 : $apiKey.hashCode());
        Object $apiUrl = this.getApiUrl();
        result = result * prime + ($apiUrl == null ? 43 : $apiUrl.hashCode());
        Object $customFields = this.getCustomFields();
        result = result * prime + ($customFields == null ? 43 : $customFields.hashCode());
        Object $entityDisplayName = this.getEntityDisplayName();
        result = result * prime + ($entityDisplayName == null ? 43 : $entityDisplayName.hashCode());
        Object $httpConfig = this.getHttpConfig();
        result = result * prime + ($httpConfig == null ? 43 : $httpConfig.hashCode());
        Object $messageType = this.getMessageType();
        result = result * prime + ($messageType == null ? 43 : $messageType.hashCode());
        Object $monitoringTool = this.getMonitoringTool();
        result = result * prime + ($monitoringTool == null ? 43 : $monitoringTool.hashCode());
        Object $routingKey = this.getRoutingKey();
        result = result * prime + ($routingKey == null ? 43 : $routingKey.hashCode());
        Object $sendResolved = this.getSendResolved();
        result = result * prime + ($sendResolved == null ? 43 : $sendResolved.hashCode());
        Object $stateMessage = this.getStateMessage();
        result = result * prime + ($stateMessage == null ? 43 : $stateMessage.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VictorOpsConfig(" + "apiKey=" + this.getApiKey() + ", apiUrl=" + this.getApiUrl() + ", customFields=" + this.getCustomFields() + ", entityDisplayName=" + this.getEntityDisplayName() + ", httpConfig=" + this.getHttpConfig() + ", messageType=" + this.getMessageType() + ", monitoringTool=" + this.getMonitoringTool() + ", routingKey=" + this.getRoutingKey() + ", sendResolved=" + this.getSendResolved() + ", stateMessage=" + this.getStateMessage() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
