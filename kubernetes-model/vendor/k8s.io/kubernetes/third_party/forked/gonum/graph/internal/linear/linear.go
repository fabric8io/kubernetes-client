/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Copyright ©2015 The gonum Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

// Package linear provides common linear data structures.
package linear

import (
	"k8s.io/kubernetes/third_party/forked/gonum/graph"
)

// NodeStack implements a LIFO stack of graph.Node.
type NodeStack []graph.Node

// Len returns the number of graph.Nodes on the stack.
func (s *NodeStack) Len() int { return len(*s) }

// Pop returns the last graph.Node on the stack and removes it
// from the stack.
func (s *NodeStack) Pop() graph.Node {
	v := *s
	v, n := v[:len(v)-1], v[len(v)-1]
	*s = v
	return n
}

// Push adds the node n to the stack at the last position.
func (s *NodeStack) Push(n graph.Node) { *s = append(*s, n) }

// NodeQueue implements a FIFO queue.
type NodeQueue struct {
	head int
	data []graph.Node
}

// Len returns the number of graph.Nodes in the queue.
func (q *NodeQueue) Len() int { return len(q.data) - q.head }

// Enqueue adds the node n to the back of the queue.
func (q *NodeQueue) Enqueue(n graph.Node) {
	if len(q.data) == cap(q.data) && q.head > 0 {
		l := q.Len()
		copy(q.data, q.data[q.head:])
		q.head = 0
		q.data = append(q.data[:l], n)
	} else {
		q.data = append(q.data, n)
	}
}

// Dequeue returns the graph.Node at the front of the queue and
// removes it from the queue.
func (q *NodeQueue) Dequeue() graph.Node {
	if q.Len() == 0 {
		panic("queue: empty queue")
	}

	var n graph.Node
	n, q.data[q.head] = q.data[q.head], nil
	q.head++

	if q.Len() == 0 {
		q.head = 0
		q.data = q.data[:0]
	}

	return n
}

// Reset clears the queue for reuse.
func (q *NodeQueue) Reset() {
	q.head = 0
	q.data = q.data[:0]
}
