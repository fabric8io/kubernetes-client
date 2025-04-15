
package io.fabric8.openshift.api.model.operatorhub.v1;

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
 * OperatorGroupSpec is the spec for an OperatorGroup resource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "selector",
    "serviceAccountName",
    "staticProvidedAPIs",
    "targetNamespaces",
    "upgradeStrategy"
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
public class OperatorGroupSpec implements Editable<OperatorGroupSpecBuilder>, KubernetesResource
{

    @JsonProperty("selector")
    private LabelSelector selector;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("staticProvidedAPIs")
    private Boolean staticProvidedAPIs;
    @JsonProperty("targetNamespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> targetNamespaces = new ArrayList<>();
    @JsonProperty("upgradeStrategy")
    private String upgradeStrategy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OperatorGroupSpec() {
    }

    public OperatorGroupSpec(LabelSelector selector, String serviceAccountName, Boolean staticProvidedAPIs, List<String> targetNamespaces, String upgradeStrategy) {
        super();
        this.selector = selector;
        this.serviceAccountName = serviceAccountName;
        this.staticProvidedAPIs = staticProvidedAPIs;
        this.targetNamespaces = targetNamespaces;
        this.upgradeStrategy = upgradeStrategy;
    }

    /**
     * OperatorGroupSpec is the spec for an OperatorGroup resource.
     */
    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    /**
     * OperatorGroupSpec is the spec for an OperatorGroup resource.
     */
    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    /**
     * ServiceAccountName is the admin specified service account which will be used to deploy operator(s) in this operator group.
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * ServiceAccountName is the admin specified service account which will be used to deploy operator(s) in this operator group.
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * Static tells OLM not to update the OperatorGroup's providedAPIs annotation
     */
    @JsonProperty("staticProvidedAPIs")
    public Boolean getStaticProvidedAPIs() {
        return staticProvidedAPIs;
    }

    /**
     * Static tells OLM not to update the OperatorGroup's providedAPIs annotation
     */
    @JsonProperty("staticProvidedAPIs")
    public void setStaticProvidedAPIs(Boolean staticProvidedAPIs) {
        this.staticProvidedAPIs = staticProvidedAPIs;
    }

    /**
     * TargetNamespaces is an explicit set of namespaces to target. If it is set, Selector is ignored.
     */
    @JsonProperty("targetNamespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTargetNamespaces() {
        return targetNamespaces;
    }

    /**
     * TargetNamespaces is an explicit set of namespaces to target. If it is set, Selector is ignored.
     */
    @JsonProperty("targetNamespaces")
    public void setTargetNamespaces(List<String> targetNamespaces) {
        this.targetNamespaces = targetNamespaces;
    }

    /**
     * UpgradeStrategy defines the upgrade strategy for operators in the namespace. There are currently two supported upgrade strategies:<br><p> <br><p> Default: OLM will only allow clusterServiceVersions to move to the replacing phase from the succeeded phase. This effectively means that OLM will not allow operators to move to the next version if an installation or upgrade has failed.<br><p> <br><p> TechPreviewUnsafeFailForward: OLM will allow clusterServiceVersions to move to the replacing phase from the succeeded phase or from the failed phase. Additionally, OLM will generate new installPlans when a subscription references a failed installPlan and the catalog has been updated with a new upgrade for the existing set of operators.<br><p> <br><p> WARNING: The TechPreviewUnsafeFailForward upgrade strategy is unsafe and may result in unexpected behavior or unrecoverable data loss unless you have deep understanding of the set of operators being managed in the namespace.
     */
    @JsonProperty("upgradeStrategy")
    public String getUpgradeStrategy() {
        return upgradeStrategy;
    }

    /**
     * UpgradeStrategy defines the upgrade strategy for operators in the namespace. There are currently two supported upgrade strategies:<br><p> <br><p> Default: OLM will only allow clusterServiceVersions to move to the replacing phase from the succeeded phase. This effectively means that OLM will not allow operators to move to the next version if an installation or upgrade has failed.<br><p> <br><p> TechPreviewUnsafeFailForward: OLM will allow clusterServiceVersions to move to the replacing phase from the succeeded phase or from the failed phase. Additionally, OLM will generate new installPlans when a subscription references a failed installPlan and the catalog has been updated with a new upgrade for the existing set of operators.<br><p> <br><p> WARNING: The TechPreviewUnsafeFailForward upgrade strategy is unsafe and may result in unexpected behavior or unrecoverable data loss unless you have deep understanding of the set of operators being managed in the namespace.
     */
    @JsonProperty("upgradeStrategy")
    public void setUpgradeStrategy(String upgradeStrategy) {
        this.upgradeStrategy = upgradeStrategy;
    }

    @JsonIgnore
    public OperatorGroupSpecBuilder edit() {
        return new OperatorGroupSpecBuilder(this);
    }

    @JsonIgnore
    public OperatorGroupSpecBuilder toBuilder() {
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
