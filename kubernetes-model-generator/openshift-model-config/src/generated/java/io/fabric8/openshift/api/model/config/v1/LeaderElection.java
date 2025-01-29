
package io.fabric8.openshift.api.model.config.v1;

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
 * LeaderElection provides information to elect a leader
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "disable",
    "leaseDuration",
    "name",
    "namespace",
    "renewDeadline",
    "retryPeriod"
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
public class LeaderElection implements Editable<LeaderElectionBuilder>, KubernetesResource
{

    @JsonProperty("disable")
    private Boolean disable;
    @JsonProperty("leaseDuration")
    private String leaseDuration;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("renewDeadline")
    private String renewDeadline;
    @JsonProperty("retryPeriod")
    private String retryPeriod;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LeaderElection() {
    }

    public LeaderElection(Boolean disable, String leaseDuration, String name, String namespace, String renewDeadline, String retryPeriod) {
        super();
        this.disable = disable;
        this.leaseDuration = leaseDuration;
        this.name = name;
        this.namespace = namespace;
        this.renewDeadline = renewDeadline;
        this.retryPeriod = retryPeriod;
    }

    /**
     * disable allows leader election to be suspended while allowing a fully defaulted "normal" startup case.
     */
    @JsonProperty("disable")
    public Boolean getDisable() {
        return disable;
    }

    /**
     * disable allows leader election to be suspended while allowing a fully defaulted "normal" startup case.
     */
    @JsonProperty("disable")
    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    /**
     * LeaderElection provides information to elect a leader
     */
    @JsonProperty("leaseDuration")
    public String getLeaseDuration() {
        return leaseDuration;
    }

    /**
     * LeaderElection provides information to elect a leader
     */
    @JsonProperty("leaseDuration")
    public void setLeaseDuration(String leaseDuration) {
        this.leaseDuration = leaseDuration;
    }

    /**
     * name indicates what name to use for the resource
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name indicates what name to use for the resource
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * namespace indicates which namespace the resource is in
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * namespace indicates which namespace the resource is in
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * LeaderElection provides information to elect a leader
     */
    @JsonProperty("renewDeadline")
    public String getRenewDeadline() {
        return renewDeadline;
    }

    /**
     * LeaderElection provides information to elect a leader
     */
    @JsonProperty("renewDeadline")
    public void setRenewDeadline(String renewDeadline) {
        this.renewDeadline = renewDeadline;
    }

    /**
     * LeaderElection provides information to elect a leader
     */
    @JsonProperty("retryPeriod")
    public String getRetryPeriod() {
        return retryPeriod;
    }

    /**
     * LeaderElection provides information to elect a leader
     */
    @JsonProperty("retryPeriod")
    public void setRetryPeriod(String retryPeriod) {
        this.retryPeriod = retryPeriod;
    }

    @JsonIgnore
    public LeaderElectionBuilder edit() {
        return new LeaderElectionBuilder(this);
    }

    @JsonIgnore
    public LeaderElectionBuilder toBuilder() {
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
