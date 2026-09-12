
package io.fabric8.kubernetes.api.model;

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
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "dryRun",
    "gracePeriodSeconds",
    "ignoreStoreReadErrorWithClusterBreakingPotential",
    "orphanDependents",
    "preconditions",
    "propagationPolicy"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Version("v1")
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class DeleteOptions implements Editable<DeleteOptionsBuilder>, KubernetesResource
{

    @JsonProperty("apiVersion")
    private String apiVersion = "v1";
    @JsonProperty("dryRun")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> dryRun = new ArrayList<>();
    @JsonProperty("gracePeriodSeconds")
    private Long gracePeriodSeconds;
    @JsonProperty("ignoreStoreReadErrorWithClusterBreakingPotential")
    private Boolean ignoreStoreReadErrorWithClusterBreakingPotential;
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
     */
    public DeleteOptions() {
    }

    public DeleteOptions(String apiVersion, List<String> dryRun, Long gracePeriodSeconds, Boolean ignoreStoreReadErrorWithClusterBreakingPotential, String kind, Boolean orphanDependents, Preconditions preconditions, String propagationPolicy) {
        super();
        this.apiVersion = apiVersion;
        this.dryRun = dryRun;
        this.gracePeriodSeconds = gracePeriodSeconds;
        this.ignoreStoreReadErrorWithClusterBreakingPotential = ignoreStoreReadErrorWithClusterBreakingPotential;
        this.kind = kind;
        this.orphanDependents = orphanDependents;
        this.preconditions = preconditions;
        this.propagationPolicy = propagationPolicy;
    }

    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("dryRun")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    @JsonProperty("ignoreStoreReadErrorWithClusterBreakingPotential")
    public Boolean getIgnoreStoreReadErrorWithClusterBreakingPotential() {
        return ignoreStoreReadErrorWithClusterBreakingPotential;
    }

    @JsonProperty("ignoreStoreReadErrorWithClusterBreakingPotential")
    public void setIgnoreStoreReadErrorWithClusterBreakingPotential(Boolean ignoreStoreReadErrorWithClusterBreakingPotential) {
        this.ignoreStoreReadErrorWithClusterBreakingPotential = ignoreStoreReadErrorWithClusterBreakingPotential;
    }

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

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

    @JsonIgnore
    public DeleteOptionsBuilder edit() {
        return new DeleteOptionsBuilder(this);
    }

    @JsonIgnore
    public DeleteOptionsBuilder toBuilder() {
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
        if (!(o instanceof DeleteOptions)) {
            return false;
        }
        DeleteOptions other = (DeleteOptions) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$dryRun = this.getDryRun();
        Object other$dryRun = other.getDryRun();
        if (this$dryRun == null ? other$dryRun != null : !this$dryRun.equals(other$dryRun)) {
            return false;
        }
        Object this$gracePeriodSeconds = this.getGracePeriodSeconds();
        Object other$gracePeriodSeconds = other.getGracePeriodSeconds();
        if (this$gracePeriodSeconds == null ? other$gracePeriodSeconds != null : !this$gracePeriodSeconds.equals(other$gracePeriodSeconds)) {
            return false;
        }
        Object this$ignoreStoreReadErrorWithClusterBreakingPotential = this.getIgnoreStoreReadErrorWithClusterBreakingPotential();
        Object other$ignoreStoreReadErrorWithClusterBreakingPotential = other.getIgnoreStoreReadErrorWithClusterBreakingPotential();
        if (this$ignoreStoreReadErrorWithClusterBreakingPotential == null ? other$ignoreStoreReadErrorWithClusterBreakingPotential != null : !this$ignoreStoreReadErrorWithClusterBreakingPotential.equals(other$ignoreStoreReadErrorWithClusterBreakingPotential)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$orphanDependents = this.getOrphanDependents();
        Object other$orphanDependents = other.getOrphanDependents();
        if (this$orphanDependents == null ? other$orphanDependents != null : !this$orphanDependents.equals(other$orphanDependents)) {
            return false;
        }
        Object this$preconditions = this.getPreconditions();
        Object other$preconditions = other.getPreconditions();
        if (this$preconditions == null ? other$preconditions != null : !this$preconditions.equals(other$preconditions)) {
            return false;
        }
        Object this$propagationPolicy = this.getPropagationPolicy();
        Object other$propagationPolicy = other.getPropagationPolicy();
        if (this$propagationPolicy == null ? other$propagationPolicy != null : !this$propagationPolicy.equals(other$propagationPolicy)) {
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
        return other instanceof DeleteOptions;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $dryRun = this.getDryRun();
        result = result * prime + ($dryRun == null ? 43 : $dryRun.hashCode());
        Object $gracePeriodSeconds = this.getGracePeriodSeconds();
        result = result * prime + ($gracePeriodSeconds == null ? 43 : $gracePeriodSeconds.hashCode());
        Object $ignoreStoreReadErrorWithClusterBreakingPotential = this.getIgnoreStoreReadErrorWithClusterBreakingPotential();
        result = result * prime + ($ignoreStoreReadErrorWithClusterBreakingPotential == null ? 43 : $ignoreStoreReadErrorWithClusterBreakingPotential.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $orphanDependents = this.getOrphanDependents();
        result = result * prime + ($orphanDependents == null ? 43 : $orphanDependents.hashCode());
        Object $preconditions = this.getPreconditions();
        result = result * prime + ($preconditions == null ? 43 : $preconditions.hashCode());
        Object $propagationPolicy = this.getPropagationPolicy();
        result = result * prime + ($propagationPolicy == null ? 43 : $propagationPolicy.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DeleteOptions(" + "apiVersion=" + this.getApiVersion() + ", dryRun=" + this.getDryRun() + ", gracePeriodSeconds=" + this.getGracePeriodSeconds() + ", ignoreStoreReadErrorWithClusterBreakingPotential=" + this.getIgnoreStoreReadErrorWithClusterBreakingPotential() + ", kind=" + this.getKind() + ", orphanDependents=" + this.getOrphanDependents() + ", preconditions=" + this.getPreconditions() + ", propagationPolicy=" + this.getPropagationPolicy() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
