
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
import io.fabric8.kubernetes.api.builder.Editable;
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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attenuatedServiceAccountRef",
    "bundleLookups",
    "catalogSources",
    "conditions",
    "message",
    "phase",
    "plan",
    "startTime"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class InstallPlanStatus implements Editable<InstallPlanStatusBuilder> , KubernetesResource
{

    @JsonProperty("attenuatedServiceAccountRef")
    private InstallPlanStatusAttenuatedServiceAccountRef attenuatedServiceAccountRef;
    @JsonProperty("bundleLookups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<InstallPlanStatusBundleLookups> bundleLookups = new ArrayList<>();
    @JsonProperty("catalogSources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> catalogSources = new ArrayList<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<InstallPlanStatusConditions> conditions = new ArrayList<>();
    @JsonProperty("message")
    private String message;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("plan")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<InstallPlanStatusPlan> plan = new ArrayList<>();
    @JsonProperty("startTime")
    private String startTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public InstallPlanStatus() {
    }

    public InstallPlanStatus(InstallPlanStatusAttenuatedServiceAccountRef attenuatedServiceAccountRef, List<InstallPlanStatusBundleLookups> bundleLookups, List<String> catalogSources, List<InstallPlanStatusConditions> conditions, String message, String phase, List<InstallPlanStatusPlan> plan, String startTime) {
        super();
        this.attenuatedServiceAccountRef = attenuatedServiceAccountRef;
        this.bundleLookups = bundleLookups;
        this.catalogSources = catalogSources;
        this.conditions = conditions;
        this.message = message;
        this.phase = phase;
        this.plan = plan;
        this.startTime = startTime;
    }

    @JsonProperty("attenuatedServiceAccountRef")
    public InstallPlanStatusAttenuatedServiceAccountRef getAttenuatedServiceAccountRef() {
        return attenuatedServiceAccountRef;
    }

    @JsonProperty("attenuatedServiceAccountRef")
    public void setAttenuatedServiceAccountRef(InstallPlanStatusAttenuatedServiceAccountRef attenuatedServiceAccountRef) {
        this.attenuatedServiceAccountRef = attenuatedServiceAccountRef;
    }

    @JsonProperty("bundleLookups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<InstallPlanStatusBundleLookups> getBundleLookups() {
        return bundleLookups;
    }

    @JsonProperty("bundleLookups")
    public void setBundleLookups(List<InstallPlanStatusBundleLookups> bundleLookups) {
        this.bundleLookups = bundleLookups;
    }

    @JsonProperty("catalogSources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCatalogSources() {
        return catalogSources;
    }

    @JsonProperty("catalogSources")
    public void setCatalogSources(List<String> catalogSources) {
        this.catalogSources = catalogSources;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<InstallPlanStatusConditions> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<InstallPlanStatusConditions> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    @JsonProperty("plan")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<InstallPlanStatusPlan> getPlan() {
        return plan;
    }

    @JsonProperty("plan")
    public void setPlan(List<InstallPlanStatusPlan> plan) {
        this.plan = plan;
    }

    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonIgnore
    public InstallPlanStatusBuilder edit() {
        return new InstallPlanStatusBuilder(this);
    }

    @JsonIgnore
    public InstallPlanStatusBuilder toBuilder() {
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
