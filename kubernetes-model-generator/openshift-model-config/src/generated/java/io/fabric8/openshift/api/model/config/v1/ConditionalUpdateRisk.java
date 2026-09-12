
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ConditionalUpdateRisk represents a reason and cluster-state for not recommending a conditional update.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "matchingRules",
    "message",
    "name",
    "url"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ConditionalUpdateRisk implements Editable<ConditionalUpdateRiskBuilder>, KubernetesResource
{

    @JsonProperty("matchingRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterCondition> matchingRules = new ArrayList<>();
    @JsonProperty("message")
    private String message;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConditionalUpdateRisk() {
    }

    public ConditionalUpdateRisk(List<ClusterCondition> matchingRules, String message, String name, String url) {
        super();
        this.matchingRules = matchingRules;
        this.message = message;
        this.name = name;
        this.url = url;
    }

    /**
     * matchingRules is a slice of conditions for deciding which clusters match the risk and which do not. The slice is ordered by decreasing precedence. The cluster-version operator will walk the slice in order, and stop after the first it can successfully evaluate. If no condition can be successfully evaluated, the update will not be recommended.
     */
    @JsonProperty("matchingRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterCondition> getMatchingRules() {
        return matchingRules;
    }

    /**
     * matchingRules is a slice of conditions for deciding which clusters match the risk and which do not. The slice is ordered by decreasing precedence. The cluster-version operator will walk the slice in order, and stop after the first it can successfully evaluate. If no condition can be successfully evaluated, the update will not be recommended.
     */
    @JsonProperty("matchingRules")
    public void setMatchingRules(List<ClusterCondition> matchingRules) {
        this.matchingRules = matchingRules;
    }

    /**
     * message provides additional information about the risk of updating, in the event that matchingRules match the cluster state. This is only to be consumed by humans. It may contain Line Feed characters (U+000A), which should be rendered as new lines.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * message provides additional information about the risk of updating, in the event that matchingRules match the cluster state. This is only to be consumed by humans. It may contain Line Feed characters (U+000A), which should be rendered as new lines.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * name is the CamelCase reason for not recommending a conditional update, in the event that matchingRules match the cluster state.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the CamelCase reason for not recommending a conditional update, in the event that matchingRules match the cluster state.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * url contains information about this risk.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * url contains information about this risk.
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public ConditionalUpdateRiskBuilder edit() {
        return new ConditionalUpdateRiskBuilder(this);
    }

    @JsonIgnore
    public ConditionalUpdateRiskBuilder toBuilder() {
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
        if (!(o instanceof ConditionalUpdateRisk)) {
            return false;
        }
        ConditionalUpdateRisk other = (ConditionalUpdateRisk) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$matchingRules = this.getMatchingRules();
        Object other$matchingRules = other.getMatchingRules();
        if (this$matchingRules == null ? other$matchingRules != null : !this$matchingRules.equals(other$matchingRules)) {
            return false;
        }
        Object this$message = this.getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
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
        return other instanceof ConditionalUpdateRisk;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $matchingRules = this.getMatchingRules();
        result = result * prime + ($matchingRules == null ? 43 : $matchingRules.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $url = this.getUrl();
        result = result * prime + ($url == null ? 43 : $url.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ConditionalUpdateRisk(" + "matchingRules=" + this.getMatchingRules() + ", message=" + this.getMessage() + ", name=" + this.getName() + ", url=" + this.getUrl() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
