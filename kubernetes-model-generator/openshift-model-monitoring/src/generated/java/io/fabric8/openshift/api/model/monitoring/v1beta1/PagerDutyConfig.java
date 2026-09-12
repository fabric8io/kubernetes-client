
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
    "timeout",
    "url"
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
    @JsonProperty("timeout")
    private String timeout;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PagerDutyConfig() {
    }

    public PagerDutyConfig(String className, String client, String clientURL, String component, String description, List<KeyValue> details, String group, HTTPConfig httpConfig, List<PagerDutyImageConfig> pagerDutyImageConfigs, List<PagerDutyLinkConfig> pagerDutyLinkConfigs, SecretKeySelector routingKey, Boolean sendResolved, SecretKeySelector serviceKey, String severity, String source, String timeout, String url) {
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
        this.timeout = timeout;
        this.url = url;
    }

    /**
     * class defines the class/type of the event.
     */
    @JsonProperty("class")
    public String getClassName() {
        return className;
    }

    /**
     * class defines the class/type of the event.
     */
    @JsonProperty("class")
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * client defines the client identification.
     */
    @JsonProperty("client")
    public String getClient() {
        return client;
    }

    /**
     * client defines the client identification.
     */
    @JsonProperty("client")
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * clientURL defines the backlink to the sender of notification.
     */
    @JsonProperty("clientURL")
    public String getClientURL() {
        return clientURL;
    }

    /**
     * clientURL defines the backlink to the sender of notification.
     */
    @JsonProperty("clientURL")
    public void setClientURL(String clientURL) {
        this.clientURL = clientURL;
    }

    /**
     * component defines the part or component of the affected system that is broken.
     */
    @JsonProperty("component")
    public String getComponent() {
        return component;
    }

    /**
     * component defines the part or component of the affected system that is broken.
     */
    @JsonProperty("component")
    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * description of the incident.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * description of the incident.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * details defines the arbitrary key/value pairs that provide further detail about the incident.
     */
    @JsonProperty("details")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<KeyValue> getDetails() {
        return details;
    }

    /**
     * details defines the arbitrary key/value pairs that provide further detail about the incident.
     */
    @JsonProperty("details")
    public void setDetails(List<KeyValue> details) {
        this.details = details;
    }

    /**
     * group defines a cluster or grouping of sources.
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * group defines a cluster or grouping of sources.
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
     * pagerDutyImageConfigs defines a list of image details to attach that provide further detail about an incident.
     */
    @JsonProperty("pagerDutyImageConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PagerDutyImageConfig> getPagerDutyImageConfigs() {
        return pagerDutyImageConfigs;
    }

    /**
     * pagerDutyImageConfigs defines a list of image details to attach that provide further detail about an incident.
     */
    @JsonProperty("pagerDutyImageConfigs")
    public void setPagerDutyImageConfigs(List<PagerDutyImageConfig> pagerDutyImageConfigs) {
        this.pagerDutyImageConfigs = pagerDutyImageConfigs;
    }

    /**
     * pagerDutyLinkConfigs defines a list of link details to attach that provide further detail about an incident.
     */
    @JsonProperty("pagerDutyLinkConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PagerDutyLinkConfig> getPagerDutyLinkConfigs() {
        return pagerDutyLinkConfigs;
    }

    /**
     * pagerDutyLinkConfigs defines a list of link details to attach that provide further detail about an incident.
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
     * severity of the incident.
     */
    @JsonProperty("severity")
    public String getSeverity() {
        return severity;
    }

    /**
     * severity of the incident.
     */
    @JsonProperty("severity")
    public void setSeverity(String severity) {
        this.severity = severity;
    }

    /**
     * source defines the unique location of the affected system.
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * source defines the unique location of the affected system.
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * timeout is the maximum time allowed to invoke the pagerduty It requires Alertmanager &gt;= v0.30.0.
     */
    @JsonProperty("timeout")
    public String getTimeout() {
        return timeout;
    }

    /**
     * timeout is the maximum time allowed to invoke the pagerduty It requires Alertmanager &gt;= v0.30.0.
     */
    @JsonProperty("timeout")
    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    /**
     * url defines the URL to send requests to.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * url defines the URL to send requests to.
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
        if (!(o instanceof PagerDutyConfig)) {
            return false;
        }
        PagerDutyConfig other = (PagerDutyConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$className = this.getClassName();
        Object other$className = other.getClassName();
        if (this$className == null ? other$className != null : !this$className.equals(other$className)) {
            return false;
        }
        Object this$client = this.getClient();
        Object other$client = other.getClient();
        if (this$client == null ? other$client != null : !this$client.equals(other$client)) {
            return false;
        }
        Object this$clientURL = this.getClientURL();
        Object other$clientURL = other.getClientURL();
        if (this$clientURL == null ? other$clientURL != null : !this$clientURL.equals(other$clientURL)) {
            return false;
        }
        Object this$component = this.getComponent();
        Object other$component = other.getComponent();
        if (this$component == null ? other$component != null : !this$component.equals(other$component)) {
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
        Object this$group = this.getGroup();
        Object other$group = other.getGroup();
        if (this$group == null ? other$group != null : !this$group.equals(other$group)) {
            return false;
        }
        Object this$httpConfig = this.getHttpConfig();
        Object other$httpConfig = other.getHttpConfig();
        if (this$httpConfig == null ? other$httpConfig != null : !this$httpConfig.equals(other$httpConfig)) {
            return false;
        }
        Object this$pagerDutyImageConfigs = this.getPagerDutyImageConfigs();
        Object other$pagerDutyImageConfigs = other.getPagerDutyImageConfigs();
        if (this$pagerDutyImageConfigs == null ? other$pagerDutyImageConfigs != null : !this$pagerDutyImageConfigs.equals(other$pagerDutyImageConfigs)) {
            return false;
        }
        Object this$pagerDutyLinkConfigs = this.getPagerDutyLinkConfigs();
        Object other$pagerDutyLinkConfigs = other.getPagerDutyLinkConfigs();
        if (this$pagerDutyLinkConfigs == null ? other$pagerDutyLinkConfigs != null : !this$pagerDutyLinkConfigs.equals(other$pagerDutyLinkConfigs)) {
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
        Object this$serviceKey = this.getServiceKey();
        Object other$serviceKey = other.getServiceKey();
        if (this$serviceKey == null ? other$serviceKey != null : !this$serviceKey.equals(other$serviceKey)) {
            return false;
        }
        Object this$severity = this.getSeverity();
        Object other$severity = other.getSeverity();
        if (this$severity == null ? other$severity != null : !this$severity.equals(other$severity)) {
            return false;
        }
        Object this$source = this.getSource();
        Object other$source = other.getSource();
        if (this$source == null ? other$source != null : !this$source.equals(other$source)) {
            return false;
        }
        Object this$timeout = this.getTimeout();
        Object other$timeout = other.getTimeout();
        if (this$timeout == null ? other$timeout != null : !this$timeout.equals(other$timeout)) {
            return false;
        }
        Object this$url = this.getUrl();
        Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) {
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
        return other instanceof PagerDutyConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $className = this.getClassName();
        result = result * prime + ($className == null ? 43 : $className.hashCode());
        Object $client = this.getClient();
        result = result * prime + ($client == null ? 43 : $client.hashCode());
        Object $clientURL = this.getClientURL();
        result = result * prime + ($clientURL == null ? 43 : $clientURL.hashCode());
        Object $component = this.getComponent();
        result = result * prime + ($component == null ? 43 : $component.hashCode());
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $details = this.getDetails();
        result = result * prime + ($details == null ? 43 : $details.hashCode());
        Object $group = this.getGroup();
        result = result * prime + ($group == null ? 43 : $group.hashCode());
        Object $httpConfig = this.getHttpConfig();
        result = result * prime + ($httpConfig == null ? 43 : $httpConfig.hashCode());
        Object $pagerDutyImageConfigs = this.getPagerDutyImageConfigs();
        result = result * prime + ($pagerDutyImageConfigs == null ? 43 : $pagerDutyImageConfigs.hashCode());
        Object $pagerDutyLinkConfigs = this.getPagerDutyLinkConfigs();
        result = result * prime + ($pagerDutyLinkConfigs == null ? 43 : $pagerDutyLinkConfigs.hashCode());
        Object $routingKey = this.getRoutingKey();
        result = result * prime + ($routingKey == null ? 43 : $routingKey.hashCode());
        Object $sendResolved = this.getSendResolved();
        result = result * prime + ($sendResolved == null ? 43 : $sendResolved.hashCode());
        Object $serviceKey = this.getServiceKey();
        result = result * prime + ($serviceKey == null ? 43 : $serviceKey.hashCode());
        Object $severity = this.getSeverity();
        result = result * prime + ($severity == null ? 43 : $severity.hashCode());
        Object $source = this.getSource();
        result = result * prime + ($source == null ? 43 : $source.hashCode());
        Object $timeout = this.getTimeout();
        result = result * prime + ($timeout == null ? 43 : $timeout.hashCode());
        Object $url = this.getUrl();
        result = result * prime + ($url == null ? 43 : $url.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PagerDutyConfig(" + "className=" + this.getClassName() + ", client=" + this.getClient() + ", clientURL=" + this.getClientURL() + ", component=" + this.getComponent() + ", description=" + this.getDescription() + ", details=" + this.getDetails() + ", group=" + this.getGroup() + ", httpConfig=" + this.getHttpConfig() + ", pagerDutyImageConfigs=" + this.getPagerDutyImageConfigs() + ", pagerDutyLinkConfigs=" + this.getPagerDutyLinkConfigs() + ", routingKey=" + this.getRoutingKey() + ", sendResolved=" + this.getSendResolved() + ", serviceKey=" + this.getServiceKey() + ", severity=" + this.getSeverity() + ", source=" + this.getSource() + ", timeout=" + this.getTimeout() + ", url=" + this.getUrl() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
