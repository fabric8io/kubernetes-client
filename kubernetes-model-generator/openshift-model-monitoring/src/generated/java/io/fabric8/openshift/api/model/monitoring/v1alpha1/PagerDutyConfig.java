
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * PagerDutyConfig configures notifications via PagerDuty. See https://prometheus.io/docs/alerting/latest/configuration/#pagerduty_config
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "class",
    "client",
    "clientURL",
    "component",
    "description",
    "details",
    "group",
    "httpConfig",
    "pagerDutyImageConfigs",
    "pagerDutyLinkConfigs",
    "routingKey",
    "sendResolved",
    "serviceKey",
    "severity",
    "source",
    "url"
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
public class PagerDutyConfig implements Editable<PagerDutyConfigBuilder>, KubernetesResource
{

    @JsonProperty("class")
    private String className;
    @JsonProperty("client")
    private String client;
    @JsonProperty("clientURL")
    private String clientURL;
    @JsonProperty("component")
    private String component;
    @JsonProperty("description")
    private String description;
    @JsonProperty("details")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<KeyValue> details = new ArrayList<>();
    @JsonProperty("group")
    private String group;
    @JsonProperty("httpConfig")
    private HTTPConfig httpConfig;
    @JsonProperty("pagerDutyImageConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PagerDutyImageConfig> pagerDutyImageConfigs = new ArrayList<>();
    @JsonProperty("pagerDutyLinkConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PagerDutyLinkConfig> pagerDutyLinkConfigs = new ArrayList<>();
    @JsonProperty("routingKey")
    private SecretKeySelector routingKey;
    @JsonProperty("sendResolved")
    private Boolean sendResolved;
    @JsonProperty("serviceKey")
    private SecretKeySelector serviceKey;
    @JsonProperty("severity")
    private String severity;
    @JsonProperty("source")
    private String source;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PagerDutyConfig() {
    }

    public PagerDutyConfig(String className, String client, String clientURL, String component, String description, List<KeyValue> details, String group, HTTPConfig httpConfig, List<PagerDutyImageConfig> pagerDutyImageConfigs, List<PagerDutyLinkConfig> pagerDutyLinkConfigs, SecretKeySelector routingKey, Boolean sendResolved, SecretKeySelector serviceKey, String severity, String source, String url) {
        super();
        this.className = className;
        this.client = client;
        this.clientURL = clientURL;
        this.component = component;
        this.description = description;
        this.details = details;
        this.group = group;
        this.httpConfig = httpConfig;
        this.pagerDutyImageConfigs = pagerDutyImageConfigs;
        this.pagerDutyLinkConfigs = pagerDutyLinkConfigs;
        this.routingKey = routingKey;
        this.sendResolved = sendResolved;
        this.serviceKey = serviceKey;
        this.severity = severity;
        this.source = source;
        this.url = url;
    }

    /**
     * The class/type of the event.
     */
    @JsonProperty("class")
    public String getClassName() {
        return className;
    }

    /**
     * The class/type of the event.
     */
    @JsonProperty("class")
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Client identification.
     */
    @JsonProperty("client")
    public String getClient() {
        return client;
    }

    /**
     * Client identification.
     */
    @JsonProperty("client")
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * Backlink to the sender of notification.
     */
    @JsonProperty("clientURL")
    public String getClientURL() {
        return clientURL;
    }

    /**
     * Backlink to the sender of notification.
     */
    @JsonProperty("clientURL")
    public void setClientURL(String clientURL) {
        this.clientURL = clientURL;
    }

    /**
     * The part or component of the affected system that is broken.
     */
    @JsonProperty("component")
    public String getComponent() {
        return component;
    }

    /**
     * The part or component of the affected system that is broken.
     */
    @JsonProperty("component")
    public void setComponent(String component) {
        this.component = component;
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
     * Arbitrary key/value pairs that provide further detail about the incident.
     */
    @JsonProperty("details")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<KeyValue> getDetails() {
        return details;
    }

    /**
     * Arbitrary key/value pairs that provide further detail about the incident.
     */
    @JsonProperty("details")
    public void setDetails(List<KeyValue> details) {
        this.details = details;
    }

    /**
     * A cluster or grouping of sources.
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * A cluster or grouping of sources.
     */
    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * PagerDutyConfig configures notifications via PagerDuty. See https://prometheus.io/docs/alerting/latest/configuration/#pagerduty_config
     */
    @JsonProperty("httpConfig")
    public HTTPConfig getHttpConfig() {
        return httpConfig;
    }

    /**
     * PagerDutyConfig configures notifications via PagerDuty. See https://prometheus.io/docs/alerting/latest/configuration/#pagerduty_config
     */
    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    /**
     * A list of image details to attach that provide further detail about an incident.
     */
    @JsonProperty("pagerDutyImageConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PagerDutyImageConfig> getPagerDutyImageConfigs() {
        return pagerDutyImageConfigs;
    }

    /**
     * A list of image details to attach that provide further detail about an incident.
     */
    @JsonProperty("pagerDutyImageConfigs")
    public void setPagerDutyImageConfigs(List<PagerDutyImageConfig> pagerDutyImageConfigs) {
        this.pagerDutyImageConfigs = pagerDutyImageConfigs;
    }

    /**
     * A list of link details to attach that provide further detail about an incident.
     */
    @JsonProperty("pagerDutyLinkConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PagerDutyLinkConfig> getPagerDutyLinkConfigs() {
        return pagerDutyLinkConfigs;
    }

    /**
     * A list of link details to attach that provide further detail about an incident.
     */
    @JsonProperty("pagerDutyLinkConfigs")
    public void setPagerDutyLinkConfigs(List<PagerDutyLinkConfig> pagerDutyLinkConfigs) {
        this.pagerDutyLinkConfigs = pagerDutyLinkConfigs;
    }

    /**
     * PagerDutyConfig configures notifications via PagerDuty. See https://prometheus.io/docs/alerting/latest/configuration/#pagerduty_config
     */
    @JsonProperty("routingKey")
    public SecretKeySelector getRoutingKey() {
        return routingKey;
    }

    /**
     * PagerDutyConfig configures notifications via PagerDuty. See https://prometheus.io/docs/alerting/latest/configuration/#pagerduty_config
     */
    @JsonProperty("routingKey")
    public void setRoutingKey(SecretKeySelector routingKey) {
        this.routingKey = routingKey;
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
     * PagerDutyConfig configures notifications via PagerDuty. See https://prometheus.io/docs/alerting/latest/configuration/#pagerduty_config
     */
    @JsonProperty("serviceKey")
    public SecretKeySelector getServiceKey() {
        return serviceKey;
    }

    /**
     * PagerDutyConfig configures notifications via PagerDuty. See https://prometheus.io/docs/alerting/latest/configuration/#pagerduty_config
     */
    @JsonProperty("serviceKey")
    public void setServiceKey(SecretKeySelector serviceKey) {
        this.serviceKey = serviceKey;
    }

    /**
     * Severity of the incident.
     */
    @JsonProperty("severity")
    public String getSeverity() {
        return severity;
    }

    /**
     * Severity of the incident.
     */
    @JsonProperty("severity")
    public void setSeverity(String severity) {
        this.severity = severity;
    }

    /**
     * Unique location of the affected system.
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * Unique location of the affected system.
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * The URL to send requests to.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * The URL to send requests to.
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public PagerDutyConfigBuilder edit() {
        return new PagerDutyConfigBuilder(this);
    }

    @JsonIgnore
    public PagerDutyConfigBuilder toBuilder() {
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
