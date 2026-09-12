
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
        if (!(o instanceof SubscriptionStatus)) {
            return false;
        }
        SubscriptionStatus other = (SubscriptionStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$catalogHealth = this.getCatalogHealth();
        Object other$catalogHealth = other.getCatalogHealth();
        if (this$catalogHealth == null ? other$catalogHealth != null : !this$catalogHealth.equals(other$catalogHealth)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$currentCSV = this.getCurrentCSV();
        Object other$currentCSV = other.getCurrentCSV();
        if (this$currentCSV == null ? other$currentCSV != null : !this$currentCSV.equals(other$currentCSV)) {
            return false;
        }
        Object this$installPlanGeneration = this.getInstallPlanGeneration();
        Object other$installPlanGeneration = other.getInstallPlanGeneration();
        if (this$installPlanGeneration == null ? other$installPlanGeneration != null : !this$installPlanGeneration.equals(other$installPlanGeneration)) {
            return false;
        }
        Object this$installPlanRef = this.getInstallPlanRef();
        Object other$installPlanRef = other.getInstallPlanRef();
        if (this$installPlanRef == null ? other$installPlanRef != null : !this$installPlanRef.equals(other$installPlanRef)) {
            return false;
        }
        Object this$installedCSV = this.getInstalledCSV();
        Object other$installedCSV = other.getInstalledCSV();
        if (this$installedCSV == null ? other$installedCSV != null : !this$installedCSV.equals(other$installedCSV)) {
            return false;
        }
        Object this$installplan = this.getInstallplan();
        Object other$installplan = other.getInstallplan();
        if (this$installplan == null ? other$installplan != null : !this$installplan.equals(other$installplan)) {
            return false;
        }
        Object this$lastUpdated = this.getLastUpdated();
        Object other$lastUpdated = other.getLastUpdated();
        if (this$lastUpdated == null ? other$lastUpdated != null : !this$lastUpdated.equals(other$lastUpdated)) {
            return false;
        }
        Object this$reason = this.getReason();
        Object other$reason = other.getReason();
        if (this$reason == null ? other$reason != null : !this$reason.equals(other$reason)) {
            return false;
        }
        Object this$state = this.getState();
        Object other$state = other.getState();
        if (this$state == null ? other$state != null : !this$state.equals(other$state)) {
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
        return other instanceof SubscriptionStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $catalogHealth = this.getCatalogHealth();
        result = result * prime + ($catalogHealth == null ? 43 : $catalogHealth.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $currentCSV = this.getCurrentCSV();
        result = result * prime + ($currentCSV == null ? 43 : $currentCSV.hashCode());
        Object $installPlanGeneration = this.getInstallPlanGeneration();
        result = result * prime + ($installPlanGeneration == null ? 43 : $installPlanGeneration.hashCode());
        Object $installPlanRef = this.getInstallPlanRef();
        result = result * prime + ($installPlanRef == null ? 43 : $installPlanRef.hashCode());
        Object $installedCSV = this.getInstalledCSV();
        result = result * prime + ($installedCSV == null ? 43 : $installedCSV.hashCode());
        Object $installplan = this.getInstallplan();
        result = result * prime + ($installplan == null ? 43 : $installplan.hashCode());
        Object $lastUpdated = this.getLastUpdated();
        result = result * prime + ($lastUpdated == null ? 43 : $lastUpdated.hashCode());
        Object $reason = this.getReason();
        result = result * prime + ($reason == null ? 43 : $reason.hashCode());
        Object $state = this.getState();
        result = result * prime + ($state == null ? 43 : $state.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SubscriptionStatus(" + "catalogHealth=" + this.getCatalogHealth() + ", conditions=" + this.getConditions() + ", currentCSV=" + this.getCurrentCSV() + ", installPlanGeneration=" + this.getInstallPlanGeneration() + ", installPlanRef=" + this.getInstallPlanRef() + ", installedCSV=" + this.getInstalledCSV() + ", installplan=" + this.getInstallplan() + ", lastUpdated=" + this.getLastUpdated() + ", reason=" + this.getReason() + ", state=" + this.getState() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
