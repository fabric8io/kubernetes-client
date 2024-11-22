
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
public class SubscriptionStatus implements Editable<SubscriptionStatusBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("catalogHealth")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubscriptionCatalogHealth> getCatalogHealth() {
        return catalogHealth;
    }

    @JsonProperty("catalogHealth")
    public void setCatalogHealth(List<SubscriptionCatalogHealth> catalogHealth) {
        this.catalogHealth = catalogHealth;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubscriptionCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<SubscriptionCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("currentCSV")
    public String getCurrentCSV() {
        return currentCSV;
    }

    @JsonProperty("currentCSV")
    public void setCurrentCSV(String currentCSV) {
        this.currentCSV = currentCSV;
    }

    @JsonProperty("installPlanGeneration")
    public Integer getInstallPlanGeneration() {
        return installPlanGeneration;
    }

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

    @JsonProperty("installedCSV")
    public String getInstalledCSV() {
        return installedCSV;
    }

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

    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

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
