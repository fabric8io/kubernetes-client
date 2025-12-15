
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
 * SysctlConfig specifies the settings for Linux agent nodes.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fsAioMaxNr",
    "fsFileMax",
    "fsInotifyMaxUserWatches",
    "fsNrOpen",
    "kernelThreadsMax",
    "netCoreNetdevMaxBacklog",
    "netCoreOptmemMax",
    "netCoreRmemDefault",
    "netCoreRmemMax",
    "netCoreSomaxconn",
    "netCoreWmemDefault",
    "netCoreWmemMax",
    "netIpv4IPLocalPortRange",
    "netIpv4NeighDefaultGcThresh1",
    "netIpv4NeighDefaultGcThresh2",
    "netIpv4NeighDefaultGcThresh3",
    "netIpv4TCPFinTimeout",
    "netIpv4TCPKeepaliveProbes",
    "netIpv4TCPKeepaliveTime",
    "netIpv4TCPMaxSynBacklog",
    "netIpv4TCPMaxTwBuckets",
    "netIpv4TCPTwReuse",
    "netIpv4TCPkeepaliveIntvl",
    "netNetfilterNfConntrackBuckets",
    "netNetfilterNfConntrackMax",
    "vmMaxMapCount",
    "vmSwappiness",
    "vmVfsCachePressure"
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
public class SysctlConfig implements Editable<SysctlConfigBuilder>, KubernetesResource
{

    @JsonProperty("fsAioMaxNr")
    private Integer fsAioMaxNr;
    @JsonProperty("fsFileMax")
    private Integer fsFileMax;
    @JsonProperty("fsInotifyMaxUserWatches")
    private Integer fsInotifyMaxUserWatches;
    @JsonProperty("fsNrOpen")
    private Integer fsNrOpen;
    @JsonProperty("kernelThreadsMax")
    private Integer kernelThreadsMax;
    @JsonProperty("netCoreNetdevMaxBacklog")
    private Integer netCoreNetdevMaxBacklog;
    @JsonProperty("netCoreOptmemMax")
    private Integer netCoreOptmemMax;
    @JsonProperty("netCoreRmemDefault")
    private Integer netCoreRmemDefault;
    @JsonProperty("netCoreRmemMax")
    private Integer netCoreRmemMax;
    @JsonProperty("netCoreSomaxconn")
    private Integer netCoreSomaxconn;
    @JsonProperty("netCoreWmemDefault")
    private Integer netCoreWmemDefault;
    @JsonProperty("netCoreWmemMax")
    private Integer netCoreWmemMax;
    @JsonProperty("netIpv4IPLocalPortRange")
    private String netIpv4IPLocalPortRange;
    @JsonProperty("netIpv4NeighDefaultGcThresh1")
    private Integer netIpv4NeighDefaultGcThresh1;
    @JsonProperty("netIpv4NeighDefaultGcThresh2")
    private Integer netIpv4NeighDefaultGcThresh2;
    @JsonProperty("netIpv4NeighDefaultGcThresh3")
    private Integer netIpv4NeighDefaultGcThresh3;
    @JsonProperty("netIpv4TCPFinTimeout")
    private Integer netIpv4TCPFinTimeout;
    @JsonProperty("netIpv4TCPKeepaliveProbes")
    private Integer netIpv4TCPKeepaliveProbes;
    @JsonProperty("netIpv4TCPKeepaliveTime")
    private Integer netIpv4TCPKeepaliveTime;
    @JsonProperty("netIpv4TCPMaxSynBacklog")
    private Integer netIpv4TCPMaxSynBacklog;
    @JsonProperty("netIpv4TCPMaxTwBuckets")
    private Integer netIpv4TCPMaxTwBuckets;
    @JsonProperty("netIpv4TCPTwReuse")
    private Boolean netIpv4TCPTwReuse;
    @JsonProperty("netIpv4TCPkeepaliveIntvl")
    private Integer netIpv4TCPkeepaliveIntvl;
    @JsonProperty("netNetfilterNfConntrackBuckets")
    private Integer netNetfilterNfConntrackBuckets;
    @JsonProperty("netNetfilterNfConntrackMax")
    private Integer netNetfilterNfConntrackMax;
    @JsonProperty("vmMaxMapCount")
    private Integer vmMaxMapCount;
    @JsonProperty("vmSwappiness")
    private Integer vmSwappiness;
    @JsonProperty("vmVfsCachePressure")
    private Integer vmVfsCachePressure;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SysctlConfig() {
    }

    public SysctlConfig(Integer fsAioMaxNr, Integer fsFileMax, Integer fsInotifyMaxUserWatches, Integer fsNrOpen, Integer kernelThreadsMax, Integer netCoreNetdevMaxBacklog, Integer netCoreOptmemMax, Integer netCoreRmemDefault, Integer netCoreRmemMax, Integer netCoreSomaxconn, Integer netCoreWmemDefault, Integer netCoreWmemMax, String netIpv4IPLocalPortRange, Integer netIpv4NeighDefaultGcThresh1, Integer netIpv4NeighDefaultGcThresh2, Integer netIpv4NeighDefaultGcThresh3, Integer netIpv4TCPFinTimeout, Integer netIpv4TCPKeepaliveProbes, Integer netIpv4TCPKeepaliveTime, Integer netIpv4TCPMaxSynBacklog, Integer netIpv4TCPMaxTwBuckets, Boolean netIpv4TCPTwReuse, Integer netIpv4TCPkeepaliveIntvl, Integer netNetfilterNfConntrackBuckets, Integer netNetfilterNfConntrackMax, Integer vmMaxMapCount, Integer vmSwappiness, Integer vmVfsCachePressure) {
        super();
        this.fsAioMaxNr = fsAioMaxNr;
        this.fsFileMax = fsFileMax;
        this.fsInotifyMaxUserWatches = fsInotifyMaxUserWatches;
        this.fsNrOpen = fsNrOpen;
        this.kernelThreadsMax = kernelThreadsMax;
        this.netCoreNetdevMaxBacklog = netCoreNetdevMaxBacklog;
        this.netCoreOptmemMax = netCoreOptmemMax;
        this.netCoreRmemDefault = netCoreRmemDefault;
        this.netCoreRmemMax = netCoreRmemMax;
        this.netCoreSomaxconn = netCoreSomaxconn;
        this.netCoreWmemDefault = netCoreWmemDefault;
        this.netCoreWmemMax = netCoreWmemMax;
        this.netIpv4IPLocalPortRange = netIpv4IPLocalPortRange;
        this.netIpv4NeighDefaultGcThresh1 = netIpv4NeighDefaultGcThresh1;
        this.netIpv4NeighDefaultGcThresh2 = netIpv4NeighDefaultGcThresh2;
        this.netIpv4NeighDefaultGcThresh3 = netIpv4NeighDefaultGcThresh3;
        this.netIpv4TCPFinTimeout = netIpv4TCPFinTimeout;
        this.netIpv4TCPKeepaliveProbes = netIpv4TCPKeepaliveProbes;
        this.netIpv4TCPKeepaliveTime = netIpv4TCPKeepaliveTime;
        this.netIpv4TCPMaxSynBacklog = netIpv4TCPMaxSynBacklog;
        this.netIpv4TCPMaxTwBuckets = netIpv4TCPMaxTwBuckets;
        this.netIpv4TCPTwReuse = netIpv4TCPTwReuse;
        this.netIpv4TCPkeepaliveIntvl = netIpv4TCPkeepaliveIntvl;
        this.netNetfilterNfConntrackBuckets = netNetfilterNfConntrackBuckets;
        this.netNetfilterNfConntrackMax = netNetfilterNfConntrackMax;
        this.vmMaxMapCount = vmMaxMapCount;
        this.vmSwappiness = vmSwappiness;
        this.vmVfsCachePressure = vmVfsCachePressure;
    }

    /**
     * FsAioMaxNr specifies the maximum number of system-wide asynchronous io requests. Valid values are 65536-6553500 (inclusive). Maps to fs.aio-max-nr.
     */
    @JsonProperty("fsAioMaxNr")
    public Integer getFsAioMaxNr() {
        return fsAioMaxNr;
    }

    /**
     * FsAioMaxNr specifies the maximum number of system-wide asynchronous io requests. Valid values are 65536-6553500 (inclusive). Maps to fs.aio-max-nr.
     */
    @JsonProperty("fsAioMaxNr")
    public void setFsAioMaxNr(Integer fsAioMaxNr) {
        this.fsAioMaxNr = fsAioMaxNr;
    }

    /**
     * FsFileMax specifies the max number of file-handles that the Linux kernel will allocate, by increasing increases the maximum number of open files permitted. Valid values are 8192-12000500 (inclusive). Maps to fs.file-max.
     */
    @JsonProperty("fsFileMax")
    public Integer getFsFileMax() {
        return fsFileMax;
    }

    /**
     * FsFileMax specifies the max number of file-handles that the Linux kernel will allocate, by increasing increases the maximum number of open files permitted. Valid values are 8192-12000500 (inclusive). Maps to fs.file-max.
     */
    @JsonProperty("fsFileMax")
    public void setFsFileMax(Integer fsFileMax) {
        this.fsFileMax = fsFileMax;
    }

    /**
     * FsInotifyMaxUserWatches specifies the number of file watches allowed by the system. Each watch is roughly 90 bytes on a 32-bit kernel, and roughly 160 bytes on a 64-bit kernel. Valid values are 781250-2097152 (inclusive). Maps to fs.inotify.max_user_watches.
     */
    @JsonProperty("fsInotifyMaxUserWatches")
    public Integer getFsInotifyMaxUserWatches() {
        return fsInotifyMaxUserWatches;
    }

    /**
     * FsInotifyMaxUserWatches specifies the number of file watches allowed by the system. Each watch is roughly 90 bytes on a 32-bit kernel, and roughly 160 bytes on a 64-bit kernel. Valid values are 781250-2097152 (inclusive). Maps to fs.inotify.max_user_watches.
     */
    @JsonProperty("fsInotifyMaxUserWatches")
    public void setFsInotifyMaxUserWatches(Integer fsInotifyMaxUserWatches) {
        this.fsInotifyMaxUserWatches = fsInotifyMaxUserWatches;
    }

    /**
     * FsNrOpen specifies the maximum number of file-handles a process can allocate. Valid values are 8192-20000500 (inclusive). Maps to fs.nr_open.
     */
    @JsonProperty("fsNrOpen")
    public Integer getFsNrOpen() {
        return fsNrOpen;
    }

    /**
     * FsNrOpen specifies the maximum number of file-handles a process can allocate. Valid values are 8192-20000500 (inclusive). Maps to fs.nr_open.
     */
    @JsonProperty("fsNrOpen")
    public void setFsNrOpen(Integer fsNrOpen) {
        this.fsNrOpen = fsNrOpen;
    }

    /**
     * KernelThreadsMax specifies the maximum number of all threads that can be created. Valid values are 20-513785 (inclusive). Maps to kernel.threads-max.
     */
    @JsonProperty("kernelThreadsMax")
    public Integer getKernelThreadsMax() {
        return kernelThreadsMax;
    }

    /**
     * KernelThreadsMax specifies the maximum number of all threads that can be created. Valid values are 20-513785 (inclusive). Maps to kernel.threads-max.
     */
    @JsonProperty("kernelThreadsMax")
    public void setKernelThreadsMax(Integer kernelThreadsMax) {
        this.kernelThreadsMax = kernelThreadsMax;
    }

    /**
     * NetCoreNetdevMaxBacklog specifies maximum number of packets, queued on the INPUT side, when the interface receives packets faster than kernel can process them. Valid values are 1000-3240000 (inclusive). Maps to net.core.netdev_max_backlog.
     */
    @JsonProperty("netCoreNetdevMaxBacklog")
    public Integer getNetCoreNetdevMaxBacklog() {
        return netCoreNetdevMaxBacklog;
    }

    /**
     * NetCoreNetdevMaxBacklog specifies maximum number of packets, queued on the INPUT side, when the interface receives packets faster than kernel can process them. Valid values are 1000-3240000 (inclusive). Maps to net.core.netdev_max_backlog.
     */
    @JsonProperty("netCoreNetdevMaxBacklog")
    public void setNetCoreNetdevMaxBacklog(Integer netCoreNetdevMaxBacklog) {
        this.netCoreNetdevMaxBacklog = netCoreNetdevMaxBacklog;
    }

    /**
     * NetCoreOptmemMax specifies the maximum ancillary buffer size (option memory buffer) allowed per socket. Socket option memory is used in a few cases to store extra structures relating to usage of the socket. Valid values are 20480-4194304 (inclusive). Maps to net.core.optmem_max.
     */
    @JsonProperty("netCoreOptmemMax")
    public Integer getNetCoreOptmemMax() {
        return netCoreOptmemMax;
    }

    /**
     * NetCoreOptmemMax specifies the maximum ancillary buffer size (option memory buffer) allowed per socket. Socket option memory is used in a few cases to store extra structures relating to usage of the socket. Valid values are 20480-4194304 (inclusive). Maps to net.core.optmem_max.
     */
    @JsonProperty("netCoreOptmemMax")
    public void setNetCoreOptmemMax(Integer netCoreOptmemMax) {
        this.netCoreOptmemMax = netCoreOptmemMax;
    }

    /**
     * NetCoreRmemDefault specifies the default receive socket buffer size in bytes. Valid values are 212992-134217728 (inclusive). Maps to net.core.rmem_default.
     */
    @JsonProperty("netCoreRmemDefault")
    public Integer getNetCoreRmemDefault() {
        return netCoreRmemDefault;
    }

    /**
     * NetCoreRmemDefault specifies the default receive socket buffer size in bytes. Valid values are 212992-134217728 (inclusive). Maps to net.core.rmem_default.
     */
    @JsonProperty("netCoreRmemDefault")
    public void setNetCoreRmemDefault(Integer netCoreRmemDefault) {
        this.netCoreRmemDefault = netCoreRmemDefault;
    }

    /**
     * NetCoreRmemMax specifies the maximum receive socket buffer size in bytes. Valid values are 212992-134217728 (inclusive). Maps to net.core.rmem_max.
     */
    @JsonProperty("netCoreRmemMax")
    public Integer getNetCoreRmemMax() {
        return netCoreRmemMax;
    }

    /**
     * NetCoreRmemMax specifies the maximum receive socket buffer size in bytes. Valid values are 212992-134217728 (inclusive). Maps to net.core.rmem_max.
     */
    @JsonProperty("netCoreRmemMax")
    public void setNetCoreRmemMax(Integer netCoreRmemMax) {
        this.netCoreRmemMax = netCoreRmemMax;
    }

    /**
     * NetCoreSomaxconn specifies maximum number of connection requests that can be queued for any given listening socket. An upper limit for the value of the backlog parameter passed to the listen(2)(https://man7.org/linux/man-pages/man2/listen.2.html) function. If the backlog argument is greater than the somaxconn, then it's silently truncated to this limit. Valid values are 4096-3240000 (inclusive). Maps to net.core.somaxconn.
     */
    @JsonProperty("netCoreSomaxconn")
    public Integer getNetCoreSomaxconn() {
        return netCoreSomaxconn;
    }

    /**
     * NetCoreSomaxconn specifies maximum number of connection requests that can be queued for any given listening socket. An upper limit for the value of the backlog parameter passed to the listen(2)(https://man7.org/linux/man-pages/man2/listen.2.html) function. If the backlog argument is greater than the somaxconn, then it's silently truncated to this limit. Valid values are 4096-3240000 (inclusive). Maps to net.core.somaxconn.
     */
    @JsonProperty("netCoreSomaxconn")
    public void setNetCoreSomaxconn(Integer netCoreSomaxconn) {
        this.netCoreSomaxconn = netCoreSomaxconn;
    }

    /**
     * NetCoreWmemDefault specifies the default send socket buffer size in bytes. Valid values are 212992-134217728 (inclusive). Maps to net.core.wmem_default.
     */
    @JsonProperty("netCoreWmemDefault")
    public Integer getNetCoreWmemDefault() {
        return netCoreWmemDefault;
    }

    /**
     * NetCoreWmemDefault specifies the default send socket buffer size in bytes. Valid values are 212992-134217728 (inclusive). Maps to net.core.wmem_default.
     */
    @JsonProperty("netCoreWmemDefault")
    public void setNetCoreWmemDefault(Integer netCoreWmemDefault) {
        this.netCoreWmemDefault = netCoreWmemDefault;
    }

    /**
     * NetCoreWmemMax specifies the maximum send socket buffer size in bytes. Valid values are 212992-134217728 (inclusive). Maps to net.core.wmem_max.
     */
    @JsonProperty("netCoreWmemMax")
    public Integer getNetCoreWmemMax() {
        return netCoreWmemMax;
    }

    /**
     * NetCoreWmemMax specifies the maximum send socket buffer size in bytes. Valid values are 212992-134217728 (inclusive). Maps to net.core.wmem_max.
     */
    @JsonProperty("netCoreWmemMax")
    public void setNetCoreWmemMax(Integer netCoreWmemMax) {
        this.netCoreWmemMax = netCoreWmemMax;
    }

    /**
     * NetIpv4IPLocalPortRange is used by TCP and UDP traffic to choose the local port on the agent node. PortRange should be specified in the format "first last". First, being an integer, must be between [1024 - 60999]. Last, being an integer, must be between [32768 - 65000]. Maps to net.ipv4.ip_local_port_range.
     */
    @JsonProperty("netIpv4IPLocalPortRange")
    public String getNetIpv4IPLocalPortRange() {
        return netIpv4IPLocalPortRange;
    }

    /**
     * NetIpv4IPLocalPortRange is used by TCP and UDP traffic to choose the local port on the agent node. PortRange should be specified in the format "first last". First, being an integer, must be between [1024 - 60999]. Last, being an integer, must be between [32768 - 65000]. Maps to net.ipv4.ip_local_port_range.
     */
    @JsonProperty("netIpv4IPLocalPortRange")
    public void setNetIpv4IPLocalPortRange(String netIpv4IPLocalPortRange) {
        this.netIpv4IPLocalPortRange = netIpv4IPLocalPortRange;
    }

    /**
     * NetIpv4NeighDefaultGcThresh1 specifies the minimum number of entries that may be in the ARP cache. Garbage collection won't be triggered if the number of entries is below this setting. Valid values are 128-80000 (inclusive). Maps to net.ipv4.neigh.default.gc_thresh1.
     */
    @JsonProperty("netIpv4NeighDefaultGcThresh1")
    public Integer getNetIpv4NeighDefaultGcThresh1() {
        return netIpv4NeighDefaultGcThresh1;
    }

    /**
     * NetIpv4NeighDefaultGcThresh1 specifies the minimum number of entries that may be in the ARP cache. Garbage collection won't be triggered if the number of entries is below this setting. Valid values are 128-80000 (inclusive). Maps to net.ipv4.neigh.default.gc_thresh1.
     */
    @JsonProperty("netIpv4NeighDefaultGcThresh1")
    public void setNetIpv4NeighDefaultGcThresh1(Integer netIpv4NeighDefaultGcThresh1) {
        this.netIpv4NeighDefaultGcThresh1 = netIpv4NeighDefaultGcThresh1;
    }

    /**
     * NetIpv4NeighDefaultGcThresh2 specifies soft maximum number of entries that may be in the ARP cache. ARP garbage collection will be triggered about 5 seconds after reaching this soft maximum. Valid values are 512-90000 (inclusive). Maps to net.ipv4.neigh.default.gc_thresh2.
     */
    @JsonProperty("netIpv4NeighDefaultGcThresh2")
    public Integer getNetIpv4NeighDefaultGcThresh2() {
        return netIpv4NeighDefaultGcThresh2;
    }

    /**
     * NetIpv4NeighDefaultGcThresh2 specifies soft maximum number of entries that may be in the ARP cache. ARP garbage collection will be triggered about 5 seconds after reaching this soft maximum. Valid values are 512-90000 (inclusive). Maps to net.ipv4.neigh.default.gc_thresh2.
     */
    @JsonProperty("netIpv4NeighDefaultGcThresh2")
    public void setNetIpv4NeighDefaultGcThresh2(Integer netIpv4NeighDefaultGcThresh2) {
        this.netIpv4NeighDefaultGcThresh2 = netIpv4NeighDefaultGcThresh2;
    }

    /**
     * NetIpv4NeighDefaultGcThresh3 specified hard maximum number of entries in the ARP cache. Valid values are 1024-100000 (inclusive). Maps to net.ipv4.neigh.default.gc_thresh3.
     */
    @JsonProperty("netIpv4NeighDefaultGcThresh3")
    public Integer getNetIpv4NeighDefaultGcThresh3() {
        return netIpv4NeighDefaultGcThresh3;
    }

    /**
     * NetIpv4NeighDefaultGcThresh3 specified hard maximum number of entries in the ARP cache. Valid values are 1024-100000 (inclusive). Maps to net.ipv4.neigh.default.gc_thresh3.
     */
    @JsonProperty("netIpv4NeighDefaultGcThresh3")
    public void setNetIpv4NeighDefaultGcThresh3(Integer netIpv4NeighDefaultGcThresh3) {
        this.netIpv4NeighDefaultGcThresh3 = netIpv4NeighDefaultGcThresh3;
    }

    /**
     * NetIpv4TCPFinTimeout specifies the length of time an orphaned connection will remain in the FIN_WAIT_2 state before it's aborted at the local end. Valid values are 5-120 (inclusive). Maps to net.ipv4.tcp_fin_timeout.
     */
    @JsonProperty("netIpv4TCPFinTimeout")
    public Integer getNetIpv4TCPFinTimeout() {
        return netIpv4TCPFinTimeout;
    }

    /**
     * NetIpv4TCPFinTimeout specifies the length of time an orphaned connection will remain in the FIN_WAIT_2 state before it's aborted at the local end. Valid values are 5-120 (inclusive). Maps to net.ipv4.tcp_fin_timeout.
     */
    @JsonProperty("netIpv4TCPFinTimeout")
    public void setNetIpv4TCPFinTimeout(Integer netIpv4TCPFinTimeout) {
        this.netIpv4TCPFinTimeout = netIpv4TCPFinTimeout;
    }

    /**
     * NetIpv4TCPKeepaliveProbes specifies the number of keepalive probes TCP sends out, until it decides the connection is broken. Valid values are 1-15 (inclusive). Maps to net.ipv4.tcp_keepalive_probes.
     */
    @JsonProperty("netIpv4TCPKeepaliveProbes")
    public Integer getNetIpv4TCPKeepaliveProbes() {
        return netIpv4TCPKeepaliveProbes;
    }

    /**
     * NetIpv4TCPKeepaliveProbes specifies the number of keepalive probes TCP sends out, until it decides the connection is broken. Valid values are 1-15 (inclusive). Maps to net.ipv4.tcp_keepalive_probes.
     */
    @JsonProperty("netIpv4TCPKeepaliveProbes")
    public void setNetIpv4TCPKeepaliveProbes(Integer netIpv4TCPKeepaliveProbes) {
        this.netIpv4TCPKeepaliveProbes = netIpv4TCPKeepaliveProbes;
    }

    /**
     * NetIpv4TCPKeepaliveTime specifies the rate at which TCP sends out a keepalive message when keepalive is enabled. Valid values are 30-432000 (inclusive). Maps to net.ipv4.tcp_keepalive_time.
     */
    @JsonProperty("netIpv4TCPKeepaliveTime")
    public Integer getNetIpv4TCPKeepaliveTime() {
        return netIpv4TCPKeepaliveTime;
    }

    /**
     * NetIpv4TCPKeepaliveTime specifies the rate at which TCP sends out a keepalive message when keepalive is enabled. Valid values are 30-432000 (inclusive). Maps to net.ipv4.tcp_keepalive_time.
     */
    @JsonProperty("netIpv4TCPKeepaliveTime")
    public void setNetIpv4TCPKeepaliveTime(Integer netIpv4TCPKeepaliveTime) {
        this.netIpv4TCPKeepaliveTime = netIpv4TCPKeepaliveTime;
    }

    /**
     * NetIpv4TCPMaxSynBacklog specifies the maximum number of queued connection requests that have still not received an acknowledgment from the connecting client. If this number is exceeded, the kernel will begin dropping requests. Valid values are 128-3240000 (inclusive). Maps to net.ipv4.tcp_max_syn_backlog.
     */
    @JsonProperty("netIpv4TCPMaxSynBacklog")
    public Integer getNetIpv4TCPMaxSynBacklog() {
        return netIpv4TCPMaxSynBacklog;
    }

    /**
     * NetIpv4TCPMaxSynBacklog specifies the maximum number of queued connection requests that have still not received an acknowledgment from the connecting client. If this number is exceeded, the kernel will begin dropping requests. Valid values are 128-3240000 (inclusive). Maps to net.ipv4.tcp_max_syn_backlog.
     */
    @JsonProperty("netIpv4TCPMaxSynBacklog")
    public void setNetIpv4TCPMaxSynBacklog(Integer netIpv4TCPMaxSynBacklog) {
        this.netIpv4TCPMaxSynBacklog = netIpv4TCPMaxSynBacklog;
    }

    /**
     * NetIpv4TCPMaxTwBuckets specifies maximal number of timewait sockets held by system simultaneously. If this number is exceeded, time-wait socket is immediately destroyed and warning is printed. Valid values are 8000-1440000 (inclusive). Maps to net.ipv4.tcp_max_tw_buckets.
     */
    @JsonProperty("netIpv4TCPMaxTwBuckets")
    public Integer getNetIpv4TCPMaxTwBuckets() {
        return netIpv4TCPMaxTwBuckets;
    }

    /**
     * NetIpv4TCPMaxTwBuckets specifies maximal number of timewait sockets held by system simultaneously. If this number is exceeded, time-wait socket is immediately destroyed and warning is printed. Valid values are 8000-1440000 (inclusive). Maps to net.ipv4.tcp_max_tw_buckets.
     */
    @JsonProperty("netIpv4TCPMaxTwBuckets")
    public void setNetIpv4TCPMaxTwBuckets(Integer netIpv4TCPMaxTwBuckets) {
        this.netIpv4TCPMaxTwBuckets = netIpv4TCPMaxTwBuckets;
    }

    /**
     * NetIpv4TCPTwReuse is used to allow to reuse TIME-WAIT sockets for new connections when it's safe from protocol viewpoint. Maps to net.ipv4.tcp_tw_reuse.
     */
    @JsonProperty("netIpv4TCPTwReuse")
    public Boolean getNetIpv4TCPTwReuse() {
        return netIpv4TCPTwReuse;
    }

    /**
     * NetIpv4TCPTwReuse is used to allow to reuse TIME-WAIT sockets for new connections when it's safe from protocol viewpoint. Maps to net.ipv4.tcp_tw_reuse.
     */
    @JsonProperty("netIpv4TCPTwReuse")
    public void setNetIpv4TCPTwReuse(Boolean netIpv4TCPTwReuse) {
        this.netIpv4TCPTwReuse = netIpv4TCPTwReuse;
    }

    /**
     * NetIpv4TCPkeepaliveIntvl specifies the frequency of the probes sent out. Multiplied by tcpKeepaliveprobes, it makes up the time to kill a connection that isn't responding, after probes started. Valid values are 1-75 (inclusive). Maps to net.ipv4.tcp_keepalive_intvl.
     */
    @JsonProperty("netIpv4TCPkeepaliveIntvl")
    public Integer getNetIpv4TCPkeepaliveIntvl() {
        return netIpv4TCPkeepaliveIntvl;
    }

    /**
     * NetIpv4TCPkeepaliveIntvl specifies the frequency of the probes sent out. Multiplied by tcpKeepaliveprobes, it makes up the time to kill a connection that isn't responding, after probes started. Valid values are 1-75 (inclusive). Maps to net.ipv4.tcp_keepalive_intvl.
     */
    @JsonProperty("netIpv4TCPkeepaliveIntvl")
    public void setNetIpv4TCPkeepaliveIntvl(Integer netIpv4TCPkeepaliveIntvl) {
        this.netIpv4TCPkeepaliveIntvl = netIpv4TCPkeepaliveIntvl;
    }

    /**
     * NetNetfilterNfConntrackBuckets specifies the size of hash table used by nf_conntrack module to record the established connection record of the TCP protocol. Valid values are 65536-147456 (inclusive). Maps to net.netfilter.nf_conntrack_buckets.
     */
    @JsonProperty("netNetfilterNfConntrackBuckets")
    public Integer getNetNetfilterNfConntrackBuckets() {
        return netNetfilterNfConntrackBuckets;
    }

    /**
     * NetNetfilterNfConntrackBuckets specifies the size of hash table used by nf_conntrack module to record the established connection record of the TCP protocol. Valid values are 65536-147456 (inclusive). Maps to net.netfilter.nf_conntrack_buckets.
     */
    @JsonProperty("netNetfilterNfConntrackBuckets")
    public void setNetNetfilterNfConntrackBuckets(Integer netNetfilterNfConntrackBuckets) {
        this.netNetfilterNfConntrackBuckets = netNetfilterNfConntrackBuckets;
    }

    /**
     * NetNetfilterNfConntrackMax specifies the maximum number of connections supported by the nf_conntrack module or the size of connection tracking table. Valid values are 131072-1048576 (inclusive). Maps to net.netfilter.nf_conntrack_max.
     */
    @JsonProperty("netNetfilterNfConntrackMax")
    public Integer getNetNetfilterNfConntrackMax() {
        return netNetfilterNfConntrackMax;
    }

    /**
     * NetNetfilterNfConntrackMax specifies the maximum number of connections supported by the nf_conntrack module or the size of connection tracking table. Valid values are 131072-1048576 (inclusive). Maps to net.netfilter.nf_conntrack_max.
     */
    @JsonProperty("netNetfilterNfConntrackMax")
    public void setNetNetfilterNfConntrackMax(Integer netNetfilterNfConntrackMax) {
        this.netNetfilterNfConntrackMax = netNetfilterNfConntrackMax;
    }

    /**
     * VMMaxMapCount specifies the maximum number of memory map areas a process may have. Maps to vm.max_map_count. Valid values are 65530-262144 (inclusive).
     */
    @JsonProperty("vmMaxMapCount")
    public Integer getVmMaxMapCount() {
        return vmMaxMapCount;
    }

    /**
     * VMMaxMapCount specifies the maximum number of memory map areas a process may have. Maps to vm.max_map_count. Valid values are 65530-262144 (inclusive).
     */
    @JsonProperty("vmMaxMapCount")
    public void setVmMaxMapCount(Integer vmMaxMapCount) {
        this.vmMaxMapCount = vmMaxMapCount;
    }

    /**
     * VMSwappiness specifies aggressiveness of the kernel in swapping memory pages. Higher values will increase aggressiveness, lower values decrease the amount of swap. Valid values are 0-100 (inclusive). Maps to vm.swappiness.
     */
    @JsonProperty("vmSwappiness")
    public Integer getVmSwappiness() {
        return vmSwappiness;
    }

    /**
     * VMSwappiness specifies aggressiveness of the kernel in swapping memory pages. Higher values will increase aggressiveness, lower values decrease the amount of swap. Valid values are 0-100 (inclusive). Maps to vm.swappiness.
     */
    @JsonProperty("vmSwappiness")
    public void setVmSwappiness(Integer vmSwappiness) {
        this.vmSwappiness = vmSwappiness;
    }

    /**
     * VMVfsCachePressure specifies the percentage value that controls tendency of the kernel to reclaim the memory, which is used for caching of directory and inode objects. Valid values are 1-500 (inclusive). Maps to vm.vfs_cache_pressure.
     */
    @JsonProperty("vmVfsCachePressure")
    public Integer getVmVfsCachePressure() {
        return vmVfsCachePressure;
    }

    /**
     * VMVfsCachePressure specifies the percentage value that controls tendency of the kernel to reclaim the memory, which is used for caching of directory and inode objects. Valid values are 1-500 (inclusive). Maps to vm.vfs_cache_pressure.
     */
    @JsonProperty("vmVfsCachePressure")
    public void setVmVfsCachePressure(Integer vmVfsCachePressure) {
        this.vmVfsCachePressure = vmVfsCachePressure;
    }

    @JsonIgnore
    public SysctlConfigBuilder edit() {
        return new SysctlConfigBuilder(this);
    }

    @JsonIgnore
    public SysctlConfigBuilder toBuilder() {
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
