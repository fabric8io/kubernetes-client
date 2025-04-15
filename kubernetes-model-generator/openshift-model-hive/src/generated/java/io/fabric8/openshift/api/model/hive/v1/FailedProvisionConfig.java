
package io.fabric8.openshift.api.model.hive.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * FailedProvisionConfig contains settings to control behavior undertaken by Hive when an installation attempt fails.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aws",
    "retryReasons",
    "skipGatherLogs"
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
public class FailedProvisionConfig implements Editable<FailedProvisionConfigBuilder>, KubernetesResource
{

    @JsonProperty("aws")
    private FailedProvisionAWSConfig aws;
    @JsonProperty("retryReasons")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> retryReasons = new ArrayList<>();
    @JsonProperty("skipGatherLogs")
    private Boolean skipGatherLogs;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FailedProvisionConfig() {
    }

    public FailedProvisionConfig(FailedProvisionAWSConfig aws, List<String> retryReasons, Boolean skipGatherLogs) {
        super();
        this.aws = aws;
        this.retryReasons = retryReasons;
        this.skipGatherLogs = skipGatherLogs;
    }

    /**
     * FailedProvisionConfig contains settings to control behavior undertaken by Hive when an installation attempt fails.
     */
    @JsonProperty("aws")
    public FailedProvisionAWSConfig getAws() {
        return aws;
    }

    /**
     * FailedProvisionConfig contains settings to control behavior undertaken by Hive when an installation attempt fails.
     */
    @JsonProperty("aws")
    public void setAws(FailedProvisionAWSConfig aws) {
        this.aws = aws;
    }

    /**
     * RetryReasons is a list of installFailingReason strings from the [additional-]install-log-regexes ConfigMaps. If specified, Hive will only retry a failed installation if it results in one of the listed reasons. If omitted (not the same thing as empty!), Hive will retry regardless of the failure reason. (The total number of install attempts is still constrained by ClusterDeployment.Spec.InstallAttemptsLimit.)
     */
    @JsonProperty("retryReasons")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRetryReasons() {
        return retryReasons;
    }

    /**
     * RetryReasons is a list of installFailingReason strings from the [additional-]install-log-regexes ConfigMaps. If specified, Hive will only retry a failed installation if it results in one of the listed reasons. If omitted (not the same thing as empty!), Hive will retry regardless of the failure reason. (The total number of install attempts is still constrained by ClusterDeployment.Spec.InstallAttemptsLimit.)
     */
    @JsonProperty("retryReasons")
    public void setRetryReasons(List<String> retryReasons) {
        this.retryReasons = retryReasons;
    }

    /**
     * DEPRECATED: This flag is no longer respected and will be removed in the future.
     */
    @JsonProperty("skipGatherLogs")
    public Boolean getSkipGatherLogs() {
        return skipGatherLogs;
    }

    /**
     * DEPRECATED: This flag is no longer respected and will be removed in the future.
     */
    @JsonProperty("skipGatherLogs")
    public void setSkipGatherLogs(Boolean skipGatherLogs) {
        this.skipGatherLogs = skipGatherLogs;
    }

    @JsonIgnore
    public FailedProvisionConfigBuilder edit() {
        return new FailedProvisionConfigBuilder(this);
    }

    @JsonIgnore
    public FailedProvisionConfigBuilder toBuilder() {
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
