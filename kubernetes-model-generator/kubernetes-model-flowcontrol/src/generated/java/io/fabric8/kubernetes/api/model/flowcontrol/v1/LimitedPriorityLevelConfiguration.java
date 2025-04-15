
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * LimitedPriorityLevelConfiguration specifies how to handle requests that are subject to limits. It addresses two issues:<br><p>   - How are requests for this priority level limited?<br><p>   - What should be done with requests that exceed the limit?
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "borrowingLimitPercent",
    "lendablePercent",
    "limitResponse",
    "nominalConcurrencyShares"
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
public class LimitedPriorityLevelConfiguration implements Editable<LimitedPriorityLevelConfigurationBuilder>, KubernetesResource
{

    @JsonProperty("borrowingLimitPercent")
    private Integer borrowingLimitPercent;
    @JsonProperty("lendablePercent")
    private Integer lendablePercent;
    @JsonProperty("limitResponse")
    private LimitResponse limitResponse;
    @JsonProperty("nominalConcurrencyShares")
    private Integer nominalConcurrencyShares;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LimitedPriorityLevelConfiguration() {
    }

    public LimitedPriorityLevelConfiguration(Integer borrowingLimitPercent, Integer lendablePercent, LimitResponse limitResponse, Integer nominalConcurrencyShares) {
        super();
        this.borrowingLimitPercent = borrowingLimitPercent;
        this.lendablePercent = lendablePercent;
        this.limitResponse = limitResponse;
        this.nominalConcurrencyShares = nominalConcurrencyShares;
    }

    /**
     * `borrowingLimitPercent`, if present, configures a limit on how many seats this priority level can borrow from other priority levels. The limit is known as this level's BorrowingConcurrencyLimit (BorrowingCL) and is a limit on the total number of seats that this level may borrow at any one time. This field holds the ratio of that limit to the level's nominal concurrency limit. When this field is non-nil, it must hold a non-negative integer and the limit is calculated as follows.<br><p> <br><p> BorrowingCL(i) = round( NominalCL(i) &#42; borrowingLimitPercent(i)/100.0 )<br><p> <br><p> The value of this field can be more than 100, implying that this priority level can borrow a number of seats that is greater than its own nominal concurrency limit (NominalCL). When this field is left `nil`, the limit is effectively infinite.
     */
    @JsonProperty("borrowingLimitPercent")
    public Integer getBorrowingLimitPercent() {
        return borrowingLimitPercent;
    }

    /**
     * `borrowingLimitPercent`, if present, configures a limit on how many seats this priority level can borrow from other priority levels. The limit is known as this level's BorrowingConcurrencyLimit (BorrowingCL) and is a limit on the total number of seats that this level may borrow at any one time. This field holds the ratio of that limit to the level's nominal concurrency limit. When this field is non-nil, it must hold a non-negative integer and the limit is calculated as follows.<br><p> <br><p> BorrowingCL(i) = round( NominalCL(i) &#42; borrowingLimitPercent(i)/100.0 )<br><p> <br><p> The value of this field can be more than 100, implying that this priority level can borrow a number of seats that is greater than its own nominal concurrency limit (NominalCL). When this field is left `nil`, the limit is effectively infinite.
     */
    @JsonProperty("borrowingLimitPercent")
    public void setBorrowingLimitPercent(Integer borrowingLimitPercent) {
        this.borrowingLimitPercent = borrowingLimitPercent;
    }

    /**
     * `lendablePercent` prescribes the fraction of the level's NominalCL that can be borrowed by other priority levels. The value of this field must be between 0 and 100, inclusive, and it defaults to 0. The number of seats that other levels can borrow from this level, known as this level's LendableConcurrencyLimit (LendableCL), is defined as follows.<br><p> <br><p> LendableCL(i) = round( NominalCL(i) &#42; lendablePercent(i)/100.0 )
     */
    @JsonProperty("lendablePercent")
    public Integer getLendablePercent() {
        return lendablePercent;
    }

    /**
     * `lendablePercent` prescribes the fraction of the level's NominalCL that can be borrowed by other priority levels. The value of this field must be between 0 and 100, inclusive, and it defaults to 0. The number of seats that other levels can borrow from this level, known as this level's LendableConcurrencyLimit (LendableCL), is defined as follows.<br><p> <br><p> LendableCL(i) = round( NominalCL(i) &#42; lendablePercent(i)/100.0 )
     */
    @JsonProperty("lendablePercent")
    public void setLendablePercent(Integer lendablePercent) {
        this.lendablePercent = lendablePercent;
    }

    /**
     * LimitedPriorityLevelConfiguration specifies how to handle requests that are subject to limits. It addresses two issues:<br><p>   - How are requests for this priority level limited?<br><p>   - What should be done with requests that exceed the limit?
     */
    @JsonProperty("limitResponse")
    public LimitResponse getLimitResponse() {
        return limitResponse;
    }

    /**
     * LimitedPriorityLevelConfiguration specifies how to handle requests that are subject to limits. It addresses two issues:<br><p>   - How are requests for this priority level limited?<br><p>   - What should be done with requests that exceed the limit?
     */
    @JsonProperty("limitResponse")
    public void setLimitResponse(LimitResponse limitResponse) {
        this.limitResponse = limitResponse;
    }

    /**
     * `nominalConcurrencyShares` (NCS) contributes to the computation of the NominalConcurrencyLimit (NominalCL) of this level. This is the number of execution seats available at this priority level. This is used both for requests dispatched from this priority level as well as requests dispatched from other priority levels borrowing seats from this level. The server's concurrency limit (ServerCL) is divided among the Limited priority levels in proportion to their NCS values:<br><p> <br><p> NominalCL(i)  = ceil( ServerCL &#42; NCS(i) / sum_ncs ) sum_ncs = sum[priority level k] NCS(k)<br><p> <br><p> Bigger numbers mean a larger nominal concurrency limit, at the expense of every other priority level.<br><p> <br><p> If not specified, this field defaults to a value of 30.<br><p> <br><p> Setting this field to zero supports the construction of a "jail" for this priority level that is used to hold some request(s)
     */
    @JsonProperty("nominalConcurrencyShares")
    public Integer getNominalConcurrencyShares() {
        return nominalConcurrencyShares;
    }

    /**
     * `nominalConcurrencyShares` (NCS) contributes to the computation of the NominalConcurrencyLimit (NominalCL) of this level. This is the number of execution seats available at this priority level. This is used both for requests dispatched from this priority level as well as requests dispatched from other priority levels borrowing seats from this level. The server's concurrency limit (ServerCL) is divided among the Limited priority levels in proportion to their NCS values:<br><p> <br><p> NominalCL(i)  = ceil( ServerCL &#42; NCS(i) / sum_ncs ) sum_ncs = sum[priority level k] NCS(k)<br><p> <br><p> Bigger numbers mean a larger nominal concurrency limit, at the expense of every other priority level.<br><p> <br><p> If not specified, this field defaults to a value of 30.<br><p> <br><p> Setting this field to zero supports the construction of a "jail" for this priority level that is used to hold some request(s)
     */
    @JsonProperty("nominalConcurrencyShares")
    public void setNominalConcurrencyShares(Integer nominalConcurrencyShares) {
        this.nominalConcurrencyShares = nominalConcurrencyShares;
    }

    @JsonIgnore
    public LimitedPriorityLevelConfigurationBuilder edit() {
        return new LimitedPriorityLevelConfigurationBuilder(this);
    }

    @JsonIgnore
    public LimitedPriorityLevelConfigurationBuilder toBuilder() {
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
