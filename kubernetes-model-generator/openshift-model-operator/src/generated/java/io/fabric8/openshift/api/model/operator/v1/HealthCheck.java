
package io.fabric8.openshift.api.model.operator.v1;

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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * healthCheck represents an Insights health check attributes.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "advisorURI",
    "description",
    "state",
    "totalRisk"
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
public class HealthCheck implements Editable<HealthCheckBuilder>, KubernetesResource
{

    @JsonProperty("advisorURI")
    private String advisorURI;
    @JsonProperty("description")
    private String description;
    @JsonProperty("state")
    private String state;
    @JsonProperty("totalRisk")
    private Integer totalRisk;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HealthCheck() {
    }

    public HealthCheck(String advisorURI, String description, String state, Integer totalRisk) {
        super();
        this.advisorURI = advisorURI;
        this.description = description;
        this.state = state;
        this.totalRisk = totalRisk;
    }

    /**
     * advisorURI provides the URL link to the Insights Advisor.
     */
    @JsonProperty("advisorURI")
    public String getAdvisorURI() {
        return advisorURI;
    }

    /**
     * advisorURI provides the URL link to the Insights Advisor.
     */
    @JsonProperty("advisorURI")
    public void setAdvisorURI(String advisorURI) {
        this.advisorURI = advisorURI;
    }

    /**
     * description provides basic description of the healtcheck.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * description provides basic description of the healtcheck.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * state determines what the current state of the health check is. Health check is enabled by default and can be disabled by the user in the Insights advisor user interface.
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * state determines what the current state of the health check is. Health check is enabled by default and can be disabled by the user in the Insights advisor user interface.
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * totalRisk of the healthcheck. Indicator of the total risk posed by the detected issue; combination of impact and likelihood. The values can be from 1 to 4, and the higher the number, the more important the issue.
     */
    @JsonProperty("totalRisk")
    public Integer getTotalRisk() {
        return totalRisk;
    }

    /**
     * totalRisk of the healthcheck. Indicator of the total risk posed by the detected issue; combination of impact and likelihood. The values can be from 1 to 4, and the higher the number, the more important the issue.
     */
    @JsonProperty("totalRisk")
    public void setTotalRisk(Integer totalRisk) {
        this.totalRisk = totalRisk;
    }

    @JsonIgnore
    public HealthCheckBuilder edit() {
        return new HealthCheckBuilder(this);
    }

    @JsonIgnore
    public HealthCheckBuilder toBuilder() {
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
        if (!(o instanceof HealthCheck)) {
            return false;
        }
        HealthCheck other = (HealthCheck) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$advisorURI = this.getAdvisorURI();
        Object other$advisorURI = other.getAdvisorURI();
        if (this$advisorURI == null ? other$advisorURI != null : !this$advisorURI.equals(other$advisorURI)) {
            return false;
        }
        Object this$description = this.getDescription();
        Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        Object this$state = this.getState();
        Object other$state = other.getState();
        if (this$state == null ? other$state != null : !this$state.equals(other$state)) {
            return false;
        }
        Object this$totalRisk = this.getTotalRisk();
        Object other$totalRisk = other.getTotalRisk();
        if (this$totalRisk == null ? other$totalRisk != null : !this$totalRisk.equals(other$totalRisk)) {
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
        return other instanceof HealthCheck;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $advisorURI = this.getAdvisorURI();
        result = result * prime + ($advisorURI == null ? 43 : $advisorURI.hashCode());
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $state = this.getState();
        result = result * prime + ($state == null ? 43 : $state.hashCode());
        Object $totalRisk = this.getTotalRisk();
        result = result * prime + ($totalRisk == null ? 43 : $totalRisk.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HealthCheck(" + "advisorURI=" + this.getAdvisorURI() + ", description=" + this.getDescription() + ", state=" + this.getState() + ", totalRisk=" + this.getTotalRisk() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
