
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
public class SubscriptionSpec implements KubernetesResource
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
     * 
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

    @JsonProperty("channel")
    public String getChannel() {
        return channel;
    }

    @JsonProperty("channel")
    public void setChannel(String channel) {
        this.channel = channel;
    }

    @JsonProperty("config")
    public SubscriptionConfig getConfig() {
        return config;
    }

    @JsonProperty("config")
    public void setConfig(SubscriptionConfig config) {
        this.config = config;
    }

    @JsonProperty("installPlanApproval")
    public String getInstallPlanApproval() {
        return installPlanApproval;
    }

    @JsonProperty("installPlanApproval")
    public void setInstallPlanApproval(String installPlanApproval) {
        this.installPlanApproval = installPlanApproval;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("sourceNamespace")
    public String getSourceNamespace() {
        return sourceNamespace;
    }

    @JsonProperty("sourceNamespace")
    public void setSourceNamespace(String sourceNamespace) {
        this.sourceNamespace = sourceNamespace;
    }

    @JsonProperty("startingCSV")
    public String getStartingCSV() {
        return startingCSV;
    }

    @JsonProperty("startingCSV")
    public void setStartingCSV(String startingCSV) {
        this.startingCSV = startingCSV;
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
