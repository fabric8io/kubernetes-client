# Redis

Redis is an open source (BSD licensed), in-memory data structure store, used as a database, cache and message broker.

Redis Cluster provides a way to run a Redis installation where data is automatically sharded across multiple Redis nodes.

This Operator is deploying a Redis Cluster.

## Prerequisites

You need a Kubernetes cluster up and running and Persistent Storage available with a default `Storage Class` defined.

## Getting Started

Deploy the `Operator` using the following command:

`kubectl kudo install redis`

It deploys a Redis Cluster composed of 6 instances. There are 3 masters and 1 replica per master.
