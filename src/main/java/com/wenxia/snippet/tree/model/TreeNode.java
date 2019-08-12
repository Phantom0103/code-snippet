package com.wenxia.snippet.tree.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhouw
 * @Description
 * @Date 2019-08-12
 */
@Getter
@Setter
public class TreeNode {

    private Integer id;

    private Integer parentId;

    private String name;

    private List<TreeNode> childNodes;

    public TreeNode(Integer id, Integer parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.childNodes = new ArrayList<>();
    }
}
