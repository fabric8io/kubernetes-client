
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "attenuatedServiceAccountRef",
    "bundleLookups",
    "catalogSources",
    "conditions",
    "phase",
    "plan"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class InstallPlanStatus implements KubernetesResource
{

    @JsonProperty("attenuatedServiceAccountRef")
    private io.fabric8.kubernetes.api.model.ObjectReference attenuatedServiceAccountRef;
    @JsonProperty("bundleLookups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BundleLookup> bundleLookups = new ArrayList<BundleLookup>();
    @JsonProperty("catalogSources")
    private List<String> catalogSources = new ArrayList<String>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<InstallPlanCondition> conditions = new ArrayList<InstallPlanCondition>();
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("plan")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Step> plan = new ArrayList<Step>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public InstallPlanStatus() {
    }

    /**
     * 
     * @param phase
     * @param bundleLookups
     * @param attenuatedServiceAccountRef
     * @param catalogSources
     * @param conditions
     * @param plan
     */
    public InstallPlanStatus(io.fabric8.kubernetes.api.model.ObjectReference attenuatedServiceAccountRef, List<BundleLookup> bundleLookups, List<String> catalogSources, List<InstallPlanCondition> conditions, String phase, List<Step> plan) {
        super();
        this.attenuatedServiceAccountRef = attenuatedServiceAccountRef;
        this.bundleLookups = bundleLookups;
        this.catalogSources = catalogSources;
        this.conditions = conditions;
        this.phase = phase;
        this.plan = plan;
    }

    @JsonProperty("attenuatedServiceAccountRef")
    public io.fabric8.kubernetes.api.model.ObjectReference getAttenuatedServiceAccountRef() {
        return attenuatedServiceAccountRef;
    }

    @JsonProperty("attenuatedServiceAccountRef")
    public void setAttenuatedServiceAccountRef(io.fabric8.kubernetes.api.model.ObjectReference attenuatedServiceAccountRef) {
        this.attenuatedServiceAccountRef = attenuatedServiceAccountRef;
    }

    @JsonProperty("bundleLookups")
    public List<BundleLookup> getBundleLookups() {
        return bundleLookups;
    }

    @JsonProperty("bundleLookups")
    public void setBundleLookups(List<BundleLookup> bundleLookups) {
        this.bundleLookups = bundleLookups;
    }

    @JsonProperty("catalogSources")
    public List<String> getCatalogSources() {
        return catalogSources;
    }

    @JsonProperty("catalogSources")
    public void setCatalogSources(List<String> catalogSources) {
        this.catalogSources = catalogSources;
    }

    @JsonProperty("conditions")
    public List<InstallPlanCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<InstallPlanCondition> conditions) {
        this.conditions = conditions;
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
    public List<Step> getPlan() {
        return plan;
    }

    @JsonProperty("plan")
    public void setPlan(List<Step> plan) {
        this.plan = plan;
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
