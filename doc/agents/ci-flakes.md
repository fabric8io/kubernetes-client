# CI Flake Reproduction

CI runs on 2-core GitHub Actions VMs with limited RAM. Surefire `forkCount=1C`
and Vert.x event-loop sizing both scale with `Runtime.availableProcessors()`, so
a flake that surfaces under CI scheduling pressure often will not reproduce with
a plain `mvn test` on a 16+ core developer host.

Run the test inside a constrained `docker` or `podman` container with the
project and `~/.m2` bind-mounted. This is the closest local approximation to CI
shape and is usually the fastest way to confirm or rule out a race.

```bash
# Constrained container: 2 cores, about 7 GB RAM, cgroup-enforced
docker run --rm \
  --cpus=2 --memory=7g --cpuset-cpus="0,1" \
  --user $(id -u):$(id -g) -e HOME=/tmp \
  -v "$PWD:/work" \
  -v "$HOME/.m2:/host-m2" \
  -w /work \
  maven:3.9-eclipse-temurin-11 \
  mvn -pl kubernetes-tests \
      -Dtest='SomeFlakyTest#someFlakyMethod' \
      -Dmaven.repo.local=/host-m2/repository \
      test
```

For harder contention, run a sibling `stress-ng` container pinned to the same
`cpuset` as a noisy neighbor, then loop the test 25-50 times under that stress.

```bash
docker run --rm -d --name stressor --cpus=2 --cpuset-cpus="0,1" \
  alpine:latest sh -c \
  'apk add --no-cache stress-ng && stress-ng --cpu 4 --cpu-load 80 --timeout 600s'
```

Not every CI flake reproduces locally. GitHub Actions VMs add IO and network
jitter that cgroup quota cannot simulate. After about 20 unsuccessful
iterations, switch to instrument-and-wait: add timing logs on a debug branch and
watch the next CI hit.
