
package io.fabric8.openshift.api.model.operator.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "destination",
    "maxFileSize",
    "maxLogFiles",
    "rateLimit",
    "syslogFacility"
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
public class PolicyAuditConfig implements Editable<PolicyAuditConfigBuilder>, KubernetesResource
{

    @JsonProperty("destination")
    private String destination;
    @JsonProperty("maxFileSize")
    private Long maxFileSize;
    @JsonProperty("maxLogFiles")
    private Integer maxLogFiles;
    @JsonProperty("rateLimit")
    private Long rateLimit;
    @JsonProperty("syslogFacility")
    private String syslogFacility;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PolicyAuditConfig() {
    }

    public PolicyAuditConfig(String destination, Long maxFileSize, Integer maxLogFiles, Long rateLimit, String syslogFacility) {
        super();
        this.destination = destination;
        this.maxFileSize = maxFileSize;
        this.maxLogFiles = maxLogFiles;
        this.rateLimit = rateLimit;
        this.syslogFacility = syslogFacility;
    }

    /**
     * destination is the location for policy log messages. Regardless of this config, persistent logs will always be dumped to the host at /var/log/ovn/ however Additionally syslog output may be configured as follows. Valid values are: - "libc" -&gt; to use the libc syslog() function of the host node's journdald process - "udp:host:port" -&gt; for sending syslog over UDP - "unix:file" -&gt; for using the UNIX domain socket directly - "null" -&gt; to discard all messages logged to syslog The default is "null"
     */
    @JsonProperty("destination")
    public String getDestination() {
        return destination;
    }

    /**
     * destination is the location for policy log messages. Regardless of this config, persistent logs will always be dumped to the host at /var/log/ovn/ however Additionally syslog output may be configured as follows. Valid values are: - "libc" -&gt; to use the libc syslog() function of the host node's journdald process - "udp:host:port" -&gt; for sending syslog over UDP - "unix:file" -&gt; for using the UNIX domain socket directly - "null" -&gt; to discard all messages logged to syslog The default is "null"
     */
    @JsonProperty("destination")
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * maxFilesSize is the max size an ACL_audit log file is allowed to reach before rotation occurs Units are in MB and the Default is 50MB
     */
    @JsonProperty("maxFileSize")
    public Long getMaxFileSize() {
        return maxFileSize;
    }

    /**
     * maxFilesSize is the max size an ACL_audit log file is allowed to reach before rotation occurs Units are in MB and the Default is 50MB
     */
    @JsonProperty("maxFileSize")
    public void setMaxFileSize(Long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    /**
     * maxLogFiles specifies the maximum number of ACL_audit log files that can be present.
     */
    @JsonProperty("maxLogFiles")
    public Integer getMaxLogFiles() {
        return maxLogFiles;
    }

    /**
     * maxLogFiles specifies the maximum number of ACL_audit log files that can be present.
     */
    @JsonProperty("maxLogFiles")
    public void setMaxLogFiles(Integer maxLogFiles) {
        this.maxLogFiles = maxLogFiles;
    }

    /**
     * rateLimit is the approximate maximum number of messages to generate per-second per-node. If unset the default of 20 msg/sec is used.
     */
    @JsonProperty("rateLimit")
    public Long getRateLimit() {
        return rateLimit;
    }

    /**
     * rateLimit is the approximate maximum number of messages to generate per-second per-node. If unset the default of 20 msg/sec is used.
     */
    @JsonProperty("rateLimit")
    public void setRateLimit(Long rateLimit) {
        this.rateLimit = rateLimit;
    }

    /**
     * syslogFacility the RFC5424 facility for generated messages, e.g. "kern". Default is "local0"
     */
    @JsonProperty("syslogFacility")
    public String getSyslogFacility() {
        return syslogFacility;
    }

    /**
     * syslogFacility the RFC5424 facility for generated messages, e.g. "kern". Default is "local0"
     */
    @JsonProperty("syslogFacility")
    public void setSyslogFacility(String syslogFacility) {
        this.syslogFacility = syslogFacility;
    }

    @JsonIgnore
    public PolicyAuditConfigBuilder edit() {
        return new PolicyAuditConfigBuilder(this);
    }

    @JsonIgnore
    public PolicyAuditConfigBuilder toBuilder() {
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
        if (!(o instanceof PolicyAuditConfig)) {
            return false;
        }
        PolicyAuditConfig other = (PolicyAuditConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$destination = this.getDestination();
        Object other$destination = other.getDestination();
        if (this$destination == null ? other$destination != null : !this$destination.equals(other$destination)) {
            return false;
        }
        Object this$maxFileSize = this.getMaxFileSize();
        Object other$maxFileSize = other.getMaxFileSize();
        if (this$maxFileSize == null ? other$maxFileSize != null : !this$maxFileSize.equals(other$maxFileSize)) {
            return false;
        }
        Object this$maxLogFiles = this.getMaxLogFiles();
        Object other$maxLogFiles = other.getMaxLogFiles();
        if (this$maxLogFiles == null ? other$maxLogFiles != null : !this$maxLogFiles.equals(other$maxLogFiles)) {
            return false;
        }
        Object this$rateLimit = this.getRateLimit();
        Object other$rateLimit = other.getRateLimit();
        if (this$rateLimit == null ? other$rateLimit != null : !this$rateLimit.equals(other$rateLimit)) {
            return false;
        }
        Object this$syslogFacility = this.getSyslogFacility();
        Object other$syslogFacility = other.getSyslogFacility();
        if (this$syslogFacility == null ? other$syslogFacility != null : !this$syslogFacility.equals(other$syslogFacility)) {
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
        return other instanceof PolicyAuditConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $destination = this.getDestination();
        result = result * prime + ($destination == null ? 43 : $destination.hashCode());
        Object $maxFileSize = this.getMaxFileSize();
        result = result * prime + ($maxFileSize == null ? 43 : $maxFileSize.hashCode());
        Object $maxLogFiles = this.getMaxLogFiles();
        result = result * prime + ($maxLogFiles == null ? 43 : $maxLogFiles.hashCode());
        Object $rateLimit = this.getRateLimit();
        result = result * prime + ($rateLimit == null ? 43 : $rateLimit.hashCode());
        Object $syslogFacility = this.getSyslogFacility();
        result = result * prime + ($syslogFacility == null ? 43 : $syslogFacility.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PolicyAuditConfig(" + "destination=" + this.getDestination() + ", maxFileSize=" + this.getMaxFileSize() + ", maxLogFiles=" + this.getMaxLogFiles() + ", rateLimit=" + this.getRateLimit() + ", syslogFacility=" + this.getSyslogFacility() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
