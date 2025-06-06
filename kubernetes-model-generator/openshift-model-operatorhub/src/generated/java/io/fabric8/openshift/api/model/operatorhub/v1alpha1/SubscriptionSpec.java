
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
 * SubscriptionSpec defines an Application that can be installed
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "channel",
    "config",
    "installPlanApproval",
    "name",
    "source",
    "sourceNamespace",
    "startingCSV"
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
public class SubscriptionSpec implements Editable<SubscriptionSpecBuilder>, KubernetesResource
{

    @JsonProperty("channel")
    private String channel;
    @JsonProperty("config")
    private SubscriptionConfig config;
    @JsonProperty("installPlanApproval")
    private String installPlanApproval;
    @JsonProperty("name")
    private String name;
    @JsonProperty("source")
    private String source;
    @JsonProperty("sourceNamespace")
    private String sourceNamespace;
    @JsonProperty("startingCSV")
    private String startingCSV;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SubscriptionSpec() {
    }

    public SubscriptionSpec(String channel, SubscriptionConfig config, String installPlanApproval, String name, String source, String sourceNamespace, String startingCSV) {
        super();
        this.channel = channel;
        this.config = config;
        this.installPlanApproval = installPlanApproval;
        this.name = name;
        this.source = source;
        this.sourceNamespace = sourceNamespace;
        this.startingCSV = startingCSV;
    }

    /**
     * SubscriptionSpec defines an Application that can be installed
     */
    @JsonProperty("channel")
    public String getChannel() {
        return channel;
    }

    /**
     * SubscriptionSpec defines an Application that can be installed
     */
    @JsonProperty("channel")
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * SubscriptionSpec defines an Application that can be installed
     */
    @JsonProperty("config")
    public SubscriptionConfig getConfig() {
        return config;
    }

    /**
     * SubscriptionSpec defines an Application that can be installed
     */
    @JsonProperty("config")
    public void setConfig(SubscriptionConfig config) {
        this.config = config;
    }

    /**
     * SubscriptionSpec defines an Application that can be installed
     */
    @JsonProperty("installPlanApproval")
    public String getInstallPlanApproval() {
        return installPlanApproval;
    }

    /**
     * SubscriptionSpec defines an Application that can be installed
     */
    @JsonProperty("installPlanApproval")
    public void setInstallPlanApproval(String installPlanApproval) {
        this.installPlanApproval = installPlanApproval;
    }

    /**
     * SubscriptionSpec defines an Application that can be installed
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * SubscriptionSpec defines an Application that can be installed
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * SubscriptionSpec defines an Application that can be installed
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * SubscriptionSpec defines an Application that can be installed
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * SubscriptionSpec defines an Application that can be installed
     */
    @JsonProperty("sourceNamespace")
    public String getSourceNamespace() {
        return sourceNamespace;
    }

    /**
     * SubscriptionSpec defines an Application that can be installed
     */
    @JsonProperty("sourceNamespace")
    public void setSourceNamespace(String sourceNamespace) {
        this.sourceNamespace = sourceNamespace;
    }

    /**
     * SubscriptionSpec defines an Application that can be installed
     */
    @JsonProperty("startingCSV")
    public String getStartingCSV() {
        return startingCSV;
    }

    /**
     * SubscriptionSpec defines an Application that can be installed
     */
    @JsonProperty("startingCSV")
    public void setStartingCSV(String startingCSV) {
        this.startingCSV = startingCSV;
    }

    @JsonIgnore
    public SubscriptionSpecBuilder edit() {
        return new SubscriptionSpecBuilder(this);
    }

    @JsonIgnore
    public SubscriptionSpecBuilder toBuilder() {
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
