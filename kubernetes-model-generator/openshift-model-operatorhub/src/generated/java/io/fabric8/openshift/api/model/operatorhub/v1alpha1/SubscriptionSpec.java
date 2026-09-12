
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SubscriptionSpec)) {
            return false;
        }
        SubscriptionSpec other = (SubscriptionSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$channel = this.getChannel();
        Object other$channel = other.getChannel();
        if (this$channel == null ? other$channel != null : !this$channel.equals(other$channel)) {
            return false;
        }
        Object this$config = this.getConfig();
        Object other$config = other.getConfig();
        if (this$config == null ? other$config != null : !this$config.equals(other$config)) {
            return false;
        }
        Object this$installPlanApproval = this.getInstallPlanApproval();
        Object other$installPlanApproval = other.getInstallPlanApproval();
        if (this$installPlanApproval == null ? other$installPlanApproval != null : !this$installPlanApproval.equals(other$installPlanApproval)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$source = this.getSource();
        Object other$source = other.getSource();
        if (this$source == null ? other$source != null : !this$source.equals(other$source)) {
            return false;
        }
        Object this$sourceNamespace = this.getSourceNamespace();
        Object other$sourceNamespace = other.getSourceNamespace();
        if (this$sourceNamespace == null ? other$sourceNamespace != null : !this$sourceNamespace.equals(other$sourceNamespace)) {
            return false;
        }
        Object this$startingCSV = this.getStartingCSV();
        Object other$startingCSV = other.getStartingCSV();
        if (this$startingCSV == null ? other$startingCSV != null : !this$startingCSV.equals(other$startingCSV)) {
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
        return other instanceof SubscriptionSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $channel = this.getChannel();
        result = result * prime + ($channel == null ? 43 : $channel.hashCode());
        Object $config = this.getConfig();
        result = result * prime + ($config == null ? 43 : $config.hashCode());
        Object $installPlanApproval = this.getInstallPlanApproval();
        result = result * prime + ($installPlanApproval == null ? 43 : $installPlanApproval.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $source = this.getSource();
        result = result * prime + ($source == null ? 43 : $source.hashCode());
        Object $sourceNamespace = this.getSourceNamespace();
        result = result * prime + ($sourceNamespace == null ? 43 : $sourceNamespace.hashCode());
        Object $startingCSV = this.getStartingCSV();
        result = result * prime + ($startingCSV == null ? 43 : $startingCSV.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SubscriptionSpec(" + "channel=" + this.getChannel() + ", config=" + this.getConfig() + ", installPlanApproval=" + this.getInstallPlanApproval() + ", name=" + this.getName() + ", source=" + this.getSource() + ", sourceNamespace=" + this.getSourceNamespace() + ", startingCSV=" + this.getStartingCSV() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
