
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "catalogHealth",
    "conditions",
    "currentCSV",
    "installPlanGeneration",
    "installPlanRef",
    "installedCSV",
    "installplan",
    "lastUpdated",
    "reason",
    "state"
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
public class SubscriptionStatus implements Editable<SubscriptionStatusBuilder>, KubernetesResource
{

    @JsonProperty("catalogHealth")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubscriptionCatalogHealth> catalogHealth = new ArrayList<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubscriptionCondition> conditions = new ArrayList<>();
    @JsonProperty("currentCSV")
    private String currentCSV;
    @JsonProperty("installPlanGeneration")
    private Integer installPlanGeneration;
    @JsonProperty("installPlanRef")
    private ObjectReference installPlanRef;
    @JsonProperty("installedCSV")
    private String installedCSV;
    @JsonProperty("installplan")
    private InstallPlanReference installplan;
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("state")
    private String state;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SubscriptionStatus() {
    }

    public SubscriptionStatus(List<SubscriptionCatalogHealth> catalogHealth, List<SubscriptionCondition> conditions, String currentCSV, Integer installPlanGeneration, ObjectReference installPlanRef, String installedCSV, InstallPlanReference installplan, String lastUpdated, String reason, String state) {
        super();
        this.catalogHealth = catalogHealth;
        this.conditions = conditions;
        this.currentCSV = currentCSV;
        this.installPlanGeneration = installPlanGeneration;
        this.installPlanRef = installPlanRef;
        this.installedCSV = installedCSV;
        this.installplan = installplan;
        this.lastUpdated = lastUpdated;
        this.reason = reason;
        this.state = state;
    }

    /**
     * CatalogHealth contains the Subscription's view of its relevant CatalogSources' status. It is used to determine SubscriptionStatusConditions related to CatalogSources.
     */
    @JsonProperty("catalogHealth")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubscriptionCatalogHealth> getCatalogHealth() {
        return catalogHealth;
    }

    /**
     * CatalogHealth contains the Subscription's view of its relevant CatalogSources' status. It is used to determine SubscriptionStatusConditions related to CatalogSources.
     */
    @JsonProperty("catalogHealth")
    public void setCatalogHealth(List<SubscriptionCatalogHealth> catalogHealth) {
        this.catalogHealth = catalogHealth;
    }

    /**
     * Conditions is a list of the latest available observations about a Subscription's current state.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubscriptionCondition> getConditions() {
        return conditions;
    }

    /**
     * Conditions is a list of the latest available observations about a Subscription's current state.
     */
    @JsonProperty("conditions")
    public void setConditions(List<SubscriptionCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * CurrentCSV is the CSV the Subscription is progressing to.
     */
    @JsonProperty("currentCSV")
    public String getCurrentCSV() {
        return currentCSV;
    }

    /**
     * CurrentCSV is the CSV the Subscription is progressing to.
     */
    @JsonProperty("currentCSV")
    public void setCurrentCSV(String currentCSV) {
        this.currentCSV = currentCSV;
    }

    /**
     * InstallPlanGeneration is the current generation of the installplan
     */
    @JsonProperty("installPlanGeneration")
    public Integer getInstallPlanGeneration() {
        return installPlanGeneration;
    }

    /**
     * InstallPlanGeneration is the current generation of the installplan
     */
    @JsonProperty("installPlanGeneration")
    public void setInstallPlanGeneration(Integer installPlanGeneration) {
        this.installPlanGeneration = installPlanGeneration;
    }

    @JsonProperty("installPlanRef")
    public ObjectReference getInstallPlanRef() {
        return installPlanRef;
    }

    @JsonProperty("installPlanRef")
    public void setInstallPlanRef(ObjectReference installPlanRef) {
        this.installPlanRef = installPlanRef;
    }

    /**
     * InstalledCSV is the CSV currently installed by the Subscription.
     */
    @JsonProperty("installedCSV")
    public String getInstalledCSV() {
        return installedCSV;
    }

    /**
     * InstalledCSV is the CSV currently installed by the Subscription.
     */
    @JsonProperty("installedCSV")
    public void setInstalledCSV(String installedCSV) {
        this.installedCSV = installedCSV;
    }

    @JsonProperty("installplan")
    public InstallPlanReference getInstallplan() {
        return installplan;
    }

    @JsonProperty("installplan")
    public void setInstallplan(InstallPlanReference installplan) {
        this.installplan = installplan;
    }

    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * Reason is the reason the Subscription was transitioned to its current state.
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * Reason is the reason the Subscription was transitioned to its current state.
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * State represents the current state of the Subscription
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * State represents the current state of the Subscription
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonIgnore
    public SubscriptionStatusBuilder edit() {
        return new SubscriptionStatusBuilder(this);
    }

    @JsonIgnore
    public SubscriptionStatusBuilder toBuilder() {
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
