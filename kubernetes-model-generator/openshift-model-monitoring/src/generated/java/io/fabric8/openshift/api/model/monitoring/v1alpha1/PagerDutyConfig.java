
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
    "url"
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
public class PagerDutyConfig implements KubernetesResource
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
    private List<KeyValue> details = new ArrayList<KeyValue>();
    @JsonProperty("group")
    private String group;
    @JsonProperty("httpConfig")
    private HTTPConfig httpConfig;
    @JsonProperty("pagerDutyImageConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PagerDutyImageConfig> pagerDutyImageConfigs = new ArrayList<PagerDutyImageConfig>();
    @JsonProperty("pagerDutyLinkConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PagerDutyLinkConfig> pagerDutyLinkConfigs = new ArrayList<PagerDutyLinkConfig>();
    @JsonProperty("routingKey")
    private SecretKeySelector routingKey;
    @JsonProperty("sendResolved")
    private Boolean sendResolved;
    @JsonProperty("serviceKey")
    private SecretKeySelector serviceKey;
    @JsonProperty("severity")
    private String severity;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PagerDutyConfig() {
    }

    public PagerDutyConfig(String className, String client, String clientURL, String component, String description, List<KeyValue> details, String group, HTTPConfig httpConfig, List<PagerDutyImageConfig> pagerDutyImageConfigs, List<PagerDutyLinkConfig> pagerDutyLinkConfigs, SecretKeySelector routingKey, Boolean sendResolved, SecretKeySelector serviceKey, String severity, String url) {
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
        this.url = url;
    }

    @JsonProperty("class")
    public String getClassName() {
        return className;
    }

    @JsonProperty("class")
    public void setClassName(String className) {
        this.className = className;
    }

    @JsonProperty("client")
    public String getClient() {
        return client;
    }

    @JsonProperty("client")
    public void setClient(String client) {
        this.client = client;
    }

    @JsonProperty("clientURL")
    public String getClientURL() {
        return clientURL;
    }

    @JsonProperty("clientURL")
    public void setClientURL(String clientURL) {
        this.clientURL = clientURL;
    }

    @JsonProperty("component")
    public String getComponent() {
        return component;
    }

    @JsonProperty("component")
    public void setComponent(String component) {
        this.component = component;
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

    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    @JsonProperty("httpConfig")
    public HTTPConfig getHttpConfig() {
        return httpConfig;
    }

    @JsonProperty("httpConfig")
    public void setHttpConfig(HTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    @JsonProperty("pagerDutyImageConfigs")
    public List<PagerDutyImageConfig> getPagerDutyImageConfigs() {
        return pagerDutyImageConfigs;
    }

    @JsonProperty("pagerDutyImageConfigs")
    public void setPagerDutyImageConfigs(List<PagerDutyImageConfig> pagerDutyImageConfigs) {
        this.pagerDutyImageConfigs = pagerDutyImageConfigs;
    }

    @JsonProperty("pagerDutyLinkConfigs")
    public List<PagerDutyLinkConfig> getPagerDutyLinkConfigs() {
        return pagerDutyLinkConfigs;
    }

    @JsonProperty("pagerDutyLinkConfigs")
    public void setPagerDutyLinkConfigs(List<PagerDutyLinkConfig> pagerDutyLinkConfigs) {
        this.pagerDutyLinkConfigs = pagerDutyLinkConfigs;
    }

    @JsonProperty("routingKey")
    public SecretKeySelector getRoutingKey() {
        return routingKey;
    }

    @JsonProperty("routingKey")
    public void setRoutingKey(SecretKeySelector routingKey) {
        this.routingKey = routingKey;
    }

    @JsonProperty("sendResolved")
    public Boolean getSendResolved() {
        return sendResolved;
    }

    @JsonProperty("sendResolved")
    public void setSendResolved(Boolean sendResolved) {
        this.sendResolved = sendResolved;
    }

    @JsonProperty("serviceKey")
    public SecretKeySelector getServiceKey() {
        return serviceKey;
    }

    @JsonProperty("serviceKey")
    public void setServiceKey(SecretKeySelector serviceKey) {
        this.serviceKey = serviceKey;
    }

    @JsonProperty("severity")
    public String getSeverity() {
        return severity;
    }

    @JsonProperty("severity")
    public void setSeverity(String severity) {
        this.severity = severity;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
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
