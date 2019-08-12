package com.wenxia.snippet.tree;

import com.alibaba.fastjson.JSON;
import com.wenxia.snippet.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhouw
 * @Description
 * @Date 2019-08-12
 */
public class TreeNodeTest {

    public static void main(String[] args) {
        List<TreeNode> data = initData();
        TreeNodeUtils treeNodeUtils = new TreeNodeUtils(data);
        TreeNode root = treeNodeUtils.generateTree(0);
        System.out.println(JSON.toJSONString(root));
    }

    private static List<TreeNode> initData() {
        List<TreeNode> list = new ArrayList<>();
        list.add(new TreeNode(0, null, "大集团"));
        list.add(new TreeNode(1, 0, "科技公司"));
        list.add(new TreeNode(2, 0, "文化传媒公司"));
        list.add(new TreeNode(3, 0, "武昌办事处"));
        list.add(new TreeNode(4, 0, "汉口办事处"));
        list.add(new TreeNode(5, 1, "研发中心"));
        list.add(new TreeNode(6, 1, "行政部"));
        list.add(new TreeNode(7, 5, "技术部"));
        list.add(new TreeNode(8, 5, "产品部"));
        list.add(new TreeNode(9, 5, "运维部"));
        list.add(new TreeNode(10, 2, "创作部"));
        list.add(new TreeNode(11, 2, "行政部"));
        return list;
    }
}
