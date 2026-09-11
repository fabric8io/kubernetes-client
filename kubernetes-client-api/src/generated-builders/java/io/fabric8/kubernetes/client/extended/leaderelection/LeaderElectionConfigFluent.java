package io.fabric8.kubernetes.client.extended.leaderelection;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.client.extended.leaderelection.resourcelock.Lock;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.time.Duration;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class LeaderElectionConfigFluent<A extends io.fabric8.kubernetes.client.extended.leaderelection.LeaderElectionConfigFluent<A>> extends BaseFluent<A>{

  private LeaderCallbacks leaderCallbacks;
  private Duration leaseDuration;
  private Lock lock;
  private String name;
  private boolean releaseOnCancel;
  private Duration renewDeadline;
  private Duration retryPeriod;

  public LeaderElectionConfigFluent() {
  }
  
  public LeaderElectionConfigFluent(LeaderElectionConfig instance) {
    this.copyInstance(instance);
  }

  protected void copyInstance(LeaderElectionConfig instance) {
    if (instance != null) {
        this.withLock(instance.getLock());
        this.withLeaseDuration(instance.getLeaseDuration());
        this.withRenewDeadline(instance.getRenewDeadline());
        this.withRetryPeriod(instance.getRetryPeriod());
        this.withLeaderCallbacks(instance.getLeaderCallbacks());
        this.withReleaseOnCancel(instance.isReleaseOnCancel());
        this.withName(instance.getName());
    }
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    LeaderElectionConfigFluent that = (LeaderElectionConfigFluent) o;
    if (!(Objects.equals(lock, that.lock))) {
      return false;
    }
    if (!(Objects.equals(leaseDuration, that.leaseDuration))) {
      return false;
    }
    if (!(Objects.equals(renewDeadline, that.renewDeadline))) {
      return false;
    }
    if (!(Objects.equals(retryPeriod, that.retryPeriod))) {
      return false;
    }
    if (!(Objects.equals(leaderCallbacks, that.leaderCallbacks))) {
      return false;
    }
    if (releaseOnCancel != that.releaseOnCancel) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    return true;
  }
  
  public LeaderCallbacks getLeaderCallbacks() {
    return this.leaderCallbacks;
  }
  
  public Duration getLeaseDuration() {
    return this.leaseDuration;
  }
  
  public Lock getLock() {
    return this.lock;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Duration getRenewDeadline() {
    return this.renewDeadline;
  }
  
  public Duration getRetryPeriod() {
    return this.retryPeriod;
  }
  
  public boolean hasLeaderCallbacks() {
    return this.leaderCallbacks != null;
  }
  
  public boolean hasLeaseDuration() {
    return this.leaseDuration != null;
  }
  
  public boolean hasLock() {
    return this.lock != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasReleaseOnCancel() {
    return true;
  }
  
  public boolean hasRenewDeadline() {
    return this.renewDeadline != null;
  }
  
  public boolean hasRetryPeriod() {
    return this.retryPeriod != null;
  }
  
  public int hashCode() {
    return Objects.hash(lock, leaseDuration, renewDeadline, retryPeriod, leaderCallbacks, releaseOnCancel, name);
  }
  
  public boolean isReleaseOnCancel() {
    return this.releaseOnCancel;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(lock == null)) {
        sb.append("lock:");
        sb.append(lock);
        sb.append(",");
    }
    if (!(leaseDuration == null)) {
        sb.append("leaseDuration:");
        sb.append(leaseDuration);
        sb.append(",");
    }
    if (!(renewDeadline == null)) {
        sb.append("renewDeadline:");
        sb.append(renewDeadline);
        sb.append(",");
    }
    if (!(retryPeriod == null)) {
        sb.append("retryPeriod:");
        sb.append(retryPeriod);
        sb.append(",");
    }
    if (!(leaderCallbacks == null)) {
        sb.append("leaderCallbacks:");
        sb.append(leaderCallbacks);
        sb.append(",");
    }
    sb.append("releaseOnCancel:");
    sb.append(releaseOnCancel);
    sb.append(",");
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withLeaderCallbacks(LeaderCallbacks leaderCallbacks) {
    this.leaderCallbacks = leaderCallbacks;
    return (A) this;
  }
  
  public A withLeaseDuration(Duration leaseDuration) {
    this.leaseDuration = leaseDuration;
    return (A) this;
  }
  
  public A withLock(Lock lock) {
    this.lock = lock;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withReleaseOnCancel() {
    return withReleaseOnCancel(true);
  }
  
  public A withReleaseOnCancel(boolean releaseOnCancel) {
    this.releaseOnCancel = releaseOnCancel;
    return (A) this;
  }
  
  public A withRenewDeadline(Duration renewDeadline) {
    this.renewDeadline = renewDeadline;
    return (A) this;
  }
  
  public A withRetryPeriod(Duration retryPeriod) {
    this.retryPeriod = retryPeriod;
    return (A) this;
  }
  
}