package io.fabric8.kudo.client;

/**
 * @author pangms
 * @date 2020/4/21
 */
public class Constance {
  public final static String ApiGroupName = "kudo.dev";
  // public final static String ApiGroupVersion = "v1beta1";
  public final static String ApiGroupVersion = "kudo.dev/v1beta1";

  public final static String InstancesPlural = "instances";

  // ExecutionInProgress actively deploying, but not yet healthy.
  public static final String ExecutionInProgress = "IN_PROGRESS";

  // ExecutionPending Not ready to deploy because dependent phases/steps not healthy.
  public static final String ExecutionPending = "PENDING";

  // ExecutionComplete deployed and healthy.
  public static final String ExecutionComplete = "COMPLETE";

  // ErrorStatus there was an error deploying the application.
  public static final String ErrorStatus = "ERROR";

  // ExecutionFatalError there was an error deploying the application.
  public static final String ExecutionFatalError = "FATAL_ERROR";

  // ExecutionNeverRun is used when this plan/phase/step was never run so far
  public static final String ExecutionNeverRun = "NEVER_RUN";
}
