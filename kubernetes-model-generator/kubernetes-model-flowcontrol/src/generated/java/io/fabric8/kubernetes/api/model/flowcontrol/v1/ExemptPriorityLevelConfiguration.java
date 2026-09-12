
package io.fabric8.kubernetes.api.model.flowcontrol.v1;

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
 * ExemptPriorityLevelConfiguration describes the configurable aspects of the handling of exempt requests. In the mandatory exempt configuration object the values in the fields here can be modified by authorized users, unlike the rest of the `spec`.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lendablePercent",
    "nominalConcurrencyShares"
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
public class ExemptPriorityLevelConfiguration implements Editable<ExemptPriorityLevelConfigurationBuilder>, KubernetesResource
{

    @JsonProperty("lendablePercent")
    private Integer lendablePercent;
    @JsonProperty("nominalConcurrencyShares")
    private Integer nominalConcurrencyShares;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ExemptPriorityLevelConfiguration() {
    }

    public ExemptPriorityLevelConfiguration(Integer lendablePercent, Integer nominalConcurrencyShares) {
        super();
        this.lendablePercent = lendablePercent;
        this.nominalConcurrencyShares = nominalConcurrencyShares;
    }

    /**
     * `lendablePercent` prescribes the fraction of the level's NominalCL that can be borrowed by other priority levels.  This value of this field must be between 0 and 100, inclusive, and it defaults to 0. The number of seats that other levels can borrow from this level, known as this level's LendableConcurrencyLimit (LendableCL), is defined as follows.<br><p> <br><p> LendableCL(i) = round( NominalCL(i) &#42; lendablePercent(i)/100.0 )
     */
    @JsonProperty("lendablePercent")
    public Integer getLendablePercent() {
        return lendablePercent;
    }

    /**
     * `lendablePercent` prescribes the fraction of the level's NominalCL that can be borrowed by other priority levels.  This value of this field must be between 0 and 100, inclusive, and it defaults to 0. The number of seats that other levels can borrow from this level, known as this level's LendableConcurrencyLimit (LendableCL), is defined as follows.<br><p> <br><p> LendableCL(i) = round( NominalCL(i) &#42; lendablePercent(i)/100.0 )
     */
    @JsonProperty("lendablePercent")
    public void setLendablePercent(Integer lendablePercent) {
        this.lendablePercent = lendablePercent;
    }

    /**
     * `nominalConcurrencyShares` (NCS) contributes to the computation of the NominalConcurrencyLimit (NominalCL) of this level. This is the number of execution seats nominally reserved for this priority level. This DOES NOT limit the dispatching from this priority level but affects the other priority levels through the borrowing mechanism. The server's concurrency limit (ServerCL) is divided among all the priority levels in proportion to their NCS values:<br><p> <br><p> NominalCL(i)  = ceil( ServerCL &#42; NCS(i) / sum_ncs ) sum_ncs = sum[priority level k] NCS(k)<br><p> <br><p> Bigger numbers mean a larger nominal concurrency limit, at the expense of every other priority level. This field has a default value of zero.
     */
    @JsonProperty("nominalConcurrencyShares")
    public Integer getNominalConcurrencyShares() {
        return nominalConcurrencyShares;
    }

    /**
     * `nominalConcurrencyShares` (NCS) contributes to the computation of the NominalConcurrencyLimit (NominalCL) of this level. This is the number of execution seats nominally reserved for this priority level. This DOES NOT limit the dispatching from this priority level but affects the other priority levels through the borrowing mechanism. The server's concurrency limit (ServerCL) is divided among all the priority levels in proportion to their NCS values:<br><p> <br><p> NominalCL(i)  = ceil( ServerCL &#42; NCS(i) / sum_ncs ) sum_ncs = sum[priority level k] NCS(k)<br><p> <br><p> Bigger numbers mean a larger nominal concurrency limit, at the expense of every other priority level. This field has a default value of zero.
     */
    @JsonProperty("nominalConcurrencyShares")
    public void setNominalConcurrencyShares(Integer nominalConcurrencyShares) {
        this.nominalConcurrencyShares = nominalConcurrencyShares;
    }

    @JsonIgnore
    public ExemptPriorityLevelConfigurationBuilder edit() {
        return new ExemptPriorityLevelConfigurationBuilder(this);
    }

    @JsonIgnore
    public ExemptPriorityLevelConfigurationBuilder toBuilder() {
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
        if (!(o instanceof ExemptPriorityLevelConfiguration)) {
            return false;
        }
        ExemptPriorityLevelConfiguration other = (ExemptPriorityLevelConfiguration) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$lendablePercent = this.getLendablePercent();
        Object other$lendablePercent = other.getLendablePercent();
        if (this$lendablePercent == null ? other$lendablePercent != null : !this$lendablePercent.equals(other$lendablePercent)) {
            return false;
        }
        Object this$nominalConcurrencyShares = this.getNominalConcurrencyShares();
        Object other$nominalConcurrencyShares = other.getNominalConcurrencyShares();
        if (this$nominalConcurrencyShares == null ? other$nominalConcurrencyShares != null : !this$nominalConcurrencyShares.equals(other$nominalConcurrencyShares)) {
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
        return other instanceof ExemptPriorityLevelConfiguration;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $lendablePercent = this.getLendablePercent();
        result = result * prime + ($lendablePercent == null ? 43 : $lendablePercent.hashCode());
        Object $nominalConcurrencyShares = this.getNominalConcurrencyShares();
        result = result * prime + ($nominalConcurrencyShares == null ? 43 : $nominalConcurrencyShares.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ExemptPriorityLevelConfiguration(" + "lendablePercent=" + this.getLendablePercent() + ", nominalConcurrencyShares=" + this.getNominalConcurrencyShares() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
