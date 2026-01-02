
package io.fabric8.openshift.api.model.insights.v1alpha2;

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
 * healthCheck represents an Insights health check attributes.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "advisorURI",
    "description",
    "totalRisk"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
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
    @JsonProperty("totalRisk")
    private String totalRisk;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HealthCheck() {
    }

    public HealthCheck(String advisorURI, String description, String totalRisk) {
        super();
        this.advisorURI = advisorURI;
        this.description = description;
        this.totalRisk = totalRisk;
    }

    /**
     * advisorURI is required field that provides the URL link to the Insights Advisor. The link must be a valid HTTPS URL and the maximum length is 2048 characters.
     */
    @JsonProperty("advisorURI")
    public String getAdvisorURI() {
        return advisorURI;
    }

    /**
     * advisorURI is required field that provides the URL link to the Insights Advisor. The link must be a valid HTTPS URL and the maximum length is 2048 characters.
     */
    @JsonProperty("advisorURI")
    public void setAdvisorURI(String advisorURI) {
        this.advisorURI = advisorURI;
    }

    /**
     * description is required field that provides basic description of the healtcheck. It must contain at least 10 characters and may not exceed 2048 characters.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * description is required field that provides basic description of the healtcheck. It must contain at least 10 characters and may not exceed 2048 characters.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * totalRisk is the required field of the healthcheck. It is indicator of the total risk posed by the detected issue; combination of impact and likelihood. Allowed values are Low, Medium, Important and Critical. The value represents the severity of the issue.
     */
    @JsonProperty("totalRisk")
    public String getTotalRisk() {
        return totalRisk;
    }

    /**
     * totalRisk is the required field of the healthcheck. It is indicator of the total risk posed by the detected issue; combination of impact and likelihood. Allowed values are Low, Medium, Important and Critical. The value represents the severity of the issue.
     */
    @JsonProperty("totalRisk")
    public void setTotalRisk(String totalRisk) {
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

}
