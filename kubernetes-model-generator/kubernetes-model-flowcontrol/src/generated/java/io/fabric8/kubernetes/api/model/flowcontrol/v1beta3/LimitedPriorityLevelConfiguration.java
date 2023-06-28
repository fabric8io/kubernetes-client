
package io.fabric8.kubernetes.api.model.flowcontrol.v1beta3;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
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
    "borrowingLimitPercent",
    "lendablePercent",
    "limitResponse",
    "nominalConcurrencyShares"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class LimitedPriorityLevelConfiguration implements KubernetesResource
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
     * 
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

    @JsonProperty("borrowingLimitPercent")
    public Integer getBorrowingLimitPercent() {
        return borrowingLimitPercent;
    }

    @JsonProperty("borrowingLimitPercent")
    public void setBorrowingLimitPercent(Integer borrowingLimitPercent) {
        this.borrowingLimitPercent = borrowingLimitPercent;
    }

    @JsonProperty("lendablePercent")
    public Integer getLendablePercent() {
        return lendablePercent;
    }

    @JsonProperty("lendablePercent")
    public void setLendablePercent(Integer lendablePercent) {
        this.lendablePercent = lendablePercent;
    }

    @JsonProperty("limitResponse")
    public LimitResponse getLimitResponse() {
        return limitResponse;
    }

    @JsonProperty("limitResponse")
    public void setLimitResponse(LimitResponse limitResponse) {
        this.limitResponse = limitResponse;
    }

    @JsonProperty("nominalConcurrencyShares")
    public Integer getNominalConcurrencyShares() {
        return nominalConcurrencyShares;
    }

    @JsonProperty("nominalConcurrencyShares")
    public void setNominalConcurrencyShares(Integer nominalConcurrencyShares) {
        this.nominalConcurrencyShares = nominalConcurrencyShares;
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
