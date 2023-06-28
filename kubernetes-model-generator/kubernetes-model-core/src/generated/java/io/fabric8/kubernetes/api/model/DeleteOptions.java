
package io.fabric8.kubernetes.api.model;

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
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
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
    "dryRun",
    "gracePeriodSeconds",
    "orphanDependents",
    "preconditions",
    "propagationPolicy"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1")
@Group("")
@Generated("jsonschema2pojo")
public class DeleteOptions implements KubernetesResource
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private String apiVersion = "v1";
    @JsonProperty("dryRun")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> dryRun = new ArrayList<String>();
    @JsonProperty("gracePeriodSeconds")
    private Long gracePeriodSeconds;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private String kind = "DeleteOptions";
    @JsonProperty("orphanDependents")
    private Boolean orphanDependents;
    @JsonProperty("preconditions")
    private Preconditions preconditions;
    @JsonProperty("propagationPolicy")
    private String propagationPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DeleteOptions() {
    }

    public DeleteOptions(String apiVersion, List<String> dryRun, Long gracePeriodSeconds, String kind, Boolean orphanDependents, Preconditions preconditions, String propagationPolicy) {
        super();
        this.apiVersion = apiVersion;
        this.dryRun = dryRun;
        this.gracePeriodSeconds = gracePeriodSeconds;
        this.kind = kind;
        this.orphanDependents = orphanDependents;
        this.preconditions = preconditions;
        this.propagationPolicy = propagationPolicy;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("dryRun")
    public List<String> getDryRun() {
        return dryRun;
    }

    @JsonProperty("dryRun")
    public void setDryRun(List<String> dryRun) {
        this.dryRun = dryRun;
    }

    @JsonProperty("gracePeriodSeconds")
    public Long getGracePeriodSeconds() {
        return gracePeriodSeconds;
    }

    @JsonProperty("gracePeriodSeconds")
    public void setGracePeriodSeconds(Long gracePeriodSeconds) {
        this.gracePeriodSeconds = gracePeriodSeconds;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("orphanDependents")
    public Boolean getOrphanDependents() {
        return orphanDependents;
    }

    @JsonProperty("orphanDependents")
    public void setOrphanDependents(Boolean orphanDependents) {
        this.orphanDependents = orphanDependents;
    }

    @JsonProperty("preconditions")
    public Preconditions getPreconditions() {
        return preconditions;
    }

    @JsonProperty("preconditions")
    public void setPreconditions(Preconditions preconditions) {
        this.preconditions = preconditions;
    }

    @JsonProperty("propagationPolicy")
    public String getPropagationPolicy() {
        return propagationPolicy;
    }

    @JsonProperty("propagationPolicy")
    public void setPropagationPolicy(String propagationPolicy) {
        this.propagationPolicy = propagationPolicy;
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
