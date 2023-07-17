
package io.fabric8.chaosmesh.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "action",
    "address",
    "clock",
    "disk-fill",
    "disk-read-payload",
    "disk-write-payload",
    "duration",
    "jvm-exception",
    "jvm-gc",
    "jvm-latency",
    "jvm-return",
    "jvm-rule-data",
    "jvm-stress",
    "mode",
    "network-bandwidth",
    "network-corrupt",
    "network-delay",
    "network-dns",
    "network-duplicate",
    "network-loss",
    "network-partition",
    "process",
    "selector",
    "stress-cpu",
    "stress-mem",
    "uid",
    "value"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("jsonschema2pojo")
public class PhysicalMachineChaosSpec implements KubernetesResource
{

    @JsonProperty("action")
    private java.lang.String action;
    @JsonProperty("address")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> address = new ArrayList<java.lang.String>();
    @JsonProperty("clock")
    private ClockSpec clock;
    @JsonProperty("disk-fill")
    private DiskFillSpec diskFill;
    @JsonProperty("disk-read-payload")
    private DiskPayloadSpec diskReadPayload;
    @JsonProperty("disk-write-payload")
    private DiskPayloadSpec diskWritePayload;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("jvm-exception")
    private JVMExceptionSpec jvmException;
    @JsonProperty("jvm-gc")
    private JVMGCSpec jvmGc;
    @JsonProperty("jvm-latency")
    private JVMLatencySpec jvmLatency;
    @JsonProperty("jvm-return")
    private JVMReturnSpec jvmReturn;
    @JsonProperty("jvm-rule-data")
    private JVMRuleDataSpec jvmRuleData;
    @JsonProperty("jvm-stress")
    private JVMStressSpec jvmStress;
    @JsonProperty("mode")
    private java.lang.String mode;
    @JsonProperty("network-bandwidth")
    private NetworkBandwidthSpec networkBandwidth;
    @JsonProperty("network-corrupt")
    private NetworkCorruptSpec networkCorrupt;
    @JsonProperty("network-delay")
    private NetworkDelaySpec networkDelay;
    @JsonProperty("network-dns")
    private NetworkDNSSpec networkDns;
    @JsonProperty("network-duplicate")
    private NetworkDuplicateSpec networkDuplicate;
    @JsonProperty("network-loss")
    private NetworkLossSpec networkLoss;
    @JsonProperty("network-partition")
    private NetworkPartitionSpec networkPartition;
    @JsonProperty("process")
    private ProcessSpec process;
    @JsonProperty("selector")
    private PhysicalMachineSelectorSpec selector;
    @JsonProperty("stress-cpu")
    private StressCPUSpec stressCpu;
    @JsonProperty("stress-mem")
    private StressMemorySpec stressMem;
    @JsonProperty("uid")
    private java.lang.String uid;
    @JsonProperty("value")
    private java.lang.String value;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PhysicalMachineChaosSpec() {
    }

    public PhysicalMachineChaosSpec(java.lang.String action, List<java.lang.String> address, ClockSpec clock, DiskFillSpec diskFill, DiskPayloadSpec diskReadPayload, DiskPayloadSpec diskWritePayload, String duration, JVMExceptionSpec jvmException, JVMGCSpec jvmGc, JVMLatencySpec jvmLatency, JVMReturnSpec jvmReturn, JVMRuleDataSpec jvmRuleData, JVMStressSpec jvmStress, java.lang.String mode, NetworkBandwidthSpec networkBandwidth, NetworkCorruptSpec networkCorrupt, NetworkDelaySpec networkDelay, NetworkDNSSpec networkDns, NetworkDuplicateSpec networkDuplicate, NetworkLossSpec networkLoss, NetworkPartitionSpec networkPartition, ProcessSpec process, PhysicalMachineSelectorSpec selector, StressCPUSpec stressCpu, StressMemorySpec stressMem, java.lang.String uid, java.lang.String value) {
        super();
        this.action = action;
        this.address = address;
        this.clock = clock;
        this.diskFill = diskFill;
        this.diskReadPayload = diskReadPayload;
        this.diskWritePayload = diskWritePayload;
        this.duration = duration;
        this.jvmException = jvmException;
        this.jvmGc = jvmGc;
        this.jvmLatency = jvmLatency;
        this.jvmReturn = jvmReturn;
        this.jvmRuleData = jvmRuleData;
        this.jvmStress = jvmStress;
        this.mode = mode;
        this.networkBandwidth = networkBandwidth;
        this.networkCorrupt = networkCorrupt;
        this.networkDelay = networkDelay;
        this.networkDns = networkDns;
        this.networkDuplicate = networkDuplicate;
        this.networkLoss = networkLoss;
        this.networkPartition = networkPartition;
        this.process = process;
        this.selector = selector;
        this.stressCpu = stressCpu;
        this.stressMem = stressMem;
        this.uid = uid;
        this.value = value;
    }

    @JsonProperty("action")
    public java.lang.String getAction() {
        return action;
    }

    @JsonProperty("action")
    public void setAction(java.lang.String action) {
        this.action = action;
    }

    @JsonProperty("address")
    public List<java.lang.String> getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(List<java.lang.String> address) {
        this.address = address;
    }

    @JsonProperty("clock")
    public ClockSpec getClock() {
        return clock;
    }

    @JsonProperty("clock")
    public void setClock(ClockSpec clock) {
        this.clock = clock;
    }

    @JsonProperty("disk-fill")
    public DiskFillSpec getDiskFill() {
        return diskFill;
    }

    @JsonProperty("disk-fill")
    public void setDiskFill(DiskFillSpec diskFill) {
        this.diskFill = diskFill;
    }

    @JsonProperty("disk-read-payload")
    public DiskPayloadSpec getDiskReadPayload() {
        return diskReadPayload;
    }

    @JsonProperty("disk-read-payload")
    public void setDiskReadPayload(DiskPayloadSpec diskReadPayload) {
        this.diskReadPayload = diskReadPayload;
    }

    @JsonProperty("disk-write-payload")
    public DiskPayloadSpec getDiskWritePayload() {
        return diskWritePayload;
    }

    @JsonProperty("disk-write-payload")
    public void setDiskWritePayload(DiskPayloadSpec diskWritePayload) {
        this.diskWritePayload = diskWritePayload;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("jvm-exception")
    public JVMExceptionSpec getJvmException() {
        return jvmException;
    }

    @JsonProperty("jvm-exception")
    public void setJvmException(JVMExceptionSpec jvmException) {
        this.jvmException = jvmException;
    }

    @JsonProperty("jvm-gc")
    public JVMGCSpec getJvmGc() {
        return jvmGc;
    }

    @JsonProperty("jvm-gc")
    public void setJvmGc(JVMGCSpec jvmGc) {
        this.jvmGc = jvmGc;
    }

    @JsonProperty("jvm-latency")
    public JVMLatencySpec getJvmLatency() {
        return jvmLatency;
    }

    @JsonProperty("jvm-latency")
    public void setJvmLatency(JVMLatencySpec jvmLatency) {
        this.jvmLatency = jvmLatency;
    }

    @JsonProperty("jvm-return")
    public JVMReturnSpec getJvmReturn() {
        return jvmReturn;
    }

    @JsonProperty("jvm-return")
    public void setJvmReturn(JVMReturnSpec jvmReturn) {
        this.jvmReturn = jvmReturn;
    }

    @JsonProperty("jvm-rule-data")
    public JVMRuleDataSpec getJvmRuleData() {
        return jvmRuleData;
    }

    @JsonProperty("jvm-rule-data")
    public void setJvmRuleData(JVMRuleDataSpec jvmRuleData) {
        this.jvmRuleData = jvmRuleData;
    }

    @JsonProperty("jvm-stress")
    public JVMStressSpec getJvmStress() {
        return jvmStress;
    }

    @JsonProperty("jvm-stress")
    public void setJvmStress(JVMStressSpec jvmStress) {
        this.jvmStress = jvmStress;
    }

    @JsonProperty("mode")
    public java.lang.String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(java.lang.String mode) {
        this.mode = mode;
    }

    @JsonProperty("network-bandwidth")
    public NetworkBandwidthSpec getNetworkBandwidth() {
        return networkBandwidth;
    }

    @JsonProperty("network-bandwidth")
    public void setNetworkBandwidth(NetworkBandwidthSpec networkBandwidth) {
        this.networkBandwidth = networkBandwidth;
    }

    @JsonProperty("network-corrupt")
    public NetworkCorruptSpec getNetworkCorrupt() {
        return networkCorrupt;
    }

    @JsonProperty("network-corrupt")
    public void setNetworkCorrupt(NetworkCorruptSpec networkCorrupt) {
        this.networkCorrupt = networkCorrupt;
    }

    @JsonProperty("network-delay")
    public NetworkDelaySpec getNetworkDelay() {
        return networkDelay;
    }

    @JsonProperty("network-delay")
    public void setNetworkDelay(NetworkDelaySpec networkDelay) {
        this.networkDelay = networkDelay;
    }

    @JsonProperty("network-dns")
    public NetworkDNSSpec getNetworkDns() {
        return networkDns;
    }

    @JsonProperty("network-dns")
    public void setNetworkDns(NetworkDNSSpec networkDns) {
        this.networkDns = networkDns;
    }

    @JsonProperty("network-duplicate")
    public NetworkDuplicateSpec getNetworkDuplicate() {
        return networkDuplicate;
    }

    @JsonProperty("network-duplicate")
    public void setNetworkDuplicate(NetworkDuplicateSpec networkDuplicate) {
        this.networkDuplicate = networkDuplicate;
    }

    @JsonProperty("network-loss")
    public NetworkLossSpec getNetworkLoss() {
        return networkLoss;
    }

    @JsonProperty("network-loss")
    public void setNetworkLoss(NetworkLossSpec networkLoss) {
        this.networkLoss = networkLoss;
    }

    @JsonProperty("network-partition")
    public NetworkPartitionSpec getNetworkPartition() {
        return networkPartition;
    }

    @JsonProperty("network-partition")
    public void setNetworkPartition(NetworkPartitionSpec networkPartition) {
        this.networkPartition = networkPartition;
    }

    @JsonProperty("process")
    public ProcessSpec getProcess() {
        return process;
    }

    @JsonProperty("process")
    public void setProcess(ProcessSpec process) {
        this.process = process;
    }

    @JsonProperty("selector")
    public PhysicalMachineSelectorSpec getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(PhysicalMachineSelectorSpec selector) {
        this.selector = selector;
    }

    @JsonProperty("stress-cpu")
    public StressCPUSpec getStressCpu() {
        return stressCpu;
    }

    @JsonProperty("stress-cpu")
    public void setStressCpu(StressCPUSpec stressCpu) {
        this.stressCpu = stressCpu;
    }

    @JsonProperty("stress-mem")
    public StressMemorySpec getStressMem() {
        return stressMem;
    }

    @JsonProperty("stress-mem")
    public void setStressMem(StressMemorySpec stressMem) {
        this.stressMem = stressMem;
    }

    @JsonProperty("uid")
    public java.lang.String getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(java.lang.String uid) {
        this.uid = uid;
    }

    @JsonProperty("value")
    public java.lang.String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
