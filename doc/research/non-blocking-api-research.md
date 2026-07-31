---
title: " Non-Blocking Kubernetes Client API — Research"
description: " Non-Blocking Kubernetes Client API — Research"
draft: true
---
# Non-Blocking Kubernetes Client API — Research

_Date: 2026-05-18_
_Related: [#7234](https://github.com/fabric8io/kubernetes-client/issues/7234) (primary anchor), [#1245](https://github.com/fabric8io/kubernetes-client/issues/1245), [#2379](https://github.com/fabric8io/kubernetes-client/issues/2379), [#4154](https://github.com/fabric8io/kubernetes-client/issues/4154), [#5129](https://github.com/fabric8io/kubernetes-client/issues/5129), [#5726](https://github.com/fabric8io/kubernetes-client/issues/5726), [#7299](https://github.com/fabric8io/kubernetes-client/issues/7299), [Discussion #5067](https://github.com/fabric8io/kubernetes-client/discussions/5067)_

**This document is a research record, not a design.** It catalogues every issue, PR and maintainer comment the project has accumulated on the topic of a non-blocking / async / reactive client surface; maps where in the code the blocking boundary actually sits today; and lays out two viable API directions side-by-side at the same fidelity. No direction has been committed — the choice is a community call to be made on the issue tracker.

## TL;DR

- The codebase **is already non-blocking from the HTTP layer down**. All four `HttpClient` implementations (JDK, OkHttp, Jetty, Vert.x) expose `CompletableFuture<HttpResponse<T>>` from `sendAsync`, and the operation layer has internal `submitList(...)`/`submitWatch(...)` methods returning `CompletableFuture`. The blocking boundary is a single line: `OperationSupport.waitForResult(...)` calling `future.get()` ([`OperationSupport.java:491`](../../kubernetes-client/src/main/java/io/fabric8/kubernetes/client/dsl/internal/OperationSupport.java)). Every public DSL terminal (`get`, `list`, `create`, `update`, `delete`, `patch`, …) funnels through it.
- There is **already a precedent for async public methods** sprinkled across the DSL: `Watchable.streamingList(Consumer<T>) → CompletableFuture<String>`, `Informable.informOnCondition(...) → CompletableFuture<List<T>>`, `SharedIndexInformer.start()/stopped() → CompletionStage<Void>`, `ExecWatch.exitCode() → CompletableFuture<Integer>`, `LogWatch.onClose() → CompletionStage<Throwable>`, `WebSocket.Builder.buildAsync(...)`. Both proposals below build on this precedent rather than introduce a new one.
- **Maintainer-set constraints** (from comments on the issues above):
  - No `NonBlockingKubernetesClient` parallel hierarchy — too much surface to maintain (@shawkins, [#7234](https://github.com/fabric8io/kubernetes-client/issues/7234)).
  - Prefer `CompletionStage<T>` over `CompletableFuture<T>` for new return types ([#4488](https://github.com/fabric8io/kubernetes-client/pull/4488), [#4732](https://github.com/fabric8io/kubernetes-client/pull/4732)).
  - Per-method opt-in, starting with methods that have a single signature and where the internal path is already async ([#7234](https://github.com/fabric8io/kubernetes-client/issues/7234)).
  - Virtual threads are the implicit competing solution — any proposal must justify why per-method `CompletionStage` variants beat "run blocking calls on a vthread executor".
  - YAML loading remains blocking (no streaming SnakeYAML parser, [#5129](https://github.com/fabric8io/kubernetes-client/issues/5129)).
  - OIDC token refresh inside HTTP interceptors is still synchronous ([#3971](https://github.com/fabric8io/kubernetes-client/issues/3971)) — "fully non-blocking" is not honest yet.
- **Two viable API directions surfaced from this research:**
  - **Option A — sister methods** (`getAsync()`, `listAsync()`, …) on the existing terminal interfaces. ~30 new methods, no new types.
  - **Option B — `.async()` view** returning a parallel terminal-only interface family (`AsyncResource<T>`, `AsyncGettable<T>`, …). ~11 new `Async*` terminal interfaces + two umbrella views + ~30 method signatures inside them. Cleaner at the call site.
- **No recommendation made.** Author bias (this research was kicked off by @manusa) leans **Option B** on call-site ergonomics grounds; the maintainer comment that motivated the framing in [#7234](https://github.com/fabric8io/kubernetes-client/issues/7234) reads more naturally as **Option A**. See § 7 for the open questions the community needs to settle before either direction can be drafted as an upstream PR.

---

## 1. Catalog of prior art

Every item the project has accumulated on this topic. Organised by category, not chronologically.

### 1.1 Primary requests (issues asking for non-blocking)

| # | Title | State | Notes |
|---|---|---|---|
| [#1245](https://github.com/fabric8io/kubernetes-client/issues/1245) | "Support async calls in Kubernets client" | Closed (stale, 2018) | Original anchor. Reopened in spirit by a 2025 comment thread that produced #7234. |
| [#2379](https://github.com/fabric8io/kubernetes-client/issues/2379) | "How to enable the client to support reactive" | Open (2020, `status/never-stale`) | @manusa linked his personal [yakc](https://github.com/manusa/yakc) PoC (RxJava + Retrofit) as an example of what reactive could have looked like greenfield. @shawkins later noted the core is mostly reactive as of 6.0, but the DSL is not. |
| [#4154](https://github.com/fabric8io/kubernetes-client/issues/4154) | "Generally account for non-blocking channels" | Open (2022, opened by @shawkins) | Proposes `ReadableByteChannel`/`WritableByteChannel` + `blocking` parameter + `CompletableFuture<Boolean> upload(channel, blockingMode)` for exec/log/copy paths. |
| [#5129](https://github.com/fabric8io/kubernetes-client/issues/5129) | "Add support for non-blocking parsing" | Closed (stale, 2023, opened by @shawkins) | Killed by SnakeYAML's lack of streaming support. Useful prior art if revisited. |
| [#5726](https://github.com/fabric8io/kubernetes-client/issues/5726) | "Allow to set the executor used by OkHttp Dispatcher (for Virtual Threads)" | Closed (stale, 2024) | Exposing the executor is unsafe; the documented workaround is `ExecutorSupplier` + custom `HttpClientFactory`. |
| [#7234](https://github.com/fabric8io/kubernetes-client/issues/7234) | "Expose a non-blocking KubernetesClient API" | Open (2025, `status/never-stale`) | Current primary anchor. Contains the canonical maintainer statement (see § 2). |
| [#7299](https://github.com/fabric8io/kubernetes-client/issues/7299) | "Http calls staying blocked for way too long" | Open (2025) | Real-world pain: 30h vertx-worker stack-traced inside `OperationSupport.waitForResult → CompletableFuture.get`. Cited by callers arguing for #7234. |
| [Discussion #5067](https://github.com/fabric8io/kubernetes-client/discussions/5067) | "Non-blocking usage of Kubernetes Client using Vert.x Http Client" | Open Q&A (2023) | The only relevant Discussion. Maintainer answer: "the JDK, Vert.x, and Jetty HttpClients all offer better internal non-blocking support that utilize a shared core thread pool, but none of them change the overall DSL exposed by the fabric8 client." |

### 1.2 Implementation PRs that built the runway

| # | Title | Year | Why it matters |
|---|---|---|---|
| [#656](https://github.com/fabric8io/kubernetes-client/pull/656) | "Make watching via http async" | 2017 | Historical first async-ification — watch was the first thing to go non-blocking internally. |
| [#3108](https://github.com/fabric8io/kubernetes-client/pull/3108) | "Overhauling all threading concerns related to informers" | 2021 | Consolidated informer thread pools. Prerequisite for fewer-threads design. |
| [#3549](https://github.com/fabric8io/kubernetes-client/pull/3549) | "Adding an api layer to isolate OkHttp" | 2021 | Foundational. Introduced the `HttpClient` SPI that all subsequent backends implement. |
| [#4488](https://github.com/fabric8io/kubernetes-client/pull/4488) | "Allowing for users to set the exception handling behavior" | 2022 | Narrowed informer `start()`/`stopped()` from `CompletableFuture` to `CompletionStage` — the maintainer-preferred return type for new async surface. |
| [#4732](https://github.com/fabric8io/kubernetes-client/pull/4732) | "CompletableFuture cancel will close the underlying resource" | 2023 | Resource-lifecycle correctness for cancelled futures. Reiterated `CompletionStage` preference in the discussion. |
| [#4737](https://github.com/fabric8io/kubernetes-client/pull/4737) | "Vertx client" | 2023 | Added the fully non-blocking Vert.x backend (now the default in 7.x). |
| [#5081](https://github.com/fabric8io/kubernetes-client/pull/5081) | "Add support for informer watching without pagination" | 2025 | Implements KEP-3157 watch-list. Introduces `CompletableFuture<String> streamingList(ListOptions, Consumer<T>)` — the only async public-API signature a maintainer has drafted. |
| [#5119](https://github.com/fabric8io/kubernetes-client/pull/5119) | "Adding a callback for stream consumption" | 2023 (draft, open) | Tackles non-blocking log/exec stream consumption. Enumerates four design options including "use a reactive library". |
| [#7184](https://github.com/fabric8io/kubernetes-client/pull/7184) | "Add vertx5 module" | 2026 | Keeps the non-blocking backend on a current Vert.x line. |

### 1.3 External prior art

- **[manusa/yakc](https://github.com/manusa/yakc)** — @manusa's personal Retrofit + RxJava experiment. Linked from [#2379](https://github.com/fabric8io/kubernetes-client/issues/2379) as "what reactive could have looked like greenfield".

## 2. Maintainer-stated constraints

Quoted or paraphrased from maintainer comments on the issues above. These are the rules any proposal must respect.

### 2.1 No parallel client hierarchy

> @shawkins, [#7234](https://github.com/fabric8io/kubernetes-client/issues/7234#issuecomment-3191149619):
> *"This has been discussed / requested several times and there has been no strong work towards it. You can either: advocate for a particular method(s) to have non-blocking counter-parts exposed — this will be more palatable for methods where there is a single signature and where the underlying logic is already aligned. Or try towards something more comprehensive — that has historically been difficult. For example starting off with an interface hierarchy like `NonBlockingKubernetesClient` — that would be a lot to maintain and a huge effort. There's also the thought that virtual thread usage will be more common before we complete such an effort."*

This is the load-bearing comment any proposal must address. The structural objection is to a *parallel client hierarchy*, not to async return types in general.

### 2.2 Prefer `CompletionStage<T>` over `CompletableFuture<T>`

From [#4488](https://github.com/fabric8io/kubernetes-client/pull/4488) (narrowing `SharedIndexInformer.start()/stopped()`): *"since we don't want the user completing and don't support cancelling, we should be using the narrower type instead."*

From [#4732](https://github.com/fabric8io/kubernetes-client/pull/4732): *"A different way of addressing this is to instead have HttpClient return a CompletionStage — which makes it clear that you are instead supposed to 'cancel' via a thenAccept or whenComplete handler that closes things out."*

### 2.3 Reactive support has to be piecemeal

> @manusa, [#2379](https://github.com/fabric8io/kubernetes-client/issues/2379):
> *"Adding Reactive support for the client is possible but it would be quite an involved challenge given its current state and code generation methods … Maybe it could be achieved if done little by little (e.g. adding this as a feature in #2010)."*

### 2.4 Executor exposure is unsafe

From [#5726](https://github.com/fabric8io/kubernetes-client/issues/5726):
- @shawkins: *"over usage / misconfiguration of the HttpClient executor will quickly cause the KubernetesClient to fail in non-obvious ways."*
- @manusa: *"That executor has a very particular usage and is used under our very controlled circumstances."*

A built-in `withVirtualThreads()` toggle is also rejected: *"This unfortunately isn't very easy given our target JRE support. We either have to introduce reflective logic or different modules for the different JRE support levels."*

### 2.5 YAML loading stays blocking

From [#5129](https://github.com/fabric8io/kubernetes-client/issues/5129):
> @shawkins: *"This is unfortunately a little difficult as I don't see any non-blocking support with snake yaml, so we'd have to differentiate the paths that could accept yaml."*

Any "all returns become `CompletionStage<T>`" framing must either differentiate JSON vs YAML paths or accept that YAML stays blocking.

### 2.6 OIDC interceptor refresh still blocks

[#3971](https://github.com/fabric8io/kubernetes-client/issues/3971): *"A refinement should be made to interceptors to make non-blocking calls — token refreshes are currently blocking"*. Until this is fixed, even an async public surface will incur a synchronous step on token refresh.

### 2.7 Informer initial list is hard to make non-blocking

From [#3973](https://github.com/fabric8io/kubernetes-client/issues/3973): @shawkins noted *"Unfortunately inform will still be blocking. The first operation it needs to do is a list. A list could be non-blocking, but the result parsing will be tricky as non-blocking as the root object is a KubernetesList. A watch could be non-blocking, but you won't know when the initial add events are done."* Partially addressed by the watch-list work in [#5081](https://github.com/fabric8io/kubernetes-client/pull/5081), but the parsing concern stands for non-watch-list code paths.

## 3. Where the blocking boundary sits today

### 3.1 The single blocking point

[`OperationSupport.waitForResult`](../../kubernetes-client/src/main/java/io/fabric8/kubernetes/client/dsl/internal/OperationSupport.java) at line 491 calls `future.get()`. Every public DSL terminal method on `BaseOperation` and its subclasses funnels through it.

```java
// kubernetes-client/src/main/java/io/fabric8/kubernetes/client/dsl/internal/OperationSupport.java
protected <T> T waitForResult(CompletableFuture<T> future) {
  try {
    return future.get();    // ← THE blocking line
  } catch (InterruptedException e) { ... }
    catch (ExecutionException e) { ... }
}
```

### 3.2 HTTP layer (fully async on all four backends)

| Backend | Module | Notes |
|---|---|---|
| JDK | `httpclient-jdk` | Uses `java.net.http.HttpClient` with `Executors.newCachedThreadPool`; natively async. |
| OkHttp | `httpclient-okhttp` | Async via `Call.enqueue()` under the hood. |
| Jetty | `httpclient-jetty` | Event-driven; natively async. |
| Vert.x | `httpclient-vertx`, `httpclient-vertx5` | Fully reactive (default in 7.x). |

All four implement the `HttpClient` SPI in [`kubernetes-client-api/src/main/java/io/fabric8/kubernetes/client/http/HttpClient.java`](../../kubernetes-client-api/src/main/java/io/fabric8/kubernetes/client/http/HttpClient.java) whose two terminal methods are async:

```java
<T> CompletableFuture<HttpResponse<T>> sendAsync(HttpRequest request, Class<T> type);
CompletableFuture<HttpResponse<AsyncBody>> consumeBytes(HttpRequest, AsyncBody.Consumer<List<ByteBuffer>>);
```

### 3.3 Internal async methods already in `BaseOperation`

These already return `CompletableFuture<T>` but are not part of the public DSL:

- `BaseOperation.submitList(ListOptions) → CompletableFuture<L>` (line 452)
- `BaseOperation.submitWatch(ListOptions, Watcher<T>) → CompletableFuture<AbstractWatchManager<T>>` (line 735)

Either proposal below promotes these (or thin wrappers around them) to the public surface.

### 3.4 Existing public async surface (the precedents)

Already public, already returning `CompletableFuture` / `CompletionStage`:

| Where | Signature |
|---|---|
| [`Watchable`](../../kubernetes-client-api/src/main/java/io/fabric8/kubernetes/client/dsl/Watchable.java) | `default CompletableFuture<String> streamingList(Consumer<T> onItem)` |
| [`Informable`](../../kubernetes-client-api/src/main/java/io/fabric8/kubernetes/client/dsl/Informable.java) | `CompletableFuture<List<T>> informOnCondition(Predicate<List<T>>)` |
| [`Informable`](../../kubernetes-client-api/src/main/java/io/fabric8/kubernetes/client/dsl/Informable.java) | `SharedIndexInformer<T> runnableInformer(long resync)` (deferred-blocking — call `start()` separately) |
| `SharedIndexInformer` | `CompletionStage<Void> start()`, `CompletionStage<Void> stopped()` |
| [`ExecWatch`](../../kubernetes-client-api/src/main/java/io/fabric8/kubernetes/client/dsl/ExecWatch.java) | `CompletableFuture<Integer> exitCode()` |
| [`LogWatch`](../../kubernetes-client-api/src/main/java/io/fabric8/kubernetes/client/dsl/LogWatch.java) | `CompletionStage<Throwable> onClose()` |
| `HttpClient.WebSocket.Builder` | `CompletableFuture<WebSocket> buildAsync(Listener)` |

### 3.5 DSL terminal methods that would need an async story

Across the DSL hierarchy rooted at [`Resource<T>`](../../kubernetes-client-api/src/main/java/io/fabric8/kubernetes/client/dsl/Resource.java) and [`MixedOperation`](../../kubernetes-client-api/src/main/java/io/fabric8/kubernetes/client/dsl/MixedOperation.java), the terminal interfaces (the ones that touch I/O) and their I/O methods are:

| Interface | Terminal method(s) |
|---|---|
| `Gettable<T>` | `T get()` |
| `Listable<T>` | `T list()`, `T list(ListOptions)` (+ a deprecated paginated overload) |
| `Deletable` | `List<StatusDetails> delete()` |
| `Updatable<T>` | `T update()` (+ deprecated `replace()`) |
| `Replaceable<T>` | `T updateStatus()` (+ deprecated `replaceStatus()`) |
| `CreateOrReplaceable<T>` | `T create()`, `T createOrReplace()` |
| `EditReplacePatchable<T>` | `T edit(UnaryOperator<T>)`, `T edit(Visitor...)`, `T accept(Consumer<T>)`, `T patch()`, `T patch(PatchContext)`, `T patch(PatchContext, T)`, `T patch(PatchContext, String)` |
| `ItemWritableOperation<T>` | `T create(T)`, `T createOrReplace(T)`, `List<StatusDetails> delete(T)`, `T updateStatus(T)`, `T patchStatus(T)` |
| `ItemReplacable<T>` | `T replace(T)`, `T replaceStatus(T)` |
| `ServerSideApplicable<T>` | `T serverSideApply()` |
| `NonDeletingOperation<T>` | `T createOr(Function<...>)`, `T editStatus(UnaryOperator<T>)`, `T patchStatus()` |
| `Scalable<T>` | `T scale(int)`, `T scale(int, boolean wait)`, `Scale scale(Scale)` |
| `Waitable<T,P>` | `T waitUntilReady(long, TimeUnit)`, `T waitUntilCondition(Predicate<P>, long, TimeUnit)` |
| `Loggable` | `String getLog()` (+ pretty/reader/stream variants), `LogWatch watchLog()` (already async-shaped) |
| `Resource<T>` (own methods) | `boolean isReady()`, `T require()` |

Roughly **~30 distinct blocking terminal methods** (after excluding deprecated `replace`/`replaceStatus`, the old paginated `list(Integer, String)`, and the array-based `delete(T...)` overloads). The fluent intermediates (`Namespaceable`, `Nameable`, `Filterable`, `DryRunable`, `Timeoutable`, `RequestConfigurable`, `FieldValidateable`, `MetadataGettable`, `TableGettable`, `Containerable`, …) do not touch I/O and need no async variant; they stay shared between the sync and async surfaces.

## 4. API design options considered

Five options were considered. Three were eliminated; two are carried forward to § 5.

| # | Option | Verdict |
|---|---|---|
| A | Sister methods (`getAsync()`, `listAsync()`, …) on the existing terminal interfaces | **Carried forward** |
| B | Fluent `.async()` mode switch returning a parallel terminal-only interface family | **Carried forward** |
| C | Single bridge — `client.async(c -> c.pods()...get())` running the lambda on an executor | **Eliminated.** Doesn't address the actual problem — it relocates the blocking thread rather than removing it. A vthread executor delivers the same thing with no API change. |
| D | Reactive bridge modules (`kubernetes-client-reactor`, `kubernetes-client-mutiny`) | **Deferred.** Doesn't address [#7234](https://github.com/fabric8io/kubernetes-client/issues/7234)'s core ask (`CompletionStage`, not Reactor types). Additive — could be layered on top of A or B later. |
| E | "Use virtual threads" — document and ship nothing | **Eliminated as standalone solution** (does not help event-loop/reactive callers — see § 6) but **retained as the recommended approach for Java 21+ callers who can use vthreads**. The doc that ships with A or B should lead with this advice. |

## 5. Side-by-side: Option A vs Option B

### 5.1 Exact new surface

**Option A** adds methods to existing interfaces. No new types.

| Existing interface | New methods |
|---|---|
| `Gettable<T>` | `CompletionStage<T> getAsync()` |
| `Listable<T>` | `CompletionStage<T> listAsync()`, `CompletionStage<T> listAsync(ListOptions)` |
| `Deletable` | `CompletionStage<List<StatusDetails>> deleteAsync()` |
| `Updatable<T>` | `CompletionStage<T> updateAsync()` |
| `Replaceable<T>` | `CompletionStage<T> updateStatusAsync()` |
| `CreateOrReplaceable<T>` | `CompletionStage<T> createAsync()`, `CompletionStage<T> createOrReplaceAsync()` |
| `EditReplacePatchable<T>` | `CompletionStage<T> editAsync(UnaryOperator<T>)`, `CompletionStage<T> patchAsync()`, `CompletionStage<T> patchAsync(PatchContext)` |
| `InOutCreateable<I,O>` / `ItemWritableOperation<T>` | `CompletionStage<O> createAsync(I)`, plus async variants for status/patch/delete by item |
| `ServerSideApplicable<T>` | `CompletionStage<T> serverSideApplyAsync()` |
| `Scalable<T>` | `CompletionStage<T> scaleAsync(int)`, `CompletionStage<Scale> scaleAsync(Scale)` |
| `Waitable<T,P>` | `CompletionStage<T> waitUntilReadyAsync()`, `CompletionStage<T> waitUntilConditionAsync(Predicate<P>)` (timeout via `.orTimeout(...)` on the returned stage) |
| `NonDeletingOperation<T>` | `CompletionStage<T> patchStatusAsync()`, `CompletionStage<T> editStatusAsync(UnaryOperator<T>)` |
| `Loggable` | `CompletionStage<String> getLogAsync()` |
| `Resource<T>` | `CompletionStage<Boolean> isReadyAsync()`, `CompletionStage<T> requireAsync()` |

**~30 new methods across ~15 interfaces. No new types.**

**Option B** introduces a parallel hierarchy of terminal-only interfaces named `Async*`, plus two umbrella view interfaces. Note: no `AsyncMixedOperation` or `AsyncKubernetesClient` — namespacing/filtering stays on the sync side and `.async()` is called *after* fluent narrowing.

```
Sync hierarchy (existing)              Async hierarchy (new)
─────────────────────────              ─────────────────────
Gettable<T>                       →    AsyncGettable<T>          (.get()         → CompletionStage<T>)
Listable<T>                       →    AsyncListable<T>          (.list()        → CompletionStage<T>)
Deletable                         →    AsyncDeletable            (.delete()      → CompletionStage<List<StatusDetails>>)
Updatable<T>                      →    AsyncUpdatable<T>         (.update()      → CompletionStage<T>)
Replaceable<T>                    →    AsyncReplaceable<T>       (.updateStatus())
CreateOrReplaceable<T>            →    AsyncCreatable<T>
EditReplacePatchable<T>           →    AsyncEditReplacePatchable<T>
ServerSideApplicable<T>           →    AsyncServerSideApplicable<T>
Scalable<T>                       →    AsyncScalable<T>
Loggable                          →    AsyncLoggable
Waitable<T,P>                     →    AsyncWaitable<T,P>
```

Plus the umbrella views:

```java
public interface AsyncResource<T> extends
    AsyncGettable<T>,
    AsyncCreatable<T>,
    AsyncUpdatable<T>,
    AsyncReplaceable<T>,
    AsyncEditReplacePatchable<T>,
    AsyncServerSideApplicable<T>,
    AsyncDeletable,
    AsyncScalable<T>,
    AsyncLoggable,
    AsyncWaitable<T, T> {
  CompletionStage<Boolean> isReady();
  CompletionStage<T> require();
}

public interface AsyncFilterListDeletable<T, L> extends AsyncListable<L>, AsyncDeletable {
  CompletionStage<Stream<T>> resources();
}
```

And the entry points on the sync side:

```java
public interface Resource<T> extends /* existing */ {
  AsyncResource<T> async();
}

public interface FilterWatchListDeletable<T, L, R> extends /* existing */ {
  AsyncFilterListDeletable<T, L> async();
}

public interface NonNamespaceOperation<T, L, R> extends /* existing */ {
  AsyncNonNamespaceOperation<T> async();
}
```

**~11 new `Async*` terminal interfaces + 2 umbrella views + ~30 method signatures inside them.** About the same method count as A; the difference is the **types**.

### 5.2 Call-site comparison

```java
// Option A
Pod p                       = client.pods().inNamespace("ns").withName("nginx").get();
CompletionStage<Pod> pAsync = client.pods().inNamespace("ns").withName("nginx").getAsync();
CompletionStage<PodList> l  = client.pods().inNamespace("ns").listAsync();
CompletionStage<Pod> created = client.pods().createAsync(pod);
CompletionStage<Pod> updated = client.pods().withName("x").updateAsync();
CompletionStage<List<StatusDetails>> del = client.pods().withName("x").deleteAsync();
```

```java
// Option B
Pod p                       = client.pods().inNamespace("ns").withName("nginx").get();
CompletionStage<Pod> pAsync = client.pods().inNamespace("ns").withName("nginx").async().get();
CompletionStage<PodList> l  = client.pods().inNamespace("ns").async().list();
CompletionStage<Pod> created = client.pods().async().create(pod);
CompletionStage<Pod> updated = client.pods().withName("x").async().update();
CompletionStage<List<StatusDetails>> del = client.pods().withName("x").async().delete();

// composes naturally with other fluent modifiers
client.pods().inNamespace("ns").dryRun(true).async().create(pod);
```

### 5.3 Generics impact on `MixedOperation<T, L, R>`

[`MixedOperation<T, L, R extends Resource<T>>`](../../kubernetes-client-api/src/main/java/io/fabric8/kubernetes/client/dsl/MixedOperation.java) is purely a typing umbrella over `AnyNamespaceable`, `Namespaceable`, and `NonNamespaceOperation` — it has no methods of its own.

**Option A:** zero impact. New `*Async` methods go on the terminal interfaces; `MixedOperation`'s type parameters don't change. The `R extends Resource<T>` bound continues to work because `Resource<T>` simply gains more methods.

**Option B:** the `<T, L, R>` parameters themselves don't change either, but `NonNamespaceOperation` (which `MixedOperation` extends) gains an `async()` method. The genuine type-explosion risk is at the **specialized resource subclasses**: should `PodResource.async()` return a wider `AsyncPodResource` (covering exec/copy/eviction)? Should `RollableScalableResource.async()` return `AsyncRollableScalableResource`? If yes, the parallel hierarchy cascades into roughly half a dozen specialized resource types (`PodResource`, `ServiceResource`, `ServiceAccountResource`, `RollableScalableResource`, `CertificateSigningRequestResource`, `EphemeralContainersResource`, `ContainerResource`). In Option A, `PodResource.execAsync()` / `copyAsync()` are just additional methods — no cascade.

### 5.4 How existing async escape hatches fit in

**Both options preserve them as-is.** No deletions, no renames.

| Existing async surface | Option A | Option B |
|---|---|---|
| `Watchable.streamingList(Consumer<T>) → CompletableFuture<String>` | Stays. Naturally adjacent to `listAsync()`. | Stays on sync `Watchable`. Could be mirrored on `AsyncListable` for symmetry — not required. |
| `Informable.informOnCondition(...)` | Stays (already async-shaped by return type). | Stays. Could be moved to an `AsyncInformable` view — likely not worth it. |
| `Informable.runnableInformer(...)` | Stays. | Stays. |
| `WebSocket.Builder.buildAsync()` | Stays. | Stays. |
| `SharedIndexInformer.start()/stopped()` | Stays. New methods follow the same `CompletionStage` convention. | Stays. Existing pattern is the model for `AsyncResource`. |
| `ExecWatch.exitCode()`, `LogWatch.onClose()` | Stays. | Stays. |
| Internal `BaseOperation.submitList(...)`, `submitWatch(...)` | Become the implementation of `listAsync()`. | Become the implementation of `AsyncListable.list()`. |

**One awkward case** in either option: `Informable.inform()`. Its initial list is blocking by contract ("the informer is ready and has the initial state on return"). Neither option requires changing it. Users who want non-blocking informer startup already have `runnableInformer(...).start()` returning `CompletionStage<Void>`. Best left as-is, with a doc cross-reference.

### 5.5 Migration story

| Concern | Option A | Option B |
|---|---|---|
| Existing call sites | Unchanged. Strictly additive. | Unchanged. Strictly additive. |
| New public API commitment | ~30 new methods. Each removable if it turns out wrong (still a breaking change, but localised). | ~11 new public interfaces forever. Removing any is a breaking change. |
| Docs | One new doc page describing the `*Async` naming convention + a reference table. | One new doc page on the `.async()` view + parallel JavaDoc for every `Async*` interface mirroring the sync side. ~2× the doc surface. |
| Test churn | None required. Tests opt-in voluntarily to exercise async variants. | None required. Same. |

### 5.6 Interaction with virtual threads

The strongest counter from @shawkins ([#7234](https://github.com/fabric8io/kubernetes-client/issues/7234)) is *"virtual thread usage will be more common before we complete such an effort."* Both options need an honest answer.

**Where virtual threads cover the gap:**

A Java 21+ application running on a `Executors.newVirtualThreadPerTaskExecutor()` can call any blocking `.get()` / `.list()` / `.create()` today; the carrier thread is freed during `future.get()` in `OperationSupport.waitForResult`. For typical thread-per-request server apps on Loom, this means **the user does not need an async API at all**. Pinning happens only if the call stack holds a `synchronized` block on the I/O path, which the modern client mostly avoids.

**Where virtual threads do not cover the gap** (the real motivation for [#7234](https://github.com/fabric8io/kubernetes-client/issues/7234) and [#7299](https://github.com/fabric8io/kubernetes-client/issues/7299)):

1. **Vert.x verticle event loops.** A `future.get()` on an event-loop thread is a *bug*, not a "switch your executor and you're fine" situation. Event-loop threads are not vthreads.
2. **Reactor / Mutiny / RxJava pipelines.** Same shape — blocking the dispatcher is a contract violation.
3. **Library code at Java 11 baseline.** Fabric8 itself targets Java 11; downstream libraries embedding the client on 11/17 have no vthreads.
4. **OkHttp backend.** The dispatcher pool is a fixed pool of platform carrier threads; vthreads dispatched to OkHttp still consume them.

**Framing for the proposal:** virtual threads solve the "I have many concurrent simple requests" case for free, and most application code should reach for them first. The non-blocking API is for **callers who already have a non-blocking dispatcher in their hands** — Vert.x verticles, reactive pipelines, Netty handlers — because the surrounding framework doesn't dispatch them. The accompanying doc should lead with this framing rather than positioning async as the universal answer.

This applies to A and B equally — but it does mean the proposal should explicitly **scope-limit** the new API to the most painful methods in those contexts (single-resource `get` / `update` / `patch`, list, watch initialization) rather than universally mirror every blocking call. A staged rollout (see § 7) is more defensible than a big-bang.

### 5.7 Implementation sketch — removing `waitForResult` from the new path

Both options share the implementation. The existing blocking `get()` does **not** change; it keeps calling `waitForResult(...)` and blocking at `OperationSupport.java:491`. The new async path bypasses `waitForResult` entirely.

Add a private async helper alongside each existing handler (the internal async method already exists — see `OperationSupport.handleResponse(HttpClient, HttpRequest.Builder, TypeReference)` at line 542):

```java
// BaseOperation
protected CompletableFuture<T> handleGetAsync(URL resourceUrl) {
  HttpRequest.Builder requestBuilder = httpClient.newHttpRequestBuilder().uri(resourceUrl.toString());
  return handleResponse(httpClient, withRequestTimeout(requestBuilder), new TypeReference<T>() {});
}
```

**Option A** wires it to a public sister method:

```java
@Override
public CompletionStage<T> getAsync() {
  URL url = resourceUrl();
  return handleGetAsync(url).thenApply(item -> { updateApiVersionResource(item); return item; });
}
```

**Option B** wires it inside an async view class returned by `async()`:

```java
private final class AsyncView implements AsyncResource<T> {
  @Override
  public CompletionStage<T> get() {
    URL url = resourceUrl();
    return handleGetAsync(url).thenApply(item -> { updateApiVersionResource(item); return item; });
  }
  // ... same for the other ~14 methods
}

@Override
public AsyncResource<T> async() { return asyncView; }
```

**Methods that aren't trivially async today** (e.g., paging-aware `list()`, `editStatus(UnaryOperator)` which does GET-modify-PUT internally) need a `thenCompose` chain rather than a direct promotion. Retry-on-conflict for `editStatus` async becomes a recursive `thenCompose` or a small retry helper:

```java
public CompletionStage<T> editStatusAsync(UnaryOperator<T> mutator) {
  return getAsync().thenApply(mutator).thenCompose(this::updateStatusAsync);
}
```

This is mildly non-trivial and is the place where a few methods genuinely need new internal helpers rather than just "promote `submitX`".

**Internal hazards both options share** (already noted in § 2): OIDC token refresh ([#3971](https://github.com/fabric8io/kubernetes-client/issues/3971)) is still synchronous inside HTTP interceptors, so an async call still incurs a brief thread-blocking step during refresh; YAML loading ([#5129](https://github.com/fabric8io/kubernetes-client/issues/5129)) blocks; watch establishment is internally async via `submitWatch` already, so a `watchAsync(...) → CompletionStage<Watch>` would be a natural addition but is not in the minimum scope.

## 6. Where A and B disagree — summary

| Axis | Option A — sister methods | Option B — `.async()` view |
|---|---|---|
| New types | None | ~11 new public interfaces (+ 2 umbrellas) |
| New methods | ~30 across existing interfaces | ~30 inside the new interfaces |
| Generics impact on `MixedOperation` | None | None directly, but cascades to specialized resources (`PodResource`, etc.) |
| Call-site readability | `*Async` suffix on ~30 methods | One `.async()` switch; clean terminal names |
| Fits existing precedent (`streamingList`, `informOnCondition`, `start/stopped`) | Yes — extends the convention | Yes — but creates a structurally different one alongside |
| Doc burden | One page + reference table | One page + parallel JavaDoc for ~11 new interfaces |
| Cost to revert | Local — per-method | Structural — every `Async*` interface is forever |
| Matches @shawkins's #7234 framing | Literal match ("advocate for particular methods to have non-blocking counter-parts") | Compatible — but closer to "something more comprehensive" which the comment flagged as historically difficult |
| Author bias | — | Preferred for call-site ergonomics |
| Maintainer comment bias | Preferred for incrementalism / containment | — |

## 7. Open questions for the community

Before either direction can be drafted as an upstream PR, the following need community input on [#7234](https://github.com/fabric8io/kubernetes-client/issues/7234) (or a fresh design discussion linking back to it):

1. **A or B?** This document presents both at the same fidelity. The author bias is towards B; the load-bearing maintainer comment leans A. The community needs to settle this before any code is written.
2. **`CompletionStage<T>` confirmed as the public return type?** § 2.2 cites two prior PRs ([#4488](https://github.com/fabric8io/kubernetes-client/pull/4488), [#4732](https://github.com/fabric8io/kubernetes-client/pull/4732)) where the maintainer-stated preference was `CompletionStage`. This research takes that as binding. Worth re-confirming explicitly.
3. **Scope of v1.** Even if the long-term picture is "every terminal has an async variant", what's a defensible first slice? A plausible v1 in either option: `get`, `list` (both overloads), `delete`, `update`, `patch`, `create` (item + no-arg), `serverSideApply`. ~10 methods. Defer Waitable, Loggable, Scalable, `editStatus`/`patchStatus`, `createOr`, exec/copy until v2.
4. **OIDC interceptor blocking ([#3971](https://github.com/fabric8io/kubernetes-client/issues/3971)) — prerequisite or parallel work?** Honest documentation says the async API is best-effort until that's fixed. Should that be flagged as a prerequisite for "fully non-blocking" claims, or is "best-effort with a documented caveat" acceptable for v1?
5. **Vthreads framing in docs.** The new doc page should lead with: "if you're on Java 21+ with a vthread executor and just want concurrent simple calls, keep using the blocking API." The async surface is positioned as the answer for **callers with a non-blocking dispatcher** (event loops, reactive pipelines). Worth confirming this framing aligns with how the maintainers want the API positioned.
6. **Long tail.** `editStatus(UnaryOperator)` and `createOr(Function)` involve GET-modify-PUT cycles internally. Their async equivalents need a `thenCompose` chain and retry-on-conflict that's slightly more than a simple `submit` promotion. Should they ship in v1 or be deferred?
7. **Specialized resources under Option B.** If B wins, `PodResource.async()` either returns `AsyncResource<Pod>` (loses exec/copy) or a wider `AsyncPodResource` (adds another interface to maintain). Same for `RollableScalableResource`. The decision here defines whether B "stops at the umbrella" or cascades.

## 8. References

- [`OperationSupport.java`](../../kubernetes-client/src/main/java/io/fabric8/kubernetes/client/dsl/internal/OperationSupport.java) — the blocking boundary, line 491
- [`BaseOperation.java`](../../kubernetes-client/src/main/java/io/fabric8/kubernetes/client/dsl/internal/BaseOperation.java) — internal `submitList` (line 452), `submitWatch` (line 735)
- [`HttpClient.java`](../../kubernetes-client-api/src/main/java/io/fabric8/kubernetes/client/http/HttpClient.java) — async SPI
- [`Resource.java`](../../kubernetes-client-api/src/main/java/io/fabric8/kubernetes/client/dsl/Resource.java), [`MixedOperation.java`](../../kubernetes-client-api/src/main/java/io/fabric8/kubernetes/client/dsl/MixedOperation.java) — DSL umbrella types
- [`Watchable.java`](../../kubernetes-client-api/src/main/java/io/fabric8/kubernetes/client/dsl/Watchable.java), [`Informable.java`](../../kubernetes-client-api/src/main/java/io/fabric8/kubernetes/client/dsl/Informable.java) — existing async public surface and precedents
