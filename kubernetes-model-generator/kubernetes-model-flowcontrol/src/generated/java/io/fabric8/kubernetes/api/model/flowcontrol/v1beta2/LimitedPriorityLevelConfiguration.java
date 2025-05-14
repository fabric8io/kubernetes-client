
package io.fabric8.kubernetes.api.model.flowcontrol.v1beta2;

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
    "assuredConcurrencyShares",
    "borrowingLimitPercent",
    "lendablePercent",
    "limitResponse"
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

    @JsonProperty("assuredConcurrencyShares")
    private Integer assuredConcurrencyShares;
    @JsonProperty("borrowingLimitPercent")
    private Integer borrowingLimitPercent;
    @JsonProperty("lendablePercent")
    private Integer lendablePercent;
    @JsonProperty("limitResponse")
    private LimitResponse limitResponse;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LimitedPriorityLevelConfiguration() {
    }

    public LimitedPriorityLevelConfiguration(Integer assuredConcurrencyShares, Integer borrowingLimitPercent, Integer lendablePercent, LimitResponse limitResponse) {
        super();
        this.assuredConcurrencyShares = assuredConcurrencyShares;
        this.borrowingLimitPercent = borrowingLimitPercent;
        this.lendablePercent = lendablePercent;
        this.limitResponse = limitResponse;
    }

    /**
     * `assuredConcurrencyShares` (ACS) configures the execution limit, which is a limit on the number of requests of this priority level that may be exeucting at a given time.  ACS must be a positive number. The server's concurrency limit (SCL) is divided among the concurrency-controlled priority levels in proportion to their assured concurrency shares. This produces the assured concurrency value (ACV) --- the number of requests that may be executing at a time --- for each such priority level:<br><p> <br><p>             ACV(l) = ceil( SCL &#42; ACS(l) / ( sum[priority levels k] ACS(k) ) )<br><p> <br><p> bigger numbers of ACS mean more reserved concurrent requests (at the expense of every other PL). This field has a default value of 30.
     */
    @JsonProperty("assuredConcurrencyShares")
    public Integer getAssuredConcurrencyShares() {
        return assuredConcurrencyShares;
    }

    /**
     * `assuredConcurrencyShares` (ACS) configures the execution limit, which is a limit on the number of requests of this priority level that may be exeucting at a given time.  ACS must be a positive number. The server's concurrency limit (SCL) is divided among the concurrency-controlled priority levels in proportion to their assured concurrency shares. This produces the assured concurrency value (ACV) --- the number of requests that may be executing at a time --- for each such priority level:<br><p> <br><p>             ACV(l) = ceil( SCL &#42; ACS(l) / ( sum[priority levels k] ACS(k) ) )<br><p> <br><p> bigger numbers of ACS mean more reserved concurrent requests (at the expense of every other PL). This field has a default value of 30.
     */
    @JsonProperty("assuredConcurrencyShares")
    public void setAssuredConcurrencyShares(Integer assuredConcurrencyShares) {
        this.assuredConcurrencyShares = assuredConcurrencyShares;
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

    @JsonIgnore
    public LimitedPriorityLevelConfigurationBuilder edit() {
        return new LimitedPriorityLevelConfigurationBuilder(this);
    }

    @JsonIgnore
    public LimitedPriorityLevelConfigurationBuilder toBuilder() {
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
