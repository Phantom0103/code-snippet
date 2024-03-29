package com.wenxia.snippet.tree;

import java.util.ArrayList;
import java.util.List;

import com.wenxia.snippet.tree.model.TreeNode;

/**
 * @Author zhouw
 * @Description
 * @Date 2019-08-12
 */
public class TreeNodeUtils {

    private final List<TreeNode> treeNodeList;

    public TreeNodeUtils(List<TreeNode> treeNodeList) {
        this.treeNodeList = treeNodeList;
    }

    /**
     * 生成以id为根节点的树
     *
     * @param id
     * @return
     */
    public TreeNode generateTree(int id) {
        TreeNode root = getById(id);
        if (root == null) {
            return null;
        }

        List<TreeNode> childNodes = getChildrenById(id);
        if (childNodes.size() > 0) {
            for (TreeNode node : childNodes) {
                // 将子节点作为根，查找子节点的子节点
                TreeNode childRoot = generateTree(node.getId());
                if (childRoot != null) {
                    root.getChildNodes().add(childRoot);
                }
            }
        }

        return root;
    }

    /**
     * 根据id查找节点
     *
     * @param id
     * @return
     */
    private TreeNode getById(int id) {
        for (TreeNode node : treeNodeList) {
            if (node.getId() == id) {
                return node;
            }
        }

        return null;
    }

    /**
     * 根据id查找所有的子节点
     *
     * @param id
     * @return
     */
    private List<TreeNode> getChildrenById(int id) {
        List<TreeNode> childNodes = new ArrayList<>();
        for (TreeNode node : treeNodeList) {
            if (node.getParentId() != null && node.getParentId() == id) {
                childNodes.add(node);
            }
        }

        return childNodes;
    }
}
