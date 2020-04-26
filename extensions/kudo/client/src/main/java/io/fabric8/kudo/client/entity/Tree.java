package io.fabric8.kudo.client.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author pangms
 * @date 2020/4/24
 */
public class Tree {

    private String msg;

    private List<Tree> nodes = new ArrayList<>();

    private Tree(String msg) {
        this.msg = msg;
    }

    public static Tree craeteRoot(String name) {
        return new Tree(name);
    }

    public Tree nodeNode(String name) {
        Tree node = new Tree(name);
        this.nodes.add(node);
        return node;
    }

    public String msg() {
        return msg;
    }

    public String printTree() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s \r\n", this.msg()));

        Stack<Tree> stack = new Stack<>();
        stack.push(this);//将更节点入栈
        while (!stack.isEmpty()) {
            //出栈
            Tree node = stack.pop();
            // 添加节点信息
            sb.append(String.format("%s \r\n", node.msg()));

            if (node.nodes != null && node.nodes.size() > 0) {
                node.nodes.forEach(n -> stack.push(n));
            }
        }
        return sb.toString();
    }
}