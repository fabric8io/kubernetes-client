
package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

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
 * AutomationDef defines the automation to invoke.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "extra_vars",
    "jobTtl",
    "name",
    "policyViolationsLimit",
    "secret",
    "type"
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
public class AutomationDef implements Editable<AutomationDefBuilder>, KubernetesResource
{

    @JsonProperty("extra_vars")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object extraVars;
    @JsonProperty("jobTtl")
    private Integer jobTtl;
    @JsonProperty("name")
    private String name;
    @JsonProperty("policyViolationsLimit")
    private Integer policyViolationsLimit;
    @JsonProperty("secret")
    private String secret;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AutomationDef() {
    }

    public AutomationDef(Object extraVars, Integer jobTtl, String name, Integer policyViolationsLimit, String secret, String type) {
        super();
        this.extraVars = extraVars;
        this.jobTtl = jobTtl;
        this.name = name;
        this.policyViolationsLimit = policyViolationsLimit;
        this.secret = secret;
        this.type = type;
    }

    /**
     * AutomationDef defines the automation to invoke.
     */
    @JsonProperty("extra_vars")
    public Object getExtraVars() {
        return extraVars;
    }

    /**
     * AutomationDef defines the automation to invoke.
     */
    @JsonProperty("extra_vars")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setExtraVars(Object extraVars) {
        this.extraVars = extraVars;
    }

    /**
     * JobTTL sets the time to live for the Kubernetes Job object after the Ansible job playbook run has finished.
     */
    @JsonProperty("jobTtl")
    public Integer getJobTtl() {
        return jobTtl;
    }

    /**
     * JobTTL sets the time to live for the Kubernetes Job object after the Ansible job playbook run has finished.
     */
    @JsonProperty("jobTtl")
    public void setJobTtl(Integer jobTtl) {
        this.jobTtl = jobTtl;
    }

    /**
     * Name of the Ansible Template to run in Ansible Automation Platform as a job.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the Ansible Template to run in Ansible Automation Platform as a job.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The maximum number of violating cluster contexts that are provided to the Ansible job as extra variables. When policyViolationsLimit is set to "0", it means no limit. The default value is "1000".
     */
    @JsonProperty("policyViolationsLimit")
    public Integer getPolicyViolationsLimit() {
        return policyViolationsLimit;
    }

    /**
     * The maximum number of violating cluster contexts that are provided to the Ansible job as extra variables. When policyViolationsLimit is set to "0", it means no limit. The default value is "1000".
     */
    @JsonProperty("policyViolationsLimit")
    public void setPolicyViolationsLimit(Integer policyViolationsLimit) {
        this.policyViolationsLimit = policyViolationsLimit;
    }

    /**
     * TowerSecret is the name of the secret that contains the Ansible Automation Platform credential.
     */
    @JsonProperty("secret")
    public String getSecret() {
        return secret;
    }

    /**
     * TowerSecret is the name of the secret that contains the Ansible Automation Platform credential.
     */
    @JsonProperty("secret")
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * Type of the automation to invoke
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type of the automation to invoke
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public AutomationDefBuilder edit() {
        return new AutomationDefBuilder(this);
    }

    @JsonIgnore
    public AutomationDefBuilder toBuilder() {
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
        if (!(o instanceof AutomationDef)) {
            return false;
        }
        AutomationDef other = (AutomationDef) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$extraVars = this.getExtraVars();
        Object other$extraVars = other.getExtraVars();
        if (this$extraVars == null ? other$extraVars != null : !this$extraVars.equals(other$extraVars)) {
            return false;
        }
        Object this$jobTtl = this.getJobTtl();
        Object other$jobTtl = other.getJobTtl();
        if (this$jobTtl == null ? other$jobTtl != null : !this$jobTtl.equals(other$jobTtl)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$policyViolationsLimit = this.getPolicyViolationsLimit();
        Object other$policyViolationsLimit = other.getPolicyViolationsLimit();
        if (this$policyViolationsLimit == null ? other$policyViolationsLimit != null : !this$policyViolationsLimit.equals(other$policyViolationsLimit)) {
            return false;
        }
        Object this$secret = this.getSecret();
        Object other$secret = other.getSecret();
        if (this$secret == null ? other$secret != null : !this$secret.equals(other$secret)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof AutomationDef;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $extraVars = this.getExtraVars();
        result = result * prime + ($extraVars == null ? 43 : $extraVars.hashCode());
        Object $jobTtl = this.getJobTtl();
        result = result * prime + ($jobTtl == null ? 43 : $jobTtl.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $policyViolationsLimit = this.getPolicyViolationsLimit();
        result = result * prime + ($policyViolationsLimit == null ? 43 : $policyViolationsLimit.hashCode());
        Object $secret = this.getSecret();
        result = result * prime + ($secret == null ? 43 : $secret.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AutomationDef(" + "extraVars=" + this.getExtraVars() + ", jobTtl=" + this.getJobTtl() + ", name=" + this.getName() + ", policyViolationsLimit=" + this.getPolicyViolationsLimit() + ", secret=" + this.getSecret() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
